import {makeStyles} from "@material-ui/core/styles";
import logo from "../images/logo.png";
import {Grid} from "@material-ui/core";
import {Carousel} from "react-bootstrap";
import slide1 from "../images/asi_orani1_1.jpg";
import slide2 from "../images/asi.jpg";
import 'react-slideshow-image/dist/styles.css'
import {Slide} from 'react-slideshow-image';
import React from 'react';
import {Link} from "react-router-dom";


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
    const slideImages = [
        {
            url: slide2,
            caption: 'Slide 1'
        },
        {
            url: 'images/slide_3.jpg',
            caption: 'Slide 2'
        },
        {
            url: 'images/slide_4.jpg',
            caption: 'Slide 3'
        },
    ];

    function handleClick() {
        return undefined;
    }

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
                        <Link to={"/login"}>
                            <button className={classes.btn}>Login</button>
                        </Link>
                    </Grid>
                </Grid>
            </div>
            <Carousel>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src={slide2}
                        alt="First slide"
                    />
                    <Carousel.Caption>
                        <h3>Coronavirus Vaccines</h3>
                        <p>Coronavirus vaccines</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src={slide1}
                        alt="Second slide"
                    />

                    <Carousel.Caption>
                        <h3>Second slide label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src={slide2}
                        alt="Third slide"
                    />

                    <Carousel.Caption>
                        <h3>Get Vaccinated</h3>
                        <p>See the closest health center</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
        </div>
    );
}
export default Welcome;
