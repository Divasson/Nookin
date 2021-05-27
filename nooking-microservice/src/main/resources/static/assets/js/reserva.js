document.addEventListener("DOMContentLoaded", function(event) {



    var form = document.getElementById("reserva_form");
    form.addEventListener("submit", function(e) {
        e.preventDefault();
        return validateReserva();
    });



});

document.getElementById("numpersonas").addEventListener("click", function(e){



    var div = document.getElementById('usuarios');
    while (div.firstChild) {
        div.removeChild(div.firstChild);
    }
    document.getElementById("usuarios").innerHtml ="";

    for (let step=0; step < document.getElementById("numpersonas").value ; step++) {
    const div = document.createElement("div");
    div.className = "form-group mt-4";
    const app = document.createElement("input"); // <div></div>
    app.type="email";
    app.name="usuario"+ step;
    app.id = "usuario"+ step;
    app.className = "form-control"; // <div id="app"></div>
    let aux= step+1;
    app.placeholder= "email"+ aux;
    div.appendChild(app);// <div id="app"><div>Esto es un div insertado con JS</div></div>
    a=div;
    var b = document.getElementById("usuarios");
    b.appendChild(div);

    document.getElementById("usuarios").innerHtml = b;
    }



})

var a;
var date;
var emails;
var emailsEmails;
async function validateReserva() {
    try {
        var invitados = document.getElementById("numpersonas").value;
        console.log(invitados);
        emails = [];
        var id;
        for (var step =0;step<invitados;step++){
            id="usuario"+step;
            emails[step]=document.getElementById(id).value;
            emailsEmails = emailsEmails +","+document.getElementById(id).value;;
        }

        console.log(emails);
        
        date = document.getElementById("date").value;
        var id_local = window.location.search.substring(4);
        console.log(parseInt(date.substring(8)).toString());
        console.log(parseInt(date.substring(5,7)).toString());
        console.log(parseInt(date.substring(0,4)).toString());
        const data = { usuariosReserva: emails, 
            numPersonasReserva: invitados, 
            dia: parseInt(date.substring(8)).toString(),
            mes: parseInt(date.substring(5,7)).toString(), 
            ano: parseInt(date.substring(0,4)).toString(),
            id_local: id_local };
        const address = 'api/reservas';
        a=data;
        console.log(data);
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
                    //throw new Error("HTTP status " + response.status);
                    responseOk = 0;
                } else {
                    responseOk = 1;
                }
                return response.json();
            })
            .then(data => {
                ListaLocales = data
                console.log(ListaLocales);
                if (!responseOk) {
                    alert("Algo no ha ido como debería");
                    return false;
                } 
                alert("Tu reserva se ha realizado con éxito");
                sendEmail();
                return false;
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
        To: emailsEmails+', nacho@divasson.com',
        From: "nachodivasson3@gmail.com",
        Subject: "Reserva de Nookin",
        Body: "<h1>Hola "+document.getElementById("usuario0").value+",</h1>"+
            "<p> Has realizado una reserva para el "+date+"</p>"+
            "<p> Muchas gracias por hacer su reserva!</p>"+
            '<a href="https://localhost:8080/index.html" >Pincha aquí</a>   ',
    }).then(
        //message=> alert(message),
        
    );    
}