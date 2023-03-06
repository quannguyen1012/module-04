
import { Button,Form, Input, Select,} from 'antd';
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

const { Option } = Select;
const { Item } = Form;



const CreateForm = () => {
    const USER_MANAGEMENT_API = "http://localhost:8080/api/v1/users";
    const ROLE_MANAGEMENT_API = "http://localhost:8080/api/v1/roles"
    const { userId } = useParams();
    const isCreate = !userId;
    const [user, setUser] = useState({
        fullname: '',
        username: '',
        password: '',
        email: '',
        photo: '',
        // position: '',
        roles: [],
        status: ''
      });
    const [roles, setRoles] = useState([]);


  
    useEffect(() => {
      if (userId) {
        axios
        .get(`${USER_MANAGEMENT_API}/${userId}`)
        .then(res => {
            setUser(res.data);
        })
        .catch(err => {
          throw err;
        });
      }
    },[userId]);

    // get all roles in db and set to roles state
    useEffect(() => {     
      axios
      .get(`${ROLE_MANAGEMENT_API}`)
      .then(res => {
        setRoles(res.data);
        console.log(res.data)
      })
      .catch(err =>{
        throw err;
      })
    },[])
  
    const handleChange = (event, type) => {
        const value = event.target ? event.target.value : event;
        setUser(prevState => ({
          ...prevState,
          [type || event.target.name]: value
        }));
      };

      const addRoles = (id) => {
        if(!user.roles.includes(id)) {
          setUser(prevState => ({
            ...prevState,
            roles: [...user.roles, id] 
          }));
        }
       
      }
  
    function handleSubmit() {
      axios
        .post(`${USER_MANAGEMENT_API}`, user)
        .then(res => {
          alert(
            `${isCreate ? "Create" : "Edit"} user ${JSON.stringify(
              res.data
            )} successfully!!!`
          );
          window.location.href = "/";
        })
        .catch(err => {
          throw err;
        });
    }
 return (
    <div className="container" style={{marginTop: 0}} >
  <div className ="form-wrapper" style={{backgroundColor:"#C7C9D6"}}>
  <h1 style={{ textAlign: "center", marginTop: 10}}>Create new user</h1>  
    <Form
      labelCol={{ span: 6 }}
      wrapperCol={{ span: 12 }}
      layout="horizontal"
      style={{ maxWidth: 600 }}
   
    >
      <Form.Item label="Full name"  >
        <Input
        className="form-control"
        type="text"
        onChange={handleChange}
        value={user.fullname}
        name="fullname" />
      </Form.Item>
      <Form.Item label="User name">
        <Input
        className="form-control"
        type="text"
        onChange={handleChange}
        value={user.username}
        name="username" /> 
      </Form.Item>
      <Form.Item label="Password">
        <Input
        className="form-control"
        type="text"
        onChange={handleChange}
        value={user.password}
        name="password" />
      </Form.Item>
      <Form.Item label="Email">
        <Input
        className="form-control"
        type="text"
        onChange={handleChange}
        value={user.email}
        name="email" />
      </Form.Item>
      <Form.Item label="Photo">
        <Input
        className="form-control"
        type="text"
        onChange={handleChange}
        value={user.photo}
        name="photo" />
      </Form.Item>
      <Form.Item label="Position">
        <Select onChange={(value)=>{
            addRoles(value)
        }}>
          {roles.map((role) => ( 
            <Select.Option key={role.id} value={role.id}>{role.desc}</Select.Option>
          ))}
        </Select>
      </Form.Item>
      <Form.Item label="Status">
        <Select onChange={(value)=>{
            handleChange(value, "status")
        }}>
          <Select.Option value="true">Active</Select.Option>
          <Select.Option value="false">Inactive</Select.Option>
        </Select>
      </Form.Item>
      <div>
      <Form.Item  style={{ textAlign: "center", marginLeft:190}}>
        <Button onClick={handleSubmit} type="primary" >Submit</Button>
        <Button onClick={getProducts} style={{marginLeft: 20}} type="primary" danger>Back</Button>
      </Form.Item>
      </div>
    </Form>
    </div>
    </div>
  );
};

export default CreateForm;

function getProducts() {
    window.location.href = "/";
}


