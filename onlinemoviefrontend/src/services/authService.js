import axios from "axios";

const BASE_URL =
"http://localhost:8080";

export const login = (data) => {

    return axios.post(
        `${BASE_URL}/user/login`,
        data
    );

};

export const register = (data) => {

    return axios.post(
        `${BASE_URL}/register`,
        data
    );

};