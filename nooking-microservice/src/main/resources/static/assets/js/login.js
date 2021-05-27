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

function validateLogin() {
    try {
        var inputValue1 = document.getElementById("login_email").value;
        var inputValue2 = document.getElementById("login_password").value;
        const data = { username: inputValue1, password: inputValue2 };
        const address = '/login';
        fetch(address, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if (typeof data.jwttoken !== 'undefined') {
                    console.log("Authenticated");
                    Cookies.set('token', data.jwttoken)
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

function validateSubmit(){

}