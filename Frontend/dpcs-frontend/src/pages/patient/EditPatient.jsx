import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Navbar from "../../components/Navbar";
import api from "../../api/api";

function EditPatient() {

    const { id } = useParams();

    const navigate = useNavigate();

    const [patient, setPatient] = useState({

        userId: "",
        dob: "",
        gender: "",
        bloodGroup: "",
        height: "",
        weight: "",
        emergencyContact: ""

    });

    useEffect(() => {

        loadPatient();

    }, []);

    const loadPatient = async () => {

        try {

            const response = await api.get(`/patients/${id}`);

            setPatient(response.data);

        } catch (error) {

            console.log(error);

        }

    };

    const handleChange = (e) => {

        setPatient({

            ...patient,
            [e.target.name]: e.target.value

        });

    };

    const updatePatient = async (e) => {

        e.preventDefault();

        try {

            await api.put(`/patients/${id}`, {

                userId: patient.userId,
                dob: patient.dob,
                gender: patient.gender,
                bloodGroup: patient.bloodGroup,
                height: patient.height,
                weight: patient.weight,
                emergencyContact: patient.emergencyContact

            });

            alert("Patient Updated Successfully");

            navigate("/patients");

        } catch (error) {

            console.log(error);

            alert("Unable to Update Patient");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="card shadow">

                    <div className="card-header">

                        <h3>Edit Patient</h3>

                    </div>

                    <div className="card-body">

                        <form onSubmit={updatePatient}>

                            <div className="mb-3">

                                <label>User ID</label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="userId"
                                    value={patient.userId}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <div className="mb-3">

                                <label>Date of Birth</label>

                                <input
                                    type="date"
                                    className="form-control"
                                    name="dob"
                                    value={patient.dob || ""}
                                    onChange={handleChange}
                                />

                            </div>

                            <div className="mb-3">

                                <label>Gender</label>

                                <select
                                    className="form-select"
                                    name="gender"
                                    value={patient.gender}
                                    onChange={handleChange}
                                >

                                    <option value="">Select Gender</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                    <option value="Other">Other</option>

                                </select>

                            </div>

                            <div className="mb-3">

                                <label>Blood Group</label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="bloodGroup"
                                    value={patient.bloodGroup}
                                    onChange={handleChange}
                                />

                            </div>

                            <div className="mb-3">

                                <label>Height</label>

                                <input
                                    type="number"
                                    step="0.1"
                                    className="form-control"
                                    name="height"
                                    value={patient.height}
                                    onChange={handleChange}
                                />

                            </div>

                            <div className="mb-3">

                                <label>Weight</label>

                                <input
                                    type="number"
                                    step="0.1"
                                    className="form-control"
                                    name="weight"
                                    value={patient.weight}
                                    onChange={handleChange}
                                />

                            </div>

                            <div className="mb-3">

                                <label>Emergency Contact</label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="emergencyContact"
                                    value={patient.emergencyContact}
                                    onChange={handleChange}
                                />

                            </div>

                            <button className="btn btn-primary me-2">

                                Update

                            </button>

                            <button
                                type="button"
                                className="btn btn-secondary"
                                onClick={() => navigate("/patients")}>

                                Cancel

                            </button>

                        </form>

                    </div>

                </div>

            </div>

        </>

    );

}

export default EditPatient;