import {makeStyles} from "@material-ui/core/styles";
import {Header} from "../components/Header";
import {Grid} from "@material-ui/core";
import Sidebar from "../components/Sidebar";
import AttendanceStudent from "./Attendance-student";

const useStyles = makeStyles({
    MyCoursesPage: {
        backgroundColor: '#ffffff',
        boxSizing: 'border-box',
        height: '100%'
    },

});

function MainPage() {
    const myCourses = ["CS-319", "CS-315", "CS-224", "CS-202"];
    const classes = useStyles();
    return (
        <div>
            <Header/>
            <Grid container>
                <Grid item xs={4}>
                    <Sidebar/>
                </Grid>
                <Grid item xs={8}>
                    <AttendanceStudent/>
                </Grid>

            </Grid>
        </div>
    )

}

export default MainPage;
