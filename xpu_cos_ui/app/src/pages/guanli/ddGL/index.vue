<template>
  <div>
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
      prop="danjia"
      label="单价"
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
      prop="jine"
      label="消费金额"
      width="120">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="yonghu"
      label="用户"
      width="100">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="shuliang"
      label="购买数量"
      width="150">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="riqi"
      label="购买日期"
      width="150">
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
export default {
    name:'DdGuanli',
    data() {
      return {
        id:1,
        danjia:0,
        shangpin:'',
        jine:0,
        yonghu:'',
        shuliang:0,
        riqi:'',
        isshow:false,
        tableData:[],
      }
    },
        async  created() {
         await  this.$store.dispatch('getallorder');
        console.log(this.$store.state.guanli.allorder)
            this.tableData=[{
            id:this.$store.state.guanli.allorder[0].id,
            danjia:this.$store.state.guanli.allorder[0].单价,
            shangpin:this.$store.state.guanli.allorder[0].商品,
            jine:this.$store.state.guanli.allorder[0].消费金额,
            yonghu:this.$store.state.guanli.allorder[0].用户,
            shuliang:this.$store.state.guanli.allorder[0].购买数量,
            riqi:this.$store.state.guanli.allorder[0].购买日期,
          },
          {
            id:this.$store.state.guanli.allorder[1].id,
            danjia:this.$store.state.guanli.allorder[1].单价,
            shangpin:this.$store.state.guanli.allorder[1].商品,
            jine:this.$store.state.guanli.allorder[1].消费金额,
            yonghu:this.$store.state.guanli.allorder[1].用户,
            shuliang:this.$store.state.guanli.allorder[1].购买数量,
            riqi:this.$store.state.guanli.allorder[1].购买日期,
          },
           
        ]
          },
}
</script>

<style>
    .dd{
        margin-top: 20px;
    }
</style>