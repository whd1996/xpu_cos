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
import SpGl from '@/pages/guanli/spGL'
import DdGl from '@/pages/guanli/ddGL'
import YhGl from '@/pages/guanli/yhGL'
import CgGl from '@/pages/guanli/cgGL'
import XxCg from '@/pages/caigou/xxCG'
import DdCg from '@/pages/caigou/ddCG'
import XgYh from '@/pages/yonghu/xgYH'
import SpZs from '@/pages/yonghu/spZS'
import DdCl from '@/pages/yonghu/ddCL'
import CkFp from '@/pages/yonghu/ckFP'
let router= new VueRouter({
    routes:[
        {
            path:'/login',
            component:Login
        },
        {
            path:'/yonghu',
            component:Yonghu,
            children:[
                {
                    path:'xgyonghu',
                    component:XgYh,
                },
                {   
                    path:'spzahnshi',
                    component:SpZs
                },
                {
                    path:'ddchuli',
                    component:DdCl,
                },
                {
                    path:'ckfapiao',
                    component:CkFp,
                },
            ]
        },
        {
            path:'/caigou',
            component:Caigou,
            children:[
                {
                    path:'xxxiugai',
                    component:XxCg,
                },
                {
                    path:'ddchaxun',
                    component:DdCg,
                },
            ]
        },
        {
            path:'/guanli',
            component:Guanli,
            children:[
                {
                    path:'ddguanli',
                    component:DdGl,
                },
                {
                    path:'spguanli',
                    component:SpGl,
                },
                {
                    path:'yhguanli',
                    component:YhGl,
                },
                {
                    path:'cgguanli',
                    component:CgGl,
                }
            ]
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
