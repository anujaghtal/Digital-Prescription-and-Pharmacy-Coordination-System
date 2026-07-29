import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/api";
import Navbar from "../../components/Navbar";

function AddMedicine() {

    const navigate = useNavigate();

    const [medicine, setMedicine] = useState({

        name: "",
        genericName: "",
        manufacturer: "",
        strength: "",
        dosageForm: "",
        price: "",
        stockQuantity: ""

    });

    const handleChange = (e) => {

        setMedicine({

            ...medicine,

            [e.target.name]: e.target.value

        });

    };

    const saveMedicine = async (e) => {

        e.preventDefault();

        try {

            await api.post("/medicines", medicine);

            alert("Medicine Added Successfully");

            navigate("/medicines");

        } catch (error) {

            console.log(error);

            alert("Unable to Save Medicine");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="card shadow">

                    <div className="card-header">

                        <h3>Add Medicine</h3>

                    </div>

                    <div className="card-body">

                        <form onSubmit={saveMedicine}>

                            <div className="mb-3">

                                <label className="form-label">
                                    Medicine Name
                                </label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="name"
                                    value={medicine.name}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <div className="mb-3">

                                <label className="form-label">
                                    Generic Name
                                </label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="genericName"
                                    value={medicine.genericName}
                                    onChange={handleChange}
                                />

                            </div>

                            <div className="mb-3">

                                <label className="form-label">
                                    Manufacturer
                                </label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="manufacturer"
                                    value={medicine.manufacturer}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <div className="mb-3">

                                <label className="form-label">
                                    Strength
                                </label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="strength"
                                    value={medicine.strength}
                                    onChange={handleChange}
                                />

                            </div>

                            <div className="mb-3">

                                <label className="form-label">
                                    Dosage Form
                                </label>

                                <input
                                    type="text"
                                    className="form-control"
                                    name="dosageForm"
                                    value={medicine.dosageForm}
                                    onChange={handleChange}
                                />

                            </div>

                            <div className="mb-3">

                                <label className="form-label">
                                    Price
                                </label>

                                <input
                                    type="number"
                                    step="0.01"
                                    className="form-control"
                                    name="price"
                                    value={medicine.price}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <div className="mb-3">

                                <label className="form-label">
                                    Stock Quantity
                                </label>

                                <input
                                    type="number"
                                    className="form-control"
                                    name="stockQuantity"
                                    value={medicine.stockQuantity}
                                    onChange={handleChange}
                                    required
                                />

                            </div>

                            <button
                                className="btn btn-success me-2">

                                Save

                            </button>

                            <button
                                type="button"
                                className="btn btn-secondary"
                                onClick={() => navigate("/medicines")}>

                                Cancel

                            </button>

                        </form>

                    </div>

                </div>

            </div>

        </>

    );

}

export default AddMedicine;