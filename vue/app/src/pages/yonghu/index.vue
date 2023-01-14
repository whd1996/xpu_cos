<template>
  <div class="els">
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
        <span slot="title">个人信息</span>
      </el-menu-item>
      <el-menu-item class="els" index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">商品展示</span>
      </el-menu-item>
      <el-menu-item class="els" index="3">
        <i class="el-icon-menu"></i>
        <span slot="title">订单查询</span>
      </el-menu-item>
       <el-menu-item class="els" index="4">
        <i class="el-icon-menu"></i>
        <span slot="title">订单处理</span>
      </el-menu-item>
       <el-menu-item class="els" index="5">
        <i class="el-icon-menu"></i>
        <span slot="title">查看发票</span>
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
    name:'MyYh',
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
        
        /* float: right;
        position: relative; */

</style>