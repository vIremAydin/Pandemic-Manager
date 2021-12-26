import {makeStyles} from "@material-ui/core/styles";
import {Button, Grid, TextField} from "@material-ui/core";
import axios from "axios";
import * as React from "react";
import {connect} from "react-redux";
import Courses from "../pages/Courses";


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

const AttendanceStudent = ({user, course}) => {
    const classes = useStyles();

    const [attendanceCode, setAttendanceCode] = React.useState(0);
    const [courseAttendanceCode, setCourseAttendanceCode] = React.useState("");
    const [courseAttendanceID, setCourseAttendanceID] = React.useState("");

    

    async function fetchCourseAttendanceCode() {

        axios.post("http://localhost:8080/api/course/create/course", {
            courseName: course,
            section: 1,
        }).then(response => {
            console.log(response.data.courseID);
            axios.post("http://localhost:8080/api/course/create/attendance/" + response.data.courseID).then(response => {
            console.log(response);
            setCourseAttendanceCode(response.data.attendanceRecord[response.data.attendanceRecord.length - 1].attendanceCode);
            setCourseAttendanceID(response.data.attendanceRecord[response.data.attendanceRecord.length - 1].attendanceID);
            }).catch(function(error) {
                console.log(error)
            })
        }).catch(function(error) {
            console.log(error)
        })
    }

    React.useEffect(() => {
        fetchCourseAttendanceCode();
    }, [])

    React.useEffect(() => {

    }, [courseAttendanceCode, courseAttendanceID])

    async function handleClick() {
        if(attendanceCode == courseAttendanceCode) {
            axios.post("http://localhost:8080/api/attendance/add/student/" + courseAttendanceID + "/" + user.id, {
            
            }).then(function(response) {
                alert("You are marked as present in database for the course" + course);
            }).catch(function(error) {
                console.log(user);
                console.log(error)
            })
            
        }
    }

    
    return (
        <Grid container>
            <div className={classes.container}>
                <TextField onChange={(event) => setAttendanceCode(event.target.value)} className={classes.textField} id="outlined-basic" label="Code" variant="outlined"/>
                <Button className={classes.btn} variant="contained" onClick={() => handleClick()}>Enter</Button>
            </div>

        </Grid>

    )
}
const mapStateToProps = (state) => {
    return {
        user: state.user.user,
        course: state.activeTab.selectedCourse
    }
}
export default connect(mapStateToProps)(AttendanceStudent);
