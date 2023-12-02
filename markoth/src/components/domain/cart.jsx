import React from 'react'
import { PRODUCTS } from '../Products';
import Product from './Product';
import { ShopContext } from './ShopContextProvider';
import { useContext } from 'react';
import CartItem from './CartItem.jsx';
import './cart.css';


const Cart = () => {

  const {cartItems} = useContext(ShopContext);

  return (
    <div>
      <div className="cartHeading">
        <h1>Bidding Cart</h1>
      </div>
      <div className="citem">
        {PRODUCTS.map((item) =>{
          if(cartItems[item.id] !== 0){
            return <CartItem data={item} />
          }
        })}
      </div>
    </div>
  )
}

export default Cart;
