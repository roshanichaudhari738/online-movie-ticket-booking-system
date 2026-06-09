import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import UserLayout from "../Components/UserLayout";
import "../CSS/Payment.css";
import { useEffect } from "react";
import { useParams } from "react-router-dom";

function Payment() {
  const [payment, setPayment] = useState({
    bookingId: "",
    amount: "",
    paymentMethod: "",
  });

  const { bookingId } = useParams();
  console.log("Booking ID from URL:", bookingId);

  const navigate = useNavigate();

  useEffect(() => {
    getBooking();
  }, []);

  const getBooking = async () => {
    try {
      const token = localStorage.getItem("token");

      const response = await axios.get(
        `http://localhost:8080/user/book/get/${bookingId}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );
      console.log(response.data);

      setPayment(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const makePayment = async () => {
    try {
      const token = localStorage.getItem("token");
      console.log("Payment Data:", payment);
      console.log("Token:", token);

      const response = await axios.post(
        "http://localhost:8080/user/pay",
        payment,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        },
      );

      alert(response.data.message);
      navigate("/user");
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <UserLayout />
      <div className="payment-container">
        <div className="payment-card">
          <h2>Payment</h2>

          <input
            className="payment-input"
            placeholder="Booking Id"
            value={bookingId}
            readOnly
          />

          <br />
          <br />

          <input
            className="payment-input"
            placeholder="Amount"
            value={payment.amount}
            readOnly
          />

          <select
          className="payment-method"
            value={payment.paymentMethod}
            onChange={(e) =>
              setPayment({
                ...payment,
                paymentMethod: e.target.value,
              })
            }
          >
            <option value="">Select Method</option>
            <option value="UPI">UPI</option>
            <option value="CARD">Card</option>
            <option value="NET_BANKING">Net Banking</option>
          </select>

          <button className="pay-btn" onClick={makePayment}>
            Pay Now
          </button>
        </div>
      </div>
    </div>
  );
}

export default Payment;
