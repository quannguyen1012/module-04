import Products from "./components/User"
import {BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import UserCreate from "./components/UserCreate";
import ProductEdit from "./components/ProductEdit";
import UserDetail from "./components/UserDetail";


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Products />} />
        <Route path={`/products/:productId`} element={<UserDetail />} />
        <Route path={"/users/create"} element={<UserCreate />} />
        <Route path={`/products/edit/:productId`} element={<ProductEdit />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App;
