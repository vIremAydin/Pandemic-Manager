import {makeStyles} from "@material-ui/core/styles";

const useStyles = makeStyles({
    header: {
        fontSize: "26px",
        marginTop: "10px",
        color: '#023047',
    }
});
const AllCases = () =>{
    const classes = useStyles();
    return(
        <div >
            <h1 className={classes.header}>All Positive and Contacted Cases in Bilkent University</h1>

        </div>
    )
}

export default AllCases;
