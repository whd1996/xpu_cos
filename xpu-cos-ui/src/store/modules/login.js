import { reqlogin } from '/尚品汇后台/vue-admin-template-master/src/api/user'


const state = {

}

const mutations = {

}

const actions = {
    async Login({ commit }, value) {
        let result = await reqlogin(value);
        if (result.code == 200) {
            console.log(result,'ok')
        } else {
            console.log(result,'err')
        }
    }
}

export default {
    state,
    mutations,
    actions
}

