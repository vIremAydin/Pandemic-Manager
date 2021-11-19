import {makeStyles} from "@material-ui/core/styles";
import logo from "../images/logo.png";

const useStyles = makeStyles({

    logo: {
        width: "150px",
        height: "100px"

    },
    logoContainer: {
        marginTop:"10px",
    },

    header: {
        position: 'absolute',
        width: '100%',
        height: '20%',
        background: '#023047',
        boxSizing: 'border-box',
        display: "flex",
      justifyContent:"space-around",


    },
    buttons:{
      display: "flex",
      flexDirection:"col",
      marginTop: "40px",
    },

    headerRightPart: {
        marginLeft: "300px",
        width: "80%",
        height: "100%",
        marginTop: "-50px"
    },

    buttonsInHeader: {
        cursor:"pointer",
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
});

export const Header = () => {
    const classes = useStyles();

    function handleButtons(attandance) {
        return undefined;
    }

    return (
        <div className={classes.header}>
            <div className={classes.logoContainer}>
                <img className={classes.logo} src={logo} alt=""/>
            </div>
            <div className={classes.buttons}>
                <button className={classes.buttonsInHeader} style={{backgroundColor: "#969090"}}
                        onClick={() => handleButtons("My Courses")}>My Courses
                </button>
                <button className={classes.buttonsInHeader} onClick={() => handleButtons("Attandance")}>Attandance
                </button>
                <button className={classes.buttonsInHeader} onClick={() => handleButtons("Participants")}>Participants
                </button>
                <button className={classes.buttonsInHeader} onClick={() => handleButtons("Seat Plan")}>Seat Plan
                </button>
                <button className={classes.buttonsInHeader} onClick={() => handleButtons("Course Info")}>Course Info
                </button>
            </div>
        </div>
    )
}
