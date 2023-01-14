import {reqLogin} from '@/api/index'


const state = {
    isKong:'',
    numid:0,
}

const mutations = {
    LOGIN(state,value){
        state.isKong=value
    },
    RLOGIN(state,value){
        state.numid=value
    }
}

const actions = {
    async rlogin({ commit }, value) {
        // console.log(1)
        let result = await reqLogin(value);
        // console.log(2)
        // console.log(result)
        if (result.data.id != null) {
            // console.log(result.data)
            // alert('1')
            commit('RLOGIN',result.data.roleId);
            commit('LOGIN','ok');
        }else{
            // console.log(result.data)
            commit('LOGIN','err')
            alert('输入错误请重新输入')
        } 
    }
}

export default {
    state,
    mutations,
    actions
}

