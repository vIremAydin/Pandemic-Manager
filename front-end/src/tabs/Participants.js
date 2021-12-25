import {makeStyles} from "@material-ui/core/styles";
import {useState, useEffect} from "react";
import {Grid} from "@material-ui/core";
import axios from "axios";
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
const Participants = ({user, course}) => {
    const classes = useStyles();
    const [allStudents, setAllStudents] = useState([{name: "irem", id: 123},
        {name: "iremA", id: 124},
        {name: "iremAB", id: 125},]);

    

    async function fetchParticipants() {
        axios.get("http://localhost:8080/api/student/getAll" ).then(response => {
            setAllStudents(response.data);
            let allEnrolledCourses = response.data.map((a, index) => {
                if(a.enrolledCourses.map(b => course)) {
                    return a;
                }
            });
            console.log(allEnrolledCourses)
        });
    }

    useEffect(()=>{
        fetchParticipants();
    }, []);
    return (
        <div>
            
            <h1 className={classes.header}>Participants</h1>
            <Grid container direction={"column"}>{
                allStudents.map((itm) =>  (<Grid item><div className={ classes.box}>
                    <span>Email: {itm.email}</span>
                     <span> ID: {itm.id}</span>
                </div> </Grid>))
            }
            </Grid>
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        user: state.user.user,
        course: state.activeTab.selectedCourse
    }
}
export default connect(mapStateToProps)(Participants);
