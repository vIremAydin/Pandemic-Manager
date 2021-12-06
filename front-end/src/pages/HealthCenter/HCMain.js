import {makeStyles} from "@material-ui/core/styles";
import Header from "../../components/Header-HC";
import {Grid} from "@material-ui/core";
import Sidebar from "../../components/Sidebar";
import {connect} from "react-redux";
import {useEffect} from "react";

import Edit_Profile from "../../tabs/Edit_Profile";

import CovidStatus from "../../tabs/CovidStatus";
import Help from "../../tabs/Help"
import TestSchedule from "../../tabs/TestSchedule";
import AllCases from "../../tabs/HealthCenterTabs/AllCases";


const useStyles = makeStyles({
    MyCoursesPage: {

        boxSizing: 'border-box',
        height: '100%',

    }

});

const HCMainPage = ({activeTab}) => {
    useEffect(() => {
        console.log(activeTab);

    }, [activeTab]);
    const classes = useStyles();
    return (
        <div className={classes.MyCoursesPage}>
            <Header/>
            <Grid container>
                <Grid item xs={4}>
                    <Sidebar/>
                </Grid>
                <Grid item xs={8}>
                    {
                        activeTab.activeTab === "Covid19Status" ? <CovidStatus/> :
                            activeTab.activeTab === "Help" ? <Help/> :
                                activeTab.activeTab === "TestSchedule" ? <TestSchedule/> :
                                    activeTab.activeTab === "AllCases" ? <AllCases/> :

                                        <Edit_Profile/>}
                </Grid>

            </Grid>
        </div>
    );
}
const mapStateToProps = (state) => {
    return {activeTab: state.activeTab};
}
export default connect(mapStateToProps)(HCMainPage);
