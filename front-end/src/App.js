import './App.css';
import {makeStyles} from "@material-ui/core/styles";
import MainPage from "./pages/Main-page";
//import { useState } from 'react';

const useStyles = makeStyles({
    container: {}
});

function App() {

    return (
        <div>
            <MainPage/>
        </div>

    );
}

export default App;
