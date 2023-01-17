import {reqRegiest} from '@/api/index'
 

const state = {
    isOk:''
}

const mutations = {
    RZHUCE(state,value){
        state.isOk=value;
    }
}

const actions = {
    async rzhuce({commit},value){
        let result=await reqRegiest(value);
        console.log(result)
        if(result.data.id!=null){
            commit('RZHUCE','ok')
        }else{
            commit('RZHUCE','err')
            alert('输入错误请重新输入');
        }
    }
}

export default {
    state,
    mutations,
    actions
}

