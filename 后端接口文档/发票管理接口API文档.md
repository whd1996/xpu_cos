
**XPU-COS项目购买服务管理API**


**简介**：XPU-COS项目SwaggerAPI管理

**HOST**:localhost:8088


**联系人**:


**Version**:1.0

**接口路径**：/v2/api-docs


# 发票管理接口

## addInvoice


**接口说明**:



**接口地址**:`/api/invoice/addInvoice`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"commodityId": 0,
	"id": 0,
	"invoiceDate": "",
	"invoiceDrawer": "",
	"orderformId": 0,
	"userId": 0
}
```


**请求参数**：

| 参数名称         | 说明     |     in |  是否必须      |  类型   |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|invoice| invoice  | body | true |invoice  | invoice   |

**schema属性说明**



**invoice**

| 参数名称         | 说明    |     in |  是否必须   |  类型  |  schema |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|commodityId|   | body | false |int32  |    |
|id|   | body | false |int32  |    |
|invoiceDate|   | body | false |date-time  |    |
|invoiceDrawer|   | body | false |string  |    |
|orderformId|   | body | false |int32  |    |
|userId|   | body | false |int32  |    |

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
| 200 | OK  |通用响应|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## deleteInvoiceById


**接口说明**:



**接口地址**:`/api/invoice/deleteInvoiceById`


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
| 200 | OK  |通用响应|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## selectALLInvoice


**接口说明**:



**接口地址**:`/api/invoice/selectALLInvoice`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无


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
| 200 | OK  |通用响应|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## selectInvoiceById


**接口说明**:



**接口地址**:`/api/invoice/selectInvoiceById`


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
| 200 | OK  |通用响应|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## updateInvoiceById


**接口说明**:



**接口地址**:`/api/invoice/updateInvoice`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"commodityId": 0,
	"id": 0,
	"invoiceDate": "",
	"invoiceDrawer": "",
	"orderformId": 0,
	"userId": 0
}
```


**请求参数**：

| 参数名称         | 说明     |     in |  是否必须      |  类型   |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|invoice| invoice  | body | true |invoice  | invoice   |

**schema属性说明**



**invoice**

| 参数名称         | 说明    |     in |  是否必须   |  类型  |  schema |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|commodityId|   | body | false |int32  |    |
|id|   | body | false |int32  |    |
|invoiceDate|   | body | false |date-time  |    |
|invoiceDrawer|   | body | false |string  |    |
|orderformId|   | body | false |int32  |    |
|userId|   | body | false |int32  |    |

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
| 200 | OK  |通用响应|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
