import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/api";
import { addAppointment } from "../../api/appointmentApi";

function AddAppointment() {

    const navigate = useNavigate();

    const [doctors, setDoctors] = useState([]);
    const [patients, setPatients] = useState([]);

    const [form, setForm] = useState({

        doctorId: "",
        patientId: "",
        appointmentDate: "",
        status: "SCHEDULED",
        notes: ""

    });

    useEffect(() => {

        loadDoctors();
        loadPatients();

    }, []);

    const loadDoctors = async () => {

        try {

            const response = await api.get("/doctors/all");

            setDoctors(response.data);

        } catch (error) {

            console.log(error);

        }

    };

    const loadPatients = async () => {

        try {

            const response = await api.get("/patients/all");

            setPatients(response.data);

        } catch (error) {

            console.log(error);

        }

    };

    const handleChange = (e) => {

        setForm({

            ...form,
            [e.target.name]: e.target.value

        });

    };

    const saveAppointment = async (e) => {

        e.preventDefault();

        try {

            await addAppointment(form);

            alert("Appointment Added Successfully");

            navigate("/appointments");

        } catch (error) {

            console.log(error);

            alert("Failed to Add Appointment");

        }

    };

    return (

        <div className="container mt-4">

            <div className="card p-4">

                <h3 className="mb-4">

                    Add Appointment

                </h3>

                <form onSubmit={saveAppointment}>

                    {/* Doctor */}

                    <div className="mb-3">

                        <label className="form-label">

                            Doctor

                        </label>

                        <select

                            className="form-select"

                            name="doctorId"

                            value={form.doctorId}

                            onChange={handleChange}

                            required

                        >

                            <option value="">

                                Select Doctor

                            </option>

                            {

                                doctors.map((doctor) => (

                                    <option

                                        key={doctor.id}

                                        value={doctor.id}

                                    >

                                        {doctor.specialization} ({doctor.userId})

                                    </option>

                                ))

                            }

                        </select>

                    </div>

                    {/* Patient */}

                    <div className="mb-3">

                        <label className="form-label">

                            Patient

                        </label>

                        <select

                            className="form-select"

                            name="patientId"

                            value={form.patientId}

                            onChange={handleChange}

                            required

                        >

                            <option value="">

                                Select Patient

                            </option>

                            {

                                patients.map((patient) => (

                                    <option

                                        key={patient.id}

                                        value={patient.id}

                                    >

                                        {patient.userId}

                                    </option>

                                ))

                            }

                        </select>

                    </div>

                    {/* Appointment Date */}

                    <div className="mb-3">

                        <label className="form-label">

                            Appointment Date

                        </label>

                        <input

                            type="datetime-local"

                            className="form-control"

                            name="appointmentDate"

                            value={form.appointmentDate}

                            onChange={handleChange}

                            required

                        />

                    </div>

                    {/* Status */}

                    <div className="mb-3">

                        <label className="form-label">

                            Status

                        </label>

                        <select

                            className="form-select"

                            name="status"

                            value={form.status}

                            onChange={handleChange}

                        >

                            <option value="SCHEDULED">

                                SCHEDULED

                            </option>

                            <option value="COMPLETED">

                                COMPLETED

                            </option>

                            <option value="CANCELLED">

                                CANCELLED

                            </option>

                        </select>

                    </div>

                    {/* Notes */}

                    <div className="mb-3">

                        <label className="form-label">

                            Notes

                        </label>

                        <textarea

                            className="form-control"

                            rows="3"

                            name="notes"

                            value={form.notes}

                            onChange={handleChange}

                        />

                    </div>

                    <button

                        className="btn btn-primary"

                    >

                        Save Appointment

                    </button>

                </form>

            </div>

        </div>

    );

}

export default AddAppointment;