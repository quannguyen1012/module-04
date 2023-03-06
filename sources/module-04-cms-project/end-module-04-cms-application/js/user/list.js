let getAll = function () {
    let token = localStorage.getItem("currentToken");
  
    axios({
      url: "http://localhost:8080/api/user/all",
      method: "GET",
      headers: { Authorization: `Bearer ${token}` },
    })
      .then(function (resp) {
        //Truy xuất đến thẻ tbody (nơi chứa giao diện danh sách user)
        let tbody = document.getElementById("users");
        console.log(resp); //test resp
  
        let content = "";
        for (let user of resp.data) {
          content += `
                      <tr>
                          <td>${user.id}</td>
                          <td>${user.email}</td>
                          <td>${user.fullname}</td>
                          <td>${user.address}</td>
                          <td>${user.phone}</td>
                          <td>${user.avatar}</td>
                          <td class="align-middle">
                              <span class="btn-group-vertical">
                                  <a type="button" data-toggle="modal" data-target="#editForm" 
                                  onclick="setEditId(${user.id})" class="btn btn-sm mb-1 btn-success"> Sửa </a>
                                  <a class="btn btn-sm mb-1 btn-danger"
                                      onclick="onDelete(${user.id})">Xóa</a>
                              </span>
                          </td>
                      </tr>
                  `;
        }
  
        // Thay đổi nội dung thẻ tbody
        tbody.innerHTML = content;
      })
      .catch(function (err) {
        console.log(err.response.data);
      });
  };
  
  getAll();
  