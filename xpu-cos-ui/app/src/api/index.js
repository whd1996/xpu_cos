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


export const reqAllpur=()=>{
    return requests({
        method:'GET',
        url:'/purchaseorder/selectAllPurchaseorderInfo'
    })
}


export const reqAdduser=(data)=>{
    return requests({
        method:'POST',
        url:'/user-manage-service/userinfo/addUser',
        data,
    })
}


export const reqDeuser=(data)=>{
    return requests({
        method:'GET',
        url:`/user-manage-service/userinfo/deleteUserById?uid=${data}`,
        data,
    })
}

export const reqUpdateuser=(data)=>{
    return requests({
        method:'POST',
        url:'/user-manage-service/userinfo/updateUserById',
        data,
    })
}


export const requp=(data)=>{
    return requests({
        method:'POST',
        url:`/commodity-manage-service/commodity/updateCommodityById`,
        data,
    })
}

export const reqaddsp=(data)=>{
    return requests({
        method:'POST',
        url:`/commodity-manage-service/commodity/addCommodity`,
        data,
    })
}


export const reqdelesp=(data)=>{
    return requests({
        method:'GET',
        url:`/commodity-manage-service/commodity/deleteCommodityById?id=${data}`,
        data,
    })
}
