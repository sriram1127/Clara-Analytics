import React, { Component } from 'react';
import Select from 'react-select';
import '../styles/custom.css';
import request from 'superagent';


class Location extends Component {

  constructor(props) {
       super(props);
       this.state = {
         countries: [],
         states: [],
         disabled: false,
         searchable: this.props.searchable,
         clearable: true,
         rtl: false,
         selectStateValue:null
       }
    }

    componentDidMount() {
      request
         .get('http://127.0.0.1:8080/ClaraAnalytics/rest/claraservice/countries')
         .then(function(res) {
             if(res.status === 200){
             this.setState({
               countries: res.body
           });
           }
         }.bind(this))
         .catch(function(err) {
            // err.message, err.response
             console.log(err);
         });
    }


  	displayName: 'StatesField';
  	propTypes: {
  		label: PropTypes.string,
  		searchable: PropTypes.bool,
  	};


    static defaultProps = {
      label: 'States:',
      searchable: true,
  }

  	clearValue (e) {
  		this.select.setInputValue('');
  	}
  	switchCountry (e) {
  		var newCountry = e.target.value;
  		this.setState({
  			country: newCountry,
  			selectValue: null,
  		});
  	}

    updateStateValue(value)  {
      console.log(value);
      this.setState({
      selectStateValue: value
      });
          this.props.sendData('state', value);
      }

    updateValue(value)  {
      this.props.sendData('country', value);
      this.setState({
      selectValue: value
    });
      console.log(value);
      if(value !== null){
      request
         .get('http://localhost:8080/ClaraAnalytics/rest/claraservice/statesByCountry?country='+ value)
         .then(function(res) {
             if(res.status === 200){
             this.setState({
               states: res.body,
                selectStateValue : ''
               //selectStateValue : res.body[0].value
           });
           }
         }.bind(this))
         .catch(function(err) {
            // err.message, err.response
             console.log(err);
         });
       }else{
         this.setState({
           states: []
       });
       }
    }

  	focusStateSelect () {
  		this.refs.stateSelect.focus();
  	}
  	toggleCheckbox (e) {
  		let newState = {};
  		newState[e.target.name] = e.target.checked;
  		this.setState(newState);
  	}
  	render () {
  		return (
        <div>
  			<div className="combosec1">
  				<Select style={{height:41 + 'px'}}
  					id="country-select"
  					ref={(ref) => { this.select = ref; }}
  					onBlurResetsInput={false}
  					onSelectResetsInput={false}
  					autoFocus
  					options={this.state.countries}
  					simpleValue
  					clearable={this.state.clearable}
  					name="selected-state"
  					disabled={this.state.disabled}
  					value={this.state.selectValue}
  					onChange={this.updateValue.bind(this)}
  					rtl={this.state.rtl}
  					searchable={this.state.searchable}
  				/>
  			</div>

        <div className="combosec2">
          <Select style={{height:41 + 'px'}}
            id="state-select"
            ref={(ref) => { this.select = ref; }}
            onBlurResetsInput={false}
            onSelectResetsInput={false}
            autoFocus
            options={this.state.states}
            onChange={this.updateStateValue.bind(this)}
            simpleValue
            clearable={this.state.clearable}
            name="selected-state"
            disabled={this.state.disabled}
            value={this.state.selectStateValue}
            rtl={this.state.rtl}
            searchable={this.state.searchable}
          />
        </div>
      </div>


  		);
  	}
}

export default Location;
