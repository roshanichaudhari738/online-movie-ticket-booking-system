import { useEffect, useState } from "react";
import axios from "axios";
// import AdminLayout from "../Components/AdminLayout";
import "../CSS/ManageShows.css";

function ManageShows() {
  const [shows, setShows] = useState([]);

  useEffect(() => {
    getShows();
  }, []);

  const getShows = async () => {
    const token = localStorage.getItem("token");

    const response = await axios.get("http://localhost:8080/admin/shows", {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    setShows(response.data);
  };

  const deactivateShow = async (id) => {
    const token = localStorage.getItem("token");

    await axios.put(`http://localhost:8080/admin/shows/${id}`,
      {}, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    getShows();
  };

  return (
    <div>
      {/* <AdminLayout /> */}

      <div className="manage-shows-container">
        <h1 className="manage-shows-title">Manage Shows</h1>

        <div className="shows-grid">
          {shows.map((show) => (
            <div key={show.id} className="show-card">
              <h3>Show #{show.id}</h3>

              <p>
                <strong>Time:</strong> {show.showTime}
              </p>

              <p>
                <strong>Price:</strong> ₹{show.price}
              </p>

              <p>
                <strong>Status:</strong>{" "}
                <span
                  className={
                    show.active ? "status-active" : "status-inactive"
                  }
                >
                  {show.active ? "Active" : "Inactive"}
                </span>
              </p>

              <button
                className={show.active ? "deactivate-btn" : "activate-btn"}
                onClick={() => deactivateShow(show.id)}
              >
                {show.active ? "Deactivate" : "Activate"}
              </button>
              
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default ManageShows;
