
**XPU-COS项目登录管理API**


**简介**：<p>XPU-COS项目SwaggerAPI管理</p>


**HOST**:localhost:7000


**说明**: 服务名可缺省，配置了动态路由
如接口地址  /login-service/user/login
</br>
可简写为 /user/login


**Version**:3.0

**接口路径**：/login-service/v2/api-docs


# 用户登录管理

## 登录接口

**接口描述**:登录接口的说明,参数类型如
{
"flag" :1,
"user":{   
"username": "abc",
"password": "123456"
}
}

**接口地址**:`/login-service/user/login`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
null
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|map| map  | body | true |  |    |

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
## 退出登录接口

**接口描述**:清空session后退出

**接口地址**:`/login-service/user/logout`


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
## 注册接口

**接口描述**:注册需要除id外的字段必填

**接口地址**:`/login-service/user/register`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"address": "",
	"id": 0,
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
|id|   | body | false |integer(int32)  |    |
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
| 200 | 调用成功  |通用响应|
| 201 | Created  ||
| 401 | 无权限  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
