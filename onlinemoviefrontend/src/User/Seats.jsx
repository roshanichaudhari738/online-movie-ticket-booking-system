import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import SeatCard from "../Components/SeatCard";
import { useNavigate } from "react-router-dom";
import "../CSS/Seats.css";
import UserLayout from "../Components/UserLayout";

function Seats() {
  const [shows, setShows] = useState([]);

  const { showId } = useParams();

  const { movieId } = useParams();
  console.log("movieId =", movieId);
  console.log("showId =", showId);

  const [seats, setSeats] = useState([]);

  const [selectedSeats, setSelectedSeats] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    getSeats();
    getShows();
  }, []);

  const getShows = async () => {
    try {
      const token = localStorage.getItem("token");
      console.log("Token =", token);
      console.log(localStorage.getItem("token"));

      const response = await axios.get(
        `http://localhost:8080/user/show/movie/${movieId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );

      setShows(response.data);
      console.log("show is ", response.data);
      console.log("Is Array:", Array.isArray(response.data)); //check if response is array or object
    } catch (error) {
      console.log(error);
    }
    console.log(shows);
  };

  const getSeats = async () => {
    try {
      const token = localStorage.getItem("token");

      const response = await axios.get(
        `http://localhost:8080/user/showseat/${showId}/seats`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );

      setSeats(response.data);
      console.log(response.data);
      console.log(setSeats(response.data));
      console.log("Is Array:", Array.isArray(response.data)); //check if response is array or object
    } catch (error) {
      console.log(error);
    }
  };

  const selectSeat = (seatId) => {
    if (selectedSeats.includes(seatId)) {
      setSelectedSeats(selectedSeats.filter((id) => id !== seatId));
    } else {
      setSelectedSeats([...selectedSeats, seatId]);
    }
  };

  const bookTicket = async () => {
    if (selectedSeats.length === 0) {
      alert("Please select at least one seat!");
      return;
    }

    try {
      const token = localStorage.getItem("token");

      const userId = localStorage.getItem("userId");
      console.log({
        userId,
        showId,
        selectedSeats,
      });

      const response = await axios.post(
        "http://localhost:8080/user/book",
        {
          userId: Number(userId),
          showId: Number(showId),
          seatId: selectedSeats,
        },
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );
      console.log(response.data);

      alert("Ticket Booked Successfully");
      navigate(`/payment/${response.data.bookingId}`);
      getSeats();

      setSelectedSeats([]);
    } catch (error) {
      console.log(error);

      alert("Booking Failed");
    }
  };

  return (
    <div>
      <UserLayout />
      <div className="seat-page">
        <h1>Select Seats</h1>
        {shows.map((show) => (
          <div key={show.id} className="theatre-info">
            Theatre : <span className="theatre-name">{show.thname}</span>
            Screen :<span className="screen-name">{show.screenName}</span>
          </div>
        ))}

        <div className="screen">SCREEN</div>

        {seats.map((seat) => (
          <button
            key={seat.id}
            disabled={seat.booked}
            onClick={() => selectSeat(seat.id)}
            className={
              seat.booked
                ? "seat booked"
                : selectedSeats.includes(seat.id)
                  ? "seat selected"
                  : "seat"
            }
          >
            {seat.seatNumber}
          </button>
        ))}

        <div className="selected-seat-text">
          Selected Seats: {selectedSeats.join(", ")}
        </div>

        <button className="book-btn" onClick={bookTicket}>
          Book Ticket
        </button>
      </div>
    </div>
  );
}

export default Seats;
