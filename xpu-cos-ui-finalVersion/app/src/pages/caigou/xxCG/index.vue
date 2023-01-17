<template>
  <div>
     <el-dialog title="请选择你要修改的内容" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="昵称" :label-width="formLabelWidth">
          <el-input v-model="form.nickname"  autocomplete="off" :placeholder="tableData[0].nickname"></el-input>
        </el-form-item>
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input v-model="form.userName" autocomplete="off" :placeholder="tableData[0].userName"></el-input>
        </el-form-item>
        <el-form-item label="用户密码" :label-width="formLabelWidth">
          <el-input v-model="form.userPassward" autocomplete="off" :placeholder="tableData[0].userPassward"></el-input>
        </el-form-item>
        <el-form-item label="用户手机号" :label-width="formLabelWidth">
          <el-input v-model="form.userPhone" autocomplete="off" :placeholder="tableData[0].userPhone"></el-input>
        </el-form-item>
        <el-form-item label="地址" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off" :placeholder="tableData[0].address"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" :plain="true" @click="getto">确 定</el-button>
      </div>
    </el-dialog>
    <el-table
    :data="tableData"
    border
    class="dd"
    style="width: 100%">
    <el-table-column
    v-show="isshow"
      fixed
      prop="id"
      label="序号"
      width="120">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="addrss"
      label="地址"
      width="120">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="nickname"
      label="昵称"
      width="120">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="roleId"
      label="身份"
      width="100">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="userName"
      label="用户名"
      width="150">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="userPassward"
      label="用户密码"
      width="150">
    </el-table-column>
     <el-table-column
    v-show="isshow"
      prop="userPhone"
      label="用户手机号"
      width="150">
    </el-table-column>
     <el-table-column fixed="right" label="操作" width="100">
        <template >
          <el-row>
            <el-button type="warning" round size="mini" @click="xx"
              >修改</el-button
            >
          </el-row>
        </template>
      </el-table-column>
  </el-table>
  </div>
</template>

<script>
export default {
  name:'XxCaigou',
    data() {
      return {
        dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        id:0,
        userName: "",
        nickname: "",
        address: "",
        roleId: 1,
        userPassward: "",
        userPhone: "",
      },
      formLabelWidth: "120px",
        id:1,
        addrss:0,
        nickname:'q',
        roleId:0,
        userName:'q',
        userPassward:0,
        userPhone:'q',
        isshow:false,
        tableData:[],
      }
    },
   async created() {
    await  this.$store.dispatch('getcgr',this.$store.state.login.user.username)
      console.log(this.$store.state.caigou.cgr);
      // if(this.$store.state.caigou.cgr)
       this.tableData=[{
            id:this.$store.state.caigou.cgr.id,
            address:this.$store.state.caigou.cgr.address,
            nickname:this.$store.state.caigou.cgr.nickname,
            roleId:'采购员',
            userName:this.$store.state.caigou.cgr.userName,
            userPassward:this.$store.state.caigou.cgr.userPassward,
            userPhone:this.$store.state.caigou.cgr.userPhone,
          },]
    },
    methods: {
      xx(){
        this.dialogFormVisible = true;
      },
      getto(){
        this.dialogFormVisible = false;
        if(this.form.nickname==''){
          this.form.nickname=this.tableData[0].nickname;
        }
        if(this.form.address==''){
          this.form.address=this.tableData[0].address;
        }
        if(this.form.userName==''){
          this.form.userName=this.tableData[0].userName;
        }
        if(this.form.userPassward==''){
          this.form.userPassward=this.tableData[0].userPassward;
        }
        if(this.form.userPhone==''){
          this.form.userPhone=this.tableData[0].userPhone;
        }
        this.form.id=this.tableData[0].id;
                console.log(this.form);
         this.$store.dispatch("updatecg", this.form);
      if (this.$store.state.caigou.isupd == "ok") {
        this.$message({
          message: "更新成功",
          type: "success",
        });;
        this.$router.push('/login')
      } else {
        this.$message({
          message: "更新成功",
          type: "success",
        });;
        this.$router.push('/login')
      }
      }
    }
}
</script>

<style>
    .dd{
        margin-top: 20px;
    }
</style>