<template>
  <div>
    <el-dialog title="购买商品" :visible.sync="outerVisible">
    <!-- <el-input v-model="tid" placeholder="请输入要购买商品的序号"></el-input> -->
    <el-input class="gg" v-model="tnum" placeholder="请输入购买的数量"></el-input>
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
      width="150">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="commodityName"
      label="商品名称"
      width="150">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="commodityPrice"
      label="商品价格"
      width="150">
    </el-table-column>
    <el-table-column
      v-show="isshow"
      prop="commodityRepertory"
      label="库存"
      width="150">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="200">
      <template slot-scope="scope">
         <el-button type="success" round size='medium' @click="buyt(scope.row)">购买</el-button>
      </template>
    </el-table-column>
    
  </el-table>
  </div>
</template>

<script>
export default {
    name:'SpZhanshi',
    data() {
      return {
        outerVisible: false,
        innerVisible: false,
        tid:null,
        tnum:null,
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
         await  this.$store.dispatch('getspqb');
           this.getdar();
          },
          methods: {
            getdar(){
             for(var i=0;i<this.$store.state.yonghu.allsp.length;i++){
              this.tableData.push({
                id:this.$store.state.yonghu.allsp[i].id,
                commodityName:this.$store.state.yonghu.allsp[i].commodityName,
                commodityPrice:this.$store.state.yonghu.allsp[i].commodityPrice,
                commodityRepertory:this.$store.state.yonghu.allsp[i].commodityRepertory,
                upordown:this.$store.state.yonghu.allsp[i].upordown,
              })
             };
             console.log(this.tableData)
            },
            buyt(add){
              // console.log(this.$store.state.yonghu);
              this.tid=add.id;
             this.outerVisible = true;
            },
           async ordersp(){
                this.addts={
                    id:this.tid,
                    num:this.tnum
                }
               await this.$store.dispatch('getbuy',this.addts);
               console.log(this.$store.state.yonghu.mybuy);
               if(this.$store.state.yonghu.mybuy=='购买成功'){
                 this.$message({
                   message: '购买成功',
                 type: 'success'
                  })
               }
                 location.reload();
               if(this.$store.state.yonghu.mybuy=='商品还未上架'){
                // console.log('xxxx')
                 alert('商品未上架');
               }
               if(this.$store.state.yonghu.mybuy=='库存不足,无法购买'){
                // console.log('xxxx')
                 alert('库存不足');
               }
               if(this.$store.state.yonghu.mybuy=='输入数量有误'){
                // console.log('xxxx')
                 alert('输入数量有误');
               }
                this.outerVisible = false;
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