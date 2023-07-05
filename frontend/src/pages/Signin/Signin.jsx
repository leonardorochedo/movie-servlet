import React, { useState } from 'react';

import { useNavigate } from 'react-router-dom';

import "./Signin.css";

export function Signin() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    async function handleLogin(e) {
        e.preventDefault();

        await fetch(`http://localhost:8080/auth/signin?email=${email}&password=${password}`, {
            method: 'POST'
        })
        .then((res) => res.json())
        .then((data) => {
            alert(data.message)

            if (data.message == "Usuário logado com sucesso!") {
                navigate('/home', { state: { userId: data.id} });
            }
        })

    };

    return (
        <div className="login-container">
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
            <input
                type="email"
                placeholder="Email"
                value={email}
                onChange={handleEmailChange}
            />
            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={handlePasswordChange}
            />
            <button type="submit">Sign In</button>
            </form>
        </div>
    );
}