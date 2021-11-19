import {makeStyles} from "@material-ui/core/styles";
import userLogo from "../images/userLogo.png";

const useStyles = makeStyles({
    sidebar:{
        display: "flex",
        flexDirection:"column",
        background:"#C4C4C4",
        width:"250px",
        height:"600px",
        padding:"20px",
    },
    buttonLeftPart: {
        display: "flex",
        marginLeft: "10%",
        marginTop: "30px",
        background: "rgba(45, 45, 45, 0.24)",
        '&:hover': {
            background:"rgba(45, 45, 45, 0.75)",
        },
        borderRadius: "20px",
        borderColor: "#000000",
        color: "#000000",
        width: "200px",
        height: "40px",
        alignItems: "center",
        justifyContent: "center",
    },
    userLogo:{
      alignItems: "center",
      marginLeft: "80px",
    },
    userName:{
        textAlign:"center",
    }

});

const Sidebar =() =>{
    const classes = useStyles();

    function handleButtons(covid19Status) {
        return undefined;
    }

    return(
    <div className = {classes.sidebar}>
        <div className={classes.userLogo}>
            <img src={userLogo} alt={""}/>
        </div>
        <div className={classes.userName}>
            <span>username</span>
        </div>
        <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Covid19 Status")}>Covid19 Status</button>
        <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Test Schedule")}>Test Schedule</button>
        <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Edit Profile")}>Edit Profile</button>
        <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Help")}>Help</button>
        <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Logout")}>Logout</button>
    </div>
);
}
export default Sidebar;
