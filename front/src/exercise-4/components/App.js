import React, {Component} from 'react';
import {BrowserRouter as Router, Switch} from 'react-router-dom';
import {Route} from "react-router";
import Home from "./Home";
import About from "./About";
import User from "./User";
import NotMatch from "./NotMatch";

class App extends Component {
  render() {
    return (
      <div className="app">
        <Router>
            <Switch>
                <Route exact path='/:user' component={User} />
                <Route exact path='/about' component={About} />
                <Route exact path='/' component={Home} />
                <Route component={NotMatch} />
            </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
