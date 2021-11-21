import {makeStyles} from "@material-ui/core/styles";
import Header from "../components/Header";
import {Grid} from "@material-ui/core";
import Sidebar from "../components/Sidebar";
import AttendanceStudent from "../tabs/Attendance-student";
import {connect} from "react-redux";
import Courses from "./Courses";
import {useEffect} from "react";
import HeaderHC from "../components/Header-HC";
import Edit_Profile from "../tabs/Edit_Profile";

const useStyles = makeStyles({
    MyCoursesPage: {
        backgroundColor: '#ffffff',
        boxSizing: 'border-box',
        height: '100%'
    },

});

const MainPage = ({activeTab}) => {
    useEffect(() =>{
        console.log(activeTab);

    }, [activeTab]);
    const classes = useStyles();
    return (
        <div>
            <Header/>
            <Grid container>
                <Grid item xs={4}>
                    <Sidebar/>
                </Grid>
                <Grid item xs={8}>
                    {activeTab.activeTab === "Attendance" ? <AttendanceStudent/> :
                    activeTab.activeTab === "MyCourses" ? <Courses/> :
                        <Edit_Profile/>}
                </Grid>

            </Grid>
        </div>
    );
}
const mapStateToProps = (state) => {
    return {activeTab: state.activeTab};
}
export default connect(mapStateToProps)(MainPage);
