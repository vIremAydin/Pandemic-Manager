import {makeStyles} from "@material-ui/core/styles";
import {Grid} from "@material-ui/core";
import logo from "../images/logo.png";
import React from "react";
import {Link} from "react-router-dom";
import Sidebar from "../components/Sidebar";
import {changeCourse, changeTab} from "../redux/tab-action";
import {connect} from "react-redux";

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
        cursor: "pointer",
        width: "164px",
        height: "47px",
        background: "#F1B24A",
        '&:hover': {
            background: "#969090",
        },
        boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
        borderRadius: "10px",

    },


});

const Courses = ({changeCourse}) => {
    const classes = useStyles();
    const myCourses = ["CS-319", "CS-315", "CS-224", "CS-202"];

    function handler(name) {
        changeCourse(name);
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
                    <Grid item xs={6}>

                    </Grid>
                    <Grid item xs={2}>
                        <button className={classes.btn}>Enroll in a Course</button>
                    </Grid>
                </Grid>
            </div>
            <Grid container>
                <Grid item xs={4}>
                    <Sidebar/>
                </Grid>
                <Grid item xs={8}>
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
                </Grid>
            </Grid>
        </div>

    );
}
const mapDispatchToProps = dispatch => ({
    changeCourse: course => dispatch(changeCourse(course)),
});
export default connect(null, mapDispatchToProps)(Courses);
