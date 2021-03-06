// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Qs from 'qs'
import axios from 'axios'
import VueAxios from 'vue-axios'
/*var axios=require('axios')
axios.defaults.baseURL='http://localhost:8814'
Vue.prototype.$axios = axios*/


var axios_instance = axios.create({
  baseURL:'http://localhost:8814',
  transformRequest: [function (data) {
    data = Qs.stringify(data);
    return data;
  }],
  headers:{'Content-Type':'application/x-www-form-urlencoded'}
})
Vue.use(VueAxios, axios_instance)

Vue.config.productionTip = false
/*作用是阻止vue 在启动时生成生产提示。*/

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
