import React from 'react';
import { Formik, Form, Field } from 'formik';
import * as Yup from 'yup';
import emailjs from 'emailjs-com'
import './Form.css'
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Slide from '@material-ui/core/Slide';

const Transition = React.forwardRef(function Transition(props, ref) {
  return <Slide direction="up" ref={ref} {...props} />;
});

const RentSchema = Yup.object().shape({
  firstName: Yup.string()
    .max(50, 'Премногу долго!')
    .required('Задолжително!'),
  lastName: Yup.string()
    .min(2, 'Премногу кратко!')
    .max(50, 'Премногу долго!')
    .required('Задолжително!'),
  email: Yup.string()
    .email('Невалиден формат!')
    .required('Задолжително!'),
  phone: Yup.number()
    .min(70000000,"Невалиден формат!")
    .max(78999999,"Невалиден формат!")
    .required('Задолжително!')
});
export default function FormFields(props){
    const dateStart = props.dateStart;
    const dateEnd = props.dateEnd;
    const location = props.location;
    const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

    return (
      <div>
        <Formik
      initialValues={{
        firstName: '',
        lastName: '',
        email: '',
        phone: '',
        dateStart: '',
        dateEnd: '',
        hourStart: '',
        hourEnd: '',
        location: ''
      }}
      validationSchema={RentSchema}
      onSubmit={values => {
        // same shape as initial values
        values.dateStart = dateStart.toString().substring(0,10);
        values.dateEnd = dateEnd.toString().substring(0,10);
        values.hourStart = dateStart.toString().substring(11,16);
        values.hourEnd = dateEnd.toString().substring(11,16);
        values.location = location.properties.Name;
        console.log(values);
        const templateId = 'digit2019';
        emailjs.init("user_MOSCUCzUTNRwgqfcKKeJb");
        emailjs.send(
          'gmail', templateId,
          values
          ).then(res => {
            console.log('Email successfully sent!')
          })
          // Handle errors here however you like, or use a React error boundary
          .catch(err => console.error('Oh well, you failed. Here some thoughts on the error that occured:', err))
      }}
    >
      {({ errors, touched }) => (
        <Form className='reservation-form'>
          <Field className='form-field' name="firstName" placeholder="Име" />
          {errors.firstName && touched.firstName ? (
            <span className='validator'>{errors.firstName}</span>
          ) : null}
          <Field className='form-field' name="lastName" placeholder="Презиме"/>
          {errors.lastName && touched.lastName ? (
            <span className='validator'>{errors.lastName}</span>
          ) : null}
          <Field className='form-field' name="email" type="email" placeholder="Електронска пошта"/>
          {errors.email && touched.email ? <span className='validator'>{errors.email}</span> : null}
          <Field className='form-field' name="phone" type="number" placeholder="Телефон"/>
          {errors.phone && touched.phone ? (
            <span className='validator'>{errors.phone}</span>
          ) : null}
          {/*<select name="location" id="locationDropdown" className='form-field' >
            <option value="Железничка" selected onClick={() => {location =PointData.features[0]}}> Железничка</option>
            <option value="City Mall" onCLick={() => {location =PointData.features[1]}}>City Mall</option>
            <option value="Градски плоштад" onClick={() => {location =PointData.features[2]}}>Градски плоштад</option>
            <option value="Capitol Mall" onClick={() => {location =PointData.features[3]}}>Capitol Mall</option>
          </select>*/}
          <button type="submit" className='submit-button' onClick={handleClickOpen}>Поднеси</button>
        </Form>
      )}    
    </Formik>
          <Dialog
        open={open}
        TransitionComponent={Transition}
        keepMounted
        onClose={handleClose}
        aria-labelledby="alert-dialog-slide-title"
        aria-describedby="alert-dialog-slide-description"
        >
        <DialogTitle id="alert-dialog-slide-title">{"Вашата нарачка беше успешна! "}</DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-slide-description">
           Набрзо ќе добиете повеќе информации на вашата електронска пошта.
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Во ред
          </Button>
        </DialogActions>
      </Dialog> 
    </div>
    );
}