<template>
  <div class="els">
      <div class="demo-type">
    <div>
       <el-avatar class="bloy">用户</el-avatar>
    </div>
  </div>
    <div class="space3"></div>
     <router-view class="rv3"></router-view>
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
      <el-menu-item class="els" index="1" @click="gr">
        <i class="el-icon-menu"></i>
        <span slot="title">个人信息</span>
      </el-menu-item>
      <el-menu-item class="els" index="2" @click="sp">
        <i class="el-icon-menu"></i>
        <span slot="title">商品展示</span>
      </el-menu-item>
       <el-menu-item class="els" index="4" @click="cl">
        <i class="el-icon-menu"></i>
        <span slot="title">订单处理</span>
      </el-menu-item>
       <el-menu-item class="els" index="5" @click="fp">
        <i class="el-icon-menu"></i>
        <span slot="title">查看发票</span>
      </el-menu-item>
      <el-menu-item class="els" @click="tcdl">
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
    mounted() {
      this.$router.push('/yonghu/xgyonghu')
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      gr(){
          this.$router.push('/yonghu/xgyonghu')
      },
      sp(){
        this.$router.push('/yonghu/spzahnshi')
      },
      cl(){
        this.$router.push('/yonghu/ddchuli')
      },
      fp(){
        this.$router.push('/yonghu/ckfapiao')
      },
     async tcdl(){
        // this.$router.push('/login')
          await this.$store.dispatch('outyonghu');
      //  console.log(this.$store.state.guanli)
       if(this.$store.state.yonghu.isout=='ok'){
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
       .bloy{
       float: right;
      position: relative;
      right: 100px;
      top :5px
    }
     .space3{
      position: relative;
      float: right;
      height: 1px;
      right: 0px;
     top: 50px;
     width: 1110px;
      box-shadow: 10px 5px  #888888; 
    }
     .rv3{
      float: right;
      position: absolute;
      left: 270px;
      top: 50px;
    }
        
        /* float: right;
        position: relative; */

</style>