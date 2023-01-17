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
        target: 'http://whd.gs.cn',
        changOrigin:true,
        pathRewrite: {"^/api" : "/"}
      }
    }
  }
}
