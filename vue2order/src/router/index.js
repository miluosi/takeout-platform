import Vue from 'vue'
import Router from 'vue-router'
import Pos from '@/components/page/Pos'
import goods from "../components/page/goods";
import login from "../components/page/login";
import cashing from "../components/page/cashing";
import shop from "../components/page/shop";
import statistic from "../components/page/statistic";
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/goods',
      name: goods,
      component: goods
    },
    {
      path: '/shop',
      name: shop,
      component: shop
    },
    {
      path: '/statistic',
      name: statistic,
      component: statistic
    },
    {
      path: '/cashing',
      name: cashing,
      component: cashing
    }
  ]
})
