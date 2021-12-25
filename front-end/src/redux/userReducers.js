import {GET_USER, SAVE_COURSE, SAVE_USER} from "./types"

const initialState = {
    user: {},
    enrolledCourses:[],
};

const UserReducer =(state = initialState, action) => {

    switch(action.type){

        case GET_USER:
            return {
                ...state,
                user:action.payload,
            };
        case SAVE_USER:
            return {
                ...state,
                user: action.payload
            };
        case SAVE_COURSE:
            return {
                ...state,
                enrolledCourses: action.payload
            }

        default: return {...state}
    }

}

export default UserReducer;
