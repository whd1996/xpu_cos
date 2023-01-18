import {reqgetusermessgae,buylist,reqyonghudd,reqtuidan,reqgetth,reqgetfp,reqoutcx} from '@/api/index'


const state = {
    yonghuu:{},
    mybuy:'',
    ddall:[],
    istui:'',
    allsp:[],
    fpall:[],
    isout:'',
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
    },
    OUTYONGHU(state,value){
        state.isout=value
    }
}

const actions = {
    async getumessgae({commit},value){
        let result=await reqgetusermessgae(value);
        // console.log(result);
        if(result.flag==true){
            commit('GETUMESSAGE',result.data)
        }
    },
    async getspqb({commit}){
        let result=await reqgetth();
        // console.log(result);
        if(result.flag==true){
            commit('GETSPQB',result.data)
        }
    },
    async getbuy({commit},value){
        let result=await buylist(value);
        // let int=JSON.parse(result);
        // console.log(JSON.parse(result));
        console.log(result)
        if(result.flag==true){
            commit('GETBUY',result.msg);
            // alert(result.msg);
        }else{
            // console.log('失败')
            commit('GETBUY',result.msg)
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
        // console.log(result);
        if(result.flag==true){
            commit('GETTUIDAN','ok')
        }else{
            alert('err')
        }
    },
    async reqgetfp({commit},value){
        let result= await reqgetfp(value);
        // console.log(result);
        if(result.flag==true){
            commit('REQGETFP',result.data)
        }
    },
    async outyonghu({commit}){
        let result=await reqoutcx();
        console.log(result);
        if(result.flag=true){
            commit('OUTYONGHU','ok')
        }else{
            commit('OUTYONGHU','err')
        }
    }
}

export default {
    state,
    mutations,
    actions
}

