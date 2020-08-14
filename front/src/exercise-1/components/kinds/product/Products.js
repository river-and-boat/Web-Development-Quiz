import React, {Component} from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import {Link, Route, Switch} from "react-router-dom";

export default class Products extends Component{
    dataSource = Object.values(require('../../../../exercise-2/mockups/data.json'));
    render() {
        const result = this.dataSource.map(pro => {
            return <tr>
                <td>{pro.id}</td>
                <td>{pro.name}</td>
                <td><Link to={`/products/${pro.id}`}>View Detail</Link></td>
            </tr>
        });

        return <table className="table">
            <thead>
                <tr>
                    <th>ID</th><th>ProductName</th><th>Operate</th>
                </tr>
            </thead>
            <tbody>
            {result}
            </tbody>
        </table>
    }
}