<template>
  <div>
    <el-dialog title="请输入信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="采购数量" :label-width="formLabelWidth">
          <el-input v-model="form.num" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" :plain="true" @click="order">确 定</el-button>
      </div>
    </el-dialog>
    <el-table
    :data="tableData"
    border
    class="cg"
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
      prop="commodityName"
      label="商品名称"
      width="120">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="commodityPrice"
      label="商品价格"
      width="120">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="upordown"
      label="是否上架"
      width="120">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="commodityRepertory"
      label="商品库存"
      width="150">
    </el-table-column>
    <el-table-column fixed="right" label="操作" width="100">
        <template  slot-scope="scope">
          <el-row>
            <el-button type="warning" round size="mini" @click="cg(scope.row)"
              >采购</el-button
            >
          </el-row>
        </template>
      </el-table-column>
  </el-table>
  </div>
</template>

<script>
export default {
    name:'DdCaigou',
     data() {
      return {
         dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        id: 0,
        num: null,
      },
      fid:0,
      formLabelWidth: "120px",
        id:0,
        commodityName:'',
        commodityRepertory:0,
        commodityPrice:'',
        upordown:0,
        isshow:false,
        tableData:[],
      }
    },
   async  created() {
         await  this.$store.dispatch('getlist');
        //  console.log(this.$store.state.guanli.allpur);
            this.gettk();
          },
          methods: {
            gettk(){
              for(var i=0;i<this.$store.state.caigou.list.length;i++){
                if(this.$store.state.caigou.list[i].upordown==1){
                  this.$store.state.caigou.list[i].upordown='已上架'
                }else{
                  this.$store.state.caigou.list[i].upordown='未上架'
                }
              this.tableData.push({
              id:this.$store.state.caigou.list[i].id,
              commodityName:this.$store.state.caigou.list[i].commodityName,
              commodityPrice:this.$store.state.caigou.list[i].commodityPrice,
              upordown:this.$store.state.caigou.list[i].upordown,
              commodityRepertory:this.$store.state.caigou.list[i].commodityRepertory,
            })
            }
            },
          async  order(){
              this.form={
                id:this.fid,
                num:this.form.num
              }
              await this.$store.dispatch('addcg',this.form)
              // console.log(this.form)
              if(this.$store.state.caigou.ist=='ok'){
                this.$message({
                  message: "采购成功",
                  type: "success",
                });
                this.dialogFormVisible=false;
                location.reload();
              }else{
                 this.$message({
                  message: "采购失败",
                  type: "warning",
                });
              }
              
            },
            cg(v){
              this.dialogFormVisible = true;
              this.fid=v.id;
            }
          },
}
</script>

<style>

</style>