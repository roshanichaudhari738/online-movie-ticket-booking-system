import { useEffect, useState } from "react";

import axios from "axios";
// import UserLayout from "../Components/UserLayout";
import "../CSS/Profile.css";

function Profile() {
  const [user, setUser] = useState({});

  useEffect(() => {
    getProfile();
  }, []);

  const getProfile = async () => {
    const token = localStorage.getItem("token");

    const id = localStorage.getItem("userId");

    const response = await axios.get(
      `http://localhost:8080/user/profile/${id}`,
      {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      },
    );
    console.log("Profile Response:", response.data);

    setUser(response.data);
  };

  return (
    <div>
      {/* <UserLayout /> */}

      <div className="profile-container">
        <div className="profile-card">
          <h2>My Profile</h2>

          <div className="profile-item">
            <strong>Name:</strong>
            {user.name}
          </div>

          <div className="profile-item">
            <strong>Email:</strong>
            {user.email}
          </div>

          <div className="profile-item">
            <strong>Role:</strong>
            {user.role}
          </div>
        </div>
      </div>
    </div>
  );
}

export default Profile;
