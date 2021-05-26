
document.addEventListener("DOMContentLoaded", function (event) {

    
    var myIcon = L.icon({
        iconUrl: 'Images/cocktail2.png',
        iconSize: [30, 40],
        iconAnchor: [30, 40],
        popupAnchor: [-10, -35],
        //shadowUrl: 'my-icon-shadow.png',
        shadowSize: [68, 95],
        shadowAnchor: [22, 94]
    });

    const CoordenadasMad = [40.4330, -3.6883];

    var mymap = L.map('mapid',{
        center : CoordenadasMad,
        zoom:13,
        maxZoom : 20,
        minZoom: 3
    });

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'pk.eyJ1IjoiZGl2YXNzb24iLCJhIjoiY2twNWNmMml3MDB6MjJucGdwN25icWJkeiJ9.KE9KANYJEpL5DnmGyM5qZQ'
    }).addTo(mymap);

    var marker = L.marker(CoordenadasMad,{
        keyboard : false,
        title: "Hola",
        icon : myIcon
    }).addTo(mymap);
    marker.bindPopup('<h1><b>Bar Marcial</b></h1><img src="Images/BarCualquiera.jpg" width="200px" height="150px">',{keepInView:true});

    // var popup = L.popup()
    // .setLatLng([40.4530, -3.6883])
    // .setContent("I am a standalone popup.")
    // .openOn(mymap);
});