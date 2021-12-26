import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import {makeStyles} from "@material-ui/core/styles";
import {Button} from "@material-ui/core";
import axios from 'axios';
import {connect} from "react-redux";



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
const TestCalendar = ({user}) =>  {
    const [value, onChange] = useState(new Date());
    const [day, setDay] = useState("");
    const classes = useStyles();

    const handleClick = (day) => {
        console.log(user);
        axios.post("http://localhost:8080/api/test/create/" + user.id).then(response => {
            alert("Coivd19 Test Appointment was requested for " + day);
        });
    }


    const handleDay = (clickedDay) => {setDay(clickedDay.toString().substr(0,15)); console.log(clickedDay.toString().substr(0,15))};

    return (
        <div className={classes.container}>
            <h1 className={classes.header}>Schedule a Test</h1>
            <Calendar
                onChange={onChange}
                value={value}
                onClickDay={handleDay}
            />
            <Button variant="contained" onClick = {() => handleClick(day)}>Take A Test Appointment</Button>
        </div>
    );
}

const mapStateToProps = (state) => {
    return {user: state.user.user};
}
export default connect(mapStateToProps)(TestCalendar);
