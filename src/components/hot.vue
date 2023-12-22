<!--
 * @Author: love-yuri yuri2078170658@gmail.com
 * @Date: 2023-12-22 08:31:19
 * @LastEditTime: 2023-12-22 16:41:27
 * @Description: 
-->
<template>
  <div class="p-3">
    <div class="font-semibold text-[46px] text-center">热门推荐</div>
    <div class="flex flex-row items-center mb-4">
      <el-input placeholder="AI搜索" v-model="search" class="mr-3" />
      <el-button type="primary" loading-icon="Eleme" @click="searchCar">搜索</el-button>
    </div>
    <div>搜索历史:</div>
    <div class="mt-3 mb-12">
      <el-tag
        v-for="(tag, index) in tags"
        size="large"
        @close="close(tag, index)"
        @click="click(tag, index)"
        :key="index"
        class="mx-1"
        closable
        type="info"
      >
        {{ tag.tag }}
      </el-tag>
    </div>
    <el-carousel :interval="4000" type="card" trigger="click" height="500px" class="mt-5" @change="cardChange">
      <el-carousel-item v-for="car in cars" :key="car.id">
        <div>
          <h1 class="text-[30px] text-center">{{ car.brand_name }} - {{ car.model_name }}</h1>
          <el-image style="width: 100%" src="/src/assets/car.jpg" fit="contain" />
        </div>
      </el-carousel-item> 
    </el-carousel>
    <!-- {{ searchResult }} -->
    <el-descriptions title="详细信息" :column="3" border>
      <el-descriptions-item
        label="id"
        label-align="center"
        align="center"
        label-class-name="my-label"
        class="cursor-pointer"
        class-name="my-content"
        width="150px"
        >{{ cars[currentCar].id }}</el-descriptions-item
      >
      <el-descriptions-item label="品牌" label-align="center" align="center"
        ><el-tag size="large">{{ cars[currentCar].brand_name }}</el-tag></el-descriptions-item
      >
      <el-descriptions-item label="车辆型号" label-align="center" align="center"
        ><el-tag size="large">{{ cars[currentCar].model_name }}</el-tag></el-descriptions-item
      >
      <el-descriptions-item label="里程数" span="1" label-align="center" align="center">
        {{ cars[currentCar].mileage }}
      </el-descriptions-item>
      <el-descriptions-item label="价格" label-align="center" align="center">
        {{ cars[currentCar].price }}
      </el-descriptions-item>
      <el-descriptions-item label="排量" label-align="center" align="center">
        {{ cars[currentCar].displacement }}
      </el-descriptions-item>
      <el-descriptions-item label="离合器类型" label-align="center" align="center" span="3">
        {{ cars[currentCar].type_of_clutch }}
      </el-descriptions-item>
      <el-descriptions-item label="上牌时间" span="3" label-align="center" align="center">
        {{ cars[currentCar].registration_date }}
      </el-descriptions-item>
      <el-descriptions-item label="登记时间" span="3" label-align="center" align="center">
        {{ cars[currentCar].release_date }}
      </el-descriptions-item>
    </el-descriptions>
  </div>
</template>
<script setup lang="ts">
import { ElLoading, ElMessage } from 'element-plus';
import axios from 'axios';
import { ref, onMounted } from 'vue';

const props = defineProps({
  message: Object,
  carCompare: Array,
});

const search = ref('');
const currentCar = ref(0);
const searchResult = ref('');
const isLoading = ref(false);
var cars = ref([
  {
    id: 1,
    brand_name: "奥迪",
    model_name: "奥迪A4L",
    displacement: 2.0,
    price: 250000.0,
    release_date: "2019-12-01",
    mileage: 10000.0,
    registration_date: "2020-01-01",
    type_of_clutch: "自动",
  },
]);
const cardChange = (a, b) => {
  currentCar.value = a;
}
const searchCar = async () => {
  if (search.value === '') {
    ElMessage.error('输入禁止为空!');
    return;
  }
  const loading = ElLoading.service({
    lock: true,
    text: '正在获取最新推荐',
    background: 'rgba(0, 0, 0, 0.7)',
  });
  const { data } = await axios.post('http://localhost:8080/oss/search', {
    username: props.message?.username,
    msg: search.value,
  });
  getTag();
  searchResult.value = data.data;
  cars.value = data.data;
  loading.close();
};

const tags = ref([
  {id: 1, tag: 'sd'}
]);

const close = async (tag, i) => {
  const { data } = await axios.post('http://localhost:8080/oss/delHistory', tag);
  if (data.data) {
    tags.value.splice(i, 1);
  }
};

const click = (tag, i) => {
  search.value = tag.tag;
};

const getHot = async () => {
  const loading = ElLoading.service({
    lock: true,
    text: '正在获取最新推荐',
    background: 'rgba(0, 0, 0, 0.7)',
  });
  const { data } = await axios.post('http://localhost:8080/oss/hot', {
    username: props.message?.username,
    msg: search.value,
  });
  searchResult.value = data.data;
  cars.value = data.data;
  loading.close();
}

const getTag = async () => {
  const { data } = await axios.post('http://localhost:8080/oss/history', {
    username: props.message?.username,
  });
  tags.value = data.data;
}

onMounted(async () => {
  getTag();
  getHot();
});
</script>
<style scoped lang="less">

</style>
