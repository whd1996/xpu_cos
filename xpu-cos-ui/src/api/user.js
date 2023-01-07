// import request from '@/utils/request'
import requests from '@/utils/request'
//登录
export function reqlogin(data) {
  return requests({
    url: '/user/login',
    method: 'post',
    data
  })
}

// 获取用户信息
// export function getInfo(token) {
//   return request({
//     url: '/admin/acl/index/info',
//     method: 'get',
//     params: { token }
//   })
// }

// //退出登录
// export function logout() {
//   return request({
//     url: '/admin/acl/index/logout',
//     method: 'post'
//   })
// }


