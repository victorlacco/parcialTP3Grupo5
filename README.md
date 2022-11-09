# parcialTP3Grupo5

**-Materia: Taller de Programacion III**

*-Integrantes: Victor Lacco, Cristian Esem, Diego Ponzo, Julian Perini*

-Enunciado del Parcial
El parcial práctico se desarrolla de forma grupal siguiente los grupos de trabajo de Proyecto Final o los de esta materia. 
La consigna es desarrollar una Aplicación Móvil en Android con el Lenguaje Kotlin, con las especificaciones definidas en este documento. 
El diseño, colores, tipografías e imágenes lo dejamos a libre elección del grupo. 
Es importante la utilización de los componentes, controles y funcionalidades vistas en clase.
A continuación compartimos el documento con las especificaciones de la aplicación, y el documento donde podrán acceder a la documentación de la API (endpoint) a utilizar.
https://docs.google.com/presentation/d/1GxQ_uzBRqtVR4RoGkFVu5d98A6Y-43FLH5fayS2vyO4

> -Documentación API: https://rickandmortyapi.com/documentation/#get-all-characters

*-Endpoints utilizados para acceder a la informacion de la API:*
Get all Characters /character
GET https://rickandmortyapi.com/api/character

Get a single character -> /character/id
GET https://rickandmortyapi.com/api/character/2

Get multiple characters -> /character/1,2,3
GET https://rickandmortyapi.com/api/character/1,2,3

Filter characters (search by name)
GET https://rickandmortyapi.com/api/character?name=rick


*-Estrategia:*
Se utilizaron tres activities, una para el uso del splash, una para el main y una para las settings.
Tambien se utilizo el componente Drawer en el dashboard donde se puede acceder a las distintas pantallas.
En el inicio de la aplicacion, se ejecuta el splash, luego finaliza, e inicia el main.
Se persisten el nombre del usuario querealiza el logueo, el id de los personajes favoritos, 
y los users settings (Los cambios se aplican al reiniciar).
La pantalla dashboard a travez del componente Recycler view lista los personajes que son llamados a la API.
El fragmento character muestra el personaje seleccionado, y los datos son recuperados a traves de la llamada a la API.
En el fragmento favoritos, se recupera el nombre del usuario logueado almacenado en shared preferences,
al igual que en dashboard, el componente Recycler View lista los personajes favoritos que son llamados a la API.
Se recupera el id de los personajes favoritos persistidos en el shared preferences.
Por ultimo el fragment settings muestra y persiste los users settings.

*-Componentes utilizados:*
Splash
Constraint Layout
Nav Host Fragment
Navigation Graph
Navigation Drawer
Recycler View List, Adapter + Holders
Retrofit
Settings
Libreria Picasso
Shared Preferences