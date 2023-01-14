<template >
  <div class="ss">
    <div class="title-container">
      <h3 class="title">注册</h3>
    </div>
    <el-form ref="form" label-width="80px">
      <el-form-item class="aa">
        <el-input placeholder="address" v-model="address"></el-input>
      </el-form-item>
      <el-form-item class="ww">
        <el-input placeholder="nickname" v-model="nickname"></el-input>
      </el-form-item>
      <el-form-item class="qq">
        <el-input placeholder="userName" v-model="userName"></el-input>
      </el-form-item>
      <el-form-item class="mm">
        <el-input placeholder="userPassward" v-model="userPassward"></el-input>
      </el-form-item>
      <el-form-item class="ll">
        <el-input placeholder="userPhone" v-model="userPhone"></el-input>
      </el-form-item>
    </el-form>
    <el-row>
      <!-- <el-button type="primary" class="anniu2" @click.native="regiest">注册</el-button> -->
       <el-button :plain="true" type="primary" @click.native="regiest" class="anniu2" >注册</el-button>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "  ZhuCe",
  data() {
    return {
      address: "",
      nickname: "",
      userName: "",
      userPassward: "",
      userPhone: "",
      id: 0,
      roleId: 0,
      res:{},
    };
  },
  methods: {
 async   regiest(){
   
             this.$message({
          message: '注册成功',
          type: 'success'
        });
        
        this.res={
            address:this.address,
            id:this.id,
            nickname:this.nickname,
            roleId:this.roleId,
            userName:this.userName,
            userPassward:this.userPassward,
            userPhone:this.userPhone,
        }
        console.log(this.res);
       await this.$store.dispatch('rzhuce',this.res);
       if(this.$store.state.zhuce.isOk=='ok'){
        this.$router.push('/login');
       }
    }
  },
};
</script>

<style >
.ss {
  height: 100%;
  width: 100%;
  background: url(~@/assets/6.jpg);
  background-size: 100% 100%;
  position: fixed;
}
.ww {
  width: 500px;
  margin-top: 10px;
  margin-left: 400px;
}
.aa {
  width: 500px;
  margin-top: 120px;
  margin-left: 400px;
}
.qq {
  width: 500px;
  margin-left: 400px;
}
.mm {
  width: 500px;
  margin-left: 400px;
}
.ll {
  width: 500px;
  margin-left: 400px;
}
.title-container {
  position: relative;
  font-size: 26px;
  color: #eee;
  margin: 0px auto 40px auto;
  text-align: center;
  font-weight: bold;
  top: 100px;
}
.anniu2 {
  display: block;
  position: relative;
  left: 480px;
  width: 420px;
}
</style>


