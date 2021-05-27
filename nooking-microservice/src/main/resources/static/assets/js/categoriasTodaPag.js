
var ListaCategorias;
document.addEventListener("DOMContentLoaded", function (event) {
    loadCategorias();
    //crearListadoCategorias();

});

function loadCategorias() {
    const address = '/api/locales/getCategorias';


    var headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    }
    fetch(address, {
        method: 'GET',
        headers: headers,
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
            ListaCategorias = data
            console.log(ListaCategorias);
            if (!responseOk) {
                alert("Algo no ha ido como debería");
                return false;
            }
            let html = [];      // variable local donde almacenaremos las líneas html

            var a = 0;
            for (i = 0; i < ListaCategorias.length; i++) {

                if (a == 0) {
                    html.push(`<div class="row">`);
                }
                html.push(`<div class="col-md-6 d-flex align-items-stretch">`);
                html.push(`<div class="card">`);
                html.push(`<div class="card-img">`);
                html.push(`<img src="${ListaCategorias[i].imagenCategoria}" alt="...">`);
                html.push(`</div>`);
                html.push(`<div class="card-body">`);
                html.push(`<h5 class="card-title"><a href="cat.html?category=${ListaCategorias[i].tipoCategoria}">` + ListaCategorias[i].tipoCategoria + `</a></h5>`)
                html.push(` <p class="card-text">` + ListaCategorias[i].descripcion + `</p>`);
                html.push(`</div>`);
                html.push(`</div>`);
                html.push(`</div>`);
                console.log(html);

                a++;
                if (a == 2) {
                    html.push(`</div>`);
                    a = 0;
                }
            }
            html.push(`</div>`);
            console.log(html);
            document.getElementById("contenedorCategorias").innerHTML = html.join("");   // Añadimos las líneas html creadas a un div vacío de detail.html con identificador "div"

            return false;
        });
}

function crearListadoCategorias() {
    let html = [];      // variable local donde almacenaremos las líneas html

    var a = 0;
    for (i = 0; i < ListaCategorias.length; i++) {

        if (a == 0) {
            html.push(`<div class="row">`);
        }
        html.push(`<div class="col-md-6 d-flex align-items-stretch">`);
        html.push(`<div class="card">`);
        html.push(`<div class="card-img">`);
        html.push(`<img src="${ListaCategorias[i].imagenCategoria}" alt="...">`);
        html.push(`</div>`);
        html.push(`<div class="card-body">`);
        html.push(`<h5 class="card-title"><a href="cat.html?category=${ListaCategorias[i].tipoCategoria}">` + ListaCategorias[i].tipoCategoria + `</a></h5>`)
        html.push(` <p class="card-text">` + ListaCategorias[i].descripcion + `</p>`);
        html.push(`</div>`);
        html.push(`</div>`);
        html.push(`</div>`);
        console.log(html);

        a++;
        if (a == 2) {
            html.push(`</div>`);
            a = 0;
        }
    }
    html.push(`</div>`);
    console.log(html);
    document.getElementById("contenedorCategorias").innerHTML = html.join("");   // Añadimos las líneas html creadas a un div vacío de detail.html con identificador "div"


}