<template>
  <div id="brand">
    <h1>品牌管理</h1>
    <el-table :data="brands" style="width: 100%" max-height="400px">
      <el-table-column fixed prop="id" label="id" width="140px" />
      <el-table-column prop="name" label="品牌" />
      <el-table-column prop="remark" label="备注" />
      <el-table-column fixed="right" label="Operations">
        <template #default="scope">
          <el-button
            link
            type="primary"
            size="small"
            @click.prevent="deleteBrand(scope.row)"
          >
            Remove
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="buttons">
      <el-input placeholder="品牌名" v-model="brand_value_1" />
      <el-input placeholder="备注" v-model="remark" />
      <el-button
        style="width: 100%"
        type="primary"
        @click="addBrand"
        >添加品牌</el-button
      >
    </div>
  </div>

  <div id="module">
    <h1>型号管理</h1>
    <el-table :data="modules" style="width: 100%" max-height="400">
      <el-table-column fixed prop="id" label="id" width="140px" />
      <el-table-column prop="brand_name" label="品牌" />
      <el-table-column prop="name" label="型号" />
      <el-table-column fixed="right" label="Operations">
        <template #default="scope">
          <el-button
            link
            type="primary"
            @click.prevent="deleteModel(scope.row)"
          >
            Remove
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
  <div id="add">
    <el-select v-model="brand_value_2" placeholder="品牌">
      <el-option
        v-for="item in brands"
        :key="item.id"
        :label="item.name"
        :value="item.name"
      />
    </el-select>
    <el-input placeholder="车型" v-model="module_name" />
    <el-button
      style="width: 100%"
      type="primary"
      @click="addModule"
      >添加车型</el-button
    >
  </div>
  <h2>添加车辆</h2>
  <div id="addCar">
    <el-select v-model="car_brand" placeholder="品牌" @change="setBrand">
      <el-option
        v-for="item in brands"
        :key="item.id"
        :label="item.name"
        :value="item.name"
        placement="top"
      />
    </el-select>
    <el-select v-model="car_module" placeholder="型号" :disabled="!hasBrand">
      <el-option
        v-for="item in brand_models"
        :key="item.id"
        :label="item.name"
        :value="item.name"
      />
    </el-select>
    <el-input
      placeholder="里程"
      @change="valueChange"
      v-model="car_displacement"
      maxlength="15"
    />
    <el-input
      placeholder="价格"
      v-model="car_price"
      maxlength="15"
      type="number"
    />
    <el-input
      placeholder="排量"
      @change="valueChange"
      v-model="car_mileage"
      maxlength="3"
    />
    <el-input
      placeholder="离合器类型"
      v-model="car_type_of_clutch"
      maxlength="6"
    />
  </div>
  <div id="jntm">
    <el-date-picker
      v-model="car_registration_date"
      type="date"
      value-format="YYYY-MM-DD"
      placeholder="上牌日期"
      clearable=""
    />
    <el-button class="mt-4" style="width: 100%" type="primary" @click="addCar"
      >添加车型</el-button
    >
  </div>
</template>
  
  <script lang="ts" setup>
import { ref } from "vue";
import dayjs from "dayjs";
import { onBeforeMount } from "vue";
import axios from "axios";
import { ElMessage } from "element-plus";
import { ElTable } from "element-plus";



const props = defineProps({
  message: Object,
  carCompare: Array,
});

const emits = defineEmits(["addComCar"]);
var user_info = props.message as {
  id: number;
  username: string;
  password: string;
  money: any;
  manage: boolean;
};

var hasBrand = ref(false);
var brand_models = ref([{ id: -1, name: "no", brand_name: "no" }]);

var brands = ref();
var modules = ref();

var brand_value_1 = ref();
var remark = ref();

var brand_value_2 = ref();
var module_name = ref();

var car_brand = ref('');
var car_module = ref('');
var car_displacement = ref('');
var car_price = ref('');
var car_mileage = ref('');
var car_type_of_clutch = ref('');
var car_registration_date = ref('');

onBeforeMount(() => {
  getBrands();
  getModels();
});

const getBrands = async () => {
  try {
    let ret = await axios.post("http://localhost:8080/getAllBrand");
    brands.value = ret.data;
  } catch (error) {
    ElMessage.error(error);
  }
};

const getModels = async () => {
  try {
    let ret = await axios.post("http://localhost:8080/getAllModel");
    let data = ret.data;
    for (let i = 0; i < data.length; i++) {
      let module = data[i];
      for (let j = 0; j < brands.value.length; j++) {
        let brand = brands.value[j];
        if (brand.id == module.brand_id) {
          data[i]["brand_name"] = brand.name;
          break;
        }
      }
    }
    modules.value = ret.data;
  } catch (error) {
    ElMessage.error(error);
  }
};

const deleteRow = (index) => {
  brands.value.splice(index, 1);
};

