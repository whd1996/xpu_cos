//对axios进行二次封装
import axios from 'axios';

import store from '@/store';
//1.利用axios方法去创建axios实例
const requests=axios.create({
    //配置对象
    baseURL:'http://whd.gs.cn',
    timeout:5000,
});
//请求拦截器
requests.interceptors.request.use((config)=>{
    
    return config;
});

//响应拦截器
requests.interceptors.response.use((res)=>{
    return res.data
},(err)=>{
    return Promise.reject(new Error('faile'))//终结promise链
})  

//对外暴露
export default requests;