// Admin authentication
if(localStorage.getItem("role") !== "ADMIN"){
    alert("Access Denied!");
    window.location.href = "login.html";
}

// Welcome message
const adminName = document.getElementById("adminName");

if(adminName){
    adminName.innerHTML = "Welcome, " + localStorage.getItem("name");
}

// Logout
const logoutBtn = document.getElementById("logoutBtn");

if(logoutBtn){

    logoutBtn.addEventListener("click", function(){

        localStorage.clear();

        window.location.href = "login.html";

    });

}