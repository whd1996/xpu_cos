<template>
  <div>
    <!-- inline代表是行内表单 -->
    <el-form :inline="true" class="demo-form-inline" >
      <el-form-item label="一级分类">
        <el-select placeholder="请选择" v-model="cate1Id" @change="handler1">
          <el-option v-for="(item1) in list1" :key="item1.id" :label="item1.name" :value="item1.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="二级分类">
        <el-select placeholder="请选择" v-model="cate2Id" @change="handler2">
          <el-option :label="item2.name" :value="item2.id" v-for="(item2) in list2" :key="item2.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="三级分类">
        <el-select placeholder="请选择" v-model="cate3Id" @change="handler3">
          <el-option :label="item3.name" :value="item3.id" v-for="(item3) in list3" :key="item3.id"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "CateSelect",
  data() {
    return {
      list1:[],
      list2:[],
      list3:[],
      //收集一级数据
      cate1Id:'',
      cate2Id:'',
      cate3Id:'',
    }
  },
  mounted(){
    this.Category1List();
  },
  methods:{
 async  Category1List(){
     let result=await this.$API.attr.reqCategory1List();
      if(result.code==200){
        this.list1=result.data
        // console.log(this.list1)
      }
    },

  async  handler1(){
    //清除数据
    this.list2=[];
    this.list13=[];
    this.cate2Id='';
    this.cate3Id='';
    // this.$emit('getCateId',{categoryId:this.cate1Id})
     let result=await this.$API.attr.reqCategory2List(this.cate1Id);
    //  console.log(result)
      if(result.code==200){
        this.list2=result.data;
      }
    },

   async handler2(){
    //清除数据
    this.list3=[];
    this.cate3Id='';
    // this.$emit('getCateId',{categoryId:this.cate2Id})
    let result=await this.$API.attr.reqCategory3List(this.cate2Id);
    if(result.code==200){
      this.list3=result.data;
    }
    },

    handler3(){
      this.$emit('getCateId',{
        category1Id:this.cate1Id,
        category2Id:this.cate2Id,
        category3Id:this.cate3Id,
      })
    }
  }
};
</script>

<style>
</style>