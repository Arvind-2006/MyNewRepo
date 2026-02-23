
// function viewProfile() {

//     const token = localStorage.getItem("jwt");

//     fetch("http://localhost:8080/doctor/profile", {
//         method: "GET",
//         headers: {
//             "Authorization": "Bearer " + token,
//             "Content-Type": "application/json"
//         }
//     })
//     .then(response => {
//         if (!response.ok) {
//             throw new Error("Failed to fetch doctor profile");
//         }
//         return response.json();
//     })
//     .then(data => {
//         document.getElementById("doctorsList").style.display = "block";
//         const tbody = document.getElementById("doctorBody");
        
//         tbody.innerHTML = "";

//         data.forEach(doctor => {

//             const row = document.createElement("tr");

//             row.innerHTML = `
//                 <td>${doctor.name}</td>
//                 <td>${doctor.email}</td>
//                 <td>${doctor.phone}</td>
//                 <td>${doctor.specialization}</td>
//                 <td>
//                     <button onclick="deleteDoctor(${doctor.id})">
//                         Delete
//                     </button>
//                 </td>
//             `;

//             tbody.appendChild(row);
//         });

//     })
//     .catch(error => {
//         console.error(error);
//         alert("Error loading doctors");
//     });
// }

function viewProfile() {

    const token = localStorage.getItem("jwt");

    fetch("http://localhost:8080/doctor/profile", {
        method: "GET",
        headers: {
            "Authorization": "Bearer " + token
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Failed to fetch profile");
        }
        return response.json();
    })
    .then(data => {

        document.getElementById("doctorsProfile").style.display = "block";

        const tbody = document.getElementById("doctorBody");
        tbody.innerHTML = "";

        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${data.name}</td>
            <td>${data.email}</td>
            <td>${data.phone}</td>
            <td>${data.specialization}</td>
        `;

        tbody.appendChild(row);
    })
    .catch(error => {
        console.error(error);
        alert("Error loading profile");
    });
}