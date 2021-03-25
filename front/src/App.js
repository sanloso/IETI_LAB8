import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import 'react-datepicker/dist/react-datepicker.css';
import { Login } from "./components/Login";
import { makeStyles, useTheme } from '@material-ui/core/styles';
import Menu from './menu/Menu';
import NewTask from './form/NewTask';
import UserProfile from './form/UserProfile';
import AddIcon from '@material-ui/icons/Add';
import {BrowserRouter as Router, Switch, Route, Redirect} from 'react-router-dom';
import SimpleCard from './card/SimpleCard';
import Fab from '@material-ui/core/Fab';
import FilterTask from './form/FilterTask';
import { useState } from 'react';
import PropTypes from 'prop-types';



export class App extends React.Component {
  constructor(props) {
    super(props);
    
    this.update = this.update.bind(this);
    // const auxList = JSON.parse(localStorage.getItem(''))

    if(!localStorage.getItem('listaTareas')){
      this.state = { listaTareas: [] };
    }else{
      this.state = { listaTareas: JSON.parse(localStorage.getItem('listaTareas')) };
    }

    if (!localStorage.getItem('isLoggedIn')){
      localStorage.setItem('isLoggedIn', false);
    }
    localStorage.setItem('username', 'santiago');
    localStorage.setItem('password', 'admin');
  }

  update(tarea){
    const aux = this.state.listaTareas.concat(tarea);
    localStorage.setItem('listaTareas', JSON.stringify(aux));
    this.setState({listaTareas: aux });
  }
  

  render() {

    const cardView = () => (
      <div>
        {this.state.listaTareas.map((task, i) => <SimpleCard key={i}  contenido={task}/>)}
        <Fab size="small" style={{ position: 'absolute', bottom: '10%', left: '6%', }} color="primary" aria-label="add" href="/newTask">
            <AddIcon />
        </Fab>
      </div>
    );

    const TaskView = () => (
      <div>
        <NewTask metod={this.update} />
      </div>
    );

    const ProfileView = () => (
      <div>
        <UserProfile/>
      </div>
    );

    const FilterTaskView = () => (
      <div>
        <FilterTask/>
      </div>
    );

    

    return (
      <div>
        <Router>
          <Switch>
            <Route path="/newTask" >
              {!JSON.parse(localStorage.getItem("isLoggedIn")) ? <Redirect to="/" />  : <Menu pantalla={TaskView}/>}
            </Route>
            <Route path="/filterTask" >
              {!JSON.parse(localStorage.getItem("isLoggedIn")) ? <Redirect to="/" />  : <Menu pantalla={FilterTaskView}/>}
            </Route>
            <Route path="/userProfile" >
              {!JSON.parse(localStorage.getItem("isLoggedIn")) ? <Redirect to="/" />  : <Menu pantalla={ProfileView}/>}
            </Route>
            <Route path="/home" >
              {!JSON.parse(localStorage.getItem("isLoggedIn")) ? <Redirect to="/" /> : <Menu pantalla={cardView}/>}
            </Route>
            <Route exact path="/">
              {JSON.parse(localStorage.getItem("isLoggedIn")) ? <Redirect to="/home" /> :  <Login/> }
            </Route>
          </Switch>
        </Router>
      </div>
    );
  }

}

export default App;