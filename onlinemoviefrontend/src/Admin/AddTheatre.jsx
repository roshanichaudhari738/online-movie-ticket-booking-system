import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import AdminLayout from "../Components/AdminLayout";
import "../CSS/AddTheatre.css";

function AddTheatre() {

    const [theatre, setTheatre] = useState({
        name: "",
        location: ""
    });

    const navigate =
        useNavigate();


    const handleChange = (e) => {

        setTheatre({
            ...theatre,
            [e.target.name]: e.target.value
        });

    };

    const addTheatre = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const response =
                await axios.post(
                    "http://localhost:8080/admin/add/theatres",
                    theatre,
                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            console.log(response.data);

            alert("Theatre Added Successfully");

            setTheatre({
                name: "",
                location: ""
            });

            navigate("/admin");

        }
        catch (error) {

            console.log(error);

            alert("Failed To Add Theatre");

        }

    };

    return (

        <div>
            <AdminLayout/>

            <div className="add-theatre-container">

            <div className="add-theatre-card">

            <h2>Add Theatre</h2>

            <input
            className="theatre-input"
                type="text"
                name="name"
                placeholder="Theatre Name"
                value={theatre.name}
                onChange={handleChange}
            />

            

            <input
            className="theatre-input"
                type="text"
                name="location"
                placeholder="Location"
                value={theatre.location}
                onChange={handleChange}
            />


            <button className="add-theatre-btn" onClick={addTheatre}>
                Add Theatre
            </button>
            </div>
            </div>

        </div>

    );

}

export default AddTheatre;