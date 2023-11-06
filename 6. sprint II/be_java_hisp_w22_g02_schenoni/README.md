## SocialMeli 💛 🤝

## Equipo: 🚀

- Magui Cagna
- Gonzalo Gabriel Messina
- Emmanuel Schenoni
- Iara Grisel Roldan
- Julio Alvarez
- Rodrigo Baliani

## Enunciado 

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una
serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente 
innovadora, en donde el lazo que los una sea mucho más cercano. La fecha de lanzamiento se aproxima, 
por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, 
en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que 
los mismos posteen. Para poder realizar esto, un analista funcional relevó una serie de requerimientos que deben 
llevarse a cabo; sin embargo, como cuentan con una determinada complejidad y los tiempos son escasos, deberán ser 
ejecutados en equipos de trabajo. Los mismos se detallan a continuación:


## Se plantea la creación de una API Rest que permita:

1) Poder realizar la acción de “Follow” (seguir) a un determinado usuario

2) Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

3) Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

4) Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

5) Dar de alta una nueva publicación.

6) Obtener un listado de las publicaciones realizadas en las últimas dos semanas, por los vendedores que un usuario sigue (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

7) Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

Por otra parte, dado que se pretende una buena experiencia de usuario con respecto a la forma de presentación de los resultados de cada consulta, se necesita que los mismos puedan ser ordenados mediante cualquiera de los siguientes criterios:

8) Alfabético Ascendente y Descendente

9) Fecha Ascendente y Descendente



Un analista funcional llevó a cabo el relevamiento de los requerimientos técnicos funcionales y ha proporcionado la documentación que se cita a continuación para tener en cuenta a la hora de llevar a cabo el desarrollo correspondiente:

[Especificación técnica funcional](https://docs.google.com/document/d/1Q-xGaOMPij-qk_gMvcN0Sk0isbCPqjJS/preview?usp=sharing&ouid=102053688598464604438&rtpof=true&sd=true)

# Definiciones de Equipo 🤝

Para correr la aplicación es necesaria una JDK 17 y Maven. 

Ejecutar comando mvn i y luego ejecutar Run BeJavaHispW22G02Application. 

Para las pruebas, se recomienda como primera medida seguir algunos usuarios usando el endpoint /users/{userId}/follow/{userIdToFollow}.

Una vez que tenemos varios usuarios con los que jugar, podemos dar de alta publicaciones con el endpoint /products/post y verificar que el usuario tiene ese post en su lista de publicaciones. 

A partir de esto podemos dejar de seguir usuarios, visualizar a quienes sigo y quienes me siguen, ver las publicaciones de mis seguidos, entre otras.

La colección de postman se encuentra en la carpeta /resources en formato json.

# Endpoints y responsables de su programación 🦾

✅ POST /users/{userId}/follow/{userIdToFollow} --> Rodrigo Baliani

✅ GET /users/{userId}/followers/count --> Emmanuel Schenoni

✅ GET /users/{userId}/followers/list --> Magui Cagna

✅ GET /users/{userId}/followed/list --> Julio Alvarez

✅ POST /products/post --> Iara Roldán

✅ GET /products/followed/{userId}/list --> Gonzalo Messina

✅ POST /users/{userId}/unfollow/{userIdToUnfollow} --> Julio Alvarez

✅ GET /users/{UserID}/followers/list?order --> Magui Cagna

✅ GET /products/followed/{userId}/list?order --> Gonzalo Messina


# Testing Development

✅ T001 - followUser (US-001) --> Gonzalo Messina

✅ T002 - unfollowUser (US-007) --> Emmanuel Schenoni

✅ T003 - getFollowers (US-008 - Existing Order Param)  --> Rodrigo Baliani

✅ T004 - getFollowers (US-008 - Correct Order) --> Iara Roldán

✅ T005 - getFollowedPostLasTwoWeeksOrd (US-009 - Existing Order Param)  --> Julio Alvarez

✅ T006 - getFollowedPostLasTwoWeeksOrd (US-009 - Correct Order) --> Magui Cagna

✅ T007 - getTotalFollowersByUserId (US-002) --> Rodrigo Baliani

✅ T008 - getFollowedPostLasTwoWeeks (US-006) --> Emmanuel Schenoni


# Testing Individual (Test de integración en la carpeta controller dentro de "Test")

POST CONTROLLER

✅ addNewPost()

✅ getLastTwoWeeksPostByUserFollowed() 

USER CONTROLLER

✅ getFollwers()

✅ getFollowedUser()

✅ followUser()

✅ unfollowUserNonFollow()


# Postman Testing 🟠

Dentro de la carpeta resources se encuentra el archivo "Social Meli - Grupo 2.postman_collection" el cual contiene la coleccion de Postman donde se realizan las pruebas. 

<img width="1672" alt="image" src="https://github.com/extjotabell/wave22-practicas/assets/143105901/3d6d3cf5-1c17-4d41-9d51-04d938adedcf">

Ruta: wave22-practicas/4. sprint I/be_java_hisp_w22_g01/src/main/resources/Social Meli - Grupo 2.postman_collection.json
