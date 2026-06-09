import { useState } from "react";
import axios from "axios";
import "../CSS/Auth.css";
import { useNavigate } from "react-router-dom";

function Login() {

  const [email,setEmail] = useState("");
  const [password,setPassword] = useState("");

  const navigate = useNavigate();

  const login = async () => {
    //data variable are defined to store the email and password entered by the 
    // user in the login form. This data will be sent to the backend API for authentication.
    const data={
      email,
      password
    }

    try {

      const res = await axios.post(
        "http://localhost:8080/user/login",
        data
      );

      console.log(res.data);
      console.log("Response:", res.data);
console.log("Token:", res.data.token);

      localStorage.setItem(
        "token",
        res.data.token
      );

     const token= localStorage.getItem("token");
     console.log(token);

      localStorage.setItem(
            "role",
            res.data.role
        );

        localStorage.setItem(
            "userId",
            res.data.userId
        );

        localStorage.setItem(
            "name",
            res.data.name
        );


console.log(localStorage.getItem("token"));
console.log(localStorage.getItem("role"));
console.log(localStorage.getItem("name"));

        if(res.data.role==="ADMIN")
        {
            navigate("/admin");
        }
        else
        {
            navigate("/user");
        }

      alert("Login Success");

      // navigate("/movies");

    }
    catch(error) {

      console.log(error);

      alert("Login Failed");

    }

   
  }

  return (
    <>
    <div className="auth-container">
      <h2>Login</h2>

      <div className="form-group">
      <input
        placeholder="Email"
        onChange={(e)=>
          setEmail(e.target.value)}
          required
      />
      </div>

<div className="form-group">
      <input
        type="password"
        placeholder="Password"
        onChange={(e)=>
          setPassword(e.target.value)}
          required
      />
      </div>

          
      <button onClick={login} className="auth-btn">
        Login
      </button>

      <p className="register-text">
    Don't have an account? <a href="/register">Register</a></p>
      
      </div>
    </>
  );
}

export default Login;