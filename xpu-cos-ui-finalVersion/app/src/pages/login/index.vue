<template >
<div class="ss">
  <div class="title-container">
        <h3 class="title">登录</h3>
      </div>
     <div>
        <el-radio-group v-model="radio1" class="jj" @change="aa">
          <el-radio-button label="用户登录"></el-radio-button>
          <el-radio-button label="管理员登录" ></el-radio-button>
        </el-radio-group>
      </div>
    <el-form ref="form"  label-width="80px">
        <el-form-item class="aa">
          <el-input placeholder="用户名" v-model="username"></el-input>
        </el-form-item>
        <el-form-item class="ww">
          <el-input placeholder="密码" v-model="password" type="password"></el-input>
        </el-form-item>
    </el-form>
    <el-row>
  <el-button type="primary" class="anniu" @click.native="logins">登录</el-button>
  <el-button type="primary" class="anniu3" @click.native="regiest">注册</el-button>
</el-row>
</div>
  
</template>

<script>
export default {
    name:'MyLogin',
    mounted() {
      
      console.log(this.usname);
    },
     data() {
      return {
        radio1: "用户登录",
        username:'',
        password:'',
        flag:1,
        log:{},
      };
    },
    methods: {
      ss(){
           this.$router.push('/guanli');
        },
        aa(){
      if(this.radio1=='管理员登录'){
          this.flag=0;
      }else{
        this.flag=1;
      }
    }, 
   async logins(){
    // this.usname=this.username;
    //   console.log(this.usname+'123123')
      this.log={
        flag:this.flag,
        user:{
          username:this.username,
          password:this.password,
        }
      }
      console.log(this.username)
      // this.$bus.$emit("hello",this.username)
      console.log(1111)
     await this.$store.dispatch('rlogin',this.log)
    //  console.log(this.$store.state.login.user.username)
     if(this.$store.state.login.isKong=='ok'){
          console.log(this.$store.state.login.numid)
          if(this.$store.state.login.numid==1){
            this.$router.push('/caigou');
          }
          else if(this.$store.state.login.numid==0){
            this.$router.push('/yonghu');
          }
          else{
            this.$router.push('/guanli');
          }
         }
    },
    regiest(){
        this.$router.push('/zhuce')
    }
    }
}
</script>

<style >
  .ss{
    height: 100%;
    width: 100%; 
     background:url(~@/assets/6.jpg);
     background-size: 100% 100%;
     position:fixed;
  }
  .ww{
    width:  500px;
    margin-top: 10px;
    margin-left: 400px;
    
  }
  .aa{
    width: 500px;
    margin-top: 120px;
    margin-left: 400px;
    
  }
  .jj{
    position: relative;
    top: 100px;
    left: 480px;
  }
  .title-container{
    position: relative;
    font-size: 26px;
      color: #eee;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
      top: 100px;
  }
  .anniu{
    display: block;
    position: relative;
    left: 480px;
    width: 205px;
  }
  .anniu3{
    display: block;
    position: relative;
    left: 480px;
    width: 205px;
  }

</style>


