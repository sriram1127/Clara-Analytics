import React, { Component } from 'react';
import Location from './components/Location';
import Name from './components/Name';
import Button from './components/Button';
import 'react-select/dist/react-select.css'
import './styles/custom.css';
import logo from './clara.png';
import request from 'superagent';

class App extends Component {

  constructor(props) {
       super(props);
       this.state = {
         name:null,
         lastName:null,
         countryId: null,
         stateId:null
       }
       this.getName = this.getName.bind(this);
       this.getLocation = this.getLocation.bind(this);
       this.submit = this.submit.bind(this);
    }
    getName(key, value){
        // do not forget to bind getData in constructor
      if(key === 'firstname'){
      this.setState({
        name: value
      });}
    if(key === 'lastname'){
    this.setState({
      lastName: value
    });}
    }

    getLocation(key, value){
        // do not forget to bind getData in constructor
      if(key === 'country'){
      this.setState({
        countryId: value
      });}
    if(key === 'state'){
    this.setState({
      stateId: value
    });}
    }

    submit(){
        if(this.state.name === null || this.state.name.trim() === '')
        {
          alert('Please enter valid details');
          return;
        }

        if(this.state.lastName === null || this.state.lastName.trim() === '')
        {
          alert('Please enter valid details');
          return;
        }
        if(this.state.countryId === null || this.state.countryId.trim() === '')
        {
          alert('Please enter valid details');
          console.log('checin1');
          console.log(this.state.countryId);
          return;
        }
        if(this.state.stateId === null || this.state.stateId.trim() === '')
        {
          console.log('checin2');
          console.log(this.state.stateId);
          alert('Please enter valid details');
          return;
        }
      request
   .post('http://localhost:8080/ClaraAnalytics/rest/claraservice/store')
   .type('form')
   .send({ firstname: this.state.name,
    secondname:  this.state.lastName,
    countryId: this.state.countryId,
    stateId : this.state.stateId
   })
   .set('Accept', 'application/json')
   .then(function(res) {
     if(res.status === 200){
       if (res.body === true)
      alert('Thank you!  Details Submitted');
      else {
        alert('Server is down  try Later');
      }}
   }).catch(function(err) {
      // err.message, err.response
       alert('Server is down.  Try Later..');
    });
  }

  	render () {
      return(
        <div>
        <img src={logo} alt="network busy"/>
      <div id="box" className="center">
      <div id="heading">Enter Details</div>
      <form>
      <Name sendData={this.getName}/>
      <Location sendData={this.getLocation}/>
      <Button sendData={this.submit}/>
      </form>
      </div>
    </div>
  );
    }
}

export default App;
