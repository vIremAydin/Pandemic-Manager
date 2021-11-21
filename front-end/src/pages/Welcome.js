import {makeStyles} from "@material-ui/core/styles";
import logo from "../images/logo.png";
import {Grid} from "@material-ui/core";
import {Carousel} from "react-bootstrap";
import slide1 from "../images/ası-bilkent.jpg";
import slide2 from "../images/asi.jpg";

const useStyles = makeStyles({
    contain: {
        background: "orange",
        width: "80%",
        height: "200px",
    },
    logo: {
        width: "150px",
        height: "100px"

    },
    logoContainer: {
        marginTop: "10px",
    },

    header: {
        width: '100%',
        height: '120px',
        background: '#023047',
        boxSizing: 'border-box',

    },

    btn: {
        marginTop: "30px",
        cursor: "pointer",
        width: "164px",
        height: "47px",
        background: "#F1B24A",
        '&:hover': {
            background: "#969090",
        },
        boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
        borderRadius: "10px",

    },
    caro: {}

});
const Welcome = () => {
    const classes = useStyles();

    return (
        <div>
            <div className={classes.header}>
                <Grid container>
                    <Grid item xs={4}>
                        <div className={classes.logoContainer}>
                            <img className={classes.logo} src={logo} alt=""/>
                        </div>
                    </Grid>
                    <Grid item xs={6}>

                    </Grid>
                    <Grid item xs={2}>
                        <button className={classes.btn}>Login</button>
                    </Grid>
                </Grid>
            </div>
            <div>
                <Carousel variant={"dark"} className={"w-50 h-50"}>
                    <Carousel.Item className="w-50 h-50">
                        <img
                            className={"d-block"}
                            src={slide1}
                            alt="First slide"
                        />
                        <Carousel.Caption>
                            <h3>First slide label</h3>
                            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item className="w-50 h-50">
                        <img
                            className={"d-block"}
                            src={slide2}
                            alt="Third slide"
                        />

                        <Carousel.Caption>
                            <h3>Third slide label</h3>
                            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                </Carousel>

            </div>
        </div>
    );
}
export default Welcome;
