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
      prop="Name"
      label="商品名称"
      width="120">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="kc"
      label="商品库存"
      width="120">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="isgo"
      label="是否上架"
      width="120">
    </el-table-column>
    <el-table-column
    v-show="isshow"
      prop="Num"
      label="采购数量"
      width="150">
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
export default {
    name:'CgGuanli',
    data() {
      return {
        id:0,
        Name:'',
        kc:0,
        isgo:'',
        Num:0,
        isshow:false,
        tableData:[],
      }
    },
        async  created() {
         await  this.$store.dispatch('getallpur');
         console.log(this.$store.state.guanli.allpur);
            this.gettk();
          },
          methods: {
            gettk(){
              for(var i=0;i<this.$store.state.guanli.allpur.length;i++){
              this.tableData.push({
              id:this.$store.state.guanli.allpur[i].id,
              Name:this.$store.state.guanli.allpur[i].商品名称,
              kc:this.$store.state.guanli.allpur[i].商品库存,
              isgo:this.$store.state.guanli.allpur[i].是否上架,
              Num:this.$store.state.guanli.allpur[i].采购数量,
            })
            }
            }
          },
}
</script>

<style>
 .cg{
    margin-top:20px;
  }
</style>