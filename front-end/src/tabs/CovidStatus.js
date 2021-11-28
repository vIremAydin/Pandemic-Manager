import {Grid} from "@material-ui/core";
import {useState} from "react";
import {makeStyles} from "@material-ui/core/styles";

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
const CovidStatus = () => {
    const classes = useStyles();
    const [allowed, setAllowed] = useState(true);
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
                            <p>ABC-123-ABCD</p>
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
                    <div className={classes.box}>
                        <p>28.11.2021</p>
                        <p>BioNTech</p>
                    </div>
                    <div className={classes.box} style={{marginTop:"20px"}}>
                        <p>18.01.2021</p>
                        <p>BioNTech</p>
                    </div>
                </div>
            </Grid>
        </Grid>
    )
}

export default CovidStatus;
