import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

function UserDetail() {
  const USER_MANAGEMENT_API = "http://localhost:8080/api/v1/users";
  const { userId } = useParams();
  const [user, setUser] = useState([]);

  useEffect(() => {
    if (userId) {
      axios
        .get(`${USER_MANAGEMENT_API}/${userId}`)
        .then(res => {
            setUser(res.data);
            console.log(user)
        })
        .catch(err => {
          throw err;
        });
    }
  }, [userId]);

  function getUsers() {
    window.location.href = "/";
  }

  const removeUser = async(e) => {
    if (userId) {
        axios
        .post(`${USER_MANAGEMENT_API}/delete/${userId}`)
        .then(res => {
            alert(
                `Remove user ${JSON.stringify(
                  res.data
                )} successfully!!!`
              );
              window.location.href = "/";
        })
        .catch(err => {
          throw err;
        });
    }
  }

  return (
    <div>
      <h1>Thông tin sản phẩm</h1>
      <p><b>Id</b> {user.id}</p>
      <p><b>Tên sản phẩm:</b> {user.username}</p>
      <p><b>Giá:</b> {user.email}</p>
      <p><b>Số lượng:</b> {user.fullname}</p>
      <button type="button" onClick={getUsers}>
        Quay lại
      </button>&nbsp;
      <button type="button" onClick={removeUser}>
        Xóa
      </button>
    </div>
  );
}

export default UserDetail;