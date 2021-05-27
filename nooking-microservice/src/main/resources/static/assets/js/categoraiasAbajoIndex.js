
var ListaCategorias;
var ListaLocales;
document.addEventListener("DOMContentLoaded", function (event) {
    loadCategorias();
    //crearListadoCategorias();
    loadReservasPopulares();
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
            for (i = 0; (i < ListaCategorias.length) && (i<4); i++) {

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
            document.getElementById("categoriasAbajo").innerHTML = html.join("");   // Añadimos las líneas html creadas a un div vacío de detail.html con identificador "div"

            return false;
        });
}
var valores = ["","mt-4 mt-md-0","mt-4 mt-lg-0"];
function loadReservasPopulares(){
    const address = '/api/locales/ver3Primeros';


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
            ListaLocales = data
            console.log(ListaLocales);
            if (!responseOk) {
                alert("Algo no ha ido como debería");
                return false;
            }
            let html = [];      // variable local donde almacenaremos las líneas html


            for (i = 0; (i < 3) ; i++) {
                html.push(`<div class="col-lg-4 col-md-6 d-flex align-items-stretch ">`);
                html.push(`<div class="course-item">`);
                html.push(` <img src="${ListaLocales[i].urlImagenLocal}" class="img-fluid" alt="...">`);
                html.push(`<div class="course-content">`);
                html.push(`<div class="d-flex justify-content-between align-items-center mb-3">`);
                html.push(`<h4>`+ListaLocales[i].categoria.tipoCategoria+`</h4>`);
                html.push(`</div>`);
                html.push(`<h3><a href="local-details.html?localId=${ListaLocales[i].id}">`+ListaLocales[i].nombre+`</a></h3>`);
                html.push(`<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type </p>`);
                html.push(`<div class="trainer d-flex justify-content-between align-items-center">`);
                html.push(`<div class="trainer-rank d-flex align-items-center">`);
                html.push(`<i class="bx bx-user"></i>&nbsp;50 &nbsp;&nbsp; <i class="bx bx-heart"></i>&nbsp;65 </div>`);
                html.push(`<div class="mt-2 d-flex align-items-center">`);
                html.push(`<a class="tag">-20% en carta</a>`);
                html.push(`</div></div></div></div></div>`);

            }
            
            console.log(html);
            document.getElementById("reservasPopulares").innerHTML = html.join("");   // Añadimos las líneas html creadas a un div vacío de detail.html con identificador "div"

            return false;
        });
}