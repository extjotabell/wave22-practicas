
# Sprint 1 Team 1

## Objetivo 🎯

Mercado Libre planea un crecimiento continuo y tiene como objetivo introducir innovadoras herramientas para compradores y vendedores el próximo año, con el lanzamiento de una versión Beta llamada "SocialMeli". Esta plataforma permitirá a los compradores seguir a sus vendedores favoritos y mantenerse al tanto de sus actualizaciones. Para lograrlo, se han identificado requerimientos que se abordarán en equipos de trabajo debido a su complejidad y la proximidad de la fecha de lanzamiento.



## Definiciones de Equipo 🫂

### Como se ejecuta la API:
La API se ejecuta desde el archivo BeJavaHispW22G01Application, el cual contiene el main. Dentro tenemos la opcion ▶ Boton Run para ejecutarlo.

### Como se hacen las pruebas:

Dentro de la carpeta resource se encuentra el archivo "Sprint 1v2.postman_collection" el cual contiene la coleccion de PostMan donde se realizan las pruebas.

Ruta: wave22-practicas/4. sprint I/be_java_hisp_w22_g01/src/main/resources/Sprint 1v2.postman_collection.json

En el PostMan se importa este json y se encontraran los distintos casos de prueba:

![Foto](https://github.com/extjotabell/wave22-practicas/blob/santochi_belen/4.%20sprint%20I/be_java_hisp_w22_g01/src/main/resources/postman.png)

En los casos de uso US_008 y US_009 se pueden seleccionar otros parametros.

En la solapa de Pre-request Script se encuentra los parametros que van a ser pasados.






## Endpoints y responsables de su programación ⭕️

Emmanuel:
Endpoints 
- 3: /users/{userId}/followers/list
- 6: /products/followed/{userId}/list

Belen:
Endpoints:
- 2: /users/{userId}/followers/count
- 5: /products/post


Valentina:
Endpoints:

- 1: /users/{userId}/follow/{userIdToFollow}
- 9: /products/followed/{userId}/list?order=date_asc
- 10: /products/promo-post
- 11: /products/promo-post/count?user_id={userId}
- 12: /products/promo-post/list?user_id={userId}

Nicolas:
Endpoints:
- 4: /users/{userId}/followed/list

Gonzalo:
Endpoints:

- 7: /users/{userId}/unfollow/{userIdToUnfollow}

Camila:
Endpoints:

- 8.a: /users/{UserID}/followers/list?order=name_asc

- 8.b: /users/{UserID}/followed/list?order=name_asc 


Integrantes 🤼‍♀️:
-
- Camila Soledad Lemos
- Emmanuel Felipe Paiva
- Gonzalo España Herrrera
- Nicolas Salvo
- Belen Santochi
- Valentina Gottelli


## Cierre y agradecimientos ❇

El proyecto "SocialMeli" no solo representó un desafío emocionante, sino también una oportunidad de crecimiento y aprendizaje para todos nosotros. Estamos agradecidos por la colaboración de Johanna, Martín y Mike, quienes compartieron sus conocimientos y experiencias, permitiéndonos mejorar nuestras habilidades y conocimientos en el proceso.

Este proyecto no habría sido posible sin el esfuerzo y la colaboración de cada miembro del equipo. Juntos, logramos superar obstáculos y alcanzar nuestro objetivo de manera exitosa. Agradecemos a todos por su arduo trabajo y dedicación.