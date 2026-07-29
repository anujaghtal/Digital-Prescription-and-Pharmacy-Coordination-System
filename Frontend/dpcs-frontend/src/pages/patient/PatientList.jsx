import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../../api/api";
import Navbar from "../../components/Navbar";

function PatientList() {

    const [patients, setPatients] = useState([]);

    useEffect(() => {

        loadPatients();

    }, []);

    const loadPatients = async () => {

        try {

            const response = await api.get("/patients/all");

            setPatients(response.data);

        } catch (error) {

            console.log(error);

            alert("Unable to load patients");

        }

    };

    const deletePatient = async (id) => {

        if (!window.confirm("Delete this patient?")) {

            return;

        }

        try {

            await api.delete(`/patients/${id}`);

            alert("Patient Deleted Successfully");

            loadPatients();

        } catch (error) {

            console.log(error);

            alert("Unable to delete patient");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="d-flex justify-content-between mb-3">

                    <h2>Patients</h2>

                    <Link
                        to="/patients/add"
                        className="btn btn-success">

                        Add Patient

                    </Link>

                </div>

                <table className="table table-bordered table-hover">

                    <thead className="table-dark">

                        <tr>

                            <th>User Id</th>
                            <th>DOB</th>
                            <th>Gender</th>
                            <th>Blood Group</th>
                            <th>Height</th>
                            <th>Weight</th>
                            <th>Emergency Contact</th>
                            <th>Actions</th>

                        </tr>

                    </thead>

                    <tbody>

                        {

                            patients.map((patient) => (

                                <tr key={patient.id}>

                                    <td>{patient.userId}</td>

                                    <td>{patient.dob}</td>

                                    <td>{patient.gender}</td>

                                    <td>{patient.bloodGroup}</td>

                                    <td>{patient.height}</td>

                                    <td>{patient.weight}</td>

                                    <td>{patient.emergencyContact}</td>

                                    <td>

                                        <Link
                                            to={`/patients/edit/${patient.id}`}
                                            className="btn btn-warning btn-sm me-2">

                                            Edit

                                        </Link>

                                        <button
                                            className="btn btn-danger btn-sm"
                                            onClick={() => deletePatient(patient.id)}>

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

export default PatientList;