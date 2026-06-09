import { useEffect, useState } from "react";
import axios from "axios";
import AdminLayout from "../Components/AdminLayout";
import "../CSS/ViewBookings.css";

function ViewBookings() {
  const [bookings, setBookings] = useState([]);
  const [search, setSearch] = useState("");
  const [filteredBooking, setFilteredBooking] = useState([]);

  useEffect(() => {
    getBookings();
  }, []);

  useEffect(() => {
    setFilteredBooking(bookings)
  }, [bookings]);

  const getBookings = async () => {
    try {
      const token = localStorage.getItem("token");

      const response = await axios.get("http://localhost:8080/admin/bookings", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      setBookings(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const searchBooking = () => {
    const filteredBooking = bookings.filter((book) =>
      book.status.toUpperCase().includes(search.toUpperCase()),
    );
    setFilteredBooking(filteredBooking);
  };

  return (
    <div>
      <AdminLayout />

      <div className="bookings-container">
        <h1 className="bookings-title">All Bookings</h1>

        <div className="search-container">
          <input
            className="search-input"
            type="text"
            placeholder="Search Booking"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
          <button className="search-btn" onClick={searchBooking}>
            Search
          </button>
        </div>

        <div className="bookings-list">
          {filteredBooking.map((booking) => (
            <div key={booking.bookingId} className="booking-card">
              <h3>Booking #{booking.bookingId}</h3>

              <p>
                <strong>User:</strong> {booking.userName}
              </p>

              <p>
                <strong>Movie:</strong> {booking.movieName}
              </p>

              <p>
                <strong>Amount:</strong> ₹{booking.amount}
              </p>

              <p>
                <strong>Status:</strong>

                <span
                  className={
                    booking.status === "BOOKED"
                      ? "status-booked"
                      : "status-cancelled"
                  }
                >
                  {" "}
                  {booking.status}
                </span>
              </p>

              <p>
                <strong>Booking Time:</strong> {booking.bookingTime}
              </p>

              <p>
                <strong>Show Time:</strong> {booking.showTime}
              </p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default ViewBookings;
