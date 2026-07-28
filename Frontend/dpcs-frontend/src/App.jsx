import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "./pages/auth/Login";
import AdminDashboard from "./pages/admin/Dashboard";
import DoctorDashboard from "./pages/doctor/Dashboard";
import PatientDashboard from "./pages/patient/Dashboard";
import PharmacistDashboard from "./pages/pharmacist/Dashboard";

function App() {
  return (
    <>
    <BrowserRouter>

            <Routes>

                <Route path="/" element={<Login />} />

                <Route path="/admin" element={<AdminDashboard />} />

                <Route path="/doctor" element={<DoctorDashboard />} />

                <Route path="/patient" element={<PatientDashboard />} />

                <Route path="/pharmacist" element={<PharmacistDashboard />} />

            </Routes>

        </BrowserRouter>
    </>
  )
}

export default App
