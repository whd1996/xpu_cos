import {reqgetusermessgae,buylist,reqyonghudd,reqtuidan,reqgetth,reqgetfp} from '@/api/index'


const state = {
    yonghuu:{},
    mybuy:{},
    ddall:[],
    istui:'',
    allsp:[],
    fpall:[],
}

const mutations = {
    GETUMESSAGE(state,value){
        state.yonghuu=value;
    },
    GETBUY(state,value){
        state.mybuy=value;
    },
    GETYHDD(state,value){
        state.ddall=value
    },
    GETTUIDAN(state,value){
        state.istui=value
    },
    GETSPQB(state,value){
        state.allsp=value;
    },
    REQGETFP(state,value){
        state.fpall=value;
    }
    
}

const actions = {
    async getumessgae({commit},value){
        let result=await reqgetusermessgae(value);
        console.log(result);
        if(result.flag==true){
            commit('GETUMESSAGE',result.data)
        }
    },
    async getspqb({commit}){
        let result=await reqgetth();
        console.log(result);
        if(result.flag==true){
            commit('GETSPQB',result.data)
        }
    },
    async getbuy({commit},value){
        let result=await buylist(value);
        console.log(result);
        if(result.flag==true){
            commit('GETBUY',result.data);
        }else{
            alert('err')
        }
    },
    async getyhdd({commit},value){
        let result=await reqyonghudd(value);
        console.log(result+'11111');
        if(result.flag==true){
            commit('GETYHDD',result.data);
        }else{
            alert('err');
        }
    },
    async gettuidan({commit},value){
        let result=await reqtuidan(value);
        console.log(result);
        if(result.flag==true){
            commit('GETTUIDAN','ok')
        }else{
            alert('err')
        }
    },
    async reqgetfp({commit},value){
        let result= await reqgetfp(value);
        console.log(result);
        if(result.flag==true){
            commit('REQGETFP',result.data)
        }
    }
}

export default {
    state,
    mutations,
    actions
}

