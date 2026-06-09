import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import MovieCard from "../Components/MovieCard";
// import UserLayout from "../Components/UserLayout";
import "../CSS/Movies.css";

function Movies() {
  const [movies, setMovies] = useState([]);
  const [search, setSearch] = useState("");
  const [filteredMovies, setFilteredMovies] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    getMovies();
  }, []);

  useEffect(() => {
    setFilteredMovies(movies);
  }, [movies]);

  const getMovies = async () => {
    try {
      const token = localStorage.getItem("token");
      console.log(token);

      const response = await axios.get(
        "http://localhost:8080/user/all",

        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );

      setMovies(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const viewShows = (movieId) => {
    navigate(`/shows/${movieId}`);
  };

  const searchMovie = () => {
    const filteredMovie = movies.filter((movie) =>
      movie.title.toLowerCase().includes(search.toLowerCase()),
    );
    setFilteredMovies(filteredMovie);
  };

  console.log("set Movie ", searchMovie);
  console.log("length ", filteredMovies.length);

  return (
    <div>
      {/* <UserLayout /> */}

      <div className="movies-page">
        <h1>🎬 Available Movies</h1>

        <div className="search-container">
          <input
            className="search-input"
            type="text"
            placeholder="Search Movie"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
          <button className="search-btn" onClick={searchMovie}>
            Search
          </button>

             <button className="search-btn" onClick={getMovies}>
            All
          </button>

        </div>

        <div className="movies-grid">
          {filteredMovies.length > 0 ? (
            filteredMovies.map((movie) => (
              <div key={movie.id} className="movie-card">
                <img
                  className="movie-image"
                  src={`http://localhost:8080/images/${movie.imageName}`}
                  alt={movie.title}
                />

                <div className="movie-info">
                  <h3>{movie.title}</h3>

                  <p>Genre :{movie.genre}</p>

                  <p>Language :{movie.language}</p>

                  <p>
                    Duration :{movie.duration}
                    mins
                  </p>

                  <button
                    className="show-btn"
                    onClick={() => viewShows(movie.id)}
                  >
                    View Shows
                  </button>
                </div>
              </div>
            ))
          ) : (
            <p className="no-movie-msg">This movie is not available.</p>
          )}
        </div>
      </div>
    </div>
  );
}

export default Movies;
