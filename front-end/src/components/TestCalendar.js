import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import {makeStyles} from "@material-ui/core/styles";


const useStyles = makeStyles({
    container:{
        marginTop:"10px",

    },

    header: {
        fontSize: "26px",
        marginTop: "10px",
        marginBottom:"30px",
        color: '#023047',
    }
});
const TestCalendar = () =>  {
    const [value, onChange] = useState(new Date());
    const classes = useStyles();

    return (
        <div className={classes.container}>
            <h1 className={classes.header}>Schedule a Test</h1>
            <Calendar
                onChange={onChange}
                value={value}
            />
        </div>
    );
}

export default TestCalendar;
