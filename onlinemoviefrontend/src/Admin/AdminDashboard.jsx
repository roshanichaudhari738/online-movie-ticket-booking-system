import { Link } from "react-router-dom";

import "../CSS/AdminDashboard.css";


function AdminDashboard() {
  return (
    <>
      
      <div className="dashboard-container">
        <h1 className="dashboard-title">🎬 Admin Dashboard</h1>

        

        <div className="dashboard-grid">
          <div className="dashboard-card">
            <h3>Movie Management</h3>

            <Link to="/admin/add-movie" className="dashboard-btn">
              Add Movie
            </Link>
          </div>

          <br />

          <div className="dashboard-card">
            <h3>Theatre Management</h3>

            <Link to="/admin/add-theatre" className="dashboard-btn">
              Add Theatre
            </Link>
          </div>

          <div className="dashboard-card">
            <h3>Screen Management</h3>

            <Link to="/admin/add-screen" className="dashboard-btn">
              Add Screen
            </Link>
          </div>

          <br />

          <br />

          <div className="dashboard-card">
            <h3>Show Management</h3>

            <Link to="/admin/add-show" className="dashboard-btn">
              Add Show
            </Link>
          </div>

          <br />

          <div className="dashboard-card">
            <h3>Booking Management</h3>

            <Link to="/admin/bookings" className="dashboard-btn">
              View Bookings
            </Link>
          </div>
        </div>
      </div>
    </>
  );
}

export default AdminDashboard;
