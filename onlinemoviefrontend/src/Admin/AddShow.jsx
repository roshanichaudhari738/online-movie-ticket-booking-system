import { useEffect, useState } from "react";
import axios from "axios";
import AdminLayout from "../Components/AdminLayout";
import "../CSS/AddShow.css";

function AddShow() {

    const [movies, setMovies] =
        useState([]);

    const [screens, setScreens] =
        useState([]);

    const [movieId, setMovieId] =
        useState("");

    const [screenId, setScreenId] =
        useState("");

    const [show, setShow] =
        useState({
            showTime: "",
            price: ""
        });

    useEffect(() => {

        getMovies();
        getScreens();

    }, []);

    const getMovies = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const response =
                await axios.get(
                    "http://localhost:8080/admin/movies",
                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            setMovies(response.data);
            console.log(response.data);

        } catch (error) {

            console.log(error);

        }
    };

    const getScreens = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const response =
                await axios.get(
                    "http://localhost:8080/admin/screens",
                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            setScreens(response.data);
            console.log(response.data);
        } catch (error) {

            console.log(error);

        }
    };

    const handleChange = (e) => {

        setShow({
            ...show,
            [e.target.name]:
                e.target.value
        });

    };

    const addShow = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const response =
                await axios.post(
                    `http://localhost:8080/admin/movie/${movieId}/screen/${screenId}/show`,
                    show,
                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            console.log(response.data);

            alert(
                "Show Added Successfully"
            );

            setShow({
                showTime: "",
                price: ""
            });

        } catch (error) {

            console.log(error);

            alert(
                "Failed To Add Show"
            );

        }
    };

    return (

        <div>
            <AdminLayout/>
            <div className="add-show-container">

        <div className="add-show-card">

            <h2>Add Show</h2>

            <select
            className="show-select"
                value={movieId}
                onChange={(e) =>
                    setMovieId(
                        e.target.value
                    )
                }
            >

                <option value="">
                    Select Movie
                </option>

                {
                    movies.map(
                        movie => (

                            <option
                                key={movie.id}
                                value={movie.id}
                            >
                                {movie.title}
                            </option>

                        )
                    )
                }

            </select>

            

            <select
            className="show-select"
                value={screenId}
                onChange={(e) =>
                    setScreenId(
                        e.target.value
                    )
                }
            >

                <option value="">
                    Select Screen
                </option>

                {
                    screens.map(
                        screen => (

                            <option
                                key={screen.id}
                                value={screen.id}
                            >
                                {screen.name}
                            </option>

                        )
                    )
                }

            </select>


            <input
            className="show-input"
                type="datetime-local"
                name="showTime"
                value={show.showTime}
                onChange={handleChange}
            />

            

            <input
            className="show-input"
                type="number"
                name="price"
                placeholder="Ticket Price"
                value={show.price}
                onChange={handleChange}
            />

            

            <button
            className="add-show-btn"
                onClick={addShow}
            >
                Add Show
            </button>
            </div>
            </div>

        </div>

    );

}

export default AddShow;