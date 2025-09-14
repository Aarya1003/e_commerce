import './App.css';
import Navigation from './customer/components/Navigation';
import Footer from './customer/components/Footer/Footer';
import HomePage from './customer/components/Pages/HomePage';
import Product from './customer/components/Product/Product';
import ProductDetails from './customer/components/ProductDetails/ProductDetails';
import Cart from './customer/components/Cart/Cart';
import Checkout from './customer/components/Checkout/Checkout';
import Order from './customer/components/Order/Order';
import OrderDeatils from './customer/components/Order/OrderDeatils';
import { Route, Routes } from 'react-router-dom';
import CustomerRouters from './Roters/CustomerRouters';

function App() {
  return (
    <>
    <div className="App">

    <Routes>
      <Route path='/*' element={<CustomerRouters/>}></Route>
    </Routes>

    </div>
    </>
  );
}

export default App;
