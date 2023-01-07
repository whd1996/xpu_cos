//品牌管理
import request from '@/utils/request'
//获取品牌列表接口
export const reqTradeMarkList=(page,limit)=>{
    return request({
        url:`/admin/product/baseTrademark/${page}/${limit}`,
        method:'GET',
    })
};

//处理添加品牌
export const reqAddOrUpdateTradeMark=(trade)=>{
    if(trade.id){
        //修改
        return request({
            url:'/admin/product/baseTrademark/update',
            method:'PUT',
            data:trade,
        })
    }
    else{
        //添加
        return request({
            url:'/admin/product/baseTrademark/save',
            method:'POST',
            data:trade,
        })
    }
}

//删除品牌
export const reqDeleteTrade=(id)=>{
    return request({
        url:`/admin/product/baseTrademark/remove/${id}`,
        method:'DELETE',
    })
}