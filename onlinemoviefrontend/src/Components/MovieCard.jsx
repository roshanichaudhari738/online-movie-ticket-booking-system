function MovieCard({ movie, onViewShows }) {

    return (

        <div
            style={{
                border: "1px solid black",
                padding: "10px",
                margin: "10px"
            }}
        >

            <h3>
                {movie.title}
            </h3>

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
                mins
            </p>

            <button
                onClick={() =>
                    onViewShows(
                        movie.id
                    )
                }
            >
                View Shows
            </button>

        </div>

    );

}

export default MovieCard;