import {CHANGE_ACTIVE_TAB} from "./types";

export const changeTab = (tab) =>({
        type:CHANGE_ACTIVE_TAB,
        payload:tab
    }
);
