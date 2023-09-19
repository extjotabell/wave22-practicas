
# SocialMeli
## Descripcion del problema
Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano. 
La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.
Para poder realizar esto, un analista funcional relevó una serie de requerimientos que deben llevarse a cabo; sin embargo, como cuentan con una determinada complejidad y los tiempos son escasos, deberán ser ejecutados en equipos de trabajo. Los mismos se detallan a continuación:

Se plantea creación de una API Rest que permita:
- Poder realizar la acción de “Follow” (seguir) a un determinado usuario
- Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
- Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
- Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
- Dar de alta una nueva publicación.
- Obtener un listado de las publicaciones realizadas en las últimas dos semanas, por los vendedores que un usuario sigue (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
- Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

Por otra parte, dado que se pretende una buena experiencia de usuario con respecto a la forma de presentación de los resultados de cada consulta, se necesita que los mismos puedan ser ordenados mediante cualquiera de los siguientes criterios: 
Alfabético Ascendente y Descendente
Fecha Ascendente y Descendente

## Correr la aplicacion
Desde el el IntelliJ IDEA abrir el proyecto en de la carpeta be_java_hisp_w22_g03, abrir el archivo BeJavaHispW22G03Application.java y pulsar el boton de run que se encuentra arriba a la derecha.

La coleccion de Postman para utilizar mas facilmente los endpoints del pryecto se encuetra en la carpeta be_java_hisp_w22_g03/src/main/resources con el numbre "Sprint 1.postman_collection.json"

## Endpoints

- GET /users/{userId}/followers/list (Gaspar y Lucas)
- GET /users/{userId}/followed/list (Gaspar y Lucas)
- GET /users/{UserID}/followers/list?order=name_asc (Gaspar y Lucas)
- GET /users/{UserID}/followers/list?order=name_desc (Gaspar y Lucas)
- GET /users/{UserID}/followed/list?order=name_asc (Gaspar y Lucas)
- GET /users/{UserID}/followed/list?order=name_desc (Gaspar y Lucas)

- POST /users/{userId}/follow/{userIdToFollow} (Santiago y Matias)
- POST /users/{userId}/unfollow/{userIdToFollow} (Santiago y Matias)
- GET /users/{userId}/followers/count (Santiago y Matias)

- POST /products/post (Rezno y Agustin)
- GET /products/followed/{userId}/list (Rezno y Agustin)
- GET /products/followed/{userId}/list?order=date_asc (Rezno y Agustin)
- GET /products/followed/{userId}/list?order=date_desc (Rezno y Agustin)

- POST /products/promo-post
- GET /products/promo-post/count?user_id={userId}
- GET /products/promo-post/list?user_id={userId}

## Integrantes
- Gaspar Zanini
- Lucas Espinosa
- Matias Nicolas Marin Fernandez
- Renzo Matias Bayarri
- Santiago Tobias Langer
- Agustin Tarda
