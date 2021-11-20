import {GET_USER, GET_ACTIVE_TAB} from "./types"
const initialState = {
    user:[],
    activeTab:1,
};

export default function(state = initialState, action){

    switch(action.type){

        case GET_USER:
            return {
                ...state,
                user:action.payload,
            };

        default: return {...state}
    }

}

