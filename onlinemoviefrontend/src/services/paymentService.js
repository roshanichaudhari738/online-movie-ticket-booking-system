import axios from "axios";

const BASE_URL =
"http://localhost:8080";

const getToken = () =>
localStorage.getItem("token");

export const makePayment =
(data) => {

    return axios.post(
        `${BASE_URL}/user/payment`,
        data,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};