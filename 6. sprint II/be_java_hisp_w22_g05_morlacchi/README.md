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

***

## Test 
### (Test Unitarios - Grupal)

* T-0001 : Verificar que el usuario a seguir exista. (Facundo Hermida)
* T-0002 : Verificar que el usuario a dejar de seguir exista. (Facundo Hermida)
* T-0003: Verificar que el tipo de ordenamiento alfabético exista (Cecilia Morlacchi)
* T-0004: Verificar el correcto ordenamiento ascendente y descendente por nombre. (Facundo Janeiro)
* T-0005: Verificar que el tipo de ordenamiento por fecha exista (Randy Mendoza)
* T-0006: Verificar el correcto ordenamiento ascendente y descendente por fecha. (Maximiliano Leiva)
* T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (Luis Alzamora)
* T-0008 : Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (Nahuel Filippa)

### (Test Integracion - Individual)

* US0001 : Test de integracion verificando que se siga a un usuario.
* US0002 : Test de integracion verificando que se traiga la cantidad de usuarios que sigue un usuario.
* US0003:  Test de integracion verificando que traiga un listado con los usuarios que siguen a un usuario.
* US0004:  Test de integracion verificando que traiga un listado de los usuarios a los que sigue otro usuario determinado.
* US0005:  Test de integracion verificando que se produzca el alta de un post.
* US0007:  Test de integracion verificando que se deje de seguir a un usuario.

***
*El trabajo grupal junto con el trabajo individual, lograron una cobertura del 80%*







