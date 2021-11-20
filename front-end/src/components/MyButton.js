import {makeStyles} from "@material-ui/core/styles";

const useStyles = makeStyles({

    buttonsInHeader: {
        cursor: "pointer",
        marginLeft: "30px",
        width: "164px",
        height: "47px",
        background: "#F1B24A",
        '&:hover': {
            background: "#969090",
        },
        boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
        borderRadius: "10px",

    },});

const MyButton = ({name, isActive, onClick}) =>{
    const classes = useStyles();
    return(<div>
        {
            isActive ?
                <button onClick={() =>onClick(name)} className={classes.buttonsInHeader} style={{backgroundColor: "#969090"}}
                       >{name}
                </button>
                :
                <button onClick={() =>onClick(name)} className={classes.buttonsInHeader}
                      >{name}
                </button>
        }
    </div>

    );
}
export default MyButton;
