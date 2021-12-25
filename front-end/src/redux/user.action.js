import {SAVE_USER, SAVE_COURSE} from "./types";

export const saveUser = (user) =>({
        type:SAVE_USER,
        payload:user
    }
);
export const saveCourse = (course) =>({
        type:SAVE_COURSE,
        payload:course
    }
);
