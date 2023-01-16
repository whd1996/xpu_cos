//引入Vue|Vue-router
import Vue from 'vue'
import VueRouter from 'vue-router'

//使用路由插件
Vue.use(VueRouter)
import Login from '@/pages/login'
import Yonghu from '@/pages/yonghu'
import Caigou from '@/pages/caigou'
import Guanli from '@/pages/guanli'
import Zhuce from '@/pages/zhuce'
let router= new VueRouter({
    routes:[
        {
            path:'/login',
            component:Login
        },
        {
            path:'/yonghu',
            component:Yonghu
        },
        {
            path:'/caigou',
            component:Caigou
        },
        {
            path:'/guanli',
            component:Guanli
        },
        {
            path:'/zhuce',
            component:Zhuce
        },
        {
            path:'/',
            redirect:'/login'
        },
    ],
})


export default router
