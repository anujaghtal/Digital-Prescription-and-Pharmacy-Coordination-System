import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/api";

function Register() {

    const navigate = useNavigate();

    const [form, setForm] = useState({

        fullName: "",
        email: "",
        password: "",
        phone: "",
        role: "PATIENT"

    });

    const handleChange = (e) => {

        setForm({

            ...form,
            [e.target.name]: e.target.value

        });

    };

    const register = async (e) => {

        e.preventDefault();

        console.log(form);

        try {

            await api.post("/users/register", form);

            alert("Registration Successful");

            navigate("/");

        } catch (err) {

            console.log(err.response?.data);

            alert("Registration Failed");

        }

    };

    return (

        <div className="container mt-5">

            <div className="row justify-content-center">

                <div className="col-md-5">

                    <div className="card p-4">

                        <h3 className="text-center mb-4">

                            DPCS Register

                        </h3>

                        <form onSubmit={register}>

                            <input
                                type="text"
                                className="form-control mb-3"
                                placeholder="Full Name"
                                name="fullName"
                                value={form.fullName}
                                onChange={handleChange}
                                required
                            />

                            <input
                                type="email"
                                className="form-control mb-3"
                                placeholder="Email"
                                name="email"
                                value={form.email}
                                onChange={handleChange}
                                required
                            />

                            <input
                                type="text"
                                className="form-control mb-3"
                                placeholder="Phone"
                                name="phone"
                                value={form.phone}
                                onChange={handleChange}
                                required
                            />

                            <input
                                type="password"
                                className="form-control mb-3"
                                placeholder="Password"
                                name="password"
                                value={form.password}
                                onChange={handleChange}
                                required
                            />

                            <select
                                className="form-select mb-3"
                                name="role"
                                value={form.role}
                                onChange={handleChange}
                            >
                                <option value="PATIENT">Patient</option>
                                <option value="DOCTOR">Doctor</option>
                                <option value="PHARMACIST">Pharmacist</option>
                            </select>

                            <button
                                type="submit"
                                className="btn btn-success w-100">

                                Register

                            </button>

                        </form>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default Register;