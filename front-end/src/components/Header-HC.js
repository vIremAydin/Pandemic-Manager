import {makeStyles} from "@material-ui/core/styles";
import logo from "../images/logo.png";
import notification from "../images/notification.png"
import {connect} from "react-redux";
import {changeTab} from "../redux/tab-action";
import MyButton from "./MyButton";


const useStyles = makeStyles({
    container: {
        padding: "40px",
        background: '#023047',
        height: '120px',
        boxSizing: 'border-box',
    },

    logo: {
        width: "150px",
        height: "100px"

    },
    logoContainer: {
        width: "%10",

        position: "absolute",
        top: "0px",
        left: "10px",
    },

    buttons: {
        marginLeft:"100px",
        display: "flex",
        flexDirection: "col",
        justifyContent: "space-evenly"
    },

    headerRightPart: {
        marginLeft: "300px",
        width: "80%",
        height: "100%",
        marginTop: "-50px"
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
        <div className={classes.container}>
            <div className={classes.logoContainer}>
                <img className={classes.logo} src={logo} alt=""/>
            </div>
            <div className={classes.buttons}>
                <MyButton onClick={() => handleButtons("AllCases")} isActive={tab === "AllCases"} name={"All Cases"}/>
                <MyButton onClick={() => handleButtons("Dorm")} isActive={tab === "Dorm"} name={"Dorm"}/>
                <MyButton onClick={() => handleButtons("Schedule")} isActive={tab === "Schedule"} name={"Schedule"}/>

                <img className={classes.notificationIcon} src={notification} alt=""/>

            </div>

        </div>
    )
}

const mapDispatchToProps = dispatch => ({
    changeTab: tab => dispatch(changeTab(tab)),
});
export default connect(null, mapDispatchToProps)(HeaderHC);

