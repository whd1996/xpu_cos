import {reqLogin} from '@/api/index'


const state = {
    isKong:'',
    numid:0,
    user:{},
}

const mutations = {
    LOGIN(state,value){
        state.isKong=value
    },
    RLOGIN(state,value){
        state.numid=value
    },
    JKL(state,value){
        state.user=value
    }
}

const actions = {
    async rlogin({ commit }, value) {
        // console.log(1)
        let result = await reqLogin(value);
        console.log(value)
        console.log(result)
        if (result.flag==true) {
            // console.log(result.data)
            // alert('1')
            sessionStorage.setItem("username",result.data.userName)
            sessionStorage.setItem("id",result.data.id);
            commit('JKL',value.user)
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

