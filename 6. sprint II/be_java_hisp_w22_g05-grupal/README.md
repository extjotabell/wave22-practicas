# SocialMELI2
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

## Unit Test
##### T 0001: Verificar que el usuario a seguir exista. (US-0001)
Se cumple:
Permite continuar con normalidad.

No se cumple:
Notifica la no existencia mediante una excepción.

POST /users/{userId}/follow/{userIdToFollow}

Responsable: Facundo Hermida.


##### T 0002: Verificar que el usuario a dejar de seguir exista. (US-0007)
Se cumple:
Permite continuar con normalidad.

No se cumple:
Notifica la no existencia mediante una excepción.

GET /users/{userId}/followers/count

Responsable: Facundo Hermida.

##### T 0003: Verificar que el tipo de ordenamiento alfabético exista (US-0008)
Se cumple:
Permite continuar con normalidad.

No se cumple:
Notifica la no existencia mediante una excepción.

GET /users/{userId}/followers/list

Responsable: Cecilia Morlacchi.

##### T 0004: Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
Devuelve la lista ordenada según el criterio solicitado

GET /users/{userId}/followed/list

Responsable: Facundo Janeiro.

##### T 0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009)
Se cumple:
Permite continuar con normalidad.

No se cumple:
Notifica la no existencia mediante una excepción.

POST /products/post

Responsable: Randy Mendoza.

##### T 0006: Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)
Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)

GET /products/followed/{userId}/list

Responsable: Maximiliano Leiva.

##### T 0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)
Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario. 

POST /users/{userId}/unfollow/{userIdToUnfollow}

Responsable: Luis Felipe Alzamora Milla.

##### T 0008: Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)
Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.

GET
- /users/{UserID}/followers/list?order=name_asc
- /users/{UserID}/followers/list?order=name_desc
- /users/{UserID}/followed/list?order=name_asc
- /users/{UserID}/followed/list?order=name_desc

Responsable: Nahuel Filippa.

## Integrantes
- Cecilia Morlacchi
- Facundo Hermida
- Facundo Janeiro
- Luis Felipe Alzamora Milla
- Maximiliano Leiva
- Nahuel Filippa
- Randy Mendoza