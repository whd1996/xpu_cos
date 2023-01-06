
**XPU-COS项目API**


**简介**：XPU-COS项目SwaggerAPI管理

**HOST**:localhost:8091


**联系人**:


**Version**:1.0

**接口路径**：/v2/api-docs


# 商品管理

## 商品新增接口

**接口说明**:商品新增接口的说明


**接口地址**:`/addCommodity`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"commodityName": "苹果",
	"commodityPrice": 15.5,
	"commodityRepertory": 100,
	"id": 1,
	"upordown": 1
}
```


**请求参数**：

| 参数名称         | 说明     |     in |  是否必须      |  类型   |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|commodity| commodity  | body | true |commodity  | commodity   |

**schema属性说明**



**commodity**

| 参数名称         | 说明    |     in |  是否必须   |  类型  |  schema |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|commodityName| 商品名称  | body | false |string  |    |
|commodityPrice| 商品价格  | body | false |double  |    |
|commodityRepertory| 库存  | body | false |int32  |    |
|id| 商品主键id  | body | false |int32  |    |
|upordown| 上架/下架  | body | false |int32  |    |

**响应数据**:

```json
{
	"data": "Object",
	"flag": true,
	"msg": "消息"
}
```

**响应参数说明**:


| 参数名称         | 说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|data| 返回对象  |object  |    |
|flag| 返回操作状态  |boolean  |    |
|msg| 返回消息  |string  |    |




**响应状态码说明**:


| 状态码         | 说明                             |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | 调用成功  |通用响应|
| 201 | Created  ||
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 商品删除接口

**接口说明**:商品删除接口的说明


**接口地址**:`/deleteCommodityById`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 说明     |     in |  是否必须      |  类型   |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|id| id  | query | false |integer  |    |

**响应数据**:

```json
{
	"data": "Object",
	"flag": true,
	"msg": "消息"
}
```

**响应参数说明**:


| 参数名称         | 说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|data| 返回对象  |object  |    |
|flag| 返回操作状态  |boolean  |    |
|msg| 返回消息  |string  |    |




**响应状态码说明**:


| 状态码         | 说明                             |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | 调用成功  |通用响应|
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 商品查询接口


**接口说明**:



**接口地址**:`/selectALLCommodity`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无


**响应数据**:

```json

```

**响应参数说明**:


暂无




**响应状态码说明**:


| 状态码         | 说明                             |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | 调用成功  ||
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据id商品查询接口

**接口说明**:根据id商品查询接口的说明


**接口地址**:`/selectCommodityById`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 说明     |     in |  是否必须      |  类型   |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|id| id  | query | false |integer  |    |

**响应数据**:

```json
{
	"data": "Object",
	"flag": true,
	"msg": "消息"
}
```

**响应参数说明**:


| 参数名称         | 说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|data| 返回对象  |object  |    |
|flag| 返回操作状态  |boolean  |    |
|msg| 返回消息  |string  |    |




**响应状态码说明**:


| 状态码         | 说明                             |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | 调用成功  |通用响应|
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 商品修改接口

**接口说明**:商品修改接口的说明


**接口地址**:`/updateCommodityById`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 说明     |     in |  是否必须      |  类型   |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|commodityName| 商品名称  | query | false |string  |    |
|commodityPrice| 商品价格  | query | false |number  |    |
|commodityRepertory| 库存  | query | false |integer  |    |
|id| 商品主键id  | query | false |integer  |    |
|upordown| 上架/下架  | query | false |integer  |    |

**响应数据**:

```json
{
	"data": "Object",
	"flag": true,
	"msg": "消息"
}
```

**响应参数说明**:


| 参数名称         | 说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|data| 返回对象  |object  |    |
|flag| 返回操作状态  |boolean  |    |
|msg| 返回消息  |string  |    |




**响应状态码说明**:


| 状态码         | 说明                             |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | 调用成功  |通用响应|
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
