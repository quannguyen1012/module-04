let setEditId = function (id) {
    document.getElementById("editId").value = id;
};
  
let onEdit = function () {
    let token = localStorage.getItem("currentToken");
  
    var id = document.getElementById("editId").value;
    console.log(id);
    var body = {
      id: document.getElementById("editId").value,
      fullname: document.getElementById("editFullName").value,
      username: document.getElementById("editUsername").value,
      password: document.getElementById("editPassword").value,
      email: document.getElementById("editEmail").value,
      address: document.getElementById("editAddress").value,
      phone: document.getElementById("editPhone").value,
      avatar: document.getElementById("editAvatar").value,
      roleId: document.getElementById("editRoleId").value,
      activated: document.getElementById("editActivated").value,
    };  
  
    axios({
      url: `http://localhost:8080/api/user/edit/${id}`,
      method: "PUT",
      headers: { Authorization: `Bearer ${token}` },
      data: body,
    })
    .then(function (resp) {
        console.log(resp);
        getAll();
    })
    .catch(function (err) {
        console.log(err.response);
    });
};
  