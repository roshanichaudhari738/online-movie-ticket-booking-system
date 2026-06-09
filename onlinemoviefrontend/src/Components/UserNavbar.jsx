import { Link, useNavigate } from "react-router-dom";
import "../CSS/Navbar.css";

function UserNavbar() {
  const navigate = useNavigate();

  const logout = () => {
    localStorage.clear();

    navigate("/");
  };

  const name = localStorage.getItem("name");
  console.log("name is ", name);

  return (
    <nav className="user-navbar">
      <div className="navbar-left">
        <h2>🎬 Movie Booking </h2>

        <p className="welcome-text">Welcome, {name}</p>
      </div>

      <div className="user-links">
        <Link to="/user">Dashboard</Link>

        <Link to="/movies">Movies</Link>

        <Link to="/my-bookings">My Bookings</Link>

        <Link to="/profile">Profile</Link>
      </div>

      <button className="logout-btn" onClick={logout}>
        Logout
      </button>
    </nav>
  );
}

export default UserNavbar;
