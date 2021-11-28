import { combineReducers } from 'redux'
import UserReducer from './userReducers'
import TabReducer from "./tabReducer";

export default combineReducers({
    user: UserReducer,
    activeTab:TabReducer,

});
