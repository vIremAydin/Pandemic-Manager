
import './App.css';
import { makeStyles } from "@material-ui/core/styles";
import logo from './images/logo.png';
import userLogo from './images/userLogo.png';
//import { useState } from 'react';

const useStyles = makeStyles({
   MyCoursesPage: {
      backgroundColor: '#ffffff',
      boxSizing: 'border-box',
      height: '100%' 
   },

   header: {
      position: 'absolute',
      width: '100%',
      height: '20%',
      background: '#023047',
      boxSizing: 'border-box'
   },

   headerRightPart: {
      marginLeft: "300px",
      width: "80%",
      height: "100%",
      marginTop: "-50px"
   },

   buttonsInHeader: {
      marginLeft: "30px",
      width: "164px",
      height: "47px",
      background: "#F1B24A",
      '&:hover': {
       background: "#969090",
      },
      boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
      borderRadius: "10px",
      borderColor: "#000000",
   },

   containerLeftPart: {
      position: "absolute",
      top: "174px",
      width: "253px",
      height: "82%",
      left: "0px",
      background: "rgba(45, 45, 45, 0.24)"
   },

   containerLeftPartButtons: {
      display: "block",
      marginTop: "200px",
   },

   buttonLeftPart: {
      display: "flex",
      marginLeft: "10%",
      marginTop: "30px",
      background: "rgba(45, 45, 45, 0.24)",
      '&:hover': {
         background:"rgba(45, 45, 45, 0.75)",
      },
      borderRadius: "20px",
      borderColor: "#000000",
      color: "#000000",
      width: "200px",
      height: "40px",
      alignItems: "center",
      justifyContent: "center",
   },

   course: {
      width: "200px",
      height: "250px",
      marginLeft: "100px",
      marginTop: "50px",
      background: "#FFFFFF",
      '&:hover': {
         background: "rgba(45, 45, 45, 0.5)"
      },
      border: "2px solid #C4C4C4",
      boxSizing: "border-box",
      boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25), -10px -10px 4px rgba(0, 0, 0, 0.25)",
      borderRadius: "10px",
   },

   containerRightPart: {
      width: "80%",
      height: "80%",
      paddingLeft: "240px",
      paddingTop: "258px",
   },
   containerLeftTopPart: {
      width: "100%",
      height: "5%",
      marginTop: "50px",
      textAlign: "center",
   }
});

function App() {
   const myCourses = ["CS-319", "CS-315", "CS-224", "CS-202"];
   //const instructors = ["Eray Tüzün", "Halil Altay Güvenir", "Özcan Öztürk", "Selim Aksoy"];
   
   const classes = useStyles();

   const handleButtons = (buttonName) => {
      alert(buttonName);
   }

   function ButtonsInHeader () {
      return (
         <div className = {classes.headerRightPart}>
            <button className = {classes.buttonsInHeader} style={{backgroundColor:"#969090"}} onClick={() => handleButtons("My Courses")}>My Courses</button>
            <button className = {classes.buttonsInHeader} onClick={() => handleButtons("Attandance")}>Attandance</button>
            <button className = {classes.buttonsInHeader} onClick={() => handleButtons("Participants")}>Participants</button>
            <button className = {classes.buttonsInHeader} onClick={() => handleButtons("Seat Plan")}>Seat Plan</button>
            <button className = {classes.buttonsInHeader} onClick={() => handleButtons("Course Info")}>Course Info</button>
         </div>

      );
   }

   function MyCourse ({courseName}) {
      return (
         <button className = {classes.course}>
            <div>
              <p>{courseName}</p>
            </div>
            <div>
               <p>Fall 2021-22</p>
            </div>
            <div>
               <p>Instructor: Eray Tüzün</p>
            </div>
         </button>
      );
   }
 
   function ButtonsInLeftPartOfContainer () {
      return (
         <div className = {classes.containerLeftPartButtons}>
               <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Covid19 Status")}>Covid19 Status</button>
               <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Test Schedule")}>Test Schedule</button>
               <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Edit Profile")}>Edit Profile</button>
               <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Help")}>Help</button>
               <button className = {classes.buttonLeftPart} onClick={() => handleButtons("Logout")}>Logout</button>
         </div>
      );
   }

   return (
      <div className={classes.MyCoursesPage}>
         <header className = {classes.header}>
            <img src={logo} alt=""/>
            <ButtonsInHeader/>
         </header>
         <container className = {classes.container}>
         
         <div className = {classes.containerLeftPart}>
            <div className = {classes.containerLeftTopPart}>
               <img src={userLogo} alt=""/>
               <p>Furkan Turunç</p>
               <p>Student</p>
            </div>
            
            <ButtonsInLeftPartOfContainer/>
         </div>
         <div className = {classes.containerRightPart}>
            {myCourses.map((courseName) => {
              return <MyCourse courseName = {courseName}></MyCourse>
            }
            )}
         </div>
         </container>
      </div>
   );
}

export default App;