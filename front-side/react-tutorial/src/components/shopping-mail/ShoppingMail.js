import React,{Component} from "react";
import 'bootstrap/dist/css/bootstrap.css'
import './ShoppingMail.css'

export default class ShoppingMail extends Component{

    state = {
        data: []
    }

    url = "http://localhost:8080/products";

    async componentDidMount() {
        let responsePromise = await fetch(this.url);
        const responseJson = await responsePromise.json();
        this.setState({
            data: responseJson
        });
    }

    render() {
        const result = this.state.data.map(m => {
            return <div className="col-md-3">
                <img id="avator" src={m.avator}/><br/>
                <label>{m.name}</label><br/>
                <label>单价:{m.price}/{m.unit}</label><br/>
                <button className="btn btn-primary">添加到购物车</button>
            </div>
        })

        return <div className="container">
            <div className="row">
                {result}
            </div>
        </div>
    }
}