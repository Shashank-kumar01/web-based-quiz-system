const currentPage = window.location.pathname;

const email = localStorage.getItem("email");

if(
    (currentPage.includes("dashboard.html") ||
        currentPage.includes("quiz.html") ||
        currentPage.includes("result.html"))
    && !email
){

    window.location.href = "login.html";

}
const loginBtn = document.getElementById("loginBtn");

if(window.location.pathname.includes("admin-dashboard.html")){

    if(localStorage.getItem("role") !== "ADMIN"){

        alert("Access Denied!");

        window.location.href = "login.html";
    }
}
const adminName = document.getElementById("adminName");

if(adminName){
    adminName.innerHTML = "Welcome, " + localStorage.getItem("name");
}
if(loginBtn){

    loginBtn.addEventListener("click", async function() {

        const login = document.getElementById("login").value;
        const password = document.getElementById("password").value;

        if (login.trim() === "" || password.trim() === "") {
            alert("Please enter Email/Username and Password");
            return;
        }
        const response = await fetch("http://localhost:8080/login", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                email: login,
                password: password
            })

        });


        const result = await response.json();

        console.log(result);

        if (result.message === "Login Successful") {

            // Pehle data save karo
            localStorage.setItem("email", result.email);
            localStorage.setItem("name", result.name);
            localStorage.setItem("username", result.username);
            localStorage.setItem("role", result.role);

            console.log(result.role);

            // Fir redirect karo
            if (result.role === "ADMIN") {
                window.location.href = "admin-dashboard.html";
            } else {
                window.location.href = "dashboard.html";
            }

        } else {

            alert(result.message);

        }




    });

}
const registerBtn = document.getElementById("registerBtn");

if(registerBtn){

    registerBtn.addEventListener("click", async function(){

        const name = document.getElementById("name").value;
        const username = document.getElementById("username").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        const response = await fetch("http://localhost:8080/addUser",{

            method:"POST",

            headers:{
                "Content-Type":"application/json"
            },

            body:JSON.stringify({
                name:name,
                username:username,
                email:email,
                password:password
            })

        });

        const result = await response.text();

        alert(result);

    });

}
const quizContainer = document.getElementById("quizContainer");

if(quizContainer){

    loadQuiz();

}

async function loadQuiz(){

    const quizId = localStorage.getItem("quizId");

    const response =
        await fetch("http://localhost:8080/quiz/" + quizId);

    const quiz = await response.json();

    let html = `<h3>${quiz.title}</h3>`;

    quiz.questions.forEach(question => {

        html += `

        <div class="question">

            <h4>${question.questionText}</h4>

            <label>
                <input type="radio"
                       name="question${question.id}"
                       value="${question.optionA}">
                ${question.optionA}
            </label><br>

            <label>
                <input type="radio"
                       name="question${question.id}"
                       value="${question.optionB}">
                ${question.optionB}
            </label><br>

            <label>
                <input type="radio"
                       name="question${question.id}"
                       value="${question.optionC}">
                ${question.optionC}
            </label><br>

            <label>
                <input type="radio"
                       name="question${question.id}"
                       value="${question.optionD}">
                ${question.optionD}
            </label><br>

        </div>

        <hr>

        `;

    });

    quizContainer.innerHTML = html;

}
const submitQuizBtn = document.getElementById("submitQuizBtn");

if(submitQuizBtn){

    submitQuizBtn.addEventListener("click", submitQuiz);

}

async function submitQuiz(){

    const answers = {};

    document.querySelectorAll(".question").forEach(questionDiv=>{

        const radio = questionDiv.querySelector("input[type='radio']:checked");

        if(radio){

            const questionId = radio.name.replace("question","");

            answers[questionId] = radio.value;

        }

    });

    const response = await fetch("http://localhost:8080/submitQuiz",{

        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify({

            userName: localStorage.getItem("email"),

            quizId: Number(localStorage.getItem("quizId")),

            answers:answers

        })

    });

    const score = await response.text();

    localStorage.setItem("score", score);

    window.location.href = "result.html";

}
const scoreText = document.getElementById("scoreText");

if(scoreText){

    const score = localStorage.getItem("score");

    scoreText.innerHTML = "Your Score : " + score;

}
const welcomeUser = document.getElementById("welcomeUser");

if(welcomeUser){

    const email = localStorage.getItem("email");

    welcomeUser.innerHTML = "Welcome, " + email + " 👋";

}
const logoutBtn = document.getElementById("logoutBtn");

if(logoutBtn){

    logoutBtn.addEventListener("click", function(){

        localStorage.clear();

        window.location.href = "login.html";

    });

}
const dashboardWelcome = document.getElementById("dashboardWelcome");

if(dashboardWelcome){

    dashboardWelcome.innerHTML =
        "Welcome, " + localStorage.getItem("name") + " 👋";

}

const dashboardLogoutBtn =
    document.getElementById("dashboardLogoutBtn");

if(dashboardLogoutBtn){

    dashboardLogoutBtn.addEventListener("click",function(){

        localStorage.clear();

        window.location.href="login.html";

    });

}
const backBtn = document.getElementById("backBtn");

if(backBtn){

    backBtn.addEventListener("click", function(){

        window.location.href = "dashboard.html";

    });

}
const quizList = document.getElementById("quizList");

if(quizList){

    loadAllQuizzes();

}

async function loadAllQuizzes(){

    const response = await fetch("http://localhost:8080/quizzes");

    const quizzes = await response.json();

    let html = "";

    quizzes.forEach(quiz=>{

        html += `
        
        <div class="quiz-card">

            <h3>${quiz.title}</h3>

            <p>Total Questions : ${quiz.questions.length}</p>

            <button onclick="startQuiz(${quiz.id})">

                Start Quiz

            </button>

        </div>

        <br>

        `;

    });

    quizList.innerHTML = html;

}
function startQuiz(id){

    localStorage.setItem("quizId", id);

    window.location.href = "quiz.html";

}