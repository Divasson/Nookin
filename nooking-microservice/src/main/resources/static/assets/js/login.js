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
        return validateSignup();
    });

});

function tokenVerification() {

    if (typeof Cookies.get('token') !== 'undefined') {
        console.log("Cookie detected");
        document.location.href="index.html";
    }
}

function validateSignup() {
    try {
        const name_value = document.getElementById("name").value;
        const email_value = document.getElementById("email").value;
        const pass_value = document.getElementById("password").value;
        const pass2_value = document.getElementById("password2").value;
        const age_value = document.getElementById("age").value;
        const tel_value = document.getElementById("tel").value;
        const data2 = { name: name_value, email: email_value, password: pass_value, password2: pass2_value, age: age_value, telephone: tel_value };
        console.log(data2);
        fetch("/api/signup", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data2)
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if (typeof data.jwttoken !== 'undefined') {
                    console.log("Authenticated");
                    Cookies.set('token', data.jwttoken)
                    document.location.href="/index.html";
                } else {
                    alert("Error creating the user");
                }
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;
}

function validateLogin(){
    try {
        const inputValue1 = document.getElementById("login_email").value;
        const inputValue2 = document.getElementById("login_password").value;
        const data3 = { username: inputValue1, password: inputValue2 };
        console.log(data3);
        const address = '/login';
        fetch(address, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data3)
        })
            .then(response => response.json())
            .then(data4 => {
                console.log(data4);
                if (typeof data4.jwttoken !== 'undefined') {
                    console.log("Authenticated");
                    Cookies.set('token', data4.jwttoken)
                    document.location.href="/index.html";
                } else {
                    alert("Credential not recognized");
                }
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;
}