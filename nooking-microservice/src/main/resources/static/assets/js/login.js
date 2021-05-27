document.addEventListener("DOMContentLoaded", function(event) {

    tokenVerification();

    var form = document.getElementById("login_form");
    form.addEventListener("submit", function(e) {
        e.preventDefault();
        return validateLogin();
    });

    var form2 = document.getElementById("signup_form");
    form2.addEventListener("submit", function(e) {
        e.preventDefault();
        return validateSubmit();
    });

});

function tokenVerification() {

    if (typeof Cookies.get('token') !== 'undefined') {
        console.log("Cookie detected");
        document.location.href="index.html";
    }
}
var Usuario;
function validateLogin() {
    try {
        var inputValue1 = document.getElementById("login_email").value;
        var inputValue2 = document.getElementById("login_password").value;
        const data = { username: inputValue1, password: inputValue2 };
        const address = 'api/comprobarUsuarios';
        fetch(address, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
            })
            .then(function (response) {
                console.log(response.status); // Will show you the status
                if (!response.ok) {
                    alert("Algo no ha ido como debería");
                    return false;
                } else {
                    responseOk = 1;
                }
                return response.json();
            })
            .then(data => {
                Usuario = data
                console.log(Usuario);
                if (!responseOk) {
                    alert("Algo no ha ido como debería");
                    return false;
                }else{
                    alert("Te has logado: "+Usuario.nombre+" !");
                } 
                
                return false;
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;
}

async function validateSubmit(){
    try {
        var name = document.getElementById("name").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var password2 = document.getElementById("password2").value;
        var age = document.getElementById("age").value;
        var tel = document.getElementById("tel").value;
        const data = { name: name, email: email,password:password,password2:password2,age:age,telephone:tel };
        const address = 'api/nuevosUsuarios/anadir';
        fetch(address, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
            })
            .then(function (response) {
                console.log(response.status); // Will show you the status
                if (!response.ok) {
                    alert("Algo no ha ido como debería");
                    return false;
                } else {
                    responseOk = 1;
                }
                return response.json();
            })
            .then(data => {
                Usuario = data
                console.log(Usuario);
                if (!responseOk) {
                    alert("Algo no ha ido como debería");
                    return false;
                }else{
                    alert("Te has creado una cuenta!: "+Usuario.nombre+" !Te hemos enviado un email confirmandolo");
                    console.log(Usuario.email);
                    sendEmail();
                    //window.location.href = "index.html";
                } 
                
                return false;
            }).then(data=>{
                console.log(data);
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;
}

async function sendEmail(){
    await Email.send({
        Host: "smtp.gmail.com",
        Username: "nachodivasson@gmail.com",
        Password: "ajstfwrauiddoeju",
        To: Usuario.email+', nacho@divasson.com',
        From: "nachodivasson3@gmail.com",
        Subject: "Nookin",
        Body: "<h1>Hola "+Usuario.nombre+", encantados de poder tenerte entre nosotros!</h1>"+
            "<p> Tu email es "+Usuario.email+" y tu contraseña es: "+Usuario.contrasena+"</p>"+
            "<p> Haga su primera Reserva!</p>"+
            '<a href="https://localhost:8080/index.html" >Pincha aquí</a>   ',
    }).then(
        //message=> alert(message),
        
    );    
}