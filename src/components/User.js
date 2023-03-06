import React, { useEffect, useState } from "react";
import axios from "axios";
import { Button, Space} from 'antd';
import CustomTable from "./Table";

function User(){
    const [users, setUsers] = useState([]);
    const columns = [
        {
          title: 'ID',
          dataIndex: 'id',
          key: 'id',
          render: (text) => <a>{text}</a>,
        },
        {
            title: 'Ảnh',
            dataIndex: 'photo',
            key: 'photo',
            render: (photo) => (
              <img
                src={photo}
                alt="Ảnh đại diện"
                style={{ width: '50px', height: '50px' }}
              />
            ),
          },
        {
          title: 'Tên',
          dataIndex: 'fullname',
          key: 'fullname',
        },
        {
          title: 'Email',
          dataIndex: 'email',
          key: 'email',
        },
        {
          title: 'Vị trí',
          dataIndex: ['roles', 0, 'desc'],
          key: 'role',
        },
        {
          title: 'Role',
          dataIndex: ['roles', 0, 'name'],
          key: 'role',
        },
        {
          title: 'User Name',
          dataIndex: 'username',
          key: 'username',
        },
        {
          title: 'Password',
          dataIndex: 'password',
          key: 'password',
        },
        {
          title: 'Lựa chọn',
          key: 'action',
          render: (_, user) => (
            <Space wrap size="middle">
              <a href={`/products/edit/${user.id}`}>
                <Button danger>Cập nhập</Button>
              </a>
              <a href={`/products/${user.id}`}>
                <Button type="primary" ghost>Chi tiết</Button>
              </a>
            </Space>
          ),
        },
      ];

    useEffect(() => {
        if (users.length === 0) {
            loadUsers();
        }
    },[users]);

    const loadUsers = async () => {
        const result = await axios.get("http://localhost:8080/api/v1/users");
        setUsers(result.data);
        console.log(result.data);
    };

    function handleCreate(e) {
        window.location.href = "/users/create";
        e.preventDefault();
    }
    
    return (
        <div>
            <h1 style={{textAlign: "center"}}>User list</h1>
            <span> <Button onClick={handleCreate} danger>Thêm sản phẩm</Button></span>
            <br/><br/>
            <CustomTable data = {users} columns={columns}/>
        </div>
    );
};

export default User;
