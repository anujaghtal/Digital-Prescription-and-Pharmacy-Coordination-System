import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../api/api";

function Login() {

    const [email, setEmail] = useState("");

    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const login = async (e) => {

        e.preventDefault();

        try {

            const response = await api.post("/auth/login", {

                email,
                password

            });

            localStorage.setItem("token", response.data.token);

            console.log(response.data);

            navigate("/admin");

        } catch (error) {

            alert("Invalid Credentials");

        }

    };

    return (

        <div className="container mt-5">

            <div className="row justify-content-center">

                <div className="col-md-4">

                    <div className="card p-4">

                        <h3 className="text-center mb-3">

                            DPCS Login

                        </h3>

                        <form onSubmit={login}>

                            <input
                                className="form-control mb-3"
                                placeholder="Email"
                                value={email}
                                onChange={(e)=>setEmail(e.target.value)}
                            />

                            <input
                                type="password"
                                className="form-control mb-3"
                                placeholder="Password"
                                value={password}
                                onChange={(e)=>setPassword(e.target.value)}
                            />

                            <button
                                className="btn btn-primary w-100">

                                Login

                            </button>

                        </form>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default Login;