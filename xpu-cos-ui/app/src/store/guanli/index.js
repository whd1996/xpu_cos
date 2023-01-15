import {reqAlluser,reqAllcommidity,reqAllorder} from '@/api/index';
 

const state = {
   
}

const mutations = {
   
}

const actions = {
        async getalluser ({commit}){
            let result=await reqAlluser();
            console.log(result)
        },
        async getallcom({commit}){
            let result=await reqAllcommidity();
            console.log(result);
        },
        async getallorder({commit}){
            let result=await reqAllorder();
            console.log(result)
        }
}

export default {
    state,
    mutations,
    actions
}

