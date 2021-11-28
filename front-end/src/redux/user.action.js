import {SAVE_USER} from "./types";

export const saveUser = (user) =>({
        type:SAVE_USER,
        payload:user
    }
);
