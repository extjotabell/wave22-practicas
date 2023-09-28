# Social Meli - Sprint 2

El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.


### Tests

- T-0001 (US 0001): Verificar que el usuario a seguir exista. (Matías)
- T-0002 (US 0007): Verificar que el usuario a dejar de seguir exista. (Santiago)
- T-0003 (US 0008): Verificar que el tipo de ordenamiento alfabético exista. (Lucas)
- T-0004 (US 0008): Verificar el correcto ordenamiento ascendente y descendente por nombre. (Gaspar)
- T-0005 (US 0009): Verificar que el tipo de ordenamiento por fecha exista. (Renzo)
- T-0006 (US 0009): Verificar el correcto ordenamiento ascendente y descendente por fecha. (Agustín)
- T-0007 (US 0002): Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (Santiago)
- T-0008 (US 0006): Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (Renzo)

## Tests de Integración

- POST /products/post
  - OK
  - Errores de validación body
  - HttpMessageNotReadableException
- GET /products/followed/{userId}/list?order={date_asc || date_desc}
  - Obtener lista ascendente
  - Obtener list descendente
  - Obtener lista sin ordenamiento
  - Orden de lista invalida
- GET /users/{userID}/followed/list
  - OK
  - Usuario no encontrado
- GET /users/{userId}/followed/list
  - OK
  - Usuario no encontrado
- GET /users/{userId}/followers/count
  - Usuario sin seguidores
  - Usuario con seguidores
  - Usuario no encontrado
- GET /users/{userId}/followers/list
  - OK
  - Usuario no encontrado
- POST /users/{userId}/unfollow/{userIdToUnfollow}
  - OK
  - Usuario no encontrado
  - Usuario quiere seguirse a si mismo
  - No es un seguidor del usuario

## Integrantes
- Gaspar Zanini
- Lucas Espinosa
- Matias Nicolas Marin Fernandez
- Renzo Matias Bayarri
- Santiago Tobias Langer
- Agustin Tarda
