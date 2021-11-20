import { combineReducers } from 'redux'
import userReducer from './userReducers'
import TabReducer from "./tabReducer";

export default combineReducers({
    user: userReducer,
    activeTab:TabReducer,

});
