import './App.css';
import {makeStyles} from "@material-ui/core/styles";
import {Header} from './components/Header'
import Courses from './components/Courses'

import Sidebar from './components/Sidebar'
//import { useState } from 'react';

const useStyles = makeStyles({
    container: {}
});

function App() {
    const myCourses = ["CS-319", "CS-315", "CS-224", "CS-202"];
    const classes = useStyles();
    return (
        <div className={classes.container}>
            <Header/>
            <Sidebar/>
            <Courses/>
        </div>

    );
}

export default App;
