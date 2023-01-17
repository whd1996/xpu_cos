import {reqgetcg,reqUpdateuser,reqgetlist,reqaddcg} from '@/api/index'


const state = {
    cgr:{},
    isupd:'',
    list:[],
    ist:'',
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
            console.log(result)
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
        }
}

export default {
    state,
    mutations,
    actions
}

