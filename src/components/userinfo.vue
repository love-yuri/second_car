<template>
  <div id="main">
    <el-result :title="user_info.username">
      <template #icon>
        <el-image
          src="./src/assets/head.jpg"
        />

      </template>
     
      <template #extra>
        <el-input v-model="chong_money" maxlength="8" placeholder="充值金额"></el-input> 
        <el-button type="success" round @click="recharge">充值</el-button>
      </template>
    </el-result>
    <h2>账户余额</h2>
    <h2>{{ user_info.money }}</h2>
  </div>
</template>


<script lang="ts" setup>

import axios from "axios";
import { ElMessage, } from "element-plus";
import { ref } from "vue"

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

var chong_money = ref('');
const recharge = async () => {
  if (user_info.username === 'anonymous') {
    ElMessage.error("游客不能充值!");
    return;
  }
  chong_money.value = chong_money.value.replace(/[^\d.]/g, "");
  if (parseFloat(chong_money.value) <= 0.0) {
    ElMessage.error("充值金额不能小于0!");
    return;
  }
  
  let buy = await axios.post("http://localhost:8080/updateMoney", {
    username: user_info.username,
    id: user_info.id,
    money: parseFloat(user_info.money) + parseFloat(chong_money.value)
  });

  if (buy.data == 0) {
    ElMessage.error("充值失败!");
  } else {
    user_info.money = parseFloat(user_info.money) + parseFloat(chong_money.value);
    ElMessage.success("充值成功!");
  }
};
</script>

<style scoped>

.el-button {
  margin: 30px;
}

#main {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}

h2 {
  font-size: 80px;
}

.el-image {
  width: 700px;
  height: 700px;
}

.el-button {
  width: 200px;
  height: auto;
}
</style>