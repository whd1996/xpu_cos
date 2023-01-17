<template>
  <div>
    <el-dialog title="个人信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="昵称" :label-width="formLabelWidth">
          <el-input v-model="form.nickname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input v-model="form.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户密码" :label-width="formLabelWidth">
          <el-input v-model="form.userPassward" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户手机号" :label-width="formLabelWidth">
          <el-input v-model="form.userPhone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="地址" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户身份" :label-width="formLabelWidth">
          <el-input
            v-model="form.roleId"
            autocomplete="off"
            placeholder="输入1为采购员,输入0为普通用户"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" :plain="true" @click="okok">确 定</el-button>
      </div>
    </el-dialog>
    <el-table
      :data="tableData"
      height="750"
      border
      class="yh"
      style="width: 100%"
    >
      <el-table-column v-show="isshow" fixed prop="id" label="序号" width="100">
      </el-table-column>
      <el-table-column v-show="isshow" prop="address" label="地址" width="120">
      </el-table-column>
      <el-table-column v-show="isshow" prop="nickname" label="昵称" width="100">
      </el-table-column>
      <el-table-column
        v-show="isshow"
        fixed
        prop="userName"
        label="用户名"
        width="100"
      >
      </el-table-column>
      <el-table-column
        v-show="isshow"
        fixed
        prop="userPassward"
        label="用户密码"
        width="150"
      >
      </el-table-column>
      <el-table-column
        v-show="isshow"
        fixed
        prop="userPhone"
        label="用户电话号"
        width="150"
      >
      </el-table-column>
      <el-table-column
        v-show="isshow"
        fixed
        prop="roleId"
        label="用户身份"
        width="100"
      >
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="250">
        <template slot-scope="scope">
          <el-row>
            <el-button type="primary" round size="mini" @click="tj"
              >添加</el-button
            >
            <el-button type="warning" round size="mini" @click="xg(scope.row)"
              >修改</el-button
            >
            <el-button type="danger" round size="mini" @click="sc(scope.row)"
              >删除</el-button
            >
          </el-row>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "SpGuanli",
  data() {
    return {
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        userName: "",
        nickname: "",
        address: "",
        roleId: 0,
        userPassward: "",
        userPhone: "",
      },
      formLabelWidth: "120px",
      address: "",
      id: 0,
      nickname: "",
      roleId: "",
      userName: "",
      userPassward: "",
      userPhone: "",
      isshow: false,
      tableData: [],
      xgd:{},
    };
  },
  async created() {
    await this.$store.dispatch("getalluser");
    // console.log(this.$store.state.guanli.alluser)
    this.getthing();
    // console.log(this.tableData)
    // console.log(1)
  },
  methods: {
    getthing() {
      for (var i = 0; i < this.$store.state.guanli.alluser.length; i++) {
        if (this.$store.state.guanli.alluser[i].roleId == 1) {
          this.$store.state.guanli.alluser[i].roleId = "采购员";
        } else {
          this.$store.state.guanli.alluser[i].roleId = "用户";
        }
        this.tableData.push({
          address: this.$store.state.guanli.alluser[i].address,
          id: this.$store.state.guanli.alluser[i].id,
          nickname: this.$store.state.guanli.alluser[i].nickname,
          roleId: this.$store.state.guanli.alluser[i].roleId,
          userName: this.$store.state.guanli.alluser[i].userName,
          userPassward: this.$store.state.guanli.alluser[i].userPassward,
          userPhone: this.$store.state.guanli.alluser[i].userPhone,
        });
      }
    },
    tj() {
      this.dialogFormVisible = true;
    },
    xg(xx) {
       this.$prompt('请输入用户的新身份', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          if(value=='采购员'){
            value=1;
          }else{
            value=0;
          }
          this.xgd={
            address: xx.address,
            id: xx.id,
            nickname: xx.nickname,
            roleId: value,
            userName: xx.userName,
            userPassward: xx.userPassward,
            userPhone: xx.userPhone,
          }
          this.$store.dispatch('updateu',this.xgd);
        this.$message({
            type: 'success',
            message: '修改成功'
          }); 
                location.reload();
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });       
        });
    },
    async sc(ss) {
      console.log(ss.id);
      await this.$store.dispatch("deuser", ss.id);
      this.$message({
        message: "删除成功",
        type: "success",
      });
      location.reload();
    },
    async okok() {
      this.dialogFormVisible = false;
      await this.$store.dispatch("getadduser", this.form);
      if (this.$store.state.guanli.isO == "ok") {
        this.$message({
          message: "添加成功",
          type: "success",
        });
        location.reload();
      } else {
        this.$message.error("添加失败");
      }
    },
  },
};
</script>

<style>
.yh {
  margin-top: 20px;
}
</style>