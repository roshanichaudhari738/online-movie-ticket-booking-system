import axios from "axios";

function Booking() {

  const book = async()=>{

    const token =
    localStorage.getItem("token");

    await axios.post(
      "http://localhost:8080/user/book",
      {
        userId:1,
        showId:1,
        seatIds:[1,2]
      },
      {
        headers:{
          Authorization:
          `Bearer ${token}`
        }
      }
    );

    alert("Booked");
  }

  return (
    <>
      <button onClick={book}>
        Book Ticket
      </button>
    </>
  )
}

export default Booking;