const addBrand = async () => {
  if (brand_value_1.value == '' || brand_value_1.value == undefined) {
    ElMessage.info("请填写品牌名字!");
    return;
  }
  try {
    let ret = await axios.post("http://localhost:8080/addBrand", {
      name: brand_value_1.value,
      remark: remark.value,
    });
    if (ret.data == -1) {
      ElMessage.info("品牌已经存在!");
    } else if (ret.data == 0) {
      ElMessage.error("插入失败!");
    } else {
      getBrands();
      ElMessage.success("插入成功!");
    }
  } catch (error) {
    ElMessage.error(error);
  }
};

const addModule = async () => {
  console.log(brand_value_2.value);

  if (brand_value_2.value == undefined) {
    ElMessage.info("请选择品牌!");
    return;
  }
  if (module_name.value === "" || module_name.value == undefined) {
    ElMessage.info("请输入型号!");
    return;
  }
  try {
    let brand_id;
    for (let i = 0; i < brands.value.length; i++) {
      let brand = brands.value[i];
      if (brand.name === brand_value_2.value) {
        brand_id = brand.id;
        break;
      }
    }
    let ret = await axios.post("http://localhost:8080/addModel", {
      name: module_name.value,
      brand_id: brand_id,
    });
    if (ret.data == -1) {
      ElMessage.info("车型已经存在!");
    } else if (ret.data == 0) {
      ElMessage.error("插入失败!");
    } else {
      getModels();
      ElMessage.success("插入成功!");
    }
  } catch (error) {
    ElMessage.error(error);
  }
};

const addCar = async () => {
  const data = [
    car_brand,
    car_module,
    car_displacement,
    car_price,
    car_mileage,
    car_type_of_clutch,
    car_registration_date,
  ];

  for (let item of data) {
    if (item.value === null || item.value === "" || item.value === undefined) {
      ElMessage.error("请填写数据！");
      return;
    }
  }

  var currentDate = new Date();

  // 获取年、月、日
  var year = currentDate.getFullYear();
  var month = currentDate.getMonth() + 1; // 月份从0开始，需要加1
  var day = currentDate.getDate();

  // 格式化日期
  var formattedDate = year + "-" + month + "-" + day;

  try {
    let ret = await axios.post("http://localhost:8080/addCars", {
      price: car_price.value,
      brand_name: car_brand.value,
      model_name: car_module.value,
      mileage: car_mileage.value,
      type_of_clutch: car_type_of_clutch.value,
      registration_date: car_registration_date.value,
      displacement: car_displacement.value,
      release_date: formattedDate,
    });
    if (ret.data == -1) {
      ElMessage.error("插入信息为空!");
    } else if (ret.data == 1) {
      ElMessage.success("插入成功!");
    } else {
      ElMessage.error("插入失败!");
    }
  } catch (error) {
    ElMessage.error(error);
  }

  for (let item of data) {
    item.value = "";
  }
};

const valueChange = (value) => {
  car_mileage.value = car_mileage.value.replace(/[^\d.]/g, "");
  car_displacement.value = car_displacement.value.replace(/[^\d.]/g, "");
};

const setBrand = (value) => {
  if (value! && value != undefined) {
    hasBrand.value = true;
    brand_models.value!.length = 0;
    for (let i = 0; i < modules.value.length; i++) {
      let module = modules.value[i];
      if (value === module.brand_name) {
        brand_models.value.push(module);
      }
    }
  }
};

const deleteBrand = async (row) => {

  try {
    let ret = await axios.post("http://localhost:8080/delBrand", {
      name:row.name,
      id:row.id
    });

    if (ret.data == -1) {
      ElMessage.error("需要删除的信息为空!");
    } else if (ret.data == 1) {
      getBrands();
      getModels();
      ElMessage.success("删除成功!");
    } else {
      ElMessage.error("删除失败!");
    }
    
  } catch (error) {
    ElMessage.error(error)
  }
}

const deleteModel = async (row) => {
  console.log(row.id);
  try {
    let ret = await axios.post("http://localhost:8080/delModel", {
      id:row.id
    });

    if (ret.data == -1) {
      ElMessage.error("需要删除的信息为空!");
    } else if (ret.data == 1) {
      getModels();
      ElMessage.success("删除成功!");
    } else {
      ElMessage.error("删除失败!");
    }
    
  } catch (error) {
    ElMessage.error(error)
  }
  
}
</script>


<style scoped>
#brand,
#module,
#add {
  margin: 30px;
}
h1 {
  margin-bottom: 30px;
}

h2 {
  margin-left: 30px;
}

.buttons {
  width: 100%;
  display: flex;
  align-items: center;
  padding: 12px;
}

#add,
#addCar {
  margin: 30px;
  display: flex;
  align-items: center;
  padding: 12px;
}

#addCar .el-select {
  flex-shrink: 1;
  min-width: 160px;
}

.buttons .el-input,
#add .el-input {
  margin: 12px;
}
#jntm {
  margin: 50px;
  display: flex;
}

#jntm .el-button {
  margin: 0 30px;
}
</style>
