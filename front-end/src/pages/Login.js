import {makeStyles} from "@material-ui/core/styles";
import userLogo from "../images/userLogo.png";
import {Button, TextField} from "@material-ui/core";
import {Link} from "react-router-dom"
import axios from "axios";
import * as React from "react";
import {useEffect} from "react";
import {Alert} from "@mui/material";

const useStyles = makeStyles({
    loginContainer: {
        width: "20%",
        height: "40%",
        marginLeft: "40%",
        marginTop: "10%",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center"
    },

    title: {
        color: "#023047",
        fontSize: "20px",
    },

    textfield: {
        width: "100%",
        height: "20px",
        borderRadius: "20px",
        marginTop: "20%",
    },

    loginButton: {
        marginTop: "70%",
        width: "100%",
        background: "#023047",
        color: "#ffffff",
        marginBottom: "8%",
    }

});

const Login = () => {
    const classes = useStyles();

    const [id, setId] = React.useState(0);
    const [password, setPassword] = React.useState('');
    const [isSuccessful, setSuccessful] = React.useState(true);
    useEffect(() => {
    }, [isSuccessful]);

    async function handleClick() {

        axios.get("http://localhost:8080/api/student/login/" + id + "/" + password).then((response) => {
            console.log(response.data);
            setSuccessful(response.data);
        }).catch((error) => {
            console.log(error);
        })


    }


    return (
        <div className={classes.loginContainer}>{
            isSuccessful ?   (<span/>) :
                <Alert  severity="error">Invalid email or password</Alert>

        }
            <p className={classes.title}>Welcome to Visual Pandemic</p>
            <img src={userLogo} alt=""/>
            <TextField id="outlined-basic" label="Email" variant="outlined" className={classes.textfield}
                       onChange={(event) => setId(event.target.value)}/>
            <TextField id="outlined-basic" label="Password" variant="outlined" className={classes.textfield}
                       onChange={(event) => setPassword(event.target.value)}/>
            <Link to={isSuccessful ? ("/courses") : "/login"}><Button variant="contained"
                                                                      className={classes.loginButton}
                                                                      onClick={() => handleClick()}>Login</Button></Link>
            <p>Forgot Password?</p>
            <Link to={"/register"}>Don't have an account?</Link>
        </div>

    );
}
export default Login;
