import {
    useParams
} from "react-router-dom";

import {
    useEffect,
    useState
} from "react";

import axios from "axios";

function MovieDetails() {

    const { movieId } =
        useParams();

    const [movie, setMovie] =
        useState({});

    useEffect(() => {

        getMovie();

    }, []);

    const getMovie =
        async () => {

            const response =
                await axios.get(
                    `http://localhost:8080/user/movies/${movieId}`
                );

            setMovie(
                response.data
            );

        };

    return (

        <div>

            <h1>
                {movie.title}
            </h1>

            <p>
                Genre :
                {movie.genre}
            </p>

            <p>
                Language :
                {movie.language}
            </p>

            <p>
                Duration :
                {movie.duration}
            </p>

        </div>

    );

}

export default MovieDetails;