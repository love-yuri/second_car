/*
 * @Author: chen 梦断缘空 love-yuri jyh
 * @Date: 2023-11-05 19:55:26
 * @LastEditTime: 2023-12-22 14:33:43
 * @Description:
 */
import { createRouter, createWebHashHistory } from "vue-router";
import { ElNotification } from "element-plus";

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    { path: "/", component: () => import("./components/carsinfos.vue"), props: true },
    {
      path: "/car/0",
      component: () => import("./components/carsinfos.vue"),
      props: true,
    },
    {
      path: "/car/1",
      component: () => import("./components/mycollect.vue"),
      props: true,
    },
    {
      path: "/car/2",
      component: () => import("./components/comparecar.vue"),
      props: true,
    },
    {
      path: "/car/3",
      component: () => import("./components/manager.vue"),
      props: true,
    },
    {
      path: "/car/4",
      component: () => import("./components/userinfo.vue"),
      props: true,
    },
    ,
    {
      path: "/car/5",
      component: () => import("./components/hot.vue"),
      props: true,
    },
  ],
});

const root_user = ["yuri", "root"];

router.beforeEach((to, from, next) => {
  let username = localStorage.getItem("username");
  if (username === null) {
    username = "";
  }
  if (to.fullPath == "/car/3" && !root_user.includes(username)) {
    next("/car/0");
    ElNotification.error("普通用户禁止进入管理界面!");
    return;
  }
  next();
});

export default router;
