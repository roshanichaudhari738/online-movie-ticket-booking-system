import { useEffect, useState } from "react";
import axios from "axios";
// import AdminLayout from "../Components/AdminLayout";
import "../CSS/ManageScreens.css";

function ManageScreens() {
  const [screens, setScreens] = useState([]);

  useEffect(() => {
    getScreens();
  }, []);

  const getScreens = async () => {
    const token = localStorage.getItem("token");

    const response = await axios.get("http://localhost:8080/admin/screens", {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    console.log("Screens Data:", response.data);
    setScreens(response.data);
  };

  const deactivateScreen = async (id) => {
    const token = localStorage.getItem("token");

    const response = await axios.put(
      `http://localhost:8080/admin/screens/${id}`,
      {},
      {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      },
    );

    getScreens();
    console.log(response.data);
  };

  return (
    <div>
      {/* <AdminLayout /> */}

      <div className="manage-screens-container">
        <h1 className="manage-screens-title">Manage Screens</h1>

        <div className="screens-grid">
          {screens.map((screen) => (
            <div key={screen.id} className="screen-card">
              <h3>{screen.name}</h3>

              <p>
                <strong>Total Seats:</strong> {screen.totalSeats}
              </p>

              <p>
                <strong>Status:</strong>{" "}
                <span
                  className={
                    screen.active ? "status-active" : "status-inactive"
                  }
                >
                  {screen.active ? "Active" : "Inactive"}
                </span>
              </p>

              <button
                className={screen.active ? "deactivate-btn" : "activate-btn"}
                onClick={() => deactivateScreen(screen.id)}
              >
                {screen.active ? "Deactivate" : "Activate"}
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default ManageScreens;
