import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex)
//引入小仓库
import login from './login/index'
import zhuce from './zhuce/index'
import guanli from './guanli/index'
import caigou from './caigou/index'
import yonghu from './yonghu/index'
export default new Vuex.Store({
    //实现模块式开发
    modules:{
     login,
     zhuce,
     guanli,
     caigou,
     yonghu,
    }
})