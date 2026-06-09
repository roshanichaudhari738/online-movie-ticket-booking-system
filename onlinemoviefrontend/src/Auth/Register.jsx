import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "../CSS/Auth.css";

function Register() {
  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
    role: "USER",
  });

  const navigate = useNavigate();

  const register = async () => {
    await axios.post("http://localhost:8080/user/add", user);

    alert("Registered");

    navigate("/");
  };

  return (
    <>
      <div className="auth-container">
        <h2>🎬 Register</h2>

        <div className="form-group">
          <input
            placeholder="Name"
            onChange={(e) =>
              setUser({
                ...user,
                name: e.target.value,
              })
            }
          />
        </div>
        <div className="form-group">
          <input
            placeholder="Email"
            onChange={(e) =>
              setUser({
                ...user,
                email: e.target.value,
              })
            }
          />
        </div>

        <div className="form-group">
          <input
            type="password"
            placeholder="Password"
            onChange={(e) =>
              setUser({
                ...user,
                password: e.target.value,
              })
            }
          />
        </div>

        <button onClick={register} className="auth-btn">
          Register
        </button>

        <p className="login-text">
          Already have an account? <a href="/">Login</a>
        </p>
      </div>
    </>
  );
}

export default Register;
