import { makeStyles } from "@material-ui/core/styles";
import userLogo from "../images/userLogo.png";
import {Button, TextField, Link, Grid} from "@material-ui/core";


const useStyles = makeStyles({
    
    container: {
        marginTop:"10%"
    },

    inputContainer:{
        marginTop:"2%",
    },

    textfield: {
        marginTop: "10px"
    },

    label: {
        marginBottom: "40px"
    },

    labelContainer:{
        paddingTop:"30px",
    },

    title: {
        color: "#023047",
        fontSize:"30px",
    },

    uploadButton: {
        marginTop:"10%",
        width:"100%"
    },

    saveButton:{
        float:"right",
        background:"#023047",
        color:"#ffffff",
    }
});

const EditProfile = ()=>{
    const classes = useStyles();

    const handleButton = (buttonName) => {
        return undefined;
    }

    return (
        <div className={classes.container}>
            <p className={classes.title}>Edit Your Profile</p>
            <Grid container>
                <Grid item xs={3}>
                    <img src={userLogo} alt=""/>
                </Grid>
                <Grid item xs={3}>
                     <Button variant="contained" className={classes.uploadButton}>Upload New Profile Photo</Button>
                </Grid>
            </Grid>
            <Grid container className={classes.inputContainer}>
                <Grid item xs={3} container direction="column" className={classes.labelContainer}>
                    <label className={classes.label} for="newPassword">New Password: </label>
                    <label className={classes.label} for="confirmPassword">Confirm New Password: </label>
                    <label className={classes.label} for="existingPassword">Existing Password: </label>
                </Grid>
                <Grid item xs={3} container direction="column" justifyContent="center">
                    <TextField variant="outlined" className={classes.textfield} id="newPassword"/>
                    <TextField variant="outlined" className={classes.textfield} id="confirmPassword"/>
                    <TextField variant="outlined" className={classes.textfield} id="existingPassword"/>
                </Grid>
            </Grid>
            <Grid container>
                <Grid item xs={3}></Grid>
                <Grid item xs={3}><Link href="#" className={classes.link}>Forgot Password?</Link></Grid>
            </Grid>
            <Grid container>
                <Grid item xs={3}></Grid>
                <Grid item xs={3}>
                    <Button variant="contained" className={classes.saveButton}>Save</Button>
                </Grid>
            </Grid>
        </div>
    );
}
export default EditProfile;
