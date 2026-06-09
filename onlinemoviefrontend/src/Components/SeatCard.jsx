function SeatCard({

    seat,

    selected,

    onSelect

}) {

    return (

        <button

            disabled={
                seat.booked
            }

            onClick={() =>
                onSelect(
                    seat.id
                )
            }

            style={{

                margin:
                "5px",

                border:
                selected
                ? "3px solid green"
                : "1px solid black"

            }}

        >

            {
                seat.seatNumber
            }

        </button>

    );

}

export default SeatCard;