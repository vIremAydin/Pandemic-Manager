
import { makeStyles } from "@material-ui/core/styles";
import {Grid} from "@material-ui/core";

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

const Courses = ()=>{
    const classes = useStyles();
    const myCourses = ["CS-319", "CS-315", "CS-224", "CS-202"];
    return (
        <Grid container>
            {
                myCourses.map(courseName =>(
                    <Grid xs={6}>
                    <button className = {classes.course}>
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
                    </Grid>
                ))
            }
        </Grid>

    );
}
export default Courses;
