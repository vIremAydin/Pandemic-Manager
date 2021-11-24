import {GET_ACTIVE_TAB, CHANGE_ACTIVE_TAB, GET_SELECTED_COURSE, CHANGE_SELECTED_COURSE} from "./types";

const INITIAL_STATE = {
   activeTab : "MyCourses",
   selectedCourse: null,
};

const TabReducer = (state = INITIAL_STATE, action) => {
    switch(action.type){

        case GET_ACTIVE_TAB:
            return {
                ...state,
                activeTab:action.payload,
            };
        case GET_SELECTED_COURSE:
            return {
                ...state,
                selectedCourse:action.payload,
            };
        case CHANGE_ACTIVE_TAB:
            return {
                ...state,
                activeTab: action.payload,
        };
        case CHANGE_SELECTED_COURSE:
            return {
                ...state,
                selectedCourse: action.payload,
            }

        default: return {...state}
    }

}
export default TabReducer;
