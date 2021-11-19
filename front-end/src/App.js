import './App.css';
import {makeStyles} from "@material-ui/core/styles";
import logo from './images/logo.png';
import userLogo from './images/userLogo.png';
import {Header} from './components/Header'
import Sidebar from './components/Sidebar'
//import { useState } from 'react';

const useStyles = makeStyles({
 container:{

 }
});

function App() {
    const myCourses = ["CS-319", "CS-315", "CS-224", "CS-202"];
    const classes = useStyles();
    return (
        <div className={classes.container}>
            <Header/>
            <Sidebar/>
        </div>

    );
}

export default App;
