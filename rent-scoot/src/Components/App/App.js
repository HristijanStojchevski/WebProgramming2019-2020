import React,{useState} from 'react';
import './App.css';
import Home from '../Home/Home';
import About from '../About/About';
import Contact from '../Contact/Contact';
import Rent from '../Rent/Rent';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Navbar from '../Navbar/Navbar';
import Footer from '../Footer/Footer';


function App() {
  const [selectedNav, setSelectedNav] = useState(0);
  const handleNavHome = (selected) => {
    setSelectedNav(selected);
    //console.log(selectedNav);
    } 
  return (
    <Router>
    <div className="App">
      <Navbar navValue={selectedNav}/>
      <div className="Content">
      <Switch>
        <Route path="/" exact render={props => 
  (<Home handleNavHome={handleNavHome}/>)} />
        <Route path="/About" component={About} />
        <Route path="/Rent" component={Rent} />
        <Route path="/Contact" component={Contact} />
      </Switch>
      </div>

      <Footer />

    </div>
    </Router>
  );
}

export default App;
