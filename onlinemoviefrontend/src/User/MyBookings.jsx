import { useEffect, useState } from "react";
import axios from "axios";
import UserLayout from "../Components/UserLayout";
import "../CSS/MyBookings.css";

function MyBookings() {
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

      const userId = localStorage.getItem("userId");

      console.log("Token =", token);
      console.log("UserId =", userId);

      const response = await axios.get(
        `http://localhost:8080/user/book/users/${userId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );

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

  const cancelBooking = async (bookingId) => {
    try {
      const token = localStorage.getItem("token");
      console.log("Id", bookingId);

      await axios.put(
        `http://localhost:8080/user/cancel/${bookingId}`,
        {},
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );

      alert("Booking Cancelled");

      getBookings();
    } catch (error) {
      console.log(error);

      alert("Cancel Failed");
    }
  };

  return (
    <div>
      <UserLayout />
      <div className="bookings-container">
        <h1 className="bookings-title">My Bookings</h1>

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

        <div className="bookings-grid">
          {filteredBooking.map((booking) => (
            <div key={booking.bookingId} className="booking-card">
              <h3>Booking #{booking.bookingId}</h3>

              <p>
                <strong>Seats :</strong> {booking.seatNumbers}
              </p>

              <p>
                <strong>Movie :</strong> {booking.movieName}
              </p>

              <p>
                <strong>Theatre :</strong> {booking.thName}
              </p>

              <p>
                <strong>Price :</strong>₹{booking.price}
              </p>

              <p>
                <strong>Total Amount :</strong>₹{booking.amount}
              </p>

              <p>
                <strong>Status :</strong>

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
                <strong>Show Time :</strong> {booking.showTime}
              </p>

              <p>
                <strong>Booking Time :</strong> {booking.bookingTime}
              </p>

              {booking.status === "BOOKED" && (
                <button
                  className="cancel-btn"
                  onClick={() => cancelBooking(booking.bookingId)}
                >
                  Cancel Booking
                </button>
              )}
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default MyBookings;
