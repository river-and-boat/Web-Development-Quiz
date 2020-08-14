import React, {Component} from "react";
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import './Header.css'
import ShoppingMail from "../shopping-mail/ShoppingMail";
import NewProduct from "../addProduct/NewProduct";

export default class Header extends Component{
    render() {
        return (
            // eslint-disable-next-line react/react-in-jsx-scope
            <BrowserRouter>
                {/* eslint-disable-next-line react/react-in-jsx-scope */}
                <div className="topnav">
                    <Link to="/">商城</Link>
                    <Link to="/products">订单</Link>
                    <Link to="/new">添加商品</Link>
                </div>
                <Switch>
                    <Route path="/new" component={NewProduct}></Route>
                    <Route path="/" component={ShoppingMail}></Route>
                    <Route path="/" component={ShoppingMail}></Route>
                </Switch>
            </BrowserRouter>
        );
    }
}