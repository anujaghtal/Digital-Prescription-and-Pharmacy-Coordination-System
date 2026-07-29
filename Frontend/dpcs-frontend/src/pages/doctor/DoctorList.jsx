import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Navbar from "../../components/Navbar";
import api from "../../api/api";

function DoctorList() {

    const [doctors, setDoctors] = useState([]);

    useEffect(() => {

        loadDoctors();

    }, []);

    const loadDoctors = async () => {

        try {

            const response = await api.get("/doctors/all");

            setDoctors(response.data);

        } catch (error) {

            console.log(error);

            alert("Unable to load doctors");

        }

    };

    const deleteDoctor = async (id) => {

        if (!window.confirm("Delete this doctor?")) {

            return;

        }

        try {

            await api.delete(`/doctors/${id}`);

            alert("Doctor Deleted Successfully");

            loadDoctors();

        } catch (error) {

            console.log(error);

            alert("Unable to delete doctor");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="d-flex justify-content-between mb-3">

                    <h2>Doctors</h2>

                    <Link
                        to="/doctors/add"
                        className="btn btn-success">

                        Add Doctor

                    </Link>

                </div>

                <table className="table table-bordered table-hover">

                    <thead className="table-dark">

                        <tr>

                            <th>User ID</th>

                            <th>Specialization</th>

                            <th>License</th>

                            <th>Experience</th>

                            <th>Consultation Fee</th>

                            <th>Actions</th>

                        </tr>

                    </thead>

                    <tbody>

                        {

                            doctors.map((doctor) => (

                                <tr key={doctor.id}>

                                    <td>{doctor.userId}</td>

                                    <td>{doctor.specialization}</td>

                                    <td>{doctor.licenseNumber}</td>

                                    <td>{doctor.yearsOfExperience}</td>

                                    <td>{doctor.consultationFee}</td>

                                    <td>

                                        <Link
                                            to={`/doctors/edit/${doctor.id}`}
                                            className="btn btn-warning btn-sm me-2">

                                            Edit

                                        </Link>

                                        <button
                                            className="btn btn-danger btn-sm"
                                            onClick={() => deleteDoctor(doctor.id)}>

                                            Delete

                                        </button>

                                    </td>

                                </tr>

                            ))

                        }

                    </tbody>

                </table>

            </div>

        </>

    );

}

export default DoctorList;