import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Navbar from "../../components/Navbar";
import api from "../../api/api";

function EditPharmacy() {

    const { id } = useParams();

    const navigate = useNavigate();

    const [form, setForm] = useState({

        name: "",
        licenseNumber: "",
        ownerName: "",
        email: "",
        phone: "",
        address: ""

    });

    useEffect(() => {

        loadPharmacy();

    }, []);

    const loadPharmacy = async () => {

        const response = await api.get(`/pharmacies/${id}`);

        setForm(response.data);

    };

    const handleChange = (e) => {

        setForm({

            ...form,
            [e.target.name]: e.target.value

        });

    };

    const update = async (e) => {

        e.preventDefault();

        await api.put(`/pharmacies/${id}`, form);

        alert("Pharmacy Updated Successfully");

        navigate("/pharmacies");

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <h2>Edit Pharmacy</h2>

                <form onSubmit={update}>

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

                    <button className="btn btn-primary">

                        Update

                    </button>

                </form>

            </div>

        </>

    );

}

export default EditPharmacy;