import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../components/Navbar";
import api from "../../api/api";

function AddDoctor() {

    const navigate = useNavigate();

    const [doctor, setDoctor] = useState({

        userId: "",
        specialization: "",
        licenseNumber: "",
        yearsOfExperience: "",
        consultationFee: ""

    });

    const handleChange = (e) => {

        setDoctor({

            ...doctor,
            [e.target.name]: e.target.value

        });

    };

    const saveDoctor = async (e) => {

        e.preventDefault();

        try {

            await api.post("/doctors", doctor);

            alert("Doctor Added Successfully");

            navigate("/doctors");

        } catch (error) {

            console.log(error);

            alert("Unable to Save Doctor");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="card shadow">

                    <div className="card-header">

                        <h3>Add Doctor</h3>

                    </div>

                    <div className="card-body">

                        <form onSubmit={saveDoctor}>

                            <div className="mb-3">

                                <label>User ID</label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="userId"
                                    value={doctor.userId}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <div className="mb-3">

                                <label>Specialization</label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="specialization"
                                    value={doctor.specialization}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <div className="mb-3">

                                <label>License Number</label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="licenseNumber"
                                    value={doctor.licenseNumber}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <div className="mb-3">

                                <label>Years of Experience</label>

                                <input
                                    type="number"
                                    className="form-control"
                                    name="yearsOfExperience"
                                    value={doctor.yearsOfExperience}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <div className="mb-3">

                                <label>Consultation Fee</label>

                                <input
                                    type="number"
                                    step="0.01"
                                    className="form-control"
                                    name="consultationFee"
                                    value={doctor.consultationFee}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <button className="btn btn-success me-2">

                                Save

                            </button>

                            <button
                                type="button"
                                className="btn btn-secondary"
                                onClick={() => navigate("/doctors")}>

                                Cancel

                            </button>

                        </form>

                    </div>

                </div>

            </div>

        </>

    );

}

export default AddDoctor;