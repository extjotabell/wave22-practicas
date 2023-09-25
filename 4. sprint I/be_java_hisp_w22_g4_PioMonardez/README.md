
# Social Meli

Api de proyecto grupal para el Bootcamp Java que permite seguir usuarios en la plataforma Social Meli, crear publicaciones y ver las publicaciones creadas por otros usuarios de la plataforma.

Abrir el archivo pom.xml en intellij para levantar el servidor, las pruebas se pueden realizar con postman con la siguiente coleccion:

## **Modificaciones**

En el desarrollo individual se agregaron los siguientes endpoints:

• Post - _/promo-post_

• Get - _/promo-post/count?user_id={user_id}_

• Get - _/promo-post/list?user_id={user_id}_


Se mejoro el codigo y se hizo refactor de algunos metodos, usando la anotacion JsonIgnoreProperties para poder usar ObjectMapper a la hora de mappear los objetos al dto.


## **Endpoints**

• Post - _/users/{userId}/follow/{userIdToFollow}_

Responsable: Gonzalo Garcia Aguirre

• Get - _/users/{userId}/followers/count_

Responsable: Alejandro Gabriel Hetman y Nicolas Guglielmi

• Get - _/users/{userId}/followers/list_

Responsable: Alejandro Gabriel Hetman y Nicolas Guglielmi

• Get - _/users/{userId}/followed/list_

Responsable: Edwin Javier Rodriguez

• Post - _/products/post_

Responsable: Solange Tamara Recayte

• Get - _/products/followed/{userId}/list_

Responsable: Luciana Yamila Pio Monardez

• Get- _/users/{userId}/unfollow/{userIdToUnfollow}_

Responsable: Tatiana Elorza

• Get - _/users/{UserID}/followers/list?order=name_asc_

Responsable: Alejandro Gabriel Hetman y Nicolas Guglielmi

• Get - _/products/followed/{userId}/list?order=date_asc_

Responsable: Luciana Yamila Pio Monardez

## **Integrantes**

• Gonzalo Garcia Aguirre

• Nicolas Guglielmi

• Alejandro Gabriel Hetman

• Edwin Javier Rodriguez

• Solange Tamara Recayte

• Luciana Yamila Pio Monardez

• Tatiana Elorza



## **Agradecimientos** 

A messi y la scaloneta ⭐⭐⭐

