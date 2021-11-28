import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogTitle from '@mui/material/DialogTitle';
import {Link} from "react-router-dom";
import * as React from 'react';

 const LogoutDialog =({openP}) => {
    const [open, setOpen] = React.useState(openP);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    return (
        <div>
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                    {"Log out?"}
                </DialogTitle>
                <DialogActions>
                    <Link to={"/"}><Button onClick={handleClose}>Yes</Button></Link>
                    <Button onClick={handleClose} autoFocus>
                        No
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}
export default LogoutDialog;
