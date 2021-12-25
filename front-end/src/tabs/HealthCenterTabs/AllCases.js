import {makeStyles} from "@material-ui/core/styles";
import {useState} from "react";
import {Grid} from "@material-ui/core";
import axios from "axios";

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
const AllCases = () => {
    const classes = useStyles();
    const [allCases, setAllCases] = useState([{name: "irem", id: 123},
        {name: "iremA", id: 124},
        {name: "iremAB", id: 125},]);

React.useEffect(()=>{getAllCases()},[]);

    async function getAllCases() {
        axios.get("http://localhost:8080/api/student/getAll" ).then((response) => {
            setAllCases(response.data.students);

        });
        setAllCases(allCases.filter(i => i.covidStaus.allowedToCampus));
    }
    return (
        <div>
            <h1 className={classes.header}>All Positive and Contacted Cases in Bilkent University</h1>
            <Grid container direction={"column"}>{
                allCases.map(itm => (<Grid item><div className={ classes.box}>
                    <span>Name: {itm.name}</span>
                     <span> ID: {itm.id}</span>
                </div> </Grid>))
            }
            </Grid>
        </div>
    )
}

export default AllCases;
