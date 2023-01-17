import {reqAlluser,reqAllcommidity,reqAllorder,reqAllpur,reqAdduser,reqDeuser,reqUpdateuser,requp,reqaddsp,reqdelesp} from '@/api/index';
 

const state = {
   allcom:{},
   allorder:{},
   allpur:{},
   alluser:{},
   isO:'',
   isup:'',
   isadd:'',
   isdel:'',
}

const mutations = {
    GETALLCOM(state,value){
        state.allcom=value;
    },
    GETALLORDER(state,value){
        state.allorder=value
    },
    GETALLPUR(state,value){
        
        state.allpur=value
    },
    GETALLUSER(state,value){
        state.alluser=value;
    },
    GETADDUSER(state,value){
        state.isO=value;
    },
    UPDATEUP(state,value){
        state.isup=value
    },
    ADDSP(state,value){
        state.isadd=value;
    },
    DELESP(state,value){
        state.isdel=value;
    }
}

const actions = {
        async getalluser ({commit}){
            let result=await reqAlluser();
            // console.log(result);
            if(result.flag==true){
                commit('GETALLUSER',result.data);
            }
        },
        async getallcom({commit}){
            let result=await reqAllcommidity();
            // console.log(result);
            if(result.flag==true){
                commit('GETALLCOM',result.data);
            }
        },
        async getallorder({commit}){
            let result=await reqAllorder();
            console.log(result);
            if(result.flag=true){
                commit('GETALLORDER',result.data);
            }
        },
        async getallpur({commit}){
            console.log(8);
            let result=await reqAllpur();
            console.log(result)
            if(result.flag==true){
                commit('GETALLPUR',result.data);
            }
            // if(result.)
        },
        async getadduser({commit},value){
            let result=await reqAdduser(value);
            console.log(result);
            if(result.flag==true){
                commit('GETADDUSER','ok');
            }else{
                commit('GETADDUSER','err');
            }
        },
        async deuser({commit},value){
            let result=await reqDeuser(value);
            console.log(result);
        },
        async updateu({commit},value){
            let result=await reqUpdateuser(value);
            console.log(result);
        },
        async  updateup({commit},value){
            let result=await requp(value);
            // console.log(1)
            // console.log(result)
            if(result.flag==true){
                commit('UPDATEUP','ok')
            }
        },
        async addsp({commit},value){
            let result=await reqaddsp(value);
            // console.log(result);
            if(result.flag==true){
                commit('ADDSP','ok');
            }else{
                alert('err')
            }
        },
        async delesp({commit},value){
            let result=await reqdelesp(value);
            // console.log(result);
            commit('DELESP','ok')
        }
}

export default {
    state,
    mutations,
    actions
}

