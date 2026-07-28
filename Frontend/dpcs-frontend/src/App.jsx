import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "./pages/auth/Login";
import Register from "./pages/auth/Register";
import ProtectedRoute from "./components/ProtectedRoute";
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

                <Route
                  path="/admin"
                  element={
                      <ProtectedRoute>
                          <AdminDashboard />
                      </ProtectedRoute>
                  }
              />

              <Route
                  path="/doctor"
                  element={
                      <ProtectedRoute>
                          <DoctorDashboard />
                      </ProtectedRoute>
                  }
              />

              <Route
                  path="/patient"
                  element={
                      <ProtectedRoute>
                          <PatientDashboard />
                      </ProtectedRoute>
                  }
              />

              <Route
                  path="/pharmacist"
                  element={
                      <ProtectedRoute>
                          <PharmacistDashboard />
                      </ProtectedRoute>
                  }
              />
                <Route path="/register" element={<Register />} />
      
            </Routes>

        </BrowserRouter>
    </>
  )
}

export default App
