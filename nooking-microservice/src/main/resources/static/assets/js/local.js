document.addEventListener("DOMContentLoaded", function (event) {
    cargarLocal();
});

function cargarLocal(){
    const dir = window.location.search;     // Se queda con la string del path a partir de '?'
    const s = dir.split("=");               // divide la cadena en trozos separados por el '=', eliminando el '='
    const num = s[1];
    const address = `/api/locales?id=${num}`;

    const headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    }

    var Local;

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
            Local = data
            console.log(Local);
            if (!responseOk) {
                alert("Algo no ha ido como debería");
                return false;
            }

            let html = [];      // variable local donde almacenaremos las líneas html

            html.push(`<div class="breadcrumbs" data-aos="fade-in"><div class="container">`);
            html.push(`<h2>`+Local.nombre+`</h2><p>`+Local.direccion.direccion+`</p></div></div>`);
            html.push(`<section id="course-details" class="course-details">
                        <div class="container" data-aos="fade-up">
                        <div class="row">
                          <div class="col-lg-8">
                            <img src="${Local.urlImagenLocal}" class="img-fluid" alt="">
                            <h3>`+Local.nombre+`</h3>
                            <p>
                              Qui et explicabo voluptatem et ab qui vero et voluptas. Sint voluptates temporibus quam autem. Atque nostrum voluptatum laudantium a doloremque enim et ut dicta. Nostrum ducimus est iure minima totam doloribus nisi ullam deserunt. Corporis aut officiis sit nihil est. Labore aut sapiente aperiam.
                              Qui voluptas qui vero ipsum ea voluptatem. Omnis et est. Voluptatem officia voluptatem adipisci et iusto provident doloremque consequatur. Quia et porro est. Et qui corrupti laudantium ipsa.
                              Eum quasi saepe aperiam qui delectus quaerat in. Vitae mollitia ipsa quam. Ipsa aut qui numquam eum iste est dolorum. Rem voluptas ut sit ut.
                            </p>
                          </div>
                          <div class="col-lg-4">`);
            html.push(`<div class="course-info d-flex justify-content-between align-items-center">
                            <h5>Edad Recomendada</h5>
                            <p>`+Local.categoria.edadRecomendada+`</p>
                        </div>`);
            html.push(`<div class="course-info d-flex justify-content-between align-items-center">
                          <h5>Teléfono</h5>
                          <p>`+Local.telefono+`</p>
                        </div>`);
            html.push(`<div class="course-info d-flex justify-content-between align-items-center">
                          <h5>Plazas disponibles</h5>
                          <p>`+Local.aforo+`</p>
                        </div>`);
            html.push(`<div class="course-info d-flex justify-content-between align-items-center">
                          <h5>Horario</h5>
                          <p>`+Local.categoria.horaInicio+` - `+Local.categoria.horaFinal+`</p>
                        </div>`);
            html.push(`<div class="course-info d-flex justify-content-between align-items-center">
                          <h5>Horario</h5>
                          <p><a href="${Local.paginaWeb}"> Web </a></p>
                        </div>`);
            html.push(`<div class="mt-5 row d-flex justify-content-between align-items-center">
                    <a href="reserva.html?id=${num}" class="get-started-btn" style="text-align:center;display:block;">Reservar</a>
                    </div>`);
            html.push(`</div>
                        </div>
                      </div>
                      <div data-aos="fade-up" class="mt-3">
                        <iframe style="margin: 0 auto;display:block;border:0; width: 80%; height: 400px;" src="${Local.direccion.googleMapsLink}" frameborder="0" allowfullscreen="" loading="lazy"></iframe>
                      </div>
                    </section><!-- End Cource Details Section -->`);

            console.log(html);
            document.getElementById("main").innerHTML = html.join("");   // Añadimos las líneas html creadas a un div vacío de detail.html con identificador "div"

            return false;
        });

    return false;
}