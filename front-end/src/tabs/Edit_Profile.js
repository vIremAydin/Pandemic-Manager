import { makeStyles } from "@material-ui/core/styles";
import userLogo from "../images/userLogo.png";
import {Button, TextField, Link} from "@material-ui/core";


const useStyles = makeStyles({
    editProfileContainer: {
        width: "30%",
        height: "80%",
        marginTop: "15%",
        marginLeft: "30%",
    },

    title: {
        color: "#023047",
        fontSize:"30px",
    },

    label: {
        width:"35%",
        height: "20px",
        color: "#023047"
    },

    textfield: {
        width:"65%",
        height: "20px",
        float:"right",
        marginTop:"-12px",
    },

    container: {
        marginTop:"50px",
    },

    saveButton: {
        marginTop:"10%",
        width: "10%",
        background:"#023047",
        color:"#ffffff",
        float:"right"
    },

    uploadButton: {
        width:"60%",
        float:"right",
        marginTop:"30px",
        color: "#023047",
    },

    link: {
        marginLeft:"35%",
    }
    
    
});

const EditProfile = ()=>{
    const classes = useStyles();

    const handleButton = (buttonName) => {
        return undefined;
    } 
    
    return (
        <div className={classes.editProfileContainer}>
            <p className={classes.title}>Edit Your Profile</p>
            <div>
                <img src={userLogo} alt=""/>
                <Button variant="contained" className={classes.uploadButton}>Upload New Profile Photo</Button>
            </div>
            
            <div className={classes.container}>
                <label className={classes.label}>
                    New Password: <TextField id="outlined-basic" variant="outlined" className={classes.textfield}/>
                </label>
            </div>
            
            <div className={classes.container}>
                <label className={classes.label}>
                    Confirm New Password: <TextField id="outlined-basic" variant="outlined" className={classes.textfield}/>
                </label>
            </div>
            <div className={classes.container}>
                <label className={classes.label}>
                    Existing Password: <TextField id="outlined-basic" variant="outlined" className={classes.textfield}/>
                </label>
            </div>
            <div style={{marginTop:"40px"}}>
                <Link href="#" className={classes.link}>Forgot Password?</Link>
                <Button variant="contained" className={classes.saveButton}>Save</Button>
            </div>
            
        </div>

    );
}
export default EditProfile;