import React from 'react'
import { ShopContext } from './ShopContextProvider.jsx';
import { useContext } from 'react';

const CartItem = (props) => {

    const { id, productName, productImage, biddingPrice, biddingTime } = props.data;

    const { removeFromCart, cartItems } = useContext(ShopContext);

    const cartItemAmount = cartItems[id];

    return (
        <div>
            <div className="CartItem">
                <img src={productImage} />
                <div className="description">
                    <p>
                        <b>{productName}</b>
                    </p>
                    <p>
                        Bidding Price: Rs.{biddingPrice}
                    </p>
                    <p>
                        Bidding starts at:{biddingTime}
                    </p>
                    <button className="addtocart" onClick={() => removeFromCart(id)}>Remove From Cart {cartItemAmount}</button>

                </div>
            </div>
        </div>
    )
}

export default CartItem
