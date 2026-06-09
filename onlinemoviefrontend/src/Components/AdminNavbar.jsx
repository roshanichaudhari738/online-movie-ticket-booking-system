import { Link, useNavigate } from "react-router-dom";
import "../CSS/AdminNavbar.css";

function AdminNavbar() {
  const navigate = useNavigate();

  const logout = () => {
    localStorage.clear();

    navigate("/");
  };

  return (
    <nav className="admin-navbar">
      <div className="logo">🎬 Admin Panel</div>

      

      <div className="admin-links">
        <Link to="/admin">Dashboard</Link>

        <Link to="/admin/manage-movies">Movies</Link>

        <Link to="/admin/manage-theatres">Theatres</Link>

        <Link to="/admin/manage-screens">Screens</Link>

        <Link to="/admin/manage-shows">Shows</Link>

        <Link to="/admin/bookings">Bookings</Link>
      </div>

      <button className="logout-btn" onClick={logout}>
        Logout
      </button>
    </nav>
  );
}

export default AdminNavbar;
