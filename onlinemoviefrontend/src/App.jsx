import { useState } from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./Auth/Login";
import Register from "./Auth/Register";
import Movies from "./User/Movies";
import Shows from "./User/Shows";
import Seats from "./User/Seats";
import Booking from "./User/Booking";
import AdminDashboard from "./Admin/AdminDashboard";
import AddMovie from "./Admin/AddMovie";
import AddTheatre from "./Admin/AddTheatre";
import AddScreen from "./Admin/AddScreen";
import AddShow from "./Admin/AddShow";
import MyBookings from "./User/MyBookings";
import ManageMovies from "./Admin/ManageMovies";
import UpdateMovie from "./Admin/UpdateMovie";
import ViewBookings from "./Admin/ViewBookings";
import ManageTheatres from "./Admin/ManageTheatres";
import ManageScreens from "./Admin/ManageScreens";
import ManageShows from "./Admin/ManageShows";
import Payment from "./User/Payment";
import MovieDetails from "./User/MovieDetails";
import Profile from "./User/Profile";
import ProtectedRoute from "./Components/ProtectedRoute";
import AdminRoute from "./Components/AdminRoute";
import UserDashboard from "./User/UserDashboard";
import UserLayout from "./Components/UserLayout";
import AdminLayout from "./Components/AdminLayout";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />
          {/* <Route
            path="/movies"
            element={
              <ProtectedRoute>
                <Movies />
              </ProtectedRoute>
            }
          /> */}
          <Route path="/shows/:movieId" element={<Shows />} />
          <Route path="/seats/:showId/:movieId" element={<Seats />} />
          <Route path="/booking" element={<Booking />} />
          {/* <Route
            path="/admin"
            element={
              <AdminRoute>
                <AdminDashboard />
              </AdminRoute>
            }
          /> */}
          <Route path="/admin/add-movie" element={<AddMovie />} />
          <Route path="/admin/add-theatre" element={<AddTheatre />} />
          <Route path="/admin/add-screen" element={<AddScreen />} />
          <Route path="/admin/add-show" element={<AddShow />} />
          {/* <Route path="/my-bookings" element={<MyBookings />} /> */}
          {/* <Route path="/admin/manage-movies" element={<ManageMovies />} /> */}
          <Route
            path="/admin/update-movie/:movieId"
            element={<UpdateMovie />}
          />
          <Route path="/admin/bookings" element={<ViewBookings />} />
          {/* <Route path="/admin/manage-theatres" element={<ManageTheatres />} /> */}

          {/* <Route path="/admin/manage-screens" element={<ManageScreens />} /> */}

          {/* <Route path="/admin/manage-shows" element={<ManageShows />} /> */}
          <Route path="/payment/:bookingId" element={<Payment />} />

          <Route path="/movie/:movieId" element={<MovieDetails />} />

          {/* <Route path="/profile" element={<Profile />} /> */}
          {/* <Route path="/admin" element={<AdminDashboard />} /> */}

          {/* <Route path="/user" element={<UserDashboard />} /> */}

          {/* <Route path="/movies" element={<Movies />} /> */}

          <Route path="/my-bookings" element={<MyBookings />} />

          {/* Admin side Navbar  */}
          <Route element={<AdminLayout />}>
            <Route path="/admin" element={<AdminDashboard />} />

            <Route path="/admin/manage-movies" element={<ManageMovies />} />

            <Route path="/admin/manage-theatres" element={<ManageTheatres />} />

            <Route path="/admin/manage-screens" element={<ManageScreens />} />

            <Route path="/admin/manage-shows" element={<ManageShows />} />
          </Route>

          {/* User side Navbar  */}

          <Route element={<UserLayout />}>
            <Route path="/user" element={<UserDashboard />} />

            <Route path="/movies" element={<Movies />} />

            <Route path="/my-bookings" element={<MyBookings />} />

            <Route path="/profile" element={<Profile />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
