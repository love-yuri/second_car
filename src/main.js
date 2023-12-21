/*
 * @Author: chen 梦断缘空 love-yuri jyh
 * @Date: 2023-11-05 19:55:26
 * @LastEditTime: 2023-12-21 10:31:10
 * @Description: '
 */
import { createApp } from "vue";
import App from "./App.vue";
import './main.css';
import router from './router.ts';
import store from "store";
import "./assets/main.css";

import ElementPlus from 'element-plus';
import 'element-plus/theme-chalk/index.css';
 

import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}


import locale from 'element-plus/lib/locale/lang/zh-cn'
app.use(store);
app.use(router);
app.use(scroll);
app.use(ElementPlus, { locale });
app.mount("#app");
