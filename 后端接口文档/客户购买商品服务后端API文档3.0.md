
**XPU-COS项目购买服务管理API**


**简介**：<p>XPU-COS项目SwaggerAPI管理</p>


**HOST**:localhost:7000


**说明**: 服务名可缺省，配置了动态路由<br/>
如接口地址  **/buy-service/buy/buyCommodity**
</br>
可简写为 **/buy/buyCommodity**


**Version**:3.0

**接口路径**：/buy-service/v2/api-docs


# 购买服务接口

## 购买商品

**接口描述**:购买商品接口的说明
参数类型为 购买商品的id,购买数量num

**接口地址**:`/buy-service/buy/buyCommodity`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|id| id  | query | false |integer  |    |
|num| num  | query | false |integer  |    |

**响应示例**:

```json
{
	"data": "Object",
	"flag": true,
	"msg": "消息"
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|data| 返回对象  |object  |    |
|flag| 返回操作状态  |boolean  |    |
|msg| 返回消息  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | 调用成功  |通用响应|
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
