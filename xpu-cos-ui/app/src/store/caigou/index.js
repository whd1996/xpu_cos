import {reqgetcg,reqUpdateuser,reqgetlist,reqaddcg,reqoutcx} from '@/api/index'


const state = {
    cgr:{},
    isupd:'',
    list:[],
    ist:'',
    isout:''
}

const mutations = {
    GETCGR(state,value){
        state.cgr=value;
    },
    UPDATECG(state,value){
        state.isupd=value;
    },
    GETLIST(state,value){
        state.list=value;
    },
    ADDCG(state,value){
        state.ist=value;
    },
    OUTCAIGOU(state,value){
        state.isout=value
    }
}

const actions = {
        async getcgr({commit},value){
            let result=await reqgetcg(value);
            console.log(result);
            if(result.flag==true){
                commit('GETCGR',result.data)
            }
        },
        async updatecg({commit},value){
            let result=await reqUpdateuser(value);
            // console.log(result);
            if(result.flag==true){
                commit('UPDATECG','ok');
            }else{
                alert('err')
            }
        },
        async getlist({commit}){
            let result= await reqgetlist();
            console.log(result+'awa')
            if(result.flag==true){
                commit('GETLIST',result.data)
            }
        },
        async addcg({commit},value){
            let  result=await reqaddcg(value);
            console.log(result);
            if(result.flag==true){
                commit('ADDCG','ok')
            }else{
                alert('采购失败');
            }
        },
        async outcaigou({commit}){
            let result=await reqoutcx();
            console.log(result);
            if(result.flag=true){
                commit('OUTCAIGOU','ok')
            }else{
                commit('OUTCAIGOU','err')
            }
        }
}

export default {
    state,
    mutations,
    actions
}

