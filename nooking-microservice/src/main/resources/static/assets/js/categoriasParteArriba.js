
var ListaCategorias;
document.addEventListener("DOMContentLoaded", function (event) {
    loadCategorias();
    crearDropdown();

});

function loadCategorias(){
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
        let html = [];  
        for(i=0;i<ListaCategorias.length;i++){
            let path2 = ListaCategorias[i].tipoCategoria;    
            html.push(`<li><a href="cat.html?category=${path2}">`+path2+`</a></li>`); 
            console.log(html);
        }
        document.getElementById("dropdownJS").innerHTML = html.join("");   // Añadimos las líneas html creadas a un div vacío de detail.html con identificador "div"
        return false;
    });
}

function crearDropdown(){
    let html = [];      // variable local donde almacenaremos las líneas html



   
}