import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import AdminLayout from "../Components/AdminLayout";
import "../CSS/AddMovie.css";

function AddMovie() {
  const [movie, setMovie] = useState({
    title: "",
    genre: "",
    language: "",
    duration: "",
    rating: "",
    imageName:""
  });

//   const [image, setImage] = useState(null);
 

  const navigate = useNavigate();

  const handleChange = (e) => {
    setMovie({
      ...movie,
      [e.target.name]: e.target.value,
    });
  };

  const handleFileChange = (e) => {
  setMovie({
    ...movie,
    imageName: e.target.files[0]
  });
};

  const addMovie = async () => {
    const formData= new FormData();
  formData.append("title",movie.title);
  formData.append("genre",movie.genre);
  formData.append("language",movie.language);
  formData.append("duration",movie.duration);
  formData.append("rating",movie.rating);
  formData.append("image",movie.imageName);
    try {
      const token = localStorage.getItem("token");

      const response = await axios.post(
        "http://localhost:8080/admin/add/movies",
        formData,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );

      alert("Movie Added Successfully");

      console.log(response.data);

      setMovie({
        title: "",
        genre: "",
        language: "",
        duration: "",
        rating: "",
        image: "",
      });

      navigate("/admin");
    } catch (error) {
      console.log(error);

      alert("Failed To Add Movie");
    }
  };

  return (
    <div>
      <AdminLayout />

      <div className="add-movie-container">

        <div className="add-movie-card">

      <h2>Add Movie</h2>

      <input
      className="movie-input"
        type="text"
        name="title"
        placeholder="Movie Title"
        value={movie.title}
        onChange={handleChange}
      />

      

      <input
      className="movie-input"
        type="text"
        name="genre"
        placeholder="Genre"
        value={movie.genre}
        onChange={handleChange}
      />

      

      <input
      className="movie-input"
        type="text"
        name="language"
        placeholder="Language"
        value={movie.language}
        onChange={handleChange}
      />

      

      <input
      className="movie-input"
        type="number"
        name="duration"
        placeholder="Duration (Minutes)"
        value={movie.duration}
        onChange={handleChange}
      />

      

      <input
      className="movie-input"
        type="number"
        name="rating"
        placeholder="rating"
        value={movie.rating}
        onChange={handleChange}
      />
      <br />
      <br />

      <input className="file-input" type="file"  onChange={handleFileChange} />

      <button className="add-movie-btn" onClick={addMovie}>Add Movie</button>
      </div>
      </div>
    </div>
  );
}

export default AddMovie;
