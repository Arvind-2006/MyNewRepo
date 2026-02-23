const BASE_URL = "http://localhost:8080";

function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch(`${BASE_URL}/auth/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: username, 
            password: password
        })
    })
    .then(res => {
        if (!res.ok) {
            throw new Error("Invalid credentials");
        }
        return res.text();
    })
    .then(token => {
        localStorage.setItem("jwt", token);
        checkRole();
    })
    .catch(err => {
        document.getElementById("message").innerText = err.message;
    });
}

function checkRole() {
    const token = localStorage.getItem("jwt");

    // Try Admin
    fetch(`${BASE_URL}/admin/dashboard`, {
        headers: {
            "Authorization": "Bearer " + token
        }
    })
    .then(res => {
        if (res.ok) {
            window.location.href = "admin.html";
        } else {
            // Try Doctor
            fetch(`${BASE_URL}/doctor/dashboard`, {
                headers: {
                    "Authorization": "Bearer " + token
                }
            })
            .then(res2 => {
                if (res2.ok) {
                    window.location.href = "doctor.html";
                } else {
                    window.location.href = "patient.html";
                }
            });
        }
    });
}

function logout() {
    localStorage.removeItem("jwt");
    window.location.href = "login.html";
}