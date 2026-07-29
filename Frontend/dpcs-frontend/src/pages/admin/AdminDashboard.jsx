import { useEffect, useState } from "react";
import api from "../../api/api";
import Navbar from "../../components/Navbar";

function AdminDashboard() {

    const [dashboard, setDashboard] = useState({

        totalAppointments: 0,
        completedAppointments: 0,
        pendingAppointments: 0,
        cancelledAppointments: 0,
        totalDoctors: 0,
        totalPatients: 0,
        totalMedicines: 0,
        totalPrescriptions: 0,
        totalDispensed: 0

    });

    useEffect(() => {

        loadDashboard();

    }, []);

    const loadDashboard = async () => {

        try {

            const response = await api.get("/dashboard/admin");

            setDashboard(response.data);

        } catch (error) {

            console.log(error);

        }

    };

    return (

        <>
            <Navbar />

            <div className="container mt-4">

                <h2 className="mb-4">
                    Admin Dashboard
                </h2>

                <div className="row">

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Total Doctors</h5>
                            <h2>{dashboard.totalDoctors}</h2>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Total Patients</h5>
                            <h2>{dashboard.totalPatients}</h2>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Total Medicines</h5>
                            <h2>{dashboard.totalMedicines}</h2>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Total Prescriptions</h5>
                            <h2>{dashboard.totalPrescriptions}</h2>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Total Dispensed</h5>
                            <h2>{dashboard.totalDispensed}</h2>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Total Appointments</h5>
                            <h2>{dashboard.totalAppointments}</h2>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Completed</h5>
                            <h2>{dashboard.completedAppointments}</h2>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Pending</h5>
                            <h2>{dashboard.pendingAppointments}</h2>
                        </div>
                    </div>

                    <div className="col-md-4 mb-3">
                        <div className="card p-3 shadow">
                            <h5>Cancelled</h5>
                            <h2>{dashboard.cancelledAppointments}</h2>
                        </div>
                    </div>

                </div>

            </div>

        </>

    );

}

export default AdminDashboard;