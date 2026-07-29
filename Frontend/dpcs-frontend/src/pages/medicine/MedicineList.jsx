import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/api";
import Navbar from "../../components/Navbar";

function MedicineList() {

    const navigate = useNavigate();

    const [medicines, setMedicines] = useState([]);

    useEffect(() => {

        loadMedicines();

    }, []);

    const loadMedicines = async () => {

        try {

            const response = await api.get("/medicines/all");

            setMedicines(response.data);

        } catch (error) {

            console.log(error);

        }

    };

    const deleteMedicine = async (id) => {

        const confirmDelete = window.confirm(
            "Are you sure you want to delete this medicine?"
        );

        if (!confirmDelete) return;

        try {

            await api.delete(`/medicines/${id}`);

            alert("Medicine Deleted Successfully");

            loadMedicines();

        } catch (error) {

            console.log(error);

            alert("Delete Failed");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="d-flex justify-content-between align-items-center mb-3">

                    <h2>Medicine Management</h2>

                    <button
                        className="btn btn-success"
                        onClick={() => navigate("/medicines/add")}>

                        Add Medicine

                    </button>

                </div>

                <table className="table table-bordered table-hover">

                    <thead className="table-dark">

                        <tr>

                            <th>Name</th>

                            <th>Generic Name</th>

                            <th>Manufacturer</th>

                            <th>Strength</th>

                            <th>Dosage Form</th>

                            <th>Price</th>

                            <th>Stock</th>

                            <th>Active</th>

                            <th>Actions</th>

                        </tr>

                    </thead>

                    <tbody>

                        {

                            medicines.length === 0 ?

                                (

                                    <tr>

                                        <td
                                            colSpan="9"
                                            className="text-center">

                                            No Medicines Found

                                        </td>

                                    </tr>

                                )

                                :

                                medicines.map((medicine) => (

                                    <tr key={medicine.id}>

                                        <td>{medicine.name}</td>

                                        <td>{medicine.genericName}</td>

                                        <td>{medicine.manufacturer}</td>

                                        <td>{medicine.strength}</td>

                                        <td>{medicine.dosageForm}</td>

                                        <td>₹ {medicine.price}</td>

                                        <td>{medicine.stockQuantity}</td>

                                        <td>

                                            {

                                                medicine.active ?

                                                    "Yes"

                                                    :

                                                    "No"

                                            }

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-warning btn-sm me-2"
                                                onClick={() =>
                                                    navigate(`/medicines/edit/${medicine.id}`)
                                                }>

                                                Edit

                                            </button>

                                            <button
                                                className="btn btn-danger btn-sm"
                                                onClick={() =>
                                                    deleteMedicine(medicine.id)
                                                }>

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

export default MedicineList;