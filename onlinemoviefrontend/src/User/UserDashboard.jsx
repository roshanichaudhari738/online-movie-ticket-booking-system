import { Link } from "react-router-dom";
import "../CSS/UserDashboard.css";
// import UserLayout from "../Components/UserLayout";

function UserDashboard() {
  return (
    <div>
      {/* <UserLayout/> */}
      <div className="user-dashboard">
        <h1> 🎬 User Dashboard</h1>

        <div className="user-cards">
          <div className="user-card">
            <Link to="/movies" className="user-btn">
              Browse Movies
            </Link>
          </div>

          <div className="user-card">
            <Link to="/my-bookings" className="user-btn">
              My Bookings
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserDashboard;
