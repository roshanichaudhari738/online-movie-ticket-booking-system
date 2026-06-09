function ShowCard({
    show,
    onSelectShow
}) {

    return (

        <div
            style={{
                border:
                "1px solid black",
                padding:
                "10px",
                margin:
                "10px"
            }}
        >

            <h3>
                {show.showTime}
            </h3>

            <p>
                Price :
                ₹{show.price}
            </p>

            <button
                onClick={() =>
                    onSelectShow(
                        show.id
                    )
                }
            >
                Select Seats
            </button>

        </div>

    );

}

export default ShowCard;