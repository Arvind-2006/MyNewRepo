const BASE_URL = "http://localhost:8080";
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
document.getElementById("prescriptionForm").addEventListener("submit", function(e) {
    e.preventDefault(); // Prevent page reload

    const patientName = document.getElementById("patientName").value;
    const diagnosis = document.getElementById("diagnosis").value;
    const medicineId = document.getElementById("medicineId").value;
    const quantity = document.getElementById("quantity").value;

    addPrescription(patientName, diagnosis, medicineId, quantity);
});
function addPrescription(patientName, diagnosis, medicineId, quantity) {
    const token = localStorage.getItem("jwt");
    if (!token) {
        alert("You are not logged in!");
        return;
    }

    const payload = {
        patientName: patientName,
        diagnosis: diagnosis,
        items: [
            {
                medicineId: parseInt(medicineId),
                quantity: parseInt(quantity)
            }
        ]
    };

    fetch(`${BASE_URL}/doctor/prescriptions`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token
        },
        body: JSON.stringify(payload)
    })
    .then(res => {
        if (!res.ok) {
            throw new Error("Failed to add prescription");
        }
        return res.json();
    })
    .then(data => {
        console.log("Prescription added:", data);
        alert("Prescription added successfully with ID: " + data.id);
    })
    .catch(err => {
        console.error(err);
        alert("Error adding prescription: " + err.message);
    });
}
function showAddPrescriptionForm() {
    document.getElementById("addPrescriptionForm").style.display = "block";
}
