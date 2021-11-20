import {makeStyles} from "@material-ui/core/styles";
import logo from "../images/logo.png";
import notification from "../images/notification.png"
import {connect} from "react-redux";
import {changeTab} from "../redux/tab-action";
import MyButton from "./MyButton";


const useStyles = makeStyles({

    logo: {
        width: "150px",
        height: "100px"

    },
    logoContainer: {
        marginTop: "10px",
    },

    header: {
        width: '100%',
        height: '120px',
        background: '#023047',
        boxSizing: 'border-box',
        display: "flex",
        justifyContent: "space-around",


    },
    buttons: {
        display: "flex",
        flexDirection: "col",
        marginTop: "40px",
    },

    headerRightPart: {
        marginLeft: "300px",
        width: "80%",
        height: "100%",
        marginTop: "-50px"
    },

    buttonsInHeader: {
        cursor: "pointer",
        marginLeft: "30px",
        width: "164px",
        height: "47px",
        background: "#F1B24A",
        '&:hover': {
            background: "#969090",
        },
        boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
        borderRadius: "10px",
        // borderColor: "#000000",
    },
    notificationIcon: {
        cursor: "pointer",
        marginLeft: "20px",
        width: "50px",
        height: "50px",
    }
});

const HeaderHC = ({tab, changeTab}) => {
    const classes = useStyles();

    function handleButtons(tab) {
        changeTab(tab);
        console.log(tab);
    }

    return (
        <div className={classes.header}>
            <div className={classes.logoContainer}>
                <img className={classes.logo} src={logo} alt=""/>
            </div>
            <div className={classes.buttons}>
                <MyButton onClick={()=>handleButtons("AllCases")}  isActive={tab === "AllCases"} name={"All Cases"}/>
                <MyButton onClick={()=>handleButtons("Dorm")}  isActive={tab === "Dorm"} name={"Dorm"}/>
                <MyButton onClick={()=>handleButtons("Schedule")}  isActive={tab === "Schedule"} name={"Schedule"}/>

                <img className={classes.notificationIcon} src={notification} alt=""/>

            </div>
        </div>
    )
}

const mapDispatchToProps = dispatch => ({
    changeTab: tab => dispatch(changeTab(tab)),
});
export default connect(null, mapDispatchToProps)(HeaderHC);

