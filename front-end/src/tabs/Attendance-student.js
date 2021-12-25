import {makeStyles} from "@material-ui/core/styles";
import {Button, Grid, TextField} from "@material-ui/core";
import axios from "axios";
import * as React from "react";
import {connect} from "react-redux";


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

const AttendanceStudent = ({user}) => {
    const classes = useStyles();

    const [attendanceCode, setAttendanceCode] = React.useState(0);

    async function handleClick() {
        axios.post("http://localhost:8080/api/attendance/add/student/" + attendanceCode + "/" + user.id, {
        
        }).then(function(response) {
            console.log("student attendance code is saved in database");
        }).catch(function(error) {
            console.log(error)
        })
    }

    
    return (
        <Grid container>
            <div className={classes.container}>
                <TextField onChange={(event) => setAttendanceCode(event.target.value)} className={classes.textField} id="outlined-basic" label="Code" variant="outlined"/>
                <Button className={classes.btn} variant="contained" onClick={() => handleClick()}>Enter</Button>
            </div>

            <div className={classes.container}>
                <span style={{fontSize:"20px"}}>Attendance Records</span>

            </div>
        </Grid>

    )
}
const mapStateToProps = (state) => {
    return {
        user: state.user.user
    }
}
export default connect(mapStateToProps)(AttendanceStudent);
