import { useEffect, useState } from "react";
import axios from "axios";
// import AdminLayout from "../Components/AdminLayout";
import "../CSS/ManageTheatres.css";

function ManageTheatres() {
  const [theatres, setTheatres] = useState([]);

  useEffect(() => {
    getTheatres();
  }, []);

  const getTheatres = async () => {
    const token = localStorage.getItem("token");

    const response = await axios.get("http://localhost:8080/admin/theatres", {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    setTheatres(response.data);
  };

  const deactivateTheatre = async (id) => {
    const token = localStorage.getItem("token");

    await axios.put(`http://localhost:8080/admin/theatres/${id}`,
      {}, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    getTheatres();
  };

  return (
    <div>
      {/* <AdminLayout /> */}
      <div className="manage-theatres">
        <h1>Manage Theatres</h1>

        <div className="theatres-grid">
          {theatres.map((theatre) => (
            <div key={theatre.id} className="theatre-card">
              <h3>🎭 {theatre.name}</h3>

              <p>📍 {theatre.location}</p>

              {/* <button
                className="delete-btn"
                onClick={() => deleteTheatre(theatre.id)}
              >
                Delete
              </button> */}

              <p>
                <strong>Status:</strong>{" "}
                <span
                  className={
                    theatre.active ? "status-active" : "status-inactive"
                  }
                >
                  {theatre.active ? "Active" : "Inactive"}
                </span>
              </p>

              <button
                className={theatre.active ? "deactivate-btn" : "activate-btn"}
                onClick={() => deactivateTheatre(theatre.id)}
              >
                {theatre.active ? "Deactivate" : "Activate"}
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default ManageTheatres;
