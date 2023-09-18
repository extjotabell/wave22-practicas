# SocialMELI
Es una API REST que permite seguirse a usuarios y postear nuevas ofertas.

## Problema a resolver
Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Definiciones de equipo
Levantar el proyecto en IntelliJ y ejecutar la clase BeJavaHispW22G05Application.
Una vez levantada la API. Utilizar la colección "Grupo 5 Pruebas.postman_collection.json" ubicada en la carpeta resources y probar usando las requests definidas allí.

## Endpoints
##### US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
POST /users/{userId}/follow/{userIdToFollow}

Responsable: Facundo Janeiro.


##### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
GET /users/{userId}/followers/count

Responsable: Randy Mendoza.

##### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
GET /users/{userId}/followers/list

Responsable: Maximiliano Leiva.

##### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
GET /users/{userId}/followed/list

Responsable: Nahuel Filippa.

##### US 0005: Dar de alta una nueva publicación
POST /products/post

Responsable: Facundo Hermida.

##### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero)
GET /products/followed/{userId}/list

Responsable: Luis Felipe Alzamora Milla.

##### US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
POST /users/{userId}/unfollow/{userIdToUnfollow}

Responsable: Cecilia Morlacchi.

##### US 0008: Ordenamiento alfabético ascendente y descendente
GET
- /users/{UserID}/followers/list?order=name_asc
- /users/{UserID}/followers/list?order=name_desc
- /users/{UserID}/followed/list?order=name_asc
- /users/{UserID}/followed/list?order=name_desc

Trabajado en grupo.

##### US 0009: Ordenamiento por fecha ascendente y descendente

GET
- /products/followed/{userId}/list?order=date_asc
- /products/followed/{userId}/list?order=date_desc

Trabajado en grupo.

## Integrantes
- Cecilia Morlacchi
- Facundo Hermida
- Facundo Janeiro
- Luis Felipe Alzamora Milla
- Maximiliano Leiva
- Nahuel Filippa
- Randy Mendoza

## Requerimientos individuales

#### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción

POST /products/promo-post

Para el desarrollo de este endpoint cree un nuevo DTO (PostPromoDTO) que hereda las mismas propiedades
que el PostDTO inicial que teniamos, solo que a este le agregue los atributos que lo diferencian.

#### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

GET /products/promo-post/count?user_id={userId}

Para este endpoint en primer lugar cree un metodo para el repositorio que permita obtener las publicaciones
por userId, de esta forma en el servicio solo agregue logica para quedarme con aquellas que tienen promocion

#### US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor

GET /products/promo-post/list?user_id={userId}

Para este endpoint cree 2 nuevos Dto (PostPromotionsDTO) y (PostPromoDto), traigo por el mismo metodo 
que busca en el repositorio por userId, todas las publicaciones que tiene un determinado usuario
y posteriormente hago un mapeo para devolver los datos solicitados en los requerimientos.

Adicionalmente en los controladores al devolver el ResponseEntity cambie el comodin "?" por el tipo concreto
que devuelve, esto permite a simple vista saber que esta devolviendo el endpoint a la hora de revisar el codigo. Tambien
cambie una exception que teniamos por defecto para que devuelva un bad request en caso de una excepcion inesperada, y finalmente
saque importaciones que no se estaban utilizando en algunos archivos y donde utilizabamos Streams cambie el collectos por toList()
ya que es lo recomendado. Como una opcion adicional de mejora deberia cambiarse los metodos findById de las entidades para que
devuelvan un Optional y asi gestionar valores nulos de forma mas limpia en los servicios.