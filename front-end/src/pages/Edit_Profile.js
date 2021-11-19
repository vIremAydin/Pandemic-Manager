import { makeStyles } from "@material-ui/core/styles";
import userLogo from "../images/userLogo.png";


const useStyles = makeStyles({
    editProfile: {
        display: "flex",
        width: "800px",
        height: "600px",
        marginTop: "200px",
        marginLeft: "300px",
        flexDirection: "column",
    },

    title: {
        width: "344px",
        height: "52px",
        fontSize: "44px",
        lineHeight: "52px",
        color: "#023047",
    },

    label: {
        width: "250px",
        height: "37px",
        fontSize: "20px",
        lineHeight: "23px",
        color: "#000000",
        float:"left",
        marginRight:"50px",
    },
    textfield: {
        width: "367px",
        height: "42px",
        fontSize: "20px",
        background: "#FFFFFF",
        border: "0.5px solid #C4C4C4",
        boxSizing: "border-box",
        borderRadius: "5px",
        float:"left",
        marginBottom: "10px",
    },

    form: {
        width: "700px"
    },

    link: {
        display:"block",
        width: "140px",
        marginBottom:"40px",
        marginLeft: "300px",
        color: "rgba(80, 34, 209, 1)"
    },
    
    saveButton: {
        width: "120px",
        height: "50px",
        marginLeft: "550px",
        borderRadius: "10px",
        border: "1px solid  #C4C4C4",
        backgroundColor: "rgba(2, 48, 71, 0.1)",
        color: "#023047",
        fontSize:"15px",
    },
    buttonUploadPhoto: {
        width: "200px",
        height: "50px",
        marginLeft: "200px",
        marginTop:"25px",
        borderRadius: "10px",
        border: "1px solid  #C4C4C4",
        backgroundColor: "rgba(2, 48, 71, 0.1)",
        color: "#023047",
        fontSize:"15px",
    },
    ppPart: {
        display:"flex",
        flexDirection:"row",
        marginBottom:"50px",
    }
});

const EditProfile = ()=>{
    const classes = useStyles();

    const handleButton = (buttonName) => {
        return undefined;
    } 
    
    return (
        <div className={classes.editProfile}>
            <p className={classes.title}>Edit Your Profile</p>
            <div className={classes.ppPart}>
                <img src={userLogo} alt=""/>
                <button className={classes.buttonUploadPhoto} onClick={() => handleButton("saveButton")}>Upload New Profile Photo</button>
            </div>
            <div>
                <form className={classes.form}>
                    
                    <label className={classes.label} for="name">Name: </label>
                    <input className={classes.textfield}  className={classes.textfield}  id="name" type="text"></input>
                
                    <label className={classes.label} for="newPassword">New Password: </label>
                    <input className={classes.textfield}  className={classes.textfield}  id="newPassword" type="text"></input>
                
                    <label className={classes.label} for="confirmNewPassword">Confirm New Password: </label>
                    <input className={classes.textfield}  className={classes.textfield}  id="confirmNewPassword" type="text"></input>
                
                    <label className={classes.label} for="existingPassword">Existing Password: </label>
                    <input className={classes.textfield}  className={classes.textfield}  id="existingPassword" type="text"></input>
                    
                    <a href="#" className={classes.link}>Forgot Password?</a>
                    <button className={classes.saveButton} onClick={() => handleButton("saveButton")}>Save</button>
                    
                </form>
                
            </div>
           
        </div>

    );
}
export default EditProfile;