import React from 'react';
import { PRODUCTS } from "../Products.js";
import Product from './Product.jsx';
import "./shop.css";
import Navbar from './Navbar.jsx';

const Shop = () => {
    return (
        <div>
            
            <div className="shop">
                <div className="shoptitle">
                    <h1>Shop</h1>
                </div>
                <div className="product">
                    {PRODUCTS.map((item) => (
                        <Product data={item}/>
                    ))}
                </div>
            </div>
        </div>
    )
}

export default Shop
