import axios from "axios";

const BASE_URL =
"http://localhost:8080";

const getToken = () =>
localStorage.getItem("token");

export const bookTicket =
(data) => {

    return axios.post(
        `${BASE_URL}/user/book`,
        data,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};

export const getBookings =
(userId) => {

    return axios.get(
        `${BASE_URL}/user/book/users/${userId}`,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};

export const cancelBooking =
(id) => {

    return axios.put(
        `${BASE_URL}/user/cancel/${id}`,
        {},
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};