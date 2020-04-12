import React, { Fragment,useState } from 'react';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import './Rent.css';
import BoxMap from './Mapbox';
import 'date-fns';
import DateFnsUtils from '@date-io/date-fns';
import {
  MuiPickersUtilsProvider,
  KeyboardTimePicker,
  KeyboardDatePicker,
} from '@material-ui/pickers';
import FormFields from './Form';
import * as PointData from '../../Data/vehicle-locations.json';


function Rent() {
  
  const [selectedStartDate, setSelectedStartDate] = useState(new Date().toISOString());
  
  const handleDateStartChange = date=> {
    setSelectedStartDate(date);
  };
  const [selectedEndDate, setSelectedEndDate] = useState(new Date().toISOString());
  
  const handleDateEndChange = date=> {
    setSelectedEndDate(date);
  };
  const [selectedPlace, setSelectedPlace] = useState(PointData.features[0]);
  const handleSelect = (selected) => {
    setSelectedPlace(selected);
    } 

  return (
    <Fragment>
      <Grid container direction="column" justify="space-around">
        <Grid item>
          <Grid container justify="space-around">
            <Grid item sm={12} style={{margin: '0 2em !important'}}>    
                <BoxMap handleSelect = {handleSelect} />
            </Grid>
          </Grid>
        </Grid>
        <Grid item>
          <Grid container className="forma">
            <Grid item sm={10}>
              <Paper className='reservation-form'>
                <h2 className='legend'>РЕЗЕРВИРАЈ СЕГА!</h2>
              <MuiPickersUtilsProvider utils={DateFnsUtils}>
      <Grid container justify="space-around">
        <KeyboardDatePicker
          disableToolbar
          variant="inline"
          format="MM/dd/yyyy"
          margin="normal"
          id="date-picker-inline"
          label="Датум на подигнување"
          value={selectedStartDate}
          onChange={handleDateStartChange}
          KeyboardButtonProps={{
            'aria-label': 'change date',
          }}
        />
        <KeyboardTimePicker
          margin="normal"
          id="time-picker"
          label="Време на подигнување"
          value={selectedStartDate}
          onChange={handleDateStartChange}
          KeyboardButtonProps={{
            'aria-label': 'change time',
          }}
        />
        <KeyboardDatePicker
          margin="normal"
          id="date-picker-dialog"
          label="Датум на враќање"
          format="MM/dd/yyyy"
          value={selectedEndDate}
          onChange={handleDateEndChange}
          KeyboardButtonProps={{
            'aria-label': 'change date',
          }}
        />
        <KeyboardTimePicker
          margin="normal"
          id="time-picker"
          label="Време на враќање"
          value={selectedEndDate}
          onChange={handleDateEndChange}
          KeyboardButtonProps={{
            'aria-label': 'change time',
          }}
        />
      </Grid>
    </MuiPickersUtilsProvider>
            <FormFields dateStart={selectedStartDate} dateEnd={selectedEndDate} location={selectedPlace}/>
              </Paper>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </Fragment>
  );
}

export default Rent;
