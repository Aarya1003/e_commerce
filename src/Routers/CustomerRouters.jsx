import React from 'react'
import { Route, Routes } from 'react-router-dom'
import HomePage from '../customer/components/Pages/HomePage'
import Cart from '../customer/components/Cart/Cart'
import Footer from '../customer/components/Footer/Footer'
import Product from '../customer/components/Product/Product'
import Navigation from '../customer/components/Navigation'
import ProductDetails from '../customer/components/ProductDetails/ProductDetails'
import Checkout from '../customer/components/Checkout/Checkout'
import Order from '../customer/components/Order/Order'
import OrderDeatils from '../customer/components/Order/OrderDeatils'

const CustomerRouters = () => {
  return (
    <div>
      <div>
      <Navigation/>

      </div>
      <Routes>
        <Route path='/' element={<HomePage/>}></Route>
        <Route path='/cart' element={<Cart/>}></Route>
        <Route path='/:levelOne/:levelTwo/:levelThree' element={<Product/>}></Route>
        <Route path='/product/:productId' element={<ProductDetails/>}></Route>
        <Route path='/checkout' element={<Checkout/>}></Route>
        <Route path='/account/order' element={<Order/>}></Route>
        <Route path='/account/order/:orderId' element={<OrderDeatils/>}></Route>

      </Routes> 
      {/* <Product/> */}
      {/* <ProductDetails/> */}
      {/* <Cart/> */}
      {/* <Checkout/> */}
      {/* <Order/> */}
      {/* <OrderDeatils/> */}

      <div>
        <Footer/>
      </div>
    </div>

  )
}

export default CustomerRouters
