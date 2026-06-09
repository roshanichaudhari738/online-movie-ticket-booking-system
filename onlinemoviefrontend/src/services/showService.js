import axios from "axios";

const BASE_URL =
"http://localhost:8080";

const getToken = () =>
localStorage.getItem("token");

export const getShows =
(movieId) => {

    return axios.get(
        `${BASE_URL}/user/movies/${movieId}/shows`,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};

export const addShow =
(
 movieId,
 screenId,
 data
) => {

    return axios.post(
        `${BASE_URL}/admin/movies/${movieId}/screens/${screenId}/shows`,
        data,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};