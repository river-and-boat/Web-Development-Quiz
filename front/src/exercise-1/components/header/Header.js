import React, {Component} from 'react'
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import Profile from "../kinds/Profile";
import About from "../kinds/About";
import Home from "../kinds/Home";
import './Header.css';
import Products from "../kinds/product/Products";
import ProductDetail from "../kinds/product/ProductDetail";

export default class Header extends Component{
    render() {
        return (
            <BrowserRouter>
                <div className="topnav">
                    <Link to="/">Home</Link>
                    <Link to="/products">Products</Link>
                    <Link to="/my-profile">My Profile</Link>
                    <Link to="/about-us">About Us</Link>
                </div>
                <Switch>
                    <Route path="/my-profile" component={Profile}></Route>
                    <Route path="/goods" component={Products}></Route>
                    <Route exact path="/products" component={Products}></Route>
                    <Route exact path="/products/:id" component={ProductDetail}></Route>
                    <Route path="/about-us" component={About}></Route>
                    <Route path="/" component={Home}></Route>
                </Switch>
            </BrowserRouter>
        );
    }
}
