import request from '@/utils/request'

//一级分类
export const reqCategory1List=()=>{
    return request({
        url:'/admin/product/getCategory1',
        method:'GET',
    })
}

//二级分类
export  const reqCategory2List=(category1Id)=>{
    return request({
        url:`/admin/product/getCategory2/${category1Id}`,
        method:'GET',
    })
}

//三级分类
export const reqCategory3List=(category2Id)=>{
    return request({
        url:`/admin/product/getCategory3/${category2Id}`,
        method:'GET',
    })
}

//获取平台数据
export const reqAttrLi=(category1Id,category2Id,category3Id)=>{
    return  request({
        url:`/admin/product/attrInfoList/${category1Id}/${category2Id}/${category3Id}`,
        method:'GET',
    })
}

//添加属性与属性值
export const reqAddattr=(data)=>{
    return request({
        method:'POST',
        url:'/admin/product/saveAttrInfo',
        data,
    })
}