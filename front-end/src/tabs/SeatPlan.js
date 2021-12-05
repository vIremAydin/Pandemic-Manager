import {makeStyles} from "@material-ui/core/styles";
import {Grid} from "@material-ui/core";
import {connect} from "react-redux";


const useStyles = makeStyles({
    container:{
      marginTop:"10px",
    },
    box: {
        borderRadius: "10px",
        border: "1px solid #C4C4C4",
        width: "100px",
        height: "100px",
        display: "flex",
        flexDirection: "column",
        justifyContent: "space-around",
        padding: "30px",
        boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
        marginTop: "40px",

    },

    header: {
        fontSize: "26px",
        marginTop: "10px",
        color: '#023047',
    }
});
const SeatPlan = ({course}) => {
    const classes = useStyles();
    const yourSeat = 3;
    const seats = [
        {num: 1, name: "Fark"},
        {num: 2, name: "Fark"},
        {num: 3, name: "Fark"},
        {num: 4, name: "Fark"},
        {num: 5, name: "Fark"},
        {num: 6, name: "Fark"},

    ];


    return (
        <div className={classes.container}>
            <span className={classes.header}>Seating plan for {course}</span>
            <Grid container spacing={{xs: 3}} columns={{xs: 4}}>
                {
                    seats.map(itm => (
                        <Grid item xs={4}>
                            {
                                itm.num === yourSeat ?
                                    (<div style={{background:"#95C5DEFF"}} className={classes.box}>
                                        <span style={{textAlign: "center"}}>{itm.num}</span>
                                        <span style={{textAlign: "center"}}>{itm.name}</span>
                                    </div>) :
                                    (<div className={classes.box}>
                                        <span style={{textAlign: "center"}}>{itm.num}</span>
                                        <span style={{textAlign: "center"}}>{itm.name}</span>
                                    </div>)
                            }
                        </Grid>
                    ))
                }
            </Grid>

        </div>
    )
}
const mapStateToProps = (state) => {
    return {
        course: state.activeTab.selectedCourse
    };
}
export default connect(mapStateToProps)(SeatPlan);
