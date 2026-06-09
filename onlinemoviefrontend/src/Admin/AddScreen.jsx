import { useEffect, useState } from "react";
import axios from "axios";
import AdminLayout from "../Components/AdminLayout";
import "../CSS/AddScreen.css";

function AddScreen() {

    const [theatres, setTheatres] = useState([]);

    const [screen, setScreen] = useState({
        name: "",
        totalSeats: ""
    });

    const [theatreId, setTheatreId] =
        useState("");

    useEffect(() => {

        getTheatres();

    }, []);

    const getTheatres = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const response =
                await axios.get(
                    "http://localhost:8080/admin/theatres",
                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            setTheatres(response.data);

        }
        catch (error) {

            console.log(error);

        }

    };

    const handleChange = (e) => {

        setScreen({
            ...screen,
            [e.target.name]:
                e.target.value
        });

    };

    const addScreen = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const response =
                await axios.post(
                    `http://localhost:8080/admin/theater/${theatreId}/screens`,
                    screen,
                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            console.log(response.data);

            alert(
                "Screen Added Successfully"
            );

            setScreen({
                name: "",
                totalSeats: ""
            });

        }
        catch (error) {

            console.log(error);

            alert(
                "Failed To Add Screen"
            );

        }

    };

    return (

        <div>
            <AdminLayout/>

            <div className="add-screen-container">

                <div className="add-screen-card">

            <h2>Add Screen</h2>

            <select
                value={theatreId}
                onChange={(e) =>
                    setTheatreId(
                        e.target.value
                    )
                }
            >

                <option value="">
                    Select Theatre
                </option>

                {
                    theatres.map(
                        (theatre) => (

                            <option
                                key={theatre.id}
                                value={theatre.id}
                            >
                                {theatre.name}
                            </option>

                        )
                    )
                }

            </select>

            <br /><br />

            <input
                type="text"
                name="name"
                placeholder="Screen Name"
                value={
                    screen.name
                }
                onChange={
                    handleChange
                }
            />

            <br /><br />

            <input
                type="number"
                name="totalSeats"
                placeholder="Total Seats"
                value={
                    screen.totalSeats
                }
                onChange={
                    handleChange
                }
            />

            <br /><br />

            <button
                onClick={addScreen}
            >
                Add Screen
            </button>

            </div>
            </div>

        </div>

    );

}

export default AddScreen;