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

export const reqAlluser=()=>{
    return requests({
        method:'GET',
        url:'/user-manage-service/userinfo/selectALLUser'
    })
}

export const reqAllcommidity=()=>{
    return requests({
        method:'GET',
        url:'/commodity-manage-service/commodity/selectALLCommodity'
    })
}

export const reqAllorder=()=>{
    return requests({
        method:'GET',
        url:'/order-manage-service/order/selectAllOrder'
    })
}


