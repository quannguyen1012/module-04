import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import { Button, Space} from 'antd';

function ProductEdit() {
  const PRODUCT_MANAGEMENT_API = "http://localhost:3001/products";
  const { productId } = useParams();
  const isCreate = !productId;
  const [product, setProduct] = useState({});
  let navigate = useNavigate();

  const onInputChange = (e) => {
    setProduct({...product, [e.target.name] : e.target.value});
  }
  useEffect(() => {
    if (productId) {
      axios
        .get(`${PRODUCT_MANAGEMENT_API}/${productId}`)
        .then(res => {
            setProduct(res.data);
            console.log(res);
        }).catch(err => {
          throw err;
        });
        
    }
  }, [productId]);

  const handleSubmit = async(e) => {
    axios
      .put(`${PRODUCT_MANAGEMENT_API}/${productId}`, product)
      .then(res => {
        alert(
          `${isCreate} product ${JSON.stringify(
            res.data
          )} successfully!!!`
        );
       
        navigate("/");
      })
      .catch(err => {
        throw err;
      });
  }

  function getProducts() {
    window.location.href = "/";
    
  }

  return (
    <div>
      <h1>Cập nhập sản phẩm</h1>
      <form>
        <div>
          <label>Id</label>
          <input readOnly name="id" value={product.id} onChange= {(e) => onInputChange(e)} />
        </div>
        <div>
          <label>Tên sản phẩm</label>
          <input name="name" value={product.name} onChange= {(e) => onInputChange(e)} />
        </div>
        <div>
          <label>Giá</label>
          <input name="price" value={product.price} onChange= {(e) => onInputChange(e)} />
        </div>
        <div>
        <label>Số lượng</label>
          <input name="stock" value={product.quantity} onChange= {(e) => onInputChange(e)} />
        </div>
        <Button type="button" onClick={getProducts} b>
          Quay lại
        </Button>&nbsp;
        <Button type="button" onClick={handleSubmit} danger>
          Cập nhập
        </Button>
      </form>
    </div>
  );
}

export default ProductEdit;