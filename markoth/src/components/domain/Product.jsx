import React, { useContext } from 'react';
import { ShopContext } from './ShopContextProvider.jsx';


const Product = (props) => {
    const {id,productName,productImage,biddingPrice,biddingTime} = props.data;

    const {addToCart, cartItems} = useContext(ShopContext);

    const cartItemAmount = cartItems[id];

  return (
    <div className="shop">
        <div className="item">
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
                <button className="addtocart" onClick={()=>addToCart(id)}>Add to Bidding Cart ({cartItemAmount>0 && <>{cartItemAmount}</>})</button>
            </div>
        </div>
    </div>
  )
}

export default Product
