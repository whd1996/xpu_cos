<template>
  <div>
    <el-table
    :data="tableData"
    border
    class="sp"
    style="width: 100%">
    <el-table-column
    v-show="isshow"
      fixed
      prop="fpbianhao"
      label="发票编号"
      width="100">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="spname"
      label="商品名称"
      width="150">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="spnum"
      label="商品数量"
      width="100">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="danjia"
      label="单价"
      width="100">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="kh"
      label="客户"
      width="150">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="huafei"
      label="花费"
      width="150">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="kpdanwei"
      label="开票单位"
      width="150">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="riqi"
      label="日期"
      width="150">
    </el-table-column>
    
  </el-table>
  </div>
</template>

<script>
export default {
    name:'CkFapiao',
created() {
    console.log(this.$store.state.yonghu.yonghuu.id)
    this.$store.dispatch('reqgetfp',this.$store.state.yonghu.yonghuu.id)
    // console.log(this.$store.state.yonghu.fpall)
    this.getdar();
},
    data() {
      return {
                kh:'',
                danjia:null,
                fpbianhao:null,
                spname:'',
                spnum:null,
                kpdanwei:null,
                riqi:'',
                huafei:null,
        isshow:false,
        tableData:[],
      }
    },
        
          methods: {
            getdar(){
             for(var i=0;i<this.$store.state.yonghu.fpall.length;i++){
              this.tableData.push({
                kh:this.$store.state.yonghu.fpall[i].客户,
                danjia:this.$store.state.yonghu.fpall[i].单价,
                fpbianhao:this.$store.state.yonghu.fpall[i].发票编号,
                spname:this.$store.state.yonghu.fpall[i].商品名称,
                spnum:this.$store.state.yonghu.fpall[i].商品数量,
                kpdanwei:this.$store.state.yonghu.fpall.开票单位,
                riqi:this.$store.state.yonghu.fpall.日期,
                huafei:this.$store.state.yonghu.fpall.花费,
              })
             }
             console.log(this.tableData)
            },
          },
}
</script>

<style>
  .sp{
    margin-top:20px;
  }
  .gg{
    margin-top: 10px;
  }
</style>