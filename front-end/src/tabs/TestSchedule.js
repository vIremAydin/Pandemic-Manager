import { makeStyles } from "@material-ui/core/styles";
import {Grid} from "@material-ui/core";
import userLogo from "../images/userLogo.png";
import {Button, TextField, Link} from "@material-ui/core";


const useStyles = makeStyles({
    title: {

    },

    checkbox: {
        
    },
    calendar: {
        display: "flex",
        flexDirection: "row",
        width: "20%",
        height: "100%",
    },

    day: {
        display: "flex",
        flexDirection: "row",
        width: "10%",
        height: "50px",
        background: "#FFFFFF",
        border: "1px solid #C4C4C4",
        boxSizing: "border-box",
        boxShadow: "0px 6px 4px rgba(0, 0, 0, 0.25)",
        borderRadius: "10px",
        alignItem: "center",

    }


});

const TestSchedule = ()=>{
    const classes = useStyles();
    
    
    
     return(
        <Grid>
            <p className={classes.title}>Covid19 Test Schedule</p>
            <div className={classes.checkBox}></div>
            <div className={classes.calendar}>
                <div>31</div>
                {[...Array(30)].map((x,i) => 
                    <div className = {classes.day}>
                        {i}
                    </div>
                )}
            </div>
            
            
        </Grid>
    );

    
}
export default TestSchedule;