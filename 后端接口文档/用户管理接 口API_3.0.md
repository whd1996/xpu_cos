
**XPU-COS项目用户管理服务API**


**简介**：<p>XPU-COS项目SwaggerAPI管理</p>


**HOST**:localhost:7000


**说明**: 服务名可缺省，配置了动态路由<br/>
如接口地址 /user-manage-service/userinfo/addUser
</br>
可简写为   /userinfo/addUser


**Version**:3.0

**接口路径**：/user-manage-service/v2/api-docs


# 用户管理

## addUser


**接口描述**:


**接口地址**:`/user-manage-service/userinfo/addUser`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"address": "",
	"id": 1,
	"nickname": "",
	"roleId": 0,
	"userName": "zhangsan",
	"userPassward": "1234",
	"userPhone": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|user| user  | body | true |`user`  | `user`   |

**schema属性说明**



**`user`**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|address|   | body | false |string  |    |
|id| 主键id  | body | false |integer(int32)  |    |
|nickname|   | body | false |string  |    |
|roleId|   | body | false |integer(int32)  |    |
|userName| 用户名  | body | false |string  |    |
|userPassward| 用户密码  | body | false |string  |    |
|userPhone|   | body | false |string  |    |

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
| 200 | OK  |通用响应|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## deleteUserById


**接口描述**:


**接口地址**:`/user-manage-service/userinfo/deleteUserById`


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
| 200 | OK  |通用响应|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## selectALLUser


**接口描述**:


**接口地址**:`/user-manage-service/userinfo/selectALLUser`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



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
| 200 | OK  |通用响应|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## selectUserById


**接口描述**:


**接口地址**:`/user-manage-service/userinfo/selectUserById`


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
| 200 | OK  |通用响应|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## updateUserById


**接口描述**:


**接口地址**:`/user-manage-service/userinfo/updateUserById`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"address": "",
	"id": 1,
	"nickname": "",
	"roleId": 0,
	"userName": "zhangsan",
	"userPassward": "1234",
	"userPhone": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|user| user  | body | true |`user`  | `user`   |

**schema属性说明**



**`user`**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|address|   | body | false |string  |    |
|id| 主键id  | body | false |integer(int32)  |    |
|nickname|   | body | false |string  |    |
|roleId|   | body | false |integer(int32)  |    |
|userName| 用户名  | body | false |string  |    |
|userPassward| 用户密码  | body | false |string  |    |
|userPhone|   | body | false |string  |    |

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
| 200 | OK  |通用响应|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
