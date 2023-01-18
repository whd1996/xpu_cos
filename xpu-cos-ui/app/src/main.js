import Vue from 'vue'
import App from './App.vue'
import router from '@/router'
import store from './store'
Vue.config.productionTip = false
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.prototype.usname='ww',
Vue.use(ElementUI);
new Vue({
  render: h => h(App),
  router,
  store,
  beforeCreate() {
    Vue.prototype.$bus = this//安装全局事件总线
}
}).$mount('#app')
