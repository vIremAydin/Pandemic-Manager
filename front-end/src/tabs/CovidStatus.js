import {Grid} from "@material-ui/core";
import {useState} from "react";
import {makeStyles} from "@material-ui/core/styles";
import axios from "axios";
import {connect} from "react-redux";
import * as React from "react";
import {Button, TextField, Link} from "@material-ui/core";

const useStyles = makeStyles({
    box: {
        width: "300px",
        height: "50px",
        padding: "10px",
        border: "2px solid #C4C4C4",
        boxSizing: "border-box",
        boxShadow: "0px 2px 2px rgba(0, 0, 0, 0.25), -2px -2px 2px rgba(0, 0, 0, 0.25)",
        borderRadius: "10px",
        display: "flex",
        justifyContent: "space-between"
    },
    col: {
        display: "flex",
        flexDirection: "column",
    },
    colItem: {
        marginTop: "20px",
        marginBottom: "20px",
    },

});
const CovidStatus = ({user}) => {
    const classes = useStyles();
    const [allowed, setAllowed] = useState(false);
    const [hesCode, setHesCode] = useState("");
    const [vaccinationNames, setVaccinationNames] = useState([]);
    const [datesOfDoses, setDatesOfDoses] = useState([]);
    const [nbOfDoses, setNbOfDoses] = useState(0);
 
    async function handle() {
        axios.get("http://localhost:8080/api/student/get/" + user.id).then((response) => {
            console.log(user);
        setHesCode(response.data.covidStaus.hesCode);
        setAllowed(response.data.covidStaus.allowedToCampus)
        setVaccinationNames(response.data.vaccinationStatus.vaccinationNames);
        setDatesOfDoses(response.data.vaccinationStatus.datesOfDoses);
        setNbOfDoses(response.data.vaccinationStatus.numOfDoses);
    });
        
    }

    
    React.useEffect(() => {
        handle();
    }, []);

    const [selectedFile, setSelectedFile] = React.useState(null);

    const fileSelectedHandler = event => {
        setSelectedFile(event.target.files[0]);
        console.log(event.target.files[0]);
        setDatesOfDoses([event.target.files[0].lastModifiedDate.toString().substr(0, 15), ...datesOfDoses]);
    }

    React.useEffect(() => {

    }, [datesOfDoses])

    async function handleClick() {
       console.log(selectedFile);
       datesOfDoses.map((object) => {
            axios.post("http://localhost:8080/api/student/add/vaccinationDate/" + user.id, {
                object
            }).then((response) => {
                console.log("successful");
            })


        })
        vaccinationNames.map((object) => {
            axios.post("http://localhost:8080/api/student/add/vaccinationName/" + user.id, {
                object
            }).then((response) => {
                console.log("successful");
            })
        })
    }

    

    return (
        <Grid container>
            
            <Grid item xs={6}>
                <div className={classes.col}>
                    <div className={classes.colItem}>
                        <h3>Covid-19 Status</h3>
                        <div>{
                            allowed ? <p style={{color: "green"}}>You are allowed on campus.</p> :
                                <p style={{color: "red"}}>You are not allowed on campus</p>
                        }</div>
                        <div className={classes.box}>
                            <p>HES CODE:</p>
                            <p>{hesCode}</p>
                        </div>
                    </div>
                    <div className={classes.colItem}>
                        <h3>Covid-19 Records</h3>
                        <div className={classes.box} style={{marginTop:"20px"}}>
                            <p>23.09.2020</p>
                            <p>Positive</p>
                        </div>
                    </div>
                </div>

            </Grid>
            <Grid item xs={6}>
                <div className={classes.col}>
                    <div className={classes.colItem}>
                        <h3>Vaccination Info</h3>
                    </div>
                    </div>
                    <div className={classes.colItem}>
                        <TextField id="outlined-basic" label="Vaccination Name" variant="outlined" onChange={(event) => setVaccinationNames([event.target.value, ...vaccinationNames])}/>
                        <input type="file" onChange={fileSelectedHandler} name="Upload Vaccination Card"/>
                        <Button variant="contained" style={{color:"#023047"}} onClick = {() => handleClick()}>Upload Vaccination Card</Button>
                        <div></div>
                        {console.log(datesOfDoses)}
                        {datesOfDoses.map((object, index) => {
                            <div className={classes.box}>
                                <p>{object}</p>
                                <p>{vaccinationNames[index]}</p>
                            </div>
                        })}
               
                    
                </div>
            </Grid>
        </Grid>
    )
}
const mapStateToProps = (state) => {
    return {user: state.user.user};
}
export default connect(mapStateToProps)(CovidStatus);
