document.addEventListener("DOMContentLoaded", function (event) {
    cargarCategoria();
});

function cargarCategoria(){
    const dir = window.location.search;     // Se queda con la string del path a partir de '?'
    const s = dir.split("=");               // divide la cadena en trozos separados por el '=', eliminando el '='
    let cat = s[1];
    const address = `/api/locales/byCat?cat=${cat}`;

    const headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    }

    var ListaLocales;

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
            }else{
                let html = [];      // variable Locales donde almacenaremos las líneas html
                let j = 3;
                let n = 9;

                html.push(`<div class="breadcrumbs">
                              <div class="container">
                                <h2>`+ListaLocales[0].categoria.tipoCategoria+`</h2>
                                <p>`+ListaLocales[0].categoria.descripcion+`</p>
                              </div>
                            </div>
                            <section id="courses" class="courses">
                              <div class="container" data-aos="fade-up">`);

                for (i = 0; (i < ListaLocales.length) ; i++) {
                    if(j==3){
                        if(n==0){
                            html.push(`</div>`);
                        }
                        html.push(`<div class="row" data-aos="zoom-in" data-aos-delay="100">`);
                        n=0;
                        j=0;
                    }
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
                    j++;
                }

                html.push(`</div></section>`);

                console.log(html);
                document.getElementById("main").innerHTML = html.join("");   // Añadimos las líneas html creadas a un div vacío de detail.html con identificador "div"
            }
            return false;
        });

    return false;
}