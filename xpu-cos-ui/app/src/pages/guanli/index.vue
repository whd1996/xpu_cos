<template>
  <div class="els">
     <div class="demo-type">
      <div class="xpu">
        <p>XPU-COS后台管理系统</p>
      </div>
    <div>
       <el-avatar class="blog">管理</el-avatar>
    </div>
  </div>
    <div class="space1"></div>
        <router-view class="rv"></router-view>
  <el-row class="tac">
  <el-col :span="12">
    <el-menu
      default-active="0"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item class="els"  @click="yh" index="1">
        <i class="el-icon-menu"></i>
        <span slot="title">用户管理</span>
      </el-menu-item>
      <el-menu-item class="els"  @click="sp" index="2">
        <i class="el-icon-menu"></i>
        <span slot="title" >商品管理</span>
      </el-menu-item>
      <el-menu-item class="els"  @click="dd" index="3">
        <i class="el-icon-menu"></i>
        <span slot="title">订单查询</span>
      </el-menu-item>
      <el-menu-item class="els"  @click="cg" index="4">
        <i class="el-icon-menu"></i>
        <span slot="title">采购信息查询</span>
      </el-menu-item>
      <el-menu-item class="els" @click="tc">
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
    name:'GuanLi',
    data() {
      return {
        circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
        sizeList: ["large", "medium", "small"]
      }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      sp(){
        this.$router.push('/guanli/spguanli')
      },
      dd(){
        this.$router.push('/guanli/ddguanli')
      },
      yh(){
        this.$router.push('/guanli/yhguanli');
      },
      cg(){
        this.$router.push('/guanli/cgguanli');
      },
   async   tc(){
        // this.$router.push('/login');
       await this.$store.dispatch('outguali');
      //  console.log(this.$store.state.guanli)
       if(this.$store.state.guanli.isout=='ok'){
          this.$message({
            type: 'success',
            message: '退出成功'
          }); 
          this.$router.push('/login');
       }else{
        this.$message({
            type: 'warning',
            message: '退出失败'
          }); 
       }
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
    .space1{
      position: relative;
      float: right;
      height: 1px;
      right: 0px;
     top: 50px;
     width: 1110px;
      box-shadow: 10px 5px  #888888; 
    }
    .blog{
      float: right;
      position: relative;
      right: 100px;
      top :5px
    }
    .rv{
      float: right;
      position: absolute;
      left: 270px;
      top: 50px;
    }
        .xpu{
          float: right;
          position: absolute;
          right: 950px;
          color: black;
          font-size: large;
        }
        /* float: right;
        position: relative; */

</style>