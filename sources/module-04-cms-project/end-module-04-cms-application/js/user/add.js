let onAdd = function () {
    let token = localStorage.getItem("currentToken");
  
    var body = {
      username: document.getElementById("addUsername").value,
      email: document.getElementById("addEmail").value,
      password: document.getElementById("addPassword").value,
      fullname: document.getElementById("addFullName").value,
      address: document.getElementById("addAddress").value,
      phone: document.getElementById("addPhone").value,
      avatar: document.getElementById("addAvatar").value,
      roleId: document.getElementById("addRoleId").value,
      activated: document.getElementById("addActivated").value,
    };
  
    axios({
      url: `http://localhost:8080/api/user/add`,
      method: "POST",
      data: body,
      headers: { Authorization: `Bearer ${token}` },
    })
      .then(function (resp) {
        console.log(resp);
        getAll();
      })
      .catch(function (err) {
        console.log(err.response);
      });
};
  