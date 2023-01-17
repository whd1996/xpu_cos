<template>
  <div>
    <el-dialog title="增加商品" :visible.sync="outerVisible">
    <el-input v-model="tname" placeholder="请输入商品名"></el-input>
    <el-input class="gg" v-model="tprice" placeholder="请输入商品价格"></el-input>
    <div slot="footer" class="dialog-footer">
      <el-button @click="outerVisible = false">取 消</el-button>
      <el-button type="primary" @click="ordersp">确 定</el-button>
    </div>
  </el-dialog>
    <el-table
    :data="tableData"
    border
    class="sp"
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
      prop="commodityRepertory"
      label="库存"
      width="120">
    </el-table-column>
     <el-table-column
      v-show="isshow"
      label="上架/下架"
      width="200">
      <template slot-scope="scope">
        <!-- <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button> -->
         <el-button type="success" :plain="true" round size='medium' @click="upt(scope.row)">上架</el-button>
          <el-button type="danger" round size='medium' @click="downt(scope.row)">下架</el-button>
      </template>
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="300">
      <template slot-scope="scope">
        <!-- <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button> -->
         <el-button type="success" round size='medium' @click="addt(scope.row)">增加商品</el-button>
          <el-button type="danger" round size='medium' @click="delet(scope.row)">删除商品</el-button>
      </template>
    </el-table-column>
    
  </el-table>
  </div>
</template>

<script>
export default {
    name:'SpGuanli',
    data() {
      return {
        outerVisible: false,
        innerVisible: false,
        tname:'',
        tprice:'',
        id:0,
        commodityName:"",
        commodityPrice:0,
        commodityRepertory:0,
        upordown:0,
        upthing:{},
        addts:{},
        isshow:false,
        tableData:[],
      }
    },
        async  created() {
         await  this.$store.dispatch('getallcom');
           this.getdar();
          },
          methods: {
            getdar(){
             for(var i=0;i<this.$store.state.guanli.allcom.length;i++){

              this.tableData.push({
                id:this.$store.state.guanli.allcom[i].id,
                commodityName:this.$store.state.guanli.allcom[i].commodityName,
                commodityPrice:this.$store.state.guanli.allcom[i].commodityPrice,
                commodityRepertory:this.$store.state.guanli.allcom[i].commodityRepertory,
                upordown:this.$store.state.guanli.allcom[i].upordown,
              })
             }
            },
           async upt(up){
              if(up.upordown==1){
                 this.$message({
                  message: '该商品已经上架',
                type: 'warning'
               });
              }else{
                this.upthing={
                  commodityName:up.commodityName,
                  commodityPrice:up.commodityPrice,
                  commodityRepertory:up.commodityRepertory,
                  id:up.id,
                  upordown:1
                },
                console.log(this.upthing)
               await this.$store.dispatch('updateup',this.upthing);
              //  console.log(this.$store.state.guanli.isup);
              this.$message({
                  message: '上架成功',
                type: 'success'
               });
               location.reload();
              }
            },
            async downt(down){
               if(down.upordown==0){
                 this.$message({
                  message: '该商品已经下架',
                type: 'warning'
               });
              }else{
                this.upthing={
                  commodityName:down.commodityName,
                  commodityPrice:down.commodityPrice,
                  commodityRepertory:down.commodityRepertory,
                  id:down.id,
                  upordown:0
                },
                console.log(this.upthing)
               await this.$store.dispatch('updateup',this.upthing);
              //  console.log(this.$store.state.guanli.isup);
              this.$message({
                  message: '下架成功',
                type: 'success'
               });
               location.reload();
              }
            },
            addt(add){
             this.outerVisible = true;
             
            },
          async  ordersp(){
              this.innerVisible = true
              this.addts={
              commodityName:this.tname,
              commodityPrice:this.tprice,
              commodityRepertory:0,
              id:0,
              upordown:0,
             },
             console.log(this.addts)
           await  this.$store.dispatch('addsp',this.addts);
              this.outerVisible = false;
              if(this.$store.state.guanli.isadd=='ok'){
                 this.$message({
                  message: '添加成功',
                type: 'success'
                 })
                  location.reload();
              }else{
                this.$message({
                  message: '添加失败',
                type: 'waring'
                 })
              }
            },
          async  delet(dt){
              console.log(dt.id)
             await this.$store.dispatch('delesp',dt.id);
              if(this.$store.state.guanli.isdel=='ok'){
                 this.$message({
                  message: '删除成功',
                type: 'success'
                 })
                 location.reload();
              }else{
                alert('err')
              }
            }
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