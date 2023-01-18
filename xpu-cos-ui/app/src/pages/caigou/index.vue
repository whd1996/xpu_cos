<template>
  <div class="els">
     <div class="xpu1">
        <p>XPU-COS后台管理系统</p>
      </div>
    <div class="demo-type">
    <div>
       <el-avatar class="bloc">采购</el-avatar>
    </div>
  </div>
    <div class="space2"></div>
     <router-view class="rv1" :username='username'></router-view>
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
      <el-menu-item class="els" index="1" @click="xx">
        <i class="el-icon-menu"></i>
        <span slot="title">信息修改</span>
      </el-menu-item>
      <el-menu-item class="els" index="2" @click="dd">
        <i class="el-icon-menu"></i>
        <span slot="title">需采购商品展示</span>
      </el-menu-item>
      <el-menu-item class="els" @click="tta">
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
    data() {
      return {
        username:''
      }
    },
    mounted() {
    //   console.log(2)
    //    this.$bus.$on("hello", (data) => {
    //     console.log(data);
    //     this.username=data;
    //     console.log(this.username);
    // })
    console.log(this.usname)
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      dd(){
        this.$router.push('/caigou/ddchaxun');
      },
      xx(){
        this.$router.push('/caigou/xxxiugai');
      },
    async  tta(){
        // this.$router.push('/login')
          await this.$store.dispatch('outcaigou');
      //  console.log(this.$store.state.guanli)
       if(this.$store.state.caigou.isout=='ok'){
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
    .xpu1{
      float: right;
          position: absolute;
          right: 950px;
          color: black;
          font-size: large;
    }
    .rv1{
      float: right;
      position: absolute;
      left: 270px;
      top: 50px;
    }
        
        /* float: right;
        position: relative; */

</style>