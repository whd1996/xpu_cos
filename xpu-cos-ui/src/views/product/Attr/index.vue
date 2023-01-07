<template>
  <div>
    <el-card style="margin:20px 0px">
      <CateSelect @getCateId='retCateId'/>
    </el-card>

    <el-card>
     <div v-show="isShow">
       <el-button type="primary" icon="el-icon-plus" :disabled='!cate3Id' @click="addattr">添加属性</el-button>
      <el-table
        border=""
        :data='attrList'
        style="width: 100%">
        <el-table-column type="index" align="center" label="序号" width="80">
        </el-table-column>
         <el-table-column prop="attrName" label="属性名称" width="150">
        </el-table-column>
         <el-table-column prop="prop" label="属性值列表" width="width">
          <template slot-scope="{row}">
           <el-tag type="success" v-for="(attr) in row.attrValueList" :key='attr.id' style="margin: 0px 10px">{{attr.valueName}}</el-tag>
          </template>
        </el-table-column>
         <el-table-column prop="prop" label="操作" width="150">
          <template slot-scope="{row}">
            <el-button type="warning" icon="el-icon-edit" size="mini" @click="updateAttr(row)"></el-button>
            <el-button type="danger" icon="el-icon-delete" size="mini"></el-button>
          </template>
        </el-table-column>
      </el-table>
     </div>
     <!-- 添加属性和修改属性 -->
    <div v-show="!isShow">
      <el-form ref="form" :inline='true'  label-width="80px">
          <el-form-item label="属性名">
            <el-input placeholder="请输入属性名" v-model="attrInfo.attrName"></el-input>
          </el-form-item>
      </el-form>
      <el-button type="primary" icon="el-icon-plus" @click="addattrV" :disabled="!attrInfo.attrName">添加属性值</el-button>
      <el-button @click="isShow=true">取消</el-button>
      <el-table border  style="width: 100%; margin:20px 0px" :data="attrInfo.attrValueList">
        <el-table-column align="center" prop="prop" label="序号" width="80" type="index">
        </el-table-column>
        <el-table-column prop="prop" label="属性值名称" width="width">
          <template slot-scope="{row}">
            <el-input size="mini" v-model="row.valueName" placeholder="请输入属性值名称"></el-input>
          </template>
        </el-table-column>
        <el-table-column prop="prop" label="操作" width="width">
          <el-button type="danger" icon="el-icon-delete" size='mini'></el-button>
        </el-table-column>
      </el-table>
      <el-button type="primary">保存</el-button>
      <el-button @click="isShow=true">取消</el-button>
    </div>
    </el-card>
  </div>
</template>

<script>
//按需引入深拷贝
import  cloneDeep from 'lodash/cloneDeep'
export default {
    name:'Attr',
    data() {
      return {
        cate1Id:'',
        cate2Id:'',
        cate3Id:'',
        attrList:[],
        //控制table显示与隐藏
        isShow:true,
        //收集新增或修改属性值
        attrInfo:{
          attrName:'',//属性名
          attrValueList:[//属性值
            
          ],
          categoryId: 0,//三级分类的id
          categoryLevel: 3,
        }
      }
    },
    methods:{
      retCateId(Id){
        this.cate1Id=Id.category1Id;
        this.cate2Id=Id.category2Id;
        this.cate3Id=Id.category3Id;
        if(this.cate3Id!=''){
          this.getAttrList();
        }
      },
 async   getAttrList(){
     let result= await  this.$API.attr.reqAttrLi(this.cate1Id,this.cate2Id,this.cate3Id);
    //  console.log(result)
        if(result.code==200){
          this.attrList=result.data
        }
      },
      addattrV(){
        this.attrInfo.attrValueList.push({
          attrId:this.attrInfo.id,
          valueName:'',
        });
      },
      addattr(){
        //table的显示与隐藏
        this.isShow=false
        //清除数据
        this.attrInfo={
          attrName:'',//属性名
          attrValueList:[//属性值
            
          ],
          categoryId: this.category3Id,//三级分类的id
          categoryLevel: 3,
        }
      },
      updateAttr(row){
        this.isShow=false;
       // this.attrInfo={...row};//浅拷贝这里不行(浅拷贝只改变一层)
       this.attrInfo=cloneDeep(row)//深拷贝
      }
    }
}
</script>

<style>

</style>