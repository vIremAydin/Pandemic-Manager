import {makeStyles} from "@material-ui/core/styles";
import {Button, Grid, TextField} from "@material-ui/core";
import axios from "axios";
import * as React from "react";

const useStyles = makeStyles({
    textField: {
        width: "300px",
        marginLeft: "100px"
    },
    container: {
        borderRadius: "10px",
        border: "1px solid #C4C4C4",
        width: "500px",
        height: "200px",
        display: "flex",
        flexDirection: "column",
        justifyContent: "space-around",
        padding: "30px",
        boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
        marginTop: "40px",

    },
    btn: {
        background: "#F1B24A"
    }

});

const AttendanceStudent = () => {
    const classes = useStyles();

    //const [studentId, setStudentId] = React.useState(0);
    //const [attendanceCode, setAttendanceCode] = React.state.id;

   // console.log(React.state.id);

    axios.post("http://localhost:8080/api/attendance/add/student/{}{}", {

        }).then(function(response) {
            console.log(response.status);
        }).catch(function(error) {
            console.log(error)
        })
    return (
        <Grid container>
            <div className={classes.container}>
                <TextField className={classes.textField} id="outlined-basic" label="Code" variant="outlined"/>
                <Button className={classes.btn} variant="contained">Enter</Button>
            </div>

            <div className={classes.container}>
                <span style={{fontSize:"20px"}}>Attendance Records</span>

            </div>
        </Grid>

    )
}
export default AttendanceStudent;
