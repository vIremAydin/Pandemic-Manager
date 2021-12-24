import './App.css';
import {makeStyles} from "@material-ui/core/styles";
import MainPage from "./pages/Main-page";
import Welcome from "./pages/Welcome";
import {Route, Routes} from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Courses from "./pages/Courses";
import HCMain from "./pages/HealthCenter/HCMain";


const useStyles = makeStyles({
    container: {}
});

function App() {
    return (
        <div>
            <Routes>
                <Route path='/' element={<Welcome/>}/>
                <Route path='/main' element={<MainPage/>}/>
                <Route path='/login' element={<Login/>}/>
                <Route path='/courses' element={<Courses/>}/>
                <Route path='/register' element={<Register/>}/>
            </Routes>
        </div>
    );
}

export default App;
