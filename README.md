# Nookin
Práctica Final de PAT

Practica Final Programación de Aplicaciones Telemáticas 

Link: https://github.com/Divasson/Nookin

	Nuestra práctica consiste en una página de reservas para bares de una ciudad. En ella, te puedes registrar y mirar los bares disponibles en Madrid. Una vez hayas elegido un bar, puedes hacer una reserva e invitar a los usuarios que vayan a ir contigo. Es una oportunidad única para estas épocas de pandemia, que todos queremos estar fuera de casa. 

	El modelo de datos consta de las clases necesarias para guardar usuarios, locales, valoraciones, propietarios y categorías. También las clases necesarias para hacer validaciones a nuestros controllers. En las mismas clases creamos las bases de datos y sus relaciones. Los servicios son dos y nos ayudan a manejar los locales y los usuarios. En ellos actualizamos, verificamos y devolvemos los usuarios y locales según se necesite. 

	Nuestros controladores se utilizan principalmente para autenticarse, registrarse, ver los locales disponibles, filtrarlos por categorías y hacer reservas. Los repositorios son el apoyo a nuestros servicios, los que le brindan la conexión con nuestra base de datos. 

	Nuestra página web consta de varias vistas. La más habitual, un mapa conectado con la api de Google que te enseña los bares más cercanos en tu posición en el mapa. Otra muy divertida que ten enseña un plan aleatorio que te pueda apetecer esa tarde. Luego para los más instagrammers, enseñamos los mejores planes para poder posturear con tus amigos. Además, tiene una página por si quieres conocer al equipo y sabes leer latín. Como era de esperar, también te encuentras las páginas de registro y de conectar con tu cuenta. En el momento que te gusta un bar y no quieres que te quiten el sitio, puedes hacer una reserva desde la misma web, la cual quedará almacenada en los registros. 

Vistas:

Index.html
Web principal con las mejores reservas más populares, las categorías que más gustan, u opiniones de nuestros usuarios.

local-details.html
Muestra el local asociado a la id de la URL. En caso de no existir id, muestra un local aleatorio, lo que es muy útil para una de las funcionalidades de la web.
Map.html
Mapa con todos los locales de los que disponemos y links directos a ellos. Nuestra creación de más orgullo.

Categories.html
Lista con todas las categorías de las que disponemos.

Cat.html
Vista que en función de la id de la categoría muestra todos los locales de la misma.

Info.html
Página con la información de nuestra empresa.

Contact.html
Contacto para propietarios de locales que quieren añadirlos a nuestra web

Login.html
Página de login y registro.

Reserva.html
Vista asociada a una id de local para que el usuario pueda reservar en él (solo nos ha funcionado con postman).


