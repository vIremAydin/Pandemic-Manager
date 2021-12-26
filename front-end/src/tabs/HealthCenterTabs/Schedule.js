import {makeStyles} from "@material-ui/core/styles";
import {useState, useEffect} from "react";
import {Grid, useMediaQuery} from "@material-ui/core";
import axios from "axios";
import React from "react";
import {Button} from "@material-ui/core";
import {connect} from "react-redux";

const useStyles = makeStyles({
    header: {
        fontSize: "26px",
        marginTop: "10px",
        color: '#023047',
    },
    box:{
        height:"100px",
        width:"300px",
        borderRadius:"10px",
        marginTop:"20px",
        background:"#a5cce0",
        display:"flex",
        flexDirection:"column",
        padding:"10px",
    }
});
const Schedule = ({user}) => {
    const classes = useStyles();
    const [allTests, setAllTests] = useState([]);

    useEffect(()=>{getAllTests()},[]);

    async function getAllTests() {
        axios.get("http://localhost:8080/api/test/getAll").then(response => {
            console.log(response.data);
            setAllTests(response.data);
        });
    }

    const handleClick = (appointmentID, patientID) => {
        axios.put("http://localhost:8080/api/nurse/approve/testAppointment/" + user.bilkentId + "/" + appointmentID).then(response => {
            alert("Coivd19 Test Appointment of the user with ID " + patientID + " was approved");
        });
    }

    return (
        <div>
            <h1 className={classes.header}>All Test Requests in Bilkent University</h1>
            <Grid container direction={"column"}>{
                allTests.map(itm => (<Grid item><div className={ classes.box}>
                    <span>Date: {itm.date}</span>
                     <span> ID: {itm.patientID}</span>
                </div>  <Button variant="contained" onClick = {() => handleClick(itm.testID, itm.patientID)}>Approve Test Appointment</Button></Grid>))
            }
            </Grid>
        </div>
    )
}

const mapStateToProps = (state) => {
    return {user: state.user.user};
}
export default connect(mapStateToProps)(Schedule);
