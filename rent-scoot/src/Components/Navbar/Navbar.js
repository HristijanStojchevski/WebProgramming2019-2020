import React from 'react';
import {Paper,Tabs} from '@material-ui/core';
import Tab from '@material-ui/core/Tab';  
import {Link} from "react-router-dom";
import Logo from '../../Assets/images/logo.png'
import './Navbar.css';
import Grid from '@material-ui/core/Grid';

//import './Navbar.css';
function Navbar ({navValue}) {
    const [init,setInit] = React.useState(true);
    const [value, setValue] = React.useState(0);
const changeTabs= (event, newValue) => {
    setValue(newValue);
};
function setUpdate() {
    if(!init){
    setValue(1);
    }
    else {
        //read path and set nav value
        const pathName = window.location.pathname;
        if(pathName.localeCompare("/")===0){setValue(0);}
        if(pathName.localeCompare("/Rent")===0){setValue(1);}
        if(pathName.localeCompare("/About")===0){setValue(2);}
        setInit(false);
    }
}
React.useEffect(() => { setUpdate(); },[navValue]);
  
    return (
    <Paper style={{backgroundColor: '#3a4aa3'}}>
    <Grid container>
        <Grid item sm={2}>
            <img className="nav-logo" src={Logo} alt=" "/>
        </Grid>
        <Grid item sm={8}>
            <Tabs 
                value={value}
                onChange = { changeTabs }
                indicatorColor="warning"
                textColor="primary" 
                centered
                >

            <Tab label="Почетна" component={Link} to="/"/>
            <Tab label="Изнајми" component={Link} to="/Rent"/>
            <Tab label="За нас" component={Link} to="/About"/>
            </Tabs>
        </Grid>
        <Grid item sm={2}>
        </Grid>
    </Grid>
    </Paper>
  );
}

export default Navbar;