import React from 'react';

const Table = ({stockprices}) => {
  return (
    <table className="table" >
      <thead>
        <tr>
          <th>S.no</th>
          <th>Stock Name</th>
          <th>Price</th>
          <th>askPrice</th>
        </tr>
      </thead>
      <tbody>
      { (stockprices) ? stockprices.map( (stockprice, index) => {
           return (
            <tr key={ index }>
              <td>{ index}</td>
              <td>{ stockprice.stockSymbol }</td>
              <td>{ stockprice.price}</td>
              <td>{ stockprice.trend }</td>
            </tr>
          )
         }) : <tr><td colSpan="5">Loading...</td></tr> }  
      </tbody>
    </table>
  );
}

export default Table

