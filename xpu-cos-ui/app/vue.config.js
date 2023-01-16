const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  
})
module.exports = {
  lintOnSave:false,//关闭eslint校验工具
  productionSourceMap:false,//关闭map文件
  devServer:{
    proxy:{
      "/api": {
        target: 'http://localhost:7000',
        pathRewrite: {"^/api" : ""},
        changeOrigin: true, // 是否跨域
      }
    }
  }
}
