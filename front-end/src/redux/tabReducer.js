import {GET_ACTIVE_TAB, CHANGE_ACTIVE_TAB } from "./types";

const INITIAL_STATE = {
   activeTab : 1
};

const TabReducer = (state = INITIAL_STATE, action) => {
    switch(action.type){

        case GET_ACTIVE_TAB:
            return {
                ...state,
                activeTab:action.payload,
            };
        case CHANGE_ACTIVE_TAB:
            return {
                ...state,
                activeTab: action.payload,
        }

        default: return {...state}
    }

}
export default TabReducer;
