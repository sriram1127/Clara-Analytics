import React, { Component } from 'react';
import '../styles/custom.css';
class Name extends Component {

  onNameChange(e){
    console.log(e.target.value);
     console.log(e.target.name);
   this.props.sendData(e.target.name, e.target.value);
 }

 /*onSNameChange(e){
   console.log(e.target.value);
   console.log(e.target.name);
  this.props.sendData(e);
}*/

  	render () {
  		return (
  			<div className="section1">
        <input type="text" id="fname" name="firstname" placeholder="First Name" pattern="[A-Za-z]{1,30}" maxLength="30"
         onChange={this.onNameChange.bind(this)} />
        <input type="text" id="lname" name="lastname" placeholder="Second Name" pattern="[A-Za-z]{1,30}" maxLength="30"
         onChange={this.onNameChange.bind(this)} />
        </div>
  		);
  	}
}

export default Name;
