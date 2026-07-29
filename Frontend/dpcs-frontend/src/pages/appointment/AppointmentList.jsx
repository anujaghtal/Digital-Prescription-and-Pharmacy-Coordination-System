import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import {
    getAppointments,
    deleteAppointment
} from "../../api/appointmentApi";

function AppointmentList() {

    const [appointments, setAppointments] = useState([]);

    useEffect(() => {

        loadAppointments();

    }, []);

    const loadAppointments = async () => {

        try {

            const response = await getAppointments();

            setAppointments(response.data);

        }

        catch (err) {

            console.log(err);

        }

    };

    const removeAppointment = async (id) => {

        if (!window.confirm("Delete this appointment?")) {

            return;

        }

        try {

            await deleteAppointment(id);

            alert("Appointment Deleted Successfully");

            loadAppointments();

        }

        catch (err) {

            console.log(err);

            alert("Delete Failed");

        }

    };

    return (

        <div className="container mt-4">

            <div className="d-flex justify-content-between mb-3">

                <h3>Appointments</h3>

                <Link
                    to="/appointments/add"
                    className="btn btn-primary"
                >
                    Add Appointment
                </Link>

            </div>

            <table className="table table-bordered table-striped">

                <thead>

                <tr>

                    <th>Doctor ID</th>

                    <th>Patient ID</th>

                    <th>Date</th>

                    <th>Status</th>

                    <th>Notes</th>

                    <th>Actions</th>

                </tr>

                </thead>

                <tbody>

                {appointments.map((appointment) => (

                    <tr key={appointment.id}>

                        <td>{appointment.doctorId}</td>

                        <td>{appointment.patientId}</td>

                        <td>{appointment.appointmentDate}</td>

                        <td>{appointment.status}</td>

                        <td>{appointment.notes}</td>

                        <td>

                            <Link
                                to={`/appointments/edit/${appointment.id}`}
                                className="btn btn-warning btn-sm me-2"
                            >
                                Edit
                            </Link>

                            <button
                                className="btn btn-danger btn-sm"
                                onClick={() => removeAppointment(appointment.id)}
                            >
                                Delete
                            </button>

                        </td>

                    </tr>

                ))}

                </tbody>

            </table>

        </div>

    );

}

export default AppointmentList;