import { makeStyles } from "@material-ui/core/styles";
import userLogo from "../images/userLogo.png";
import {Button, TextField, Link} from "@material-ui/core";


const useStyles = makeStyles({
    helpContainer: {
        width: "50%",
        height: "80%",
        marginTop: "15%",
        marginLeft: "30%",
    },

    title: {
        color: "#023047",
        fontSize:"30px",
    },
    box: {
        width: "100%",
        height: "80%",
        background: "#FFFFFF",
        border: "1px solid #C4C4C4",
        boxSizing: "border-box",
        boxShadow: "0px 6px 4px rgba(0, 0, 0, 0.25)",
        borderRadius: "10px",
        paddingBottom:"20px",
        paddingTop:"40px",
    },

    set: {
        display:"flex",
        flexDirection:"row",
        marginLeft: "10px",
        marginRight: "10px",
        marginTop:"-20px",
        
    },
    
    p:{
        color: "#023047",
        fontWeight:"bold"
    },

    report: {
        display:"flex",
        flexDirection:"row",
        marginTop:"20px",
        marginBottom:"10px",
    },

    reportButton: {
        marginLeft:"20px",
        color: "#023047",
        width:"25%",
    }
});

const Help = ()=>{
    const classes = useStyles();
    const questionsAndAnswers = [{question: "Why can’t I enter a course attandance code?", answer: "There is a 3 minutes time limit to enter the code. After 3 minutes, the attandance session ends."},
                                {question: "Why can’t I view the seat plan?", answer:"Your instructor might not enter the seat plan details (i.e. number of rows and columns of the seat plan)."},
                                {question: "Why don’t I get any email regarding test schedule remainder?", answer: "Click on Test Schedule button on main page, then please check the box (i.e. “Notify me when my test day arrives”). "},
                                {question: "How to update my vaccination information?", answer: "Click on Covid19 Status button on main page, then click the button “Upload Vaccination Card” under “Vaccination Information” title."}];
    
    const handleButtons = (buttonName) => {
        return undefined;
    }

    return (
        <div className={classes.helpContainer}>
            <p className={classes.title}>FAQ</p>
            <div className={classes.box}>
                {
                    questionsAndAnswers.map((object, index) => (
                        <div>
                            <div className={classes.set}> <p className={classes.p}>Q{index + 1}.</p> <p>{object.question}</p></div>
                            <div className={classes.set}> <p className={classes.p}>A{index + 1}.</p> <p style={{paddingBottom:"10px"}}>{object.answer}</p></div>
                        </div>
                    ))
                }
                
            </div>
            <div className={classes.report}>
                <TextField id="outlined-basic" label="Student Name and Surname" variant="outlined" size="small"/>
                <Button variant="contained" className={classes.reportButton} onClick = {() => handleButtons("reportButton")}>Report Student</Button>

            </div>
            <Button variant="contained" style={{color:"#023047"}} onClick = {() => handleButtons("contactButton")}>Contact Health Center</Button>
            
            
        </div>

    );
}
export default Help;