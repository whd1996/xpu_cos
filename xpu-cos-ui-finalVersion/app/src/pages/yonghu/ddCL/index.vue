<template>
  <div>
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
      fixed
      prop="yonghu"
      label="用户"
      width="120">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="shangpin"
      label="商品"
      width="120">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="danjia"
      label="单价"
      width="120">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="buynum"
      label="购买数量"
      width="150">
    </el-table-column>
     <el-table-column
    v-show="isshow"
      prop="jine"
      label="金额"
      width="120">
    </el-table-column>
     <el-table-column
    v-show="isshow"
      prop="buydate"
      label="购买日期"
      width="120">
    </el-table-column>
    <el-table-column fixed="right" label="操作" width="100">
        <template  slot-scope="scope">
          <el-row>
            <el-button type="warning" round size="mini" @click="cg(scope.row)"
              >退单</el-button>
          </el-row>
        </template>
      </el-table-column>
  </el-table>
  </div>
</template>

<script>
export default {
    name:'DdChuli',
     data() {
      return {
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        id: 0,
        num: null,
      },
        oid:0,
        formLabelWidth: "120px",
        id:0,
        danjia:0,
        shangpin:'',
        jine:0,
        yonghu:'',
        buynum:0,
        buydate:'',
        isshow:false,
        tableData:[],
      }
    },
   async  created() {
            console.log(this.$store.state.yonghu.yonghuu.id);
         await  this.$store.dispatch('getyhdd',this.$store.state.yonghu.yonghuu.id);
         console.log(this.$store.state.yonghu.ddall)
            this.gettk();
          },
          methods: {
            gettk(){
              for(var i=0;i<this.$store.state.yonghu.ddall.length;i++){
              this.tableData.push({
              id:this.$store.state.yonghu.ddall[i].id,
              danjia:this.$store.state.yonghu.ddall[i].单价,
              shangpin:this.$store.state.yonghu.ddall[i].商品,
              jine:this.$store.state.yonghu.ddall[i].消费金额,
              yonghu:this.$store.state.yonghu.ddall[i].用户,
              buynum:this.$store.state.yonghu.ddall.购买数量,
              buydate:this.$store.state.yonghu.ddall.购买日期,
            })
            }
            console.log(this.tableData)
            },
           async cg(v){
              this.oid=v.id;
             await this.$store.dispatch('gettuidan',this.oid);
              if(this.$store.state.yonghu.istui=='ok'){
                 this.$message({
                  message: "退单成功",
                  type: "success",
                });
                location.reload();
              }else{
                 this.$message({
                  message: "退单失败",
                  type: "warning",
                });
              }
            }
          },
}
</script>

<style>

</style>