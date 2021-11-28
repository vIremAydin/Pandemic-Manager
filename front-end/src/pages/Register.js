import {makeStyles} from "@material-ui/core/styles";
import userLogo from "../images/userLogo.png";
import {Button, MenuItem, TextField} from "@material-ui/core";
import {Link} from "react-router-dom";
import * as React from "react";
import {changeTab} from "../redux/tab-action";
import {saveUser} from "../redux/user.action";
import {connect} from "react-redux";

const useStyles = makeStyles({
    loginContainer: {
        width: "15%",
        height: "40%",
        marginLeft: "42.5%",
        marginTop: "50px",
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
        margin: "15px",
        width: "300px"
    },

    registerButton: {
        marginTop: "20%",
        width: "100%",
        background: "#023047",
        color: "#ffffff",
        marginBottom: "8%",
    },
    textContainer: {
        display: "flex",
        flexDirection: "column"
    }

});
const userTypes = [{value: "student"},
    {value: "instructor"},
    {value: "doctor"},
    {value: "nurse"}];

const Register = ({saveUser}) => {
    const classes = useStyles();
    const [userType, setUserType] = React.useState('student');
    const [userName, setUserName] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [hes, setHes] = React.useState('');

    const handleChange = (event) => {
        setUserType(event.target.value);
    };

    function handleClick() {
        const user = {
            userName: userName,
            password: password,
            type: userType,
            hesCode: hes
        };
    console.log(user);
    saveUser(user);

}

return (
    <div className={classes.loginContainer}>
        <p className={classes.title}>Welcome to Visual Pandemic</p>
        <img src={userLogo} alt=""/>
        <div className={classes.textContainer}>
            <TextField onChange={(event) => setUserName(event.target.value)}
                       id="outlined-basic" required label="Email" variant="outlined" className={classes.textfield}/>
            <TextField onChange={(event) => setPassword(event.target.value)}
                       id="outlined-basic" required label="Password" variant="outlined"
                       className={classes.textfield}/>
            <TextField onChange={(event) => setHes(event.target.value)}
                       id="outlined-basic" required label="HES Code" variant="outlined"
                       className={classes.textfield}/>
            <TextField
                id="outlined-select-currency"
                select
                label="User Type"
                value={userType}
                onChange={handleChange}
                helperText="Please select your user type"
                className={classes.textfield}
            >
                {userTypes.map((option) => (
                    <MenuItem key={option.value} value={option.value}>
                        {option.value}
                    </MenuItem>
                ))}
            </TextField>
        </div>
        <Link to={"/courses"}><Button onClick={() => handleClick()} variant="contained"
                                      className={classes.registerButton}>Create an
            account</Button></Link>
        <p>Already have an account? <Link to={"/login"}>Log in</Link></p>
    </div>

);
}
const mapDispatchToProps = dispatch => ({
    saveUser: user => dispatch(saveUser(user)),
});
export default connect(null, mapDispatchToProps)(Register);
