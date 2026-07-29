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
import PatientList from "./pages/patient/PatientList";
import AddPatient from "./pages/patient/AddPatient";
import EditPatient from "./pages/patient/EditPatient";
import DoctorList from "./pages/doctor/DoctorList";
import AddDoctor from "./pages/doctor/AddDoctor";
import EditDoctor from "./pages/doctor/EditDoctor";

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
                <Route path="/patients" element={<PatientList />} />

                <Route path="/patients/add" element={<AddPatient />} />

                <Route path="/patients/edit/:id" element={<EditPatient />} />
                <Route path="/doctors" element={<DoctorList />} />

                <Route path="/doctors/add" element={<AddDoctor />} />

                <Route path="/doctors/edit/:id" element={<EditDoctor />} />
      
            </Routes>

        </BrowserRouter>
    </>
  )
}

export default App
