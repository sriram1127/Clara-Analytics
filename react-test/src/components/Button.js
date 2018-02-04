import React, { Component } from 'react';
import '../styles/custom.css';
class Button extends Component {
  submit(e){
    e.preventDefault();
   this.props.sendData();
  }

  	render () {
  		return (
  			<div className="button">
        <input id="btn" type="submit" value="Submit" onClick={this.submit.bind(this)}/>
        </div>
  		);
  	}
}

export default Button;
