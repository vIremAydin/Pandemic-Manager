import { makeStyles } from "@material-ui/core/styles";
import userLogo from "../images/userLogo.png";
import {Button, TextField} from "@material-ui/core";
import {Link} from "react-router-dom"

const useStyles = makeStyles({
    loginContainer: {
        width: "15%",
        height: "40%",
        marginLeft: "42.5%",
        marginTop:"10%",
        display:"flex",
        flexDirection:"column",
        justifyContent:"center",
        alignItems:"center"
    },

    title: {
        color: "#023047",
        fontSize:"20px",
    },

    textfield: {
        width:"100%",
        height: "20px",
        borderRadius: "20px",
        marginTop:"20%",
    },

    loginButton: {
        marginTop: "20%",
        width: "100%",
        background:"#023047",
        color:"#ffffff",
        marginBottom:"8%",
    }

});

const Login = ()=>{
    const classes = useStyles();

    return (
        <div className={classes.loginContainer}>
            <p className={classes.title}>Welcome to Visual Pandemic</p>
            <img src={userLogo} alt=""/>
            <TextField id="outlined-basic" label="Email" variant="outlined" className={classes.textfield}/>
            <TextField id="outlined-basic" label="Password" variant="outlined" className={classes.textfield}/>
            <Link to={"/courses"}><Button variant="contained" className={classes.loginButton}>Login</Button></Link>
            <p>Forgot Password?</p>
            <Link to={"/register"}>Don't have an account?</Link>
        </div>

    );
}
export default Login;
