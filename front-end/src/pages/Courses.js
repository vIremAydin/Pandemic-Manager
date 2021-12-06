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
import Button from "@mui/material/Button";


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

const Courses = ({activeTab, changeTab}) => {
    const classes = useStyles();
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    function goToCourse() {
        changeTab("Courses");
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
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Enroll</Button>
                    <Button onClick={handleClose}>Cancel</Button>
                </DialogActions>
            </Dialog>



        </div>

    );
}
const mapStateToProps = (state) => {
    return {activeTab: state.activeTab.activeTab};
}
const mapDispatchToProps = dispatch => ({
    changeTab: tab => dispatch(changeTab(tab)),
});
export default connect(mapStateToProps, mapDispatchToProps)(Courses);
