const BASE_URL = "http://localhost:8080";

// function login() {
//     const username = document.getElementById("username").value;
//     const password = document.getElementById("password").value;

//     fetch(`${BASE_URL}/auth/login`, {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//         },
//         body: JSON.stringify({
//             username: username, 
//             password: password
//         })
//     })
//     .then(res => {
//         if (!res.ok) {
//             throw new Error("Invalid credentials");
//         }
//         return res.text();
//     })
//     .then(token => {
//         localStorage.setItem("jwt", token);
//         checkRole();
//     })
//     .catch(err => {
//         document.getElementById("message").innerText = err.message;
//     });
// }

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
        return res.json();   // 🔥 IMPORTANT: now expecting JSON
    })
    .then(data => {
        // Store token and role
        localStorage.setItem("jwt", data.token);
        localStorage.setItem("role", data.role);

        // Redirect based on role
        redirectByRole(data.role);
    })
    .catch(err => {
        document.getElementById("message").innerText = err.message;
    });
}
function redirectByRole(role) {
    if (role === "ROLE_ADMIN") {
        window.location.href = "admin.html";
    } 
    else if (role === "ROLE_DOCTOR") {
        window.location.href = "doctor.html";
    } 
    else if (role === "ROLE_PATIENT") {
        window.location.href = "patient.html";
    } 
    else {
        document.getElementById("message").innerText = "Unknown role";
    }
}