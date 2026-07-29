import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Navbar from "../../components/Navbar";
import api from "../../api/api";

function EditDoctor() {

    const { id } = useParams();

    const navigate = useNavigate();

    const [doctor, setDoctor] = useState({

        userId: "",
        specialization: "",
        licenseNumber: "",
        yearsOfExperience: "",
        consultationFee: ""

    });

    useEffect(() => {

        loadDoctor();

    }, []);

    const loadDoctor = async () => {

        try {

            const response = await api.get(`/doctors/${id}`);

            setDoctor(response.data);

        } catch (error) {

            console.log(error);

        }

    };

    const handleChange = (e) => {

        setDoctor({

            ...doctor,
            [e.target.name]: e.target.value

        });

    };

    const updateDoctor = async (e) => {

        e.preventDefault();

        try {

            await api.put(`/doctors/${id}`, {

                userId: doctor.userId,
                specialization: doctor.specialization,
                licenseNumber: doctor.licenseNumber,
                yearsOfExperience: doctor.yearsOfExperience,
                consultationFee: doctor.consultationFee

            });

            alert("Doctor Updated Successfully");

            navigate("/doctors");

        } catch (error) {

            console.log(error);

            alert("Unable to Update Doctor");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="card shadow">

                    <div className="card-header">

                        <h3>Edit Doctor</h3>

                    </div>

                    <div className="card-body">

                        <form onSubmit={updateDoctor}>

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

                            <button className="btn btn-primary me-2">

                                Update

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

export default EditDoctor;