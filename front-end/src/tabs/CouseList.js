import {Grid} from "@material-ui/core";
import {Link} from "react-router-dom";
import React from "react";
import {changeCourse, changeTab} from "../redux/tab-action";
import {connect} from "react-redux";
import {makeStyles} from "@material-ui/core/styles";


const useStyles = makeStyles({
    course: {
        width: "200px",
        height: "250px",
        marginLeft: "100px",
        marginTop: "50px",
        background: "#FFFFFF",
        '&:hover': {
            background: "rgba(45, 45, 45, 0.5)"
        },
        border: "2px solid #C4C4C4",
        boxSizing: "border-box",
        boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25), -10px -10px 4px rgba(0, 0, 0, 0.25)",
        borderRadius: "10px",
    },
});
const CourseList =({changeCourse, changeTab}) =>{
    const myCourses = ["CS-319", "CS-315", "CS-224", "CS-202"];
const classes = useStyles();
    function handler(name) {
        changeCourse(name);
        changeTab("Attendance");
    }
    return(
        <Grid container>
            {
                myCourses.map(courseName => (
                    <Grid xs={6}>
                        <Link to={"/main"}>
                            <button onClick={() => handler(courseName)} className={classes.course}>
                                <div>
                                    <p>{courseName}</p>
                                </div>
                                <div>
                                    <p>Fall 2021-22</p>
                                </div>
                                <div>
                                    <p>Instructor: Eray Tüzün</p>
                                </div>
                            </button>
                        </Link>
                    </Grid>
                ))
            }
        </Grid>
    )
};
const mapDispatchToProps = dispatch => ({
    changeCourse: course => dispatch(changeCourse(course)),
    changeTab: tab => dispatch(changeTab(tab)),
});

export default connect(null, mapDispatchToProps)(CourseList);
