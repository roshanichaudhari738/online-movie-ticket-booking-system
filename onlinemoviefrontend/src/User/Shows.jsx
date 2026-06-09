import { useEffect, useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";

import ShowCard from "../Components/ShowCard";
import UserLayout from "../Components/UserLayout";
import "../CSS/Shows.css";

function Shows() {
  const { movieId } = useParams();

  const navigate = useNavigate();

  const [shows, setShows] = useState([]);

  useEffect(() => {
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
      console.log(response.data);
      console.log("Is Array:", Array.isArray(response.data)); //check if response is array or object
    } catch (error) {
      console.log(error);
    }
    console.log(shows);
  };

  const selectShow = (showId,movieId) => {
    navigate(`/seats/${showId}/${movieId }`);
  };

  return (
    <div>
      <UserLayout />
      <div className="shows-container">
        <h1 className="shows-title">Available Shows</h1>
        {
          shows.length==0 ? (
             <div className="no-shows">
    <p>No Shows Available</p>
  </div>
          ):(
        <div className="shows-grid">

        {shows.map((show) => (
          <div key={show.id} className="show-card">
            <p className="show-label">Theatre</p>

            <p className="show-value">{show.thname}</p>

            <p className="show-label">Screen</p>

            <p className="show-value">{show.screenName}</p>

            <p className="show-label">Show Time</p>
  <p className="show-value">

            
            {new Date(show.showTime).toLocaleString()}
  </p>

            <h4 className="show-price">₹{show.price}</h4>

            <button className="select-btn" onClick={() => selectShow(show.id,movieId)}>
              Select Seats
            </button>
          </div>
        ))}
        </div>
          )
}
      </div>
    </div>
  );
}

export default Shows;
