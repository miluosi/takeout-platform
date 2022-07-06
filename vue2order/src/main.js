// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
/*导入并使用axios依赖*/
import axios from 'axios'
Vue.prototype.$axios = axios
import 'element-ui/lib/theme-default/index.css'
import './plugins/axios.js';
//引入echarts
import './plugins/echarts.js';
/*添加store文件*/
import store from './store'

Vue.config.productionTip = false;
Vue.use(ElementUI);

/* eslint-disable no-new */
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app")
