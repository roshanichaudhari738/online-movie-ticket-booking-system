import { useEffect, useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";
import AdminLayout from "../Components/AdminLayout";
import "../CSS/UpdateMovie.css";

function UpdateMovie() {
  const { movieId } = useParams();

  const navigate = useNavigate();

  const [movie, setMovie] = useState({
    title: "",
    genre: "",
    language: "",
    duration: "",
  });

  const [existingImage, setExistingImage] = useState("");
  const [image, setImage] = useState(null);

  useEffect(() => {
    getMovie();
  }, []);

  const getMovie = async () => {
    try {
      const token = localStorage.getItem("token");

      const response = await axios.get(
        `http://localhost:8080/admin/get/movies/${movieId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );
      console.log(response.data);

      setMovie(response.data);
      setExistingImage(response.data.imageName);

    } catch (error) {
      console.log(error);
    }
  };

  const handleChange = (e) => {
    setMovie({
      ...movie,
      [e.target.name]: e.target.value,
    });
  };

  const handleFileChange = (e) => {
    setImage(e.target.files[0]);
  };

  const updateMovie = async () => {
    try {
      const token = localStorage.getItem("token");

      const formData = new FormData();

      formData.append("title", movie.title);
      formData.append("genre", movie.genre);
      formData.append("language", movie.language);
      formData.append("duration", movie.duration);
      formData.append("rating", movie.rating);

      if (image) {
        formData.append("image", image);
      } else {
        formData.append("existingImage", existingImage);
      }

      await axios.put(
        `http://localhost:8080/admin/movies/${movieId}`,
        formData,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );

      alert("Movie Updated");

      navigate("/admin/manage-movies");
    } catch (error) {
      console.log(error);

      alert("Update Failed");
    }
  };

  return (
    <div>
      <AdminLayout />

      <div className="update-movie-container">
        <div className="update-movie-card">
          <h2>Update Movie</h2>

          <input
            type="text"
            name="title"
            value={movie.title}
            onChange={handleChange}
            placeholder="Title"
          />

          <br />
          <br />

          <input
            type="text"
            name="genre"
            value={movie.genre}
            onChange={handleChange}
            placeholder="Genre"
          />

          <br />
          <br />

          <input
            type="text"
            name="language"
            value={movie.language}
            onChange={handleChange}
            placeholder="Language"
          />

          <br />
          <br />

          <input
            type="number"
            name="duration"
            value={movie.duration}
            onChange={handleChange}
            placeholder="Duration"
          />
          <br />
          <br />
          {existingImage && !image && (
            <div>
              <p>Current Image:</p>
              <img
                src={`http://localhost:8080/images/${existingImage}`}
                alt="current"
                style={{ width: "100px", height: "100px", objectFit: "cover" }}
              />
            </div>
          )}

          <input type="file" onChange={handleFileChange} />

          <br />
          <br />

          <button className="update-btn" onClick={updateMovie}>
            Update Movie
          </button>
        </div>
      </div>
    </div>
  );
}

export default UpdateMovie;
