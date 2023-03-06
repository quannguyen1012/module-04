let onDelete = function (id) {
    let token = localStorage.getItem("currentToken");
  
    axios({
      url: `http://localhost:8080/api/user/remove/${id}`,
      headers: { Authorization: `Bearer ${token}` },
      method: "DELETE",
    })
    .then(function (resp) {
        console.log(resp);
        getAll();
    })
    .catch(function (err) {
        console.log(err.response);
    });
};