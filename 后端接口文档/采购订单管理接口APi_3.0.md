
**XPU-COS项目采购订单服务管理API**


**简介**：<p>XPU-COS项目SwaggerAPI管理</p>


**HOST**:localhost:7000


**说明**: 服务名可缺省，配置了动态路由<br/>
如接口地址  /purchaseorder-manage-service/purchaseorder/deletePurchaseorderById
</br>
可简写为    /purchaseorder/deletePurchaseorderById


**Version**:1.0

**接口路径**：/purchaseorder-manage-service/v2/api-docs


# 采购订单管理

## 采购订单新增接口

**接口描述**:采购订单新增接口的说明

**接口地址**:`/purchaseorder-manage-service/purchaseorder/addPurchaseorder`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"addAmount": 20,
	"commodityId": 1001,
	"id": 1
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|purchaseorder| 采购订单对象  | body | true |采购订单表单对象  | 采购订单表单对象   |

**schema属性说明**



**采购订单表单对象**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|addAmount| 采购该商品的数量  | body | false |integer(int32)  |    |
|commodityId| 商品id  | body | false |integer(int32)  |    |
|id| 采购订单主键id  | body | false |integer(int32)  |    |

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
| 201 | Created  ||
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 采购订单删除接口

**接口描述**:采购订单删除接口的说明

**接口地址**:`/purchaseorder-manage-service/purchaseorder/deletePurchaseorderById`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|id| id  | query | false |integer  |    |

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
## 全部采购订单查询接口

**接口描述**:所有采购订单查询接口

**接口地址**:`/purchaseorder-manage-service/purchaseorder/selectAllPurchaseorder`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | 调用成功  ||
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据id查询采购订单

**接口描述**:根据id查询采购订单

**接口地址**:`/purchaseorder-manage-service/purchaseorder/selectPurchaseorderById`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|id| id  | query | false |integer  |    |

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
## 采购订单修改接口

**接口描述**:采购订单修改接口的说明

**接口地址**:`/purchaseorder-manage-service/purchaseorder/updatePurchaseorderById`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|addAmount| 采购该商品的数量  | query | false |integer  |    |
|commodityId| 商品id  | query | false |integer  |    |
|id| 采购订单主键id  | query | false |integer  |    |

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
