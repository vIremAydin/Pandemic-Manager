import {CHANGE_ACTIVE_TAB, CHANGE_SELECTED_COURSE} from "./types";

export const changeTab = (tab) =>({
        type:CHANGE_ACTIVE_TAB,
        payload:tab
    }
);
export const changeCourse = (course) =>({
        type:CHANGE_SELECTED_COURSE,
        payload:course
    }
);
