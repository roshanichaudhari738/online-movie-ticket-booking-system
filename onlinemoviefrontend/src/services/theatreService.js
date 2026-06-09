import axios from "axios";

const BASE_URL =
"http://localhost:8080";

const getToken = () =>
localStorage.getItem("token");

export const getTheatres =
() => {

    return axios.get(
        `${BASE_URL}/admin/theatres`,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};

export const addTheatre =
(data) => {

    return axios.post(
        `${BASE_URL}/admin/theatres`,
        data,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};