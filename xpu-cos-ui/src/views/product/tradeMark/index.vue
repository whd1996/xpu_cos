<template>
  <div>
    <el-button type="primary" icon="el-icon-plus" style="margin: 10px 0px" @click="showDialog">添加</el-button
    >
    <!-- 表格组件
        data:数据  
        border添加边框
        label显示的标题  
        align标题对齐方式
        prop展示的是内容
     -->
    <el-table style="width: 100%" border :data="list">
      <el-table-column
        type="index"
        prop="prop"
        label="序号"
        width="80"
        align="center"
      >
      </el-table-column>
      <el-table-column prop="tmName" label="品牌名称" width="width">
      </el-table-column>
      <el-table-column prop="prop" label="品牌LOGO" width="width">
        <template slot-scope="{ row }">
          <img :src="row.logoUrl" alt="" style="width: 100px; height: 100px" />
        </template>
      </el-table-column>
      <el-table-column prop="prop" label="操作" width="width">
        <template slot-scope="{row}">
          <!-- {row,$index} 这里用不到飘红了，暂时删除-->
          <el-button type="warning" icon="el-icon-edit" size="mini" @click="updateTrade(row)">修改</el-button>
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteTrade(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页器 
      这里的箭头(->)是指把后面的sizes和total移到最右边
      pager-count表示总共多少个按钮，等于7说明连续页码为5
    -->
    <el-pagination
      style="margin-top: 20px; text-align: center"
      :total="total"
      :current-page="page"
      :page-size="limit"
      :pager-count="5"
      :page-sizes="[3, 5, 10]"
      @current-change="handleCurrentChange"
      @size-change="handleSizeChange"
      layout=" prev, pager, next,jumper,->,sizes,total"
    >
    </el-pagination>
    <!-- 对话框
        :visible.sync控制显示于隐藏
    -->
    <el-dialog :title="tmform.id?'修改品牌':'添加品牌'" :visible.sync="dialogFormVisible">
      <el-form style="width:80%" :model="tmform" :rules="rules" ref="ruleForm">
        <el-form-item label="品牌名称" label-width="100px" prop="tmName">
          <el-input  autocomplete="off" v-model="tmform.tmName"></el-input>
        </el-form-item>
        <el-form-item label="品牌LOGO" label-width="100px" prop="logoUrl">
          <!-- 
            图片手机不能用v-model
            action:设置图片上传的地址
            :on-success上传成功执行一次
            :before-upload上传图片之前执行一次
           -->
          <el-upload
            class="avatar-uploader"
            action="/dev-api/admin/product/fileUpload"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <img v-if="tmform.logoUrl" :src="tmform.logoUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
             <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addOrupdate">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "tradeMark",
  data() {
    return {
      page: 6, //分页器第几页
      limit: 3, //当前页数展示的条数
      total: 0,
      list: [],
      dialogFormVisible: false, //对话框显示于隐藏
      imageUrl: '',
      //收集品牌信息
      tmform:{
        tmName:'',
        logoUrl:'',
      },
      rules:{
        tmName:[
          // required必须写东西
          //trigger : blur失去焦点 change 改变
            { required: true, message: '请输入品牌名称', trigger: 'blur' },
            { min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'change' }
          ],
        logoUrl:[
            { required: true, message: '请选择品牌的图片', }
          ],
      },
    };
  },
  mounted() {
    //  console.log( this.$API)
    this.getDate();
  },
  methods: {
    async getDate() {
      let result = await this.$API.trademark.reqTradeMarkList(
        this.page,
        this.limit
      );
      //  console.log(result)
      if (result.code == 200) {
        this.total = result.data.total;
        this.list = result.data.records;
      }
    },
    handleCurrentChange(page) {
      this.page = page;
      this.getDate();
    },
    //改变页码
    handleSizeChange(limit) {
      this.limit = limit;
      this.getDate();
    },
    //添加
    showDialog(){
      this.dialogFormVisible=true;
      //清除数据
      this.tmform={
        tmName:'',
        logoUrl:'',
      }
    },
    //修改
    updateTrade(row){
      this.tmform={...row};
      this.dialogFormVisible=true;
    },
    //上传图片
    handleAvatarSuccess(res, file) {
      //res为上传的图片在服务器的地址
        this.tmform.logoUrl=res.data;
      },
    beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
      //添加品牌或者修改品牌
    addOrupdate(){
       //表单验证，全部通过才放行
        this.$refs.ruleForm.validate(async (success)=>{
          if(success){
             this.dialogFormVisible=false;
              let result= await this.$API.trademark.reqAddOrUpdateTradeMark(this.tmform);
              if(result.code==200){
              this.$message({
              message:this.tmform.id?'修改品牌成功':'添加品牌成功',
              type:'success',
            });
              this.getDate();
            }else{
            this.$message.error('添加失败');
            }
          }else{
            return false;
          }
        });
      },
      deleteTrade(row){
        //弹框
        this.$confirm(`确定删除${row.tmName}吗`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async () => {
         let result=await this.$API.trademark.reqDeleteTrade(row.id);
         if(result.code==200){
           this.$message({
             type: 'success',
             message: '删除成功!'
           });
           this.getDate();
         }else{

         }
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      }
  },
};
</script>

<style>
 .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style> 