import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/api";

export default function AddPharmacy() {

    const navigate = useNavigate();

    const [form, setForm] = useState({
        name: "",
        licenseNumber: "",
        ownerName: "",
        email: "",
        phone: "",
        address: ""
    });

    const handleChange = (e) => {

        setForm({
            ...form,
            [e.target.name]: e.target.value
        });

    };

    const save = async (e) => {

        e.preventDefault();

        await api.post("/pharmacies", form);

        alert("Pharmacy Added Successfully");

        navigate("/pharmacies");

    };

    return (

        <div className="container mt-4">

            <h2>Add Pharmacy</h2>

            <form onSubmit={save}>

                <input
                    className="form-control mb-3"
                    placeholder="Name"
                    name="name"
                    value={form.name}
                    onChange={handleChange}
                />

                <input
                    className="form-control mb-3"
                    placeholder="License Number"
                    name="licenseNumber"
                    value={form.licenseNumber}
                    onChange={handleChange}
                />

                <input
                    className="form-control mb-3"
                    placeholder="Owner Name"
                    name="ownerName"
                    value={form.ownerName}
                    onChange={handleChange}
                />

                <input
                    className="form-control mb-3"
                    placeholder="Email"
                    name="email"
                    value={form.email}
                    onChange={handleChange}
                />

                <input
                    className="form-control mb-3"
                    placeholder="Phone"
                    name="phone"
                    value={form.phone}
                    onChange={handleChange}
                />

                <textarea
                    className="form-control mb-3"
                    placeholder="Address"
                    name="address"
                    value={form.address}
                    onChange={handleChange}
                />

                <button className="btn btn-success">
                    Save
                </button>

            </form>

        </div>

    );

}