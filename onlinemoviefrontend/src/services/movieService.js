import axios from "axios";

const BASE_URL =
"http://localhost:8080";

const getToken = () =>
localStorage.getItem("token");

export const getMovies =
() => {

    return axios.get(
        `${BASE_URL}/user/all`,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};

export const addMovie =
(data) => {

    return axios.post(
        `${BASE_URL}/admin/add/movies`,
        data,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};

export const deleteMovie =
(id) => {

    return axios.delete(
        `${BASE_URL}/admin/movies/${id}`,
        {
            headers: {
                Authorization:
                `Bearer ${getToken()}`
            }
        }
    );

};