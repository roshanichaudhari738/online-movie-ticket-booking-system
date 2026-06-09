import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
// import AdminLayout from "../Components/AdminLayout";
import "../CSS/ManageMovies.css";

function ManageMovies() {
  const [movies, setMovies] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    getMovies();
  }, []);

  const getMovies = async () => {
    try {
      const token = localStorage.getItem("token");

      const response = await axios.get("http://localhost:8080/admin/movies", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      setMovies(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const deactivateMovie = async (movieId) => {
    try {
      const token = localStorage.getItem("token");

      await axios.put(`http://localhost:8080/admin/movies/${movieId}`,
        {}, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      // alert("Movie Activate");

      getMovies();
    } catch (error) {
      console.log(error);

      // alert("Delete Failed");
    }
  };

  const editMovie = (movieId) => {
    navigate(`/admin/update-movie/${movieId}`);
  };

  return (
    <div>
      {/* <AdminLayout /> */}
      <div className="manage-movies">
        <h1>Manage Movies</h1>
        <div className="movies-grid">
          {movies.map((movie) => (
            <div key={movie.id} className="movie-card">
              <img
                className="movie-image"
                src={`http://localhost:8080/images/${movie.imageName}`}
              />

              <div className="movie-content">
                <h3>{movie.title}</h3>

                <p>Genre :{movie.genre}</p>

                <p>Language :{movie.language}</p>

                <p>Duration :{movie.duration}</p>
                <p>
                Status:{" "}
                <span
                  className={
                    movie.active ? "status-active" : "status-inactive"
                  }
                >
                  {movie.active ? "Active" : "Inactive"}
                </span>
              </p>

                {/* <input type="file" name="imageName" onChange={handleChange} /> */}
                <div className="movie-actions">
                  <button
                    className="edit-btn"
                    onClick={() => editMovie(movie.id)}
                  >
                    Edit
                  </button>{" "}
                  {/* <button
                    className="delete-btn"
                    onClick={() => deleteMovie(movie.id)}
                  >
                    Delete
                  </button> */}

                    <button
                className={movie.active ? "deactivate-btn" : "activate-btn"}
                onClick={() => deactivateMovie(movie.id)}
              >
                {movie.active ? "Deactivate" : "Activate"}
              </button>

                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default ManageMovies;
