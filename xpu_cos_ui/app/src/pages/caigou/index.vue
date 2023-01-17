<template>
  <div class="els">
    <div class="demo-type">
    <div>
       <el-avatar class="bloc">采购</el-avatar>
    </div>
  </div>
    <div class="space2"></div>
  <el-row class="tac">
  <el-col :span="12">
    <el-menu
      default-active="1"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item class="els" index="1">
        <i class="el-icon-menu"></i>
        <span slot="title">信息修改</span>
      </el-menu-item>
      <el-menu-item class="els" index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">商品展示</span>
      </el-menu-item>
      <el-menu-item class="els">
        <i class="el-icon-menu"></i>
        <span slot="title">退出登录</span>
      </el-menu-item>
    </el-menu>
  </el-col>
</el-row>

  </div>
</template>

<script>
export default {
    name:'CaiGou',
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>

<style>
    .tac{
        width: 450px;
    }
    .el-menu{
        height: 100vh;
    }
    .bloc{
       float: right;
      position: relative;
      right: 100px;
      top :5px
    }
     .space2{
      position: relative;
      float: right;
      height: 1px;
      right: 0px;
     top: 50px;
     width: 1110px;
      box-shadow: 10px 5px  #888888; 
    }
        
        /* float: right;
        position: relative; */

</style>