import {makeStyles} from "@material-ui/core/styles";
import {Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Grid, TextField} from "@material-ui/core";
import logo from "../images/logo.png";
import React from "react";
import Sidebar from "../components/Sidebar";
import AttendanceStudent from "../tabs/Attendance-student";
import Edit_Profile from "../tabs/Edit_Profile";
import {changeCourse, changeTab} from "../redux/tab-action";
import {connect} from "react-redux";
import CourseList from "../tabs/CouseList";
import MyButton from "../components/MyButton";
import CovidStatus from "../tabs/CovidStatus";
import Help from "../tabs/Help";
import TestSchedule from "../tabs/TestSchedule";
import Participants from "../tabs/Participants";
import Button from "@mui/material/Button";
import axios from "axios";
import {saveUser, saveCourse} from "../redux/user.action";
import {all_courses} from "../components/all_courses";

const useStyles = makeStyles({

    logo: {
        width: "150px",
        height: "100px"

    },
    logoContainer: {
        marginTop: "10px",
    },

    header: {
        width: '100%',
        height: '120px',
        background: '#023047',
        boxSizing: 'border-box',

    },
    btn: {
        marginTop: "30px",


    },
    btn2:{
        marginTop: "30px",
        cursor: "pointer",
    }


});


const Courses = ({activeTab, changeTab, user, saveUser, saveCourse}) => {
    const classes = useStyles();
    const [open, setOpen] = React.useState(false);
    const [courseCode, setCourseCode] = React.useState(0);
    const handleClickOpen = () => {
        setOpen(true);
    };

    React.useEffect(()=>{

    },[user,saveUser, saveCourse]);

    const handleClose = () => {
        setOpen(false);
        const b = all_courses.findIndex(itm => (itm.courseID == courseCode));
        console.log(b);
        console.log(courseCode);
        if(b !==-1 )
        enrollCourse();
    };

    function goToCourse() {
        changeTab("Courses");
    }

    async function enrollCourse() {

        axios.post("http://localhost:8080/api/course/add/student/" + courseCode + "/" + user.user.id).then((response) => {
            console.log("enrolled to course");
        }).catch((error) => {
            console.log(user);
            console.log(error);
        });
    //    const newUser ={user: user,
      //  enrolledCourses: user.enrolledCourses.push(courseCode) } ;
        user.enrolledCourses.push(courseCode);
        saveCourse(user.enrolledCourses);
        console.log(user);
    }

    return (
        <div>
            <div className={classes.header}>
                <Grid container>
                    <Grid item xs={4}>
                        <div className={classes.logoContainer}>
                            <img className={classes.logo} src={logo} alt=""/>
                        </div>
                    </Grid>
                    <Grid item xs={4}>

                    </Grid>
                    <Grid item xs={2} className={classes.btn2}>
                        <MyButton name={"Courses"} isActive={"Courses" === activeTab} onClick={()=>goToCourse()} />
                    </Grid>
                    <Grid item xs={2}>
                        <div className={classes.btn}>
                            <MyButton onClick={handleClickOpen} name={"Enroll"} isActive={false} />
                        </div>
                    </Grid>
                </Grid>
            </div>
            <Grid container>
                <Grid item xs={4}>
                    <Sidebar/>
                </Grid>
                <Grid item xs={8}>
                    {activeTab === "Courses" ? <CourseList/> :
                    activeTab === "Covid19Status" ? <CovidStatus/> :
                    activeTab === "Help" ? <Help/> :
                    activeTab === "TestSchedule" ? <TestSchedule/> :
                    activeTab === "Participants" ? <Participants/> :
                            <Edit_Profile/>}
                </Grid>
            </Grid>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Enroll in a Course</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                       Enter the course code given by your instructor
                    </DialogContentText>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="name"
                        label="Course Code"
                        type="text"
                        fullWidth
                        variant="standard"
                        onChange={(event) => setCourseCode(event.target.value)}
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={() =>handleClose()}>Enroll</Button>
                    <Button onClick={handleClose}>Cancel</Button>
                </DialogActions>
            </Dialog>



        </div>

    );
}
const mapStateToProps = (state) => {
    return {activeTab: state.activeTab.activeTab,
    user:state.user};
}
const mapDispatchToProps = dispatch => ({
    changeTab: tab => dispatch(changeTab(tab)),
    saveUser: user => dispatch(saveUser(user)),
    saveCourse: course => dispatch(saveCourse(course)),
});

export default connect(mapStateToProps, mapDispatchToProps)(Courses);
