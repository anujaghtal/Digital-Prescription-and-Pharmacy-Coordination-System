import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
    getAppointmentById,
    updateAppointment
} from "../../api/appointmentApi";

function EditAppointment() {

    const { id } = useParams();

    const navigate = useNavigate();

    const [appointment, setAppointment] = useState({

        doctorId: "",
        patientId: "",
        appointmentDate: "",
        status: "",
        notes: ""

    });

    useEffect(() => {

        loadAppointment();

    }, []);

    const loadAppointment = async () => {

        try {

            const response = await getAppointmentById(id);

            setAppointment(response.data);

        } catch (error) {

            console.log(error);

        }

    };

    const handleChange = (e) => {

        setAppointment({

            ...appointment,

            [e.target.name]: e.target.value

        });

    };

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            await updateAppointment(id, appointment);

            alert("Appointment Updated Successfully");

            navigate("/appointments");

        } catch (error) {

            console.log(error);

            alert("Update Failed");

        }

    };

    return (

        <div className="container mt-4">

            <div className="card p-4">

                <h3>Edit Appointment</h3>

                <form onSubmit={handleSubmit}>

                    <div className="mb-3">

                        <label>Doctor ID</label>

                        <input
                            type="text"
                            name="doctorId"
                            className="form-control"
                            value={appointment.doctorId}
                            onChange={handleChange}
                        />

                    </div>

                    <div className="mb-3">

                        <label>Patient ID</label>

                        <input
                            type="text"
                            name="patientId"
                            className="form-control"
                            value={appointment.patientId}
                            onChange={handleChange}
                        />

                    </div>

                    <div className="mb-3">

                        <label>Appointment Date</label>

                        <input
                            type="datetime-local"
                            name="appointmentDate"
                            className="form-control"
                            value={appointment.appointmentDate}
                            onChange={handleChange}
                        />

                    </div>

                    <div className="mb-3">

                        <label>Status</label>

                        <select
                            name="status"
                            className="form-select"
                            value={appointment.status}
                            onChange={handleChange}
                        >
                            <option value="SCHEDULED">SCHEDULED</option>
                            <option value="COMPLETED">COMPLETED</option>
                            <option value="CANCELLED">CANCELLED</option>
                        </select>

                    </div>

                    <div className="mb-3">

                        <label>Notes</label>

                        <textarea
                            name="notes"
                            className="form-control"
                            value={appointment.notes}
                            onChange={handleChange}
                        />

                    </div>

                    <button className="btn btn-primary">

                        Update Appointment

                    </button>

                </form>

            </div>

        </div>

    );

}

export default EditAppointment;