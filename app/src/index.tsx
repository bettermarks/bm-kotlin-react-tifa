import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {validateEquation} from 'equation-validator';

interface IEquationState {
    value: string;
}

class EquationForm extends React.Component<{}, IEquationState> {
    constructor() {
        super({});
        this.state = {value: '2 + 3 = 5'};

    }

    handleChange(event: any) {
        console.dir(event)
        this.setState({value: event.target.value});

    }

    render() {
        return (
            <p>Is <input className="equation" type="text" value={this.state.value}
                         onChange={this.handleChange.bind(this)}></input> &nbsp;
                <span>{String(validateEquation(this.state.value) === "OK" ? "Valid" : "Invalid")}</span>
            </p>
        );
    }
}

ReactDOM.render(
    <React.StrictMode>
        <h1>Equation validator</h1>
        <EquationForm/>
    </React.StrictMode>,
    document.getElementById('root')
);
