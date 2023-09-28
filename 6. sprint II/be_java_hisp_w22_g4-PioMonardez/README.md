
# Social Meli - Sprint 2

API de proyecto grupal para el Bootcamp Java que permite seguir usuarios en la plataforma Social Meli, crear publicaciones y ver las publicaciones creadas por otros usuarios de la plataforma.

Abrir el archivo pom.xml en IntelliJ para levantar el servidor, las pruebas se pueden realizar desde la carpeta de Tests bajo el siguiente orden:


### Actividad individual
Se agregan los siguientes test de integracion con distintos escenarios: 

- US 01 - Follow user

Casos:

Seguir usuario exitosamente
Intentar seguir a un usuario que ya se sigue
Intentar seguirse a uno mismo (mismo user id)
Intentar seguir a un usuario con el rol COMPRADOR
Intentar seguir a un usuario que no existe

- US 02 - Followers count
Casos:

Obtener el contador de seguidores
Intentar obtener el contador de seguidores de un usuario que no existe

- US 03 - Followers list

Obtener la lista de seguidores
Intentar obtener la lista de seguidores de un usuario que no existe


- US 04 - Followed list

Casos:
Obtener la lista de seguidos
Intentar obtener la lista de seguidos de un usuario que no existe

- US 05 - Add post

Casos:
Agregar un post
Intentar agregar un post con un user id que no existe
Intentar agregar un post con payload incompleto, en este caso sin especificar el user id

- US 06 - Posts by followed users

Casos:
Obtener lista de posts de usuarios seguidos
Obtener lista de posts de usuarios seguidos por orden asc
Obtener lista de posts de usuarios seguidos por orden desc
Intentar obtener lista de posts de usuarios seguidos por un usuario que no existe
Intentar obtener lista de posts de usuarios seguidos por un parametro de ordenamiento invalido(solo se admite asc o desc)


- US 07 - Unfollow user

Casos:
Dejar de seguir a un usuario
Intentar dejar de seguir a un usuario que no existe
Intentar dejar de seguir a un usuario que no se sigue
Intentar dejar de seguir a uno mismo(mismo id)


### Tests

- Test 0001 (US 0001): Verificar que el usuario a seguir exista.

Responsable: Gonzalo Garcia Aguirre

- Test 0002 (US 0007): Verificar que el usuario a dejar de seguir exista.

Responsable: Tatiana Elorza

- Test 0003 (US 0008): Verificar que el tipo de ordenamiento alfabético exista.

Responsable: Solange Tamara Recayte

- Test 0004 (US 0008): Verificar el correcto ordenamiento ascendente y descendente por nombre.

Responsable: Alejandro Gabriel Hetman

- Test 0005 (US 0009): Verificar que el tipo de ordenamiento por fecha exista.

Responsable: Edwin Javier Rodriguez

- Test 0006 (US 0009): Verificar el correcto ordenamiento ascendente y descendente por fecha.

Responsable: Gonzalo Garcia Aguirre

- Test 0007 (US 0002): Verificar que la cantidad de seguidores de un determinado usuario sea correcta.

Responsable: Nicolas Guglielmi

- Test 0008 (US 0006): Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. 

Responsable: Luciana Yamila Pio Monardez


## Integrantes

- Alejandro Gabriel Hetman

- Edwin Javier Rodriguez

- Gonzalo Garcia Aguirre

- Luciana Yamila Pio Monardez

- Nicolas Guglielmi

- Solange Tamara Recayte

- Tatiana Elorza


## Agradecimientos 

A messi y la scaloneta ⭐⭐⭐

