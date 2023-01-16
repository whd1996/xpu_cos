//对接口统一管理
import requests from './request'

    
//
export const reqLogin=(data)=>{
    return requests({
        method:'POST',
        url:'/user/login',
        data,
    })
}

//
export const reqRegiest=(data)=>{
    return requests({
        method:'POST',
        url:'/login-service/user/register',
        data,
    })
}



