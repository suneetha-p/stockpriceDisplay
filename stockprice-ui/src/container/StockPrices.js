import React , { Component } from 'react';
import Table from '../components/Table.js';
import 'bootstrap/dist/css/bootstrap.min.css';

class StockPrices extends Component {

  constructor(props) {
    super(props);
    this.state = {
      stockprices:   [] 
    }
  }
  async fetchData() {
    this.setState({isLoading: true});

    const response = await fetch('http://localhost:8080/price', {
      method: 'GET',
      headers: {'Content-Type': 'application/json' }});
    const data = await response.json();
    this.setState({'stockprices': data, isLoading: false});
  }

  async componentDidMount() {
    await this.fetchData(); 
    this.interval = setInterval(() => this.fetchData(), 1000); 
  }

  componentWillUnmount() {
    clearInterval(this.interval);
  }
  
  render() {
    return (
      <div className="shopping-list">
      <nav class="navbar navbar-light bg-light">
          <a class="navbar-brand" href="./">
            <img alt="" width="40" /> Stock Prices Display
          </a>
        </nav>
          <Table stockprices={ this.state.stockprices } />
    </div>
      
    );
  }
}
export default StockPrices;
