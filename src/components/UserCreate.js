

import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import CreateForm from "./CreateForm";


function UserCreate() {

  return (
    <div> 
      <CreateForm />
    </div>
  );
}

export default UserCreate;