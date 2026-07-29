import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "./pages/auth/Login";
import Register from "./pages/auth/Register";
import ProtectedRoute from "./components/ProtectedRoute";
import AdminDashboard from "./pages/admin/AdminDashboard";
import DoctorDashboard from "./pages/doctor/Dashboard";
import PatientDashboard from "./pages/patient/Dashboard";
import PharmacistDashboard from "./pages/pharmacist/Dashboard";
import MedicineList from "./pages/medicine/MedicineList";
import AddMedicine from "./pages/medicine/AddMedicine";
import EditMedicine from "./pages/medicine/EditMedicine";
function App() {
  return (
    <>
    <BrowserRouter>

            <Routes>

                <Route path="/" element={<Login />} />

                <Route
                  path="/admin"
                  element={
                      <ProtectedRoute allowedRoles={["ADMIN"]}>
                          <AdminDashboard />
                      </ProtectedRoute>
                  }
              />

              <Route
                  path="/doctor"
                  element={
                      <ProtectedRoute allowedRoles={["DOCTOR"]}>
                          <DoctorDashboard />
                      </ProtectedRoute>
                  }
              />

              <Route
                  path="/patient"
                  element={
                      <ProtectedRoute allowedRoles={["PATIENT"]}>
                          <PatientDashboard />
                      </ProtectedRoute>
                  }
              />

              <Route
                  path="/pharmacist"
                  element={
                      <ProtectedRoute allowedRoles={["PHARMACIST"]}>
                          <PharmacistDashboard />
                      </ProtectedRoute>
                  }
              />
                <Route path="/register" element={<Register />} />
                <Route
                    path="/medicines"
                    element={
                        <ProtectedRoute allowedRoles={["ADMIN","PHARMACIST"]}>
                            <MedicineList/>
                        </ProtectedRoute>
                    }
                />

                <Route
                    path="/medicines/add"
                    element={
                        <ProtectedRoute allowedRoles={["ADMIN","PHARMACIST"]}>
                            <AddMedicine/>
                        </ProtectedRoute>
                    }
                />

                <Route
                    path="/medicines/edit/:id"
                    element={
                        <ProtectedRoute allowedRoles={["ADMIN","PHARMACIST"]}>
                            <EditMedicine/>
                        </ProtectedRoute>
                    }
                />
      
            </Routes>

        </BrowserRouter>
    </>
  )
}

export default App
