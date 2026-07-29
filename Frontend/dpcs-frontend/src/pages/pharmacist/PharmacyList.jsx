import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Navbar from "../../components/Navbar";
import api from "../../api/api";

function PharmacyList() {

    const [pharmacies, setPharmacies] = useState([]);

    useEffect(() => {
        loadPharmacies();
    }, []);

    const loadPharmacies = async () => {

        try {

            const response = await api.get("/pharmacies/all");

            setPharmacies(response.data);

        } catch (error) {

            console.log(error);

        }

    };

    const deletePharmacy = async (id) => {

        if (!window.confirm("Delete this pharmacy?"))
            return;

        try {

            await api.delete(`/pharmacies/${id}`);

            alert("Pharmacy Deleted Successfully");

            loadPharmacies();

        } catch (error) {

            console.log(error);

            alert("Unable to Delete Pharmacy");

        }

    };

    return (

        <>

            <Navbar />

            <div className="container mt-4">

                <div className="d-flex justify-content-between mb-3">

                    <h2>Pharmacy Management</h2>

                    <Link
                        className="btn btn-success"
                        to="/pharmacies/add">

                        Add Pharmacy

                    </Link>

                </div>

                <table className="table table-bordered table-hover">

                    <thead className="table-dark">

                        <tr>

                            <th>Name</th>

                            <th>License</th>

                            <th>Owner</th>

                            <th>Email</th>

                            <th>Phone</th>

                            <th>Address</th>

                            <th>Actions</th>

                        </tr>

                    </thead>

                    <tbody>

                        {

                            pharmacies.map((pharmacy) => (

                                <tr key={pharmacy.id}>

                                    <td>{pharmacy.name}</td>

                                    <td>{pharmacy.licenseNumber}</td>

                                    <td>{pharmacy.ownerName}</td>

                                    <td>{pharmacy.email}</td>

                                    <td>{pharmacy.phone}</td>

                                    <td>{pharmacy.address}</td>

                                    <td>

                                        <Link
                                            className="btn btn-warning btn-sm me-2"
                                            to={`/pharmacies/edit/${pharmacy.id}`}>

                                            Edit

                                        </Link>

                                        <button
                                            className="btn btn-danger btn-sm"
                                            onClick={() => deletePharmacy(pharmacy.id)}>

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

export default PharmacyList;