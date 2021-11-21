import './App.css';
import {makeStyles} from "@material-ui/core/styles";
import MainPage from "./pages/Main-page";
import Welcome from "./pages/Welcome";
//import { useState } from 'react';

const useStyles = makeStyles({
    container: {}
});

function App() {

    return (
        <div>
            <Welcome/>
        </div>

    );
}

export default App;
