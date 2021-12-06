import {makeStyles} from "@material-ui/core/styles";
import "./button-style.css"
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
                <button className={"notActive"} disabled={true} onClick={() =>onClick(name)}
                       >{name}
                </button>
                :
                <button  className={"Active"} onClick={() =>onClick(name)}
                      >{name}
                </button>
        }
    </div>

    );
}
export default MyButton;
