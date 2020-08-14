import React, {Component} from 'react'
import {Link} from "react-router-dom";

export default class About extends Component {
    render() {
        return <div>
            <h1>Company: ThoughtWorks Local</h1>
            <h2>Location: Xian</h2>
            <h3>For more information, please</h3>
            <h3>view our {<Link to="/">website.</Link>}</h3>
        </div>
    }
}