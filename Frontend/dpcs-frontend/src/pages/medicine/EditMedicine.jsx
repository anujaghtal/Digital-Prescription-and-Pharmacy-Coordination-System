import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../../api/api";
import Navbar from "../../components/Navbar";

function EditMedicine() {

    const { id } = useParams();

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

    useEffect(() => {

        loadMedicine();

    }, []);

    const loadMedicine = async () => {

        try {

            const response = await api.get(`/medicines/${id}`);

            setMedicine(response.data);

        } catch (error) {

            console.log(error);

            alert("Unable to load medicine");

        }

    };

    const handleChange = (e) => {

        setMedicine({

            ...medicine,

            [e.target.name]: e.target.value

        });

    };

    const updateMedicine = async (e) => {

        e.preventDefault();

        try {

            await api.put(`/medicines/${id}`, {

                name: medicine.name,
                genericName: medicine.genericName,
                manufacturer: medicine.manufacturer,
                strength: medicine.strength,
                dosageForm: medicine.dosageForm,
                price: medicine.price,
                stockQuantity: medicine.stockQuantity

            });

            alert("Medicine Updated Successfully");

            navigate("/medicines");

        } catch (error) {

            console.log(error);

            alert("Unable to Update Medicine");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="card shadow">

                    <div className="card-header">

                        <h3>Edit Medicine</h3>

                    </div>

                    <div className="card-body">

                        <form onSubmit={updateMedicine}>

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
                                className="btn btn-primary me-2">

                                Update

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

export default EditMedicine;