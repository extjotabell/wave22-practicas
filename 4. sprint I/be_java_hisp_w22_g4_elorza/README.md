
# Social Meli

Api de proyecto para el Bootcamp Java que permite seguir usuarios en la plataforma Social Meli, crear publicaciones y ver las publicaciones creadas por otros usuarios de la plataforma.

La misma consta de nueve US realizadas de manera grupal, y tres más de manera individual, dos obligatorias y una más opcional.
También realicé un par de cambios en algunos endpoints de la parte grupal para mejor performance de la parte individual.

Para poder utilizar la API deberá abrir el archivo pom.xml en el programa Intellij para levantar el servidor. Las pruebas se pueden realizar con postman con la colección adjuntada en la carpeta de resources, a su vez menciono los endpooints a continuación:

## Endpoints grupales:

• Post - /users/{userId}/follow/{userIdToFollow}

Responsable: Gonzalo Garcia Aguirre

• Get - /users/{userId}/followers/count

Responsable: Alejandro Gabriel Hetman y Nicolas Guglielmi

• Get - /users/{userId}/followers/list

Responsable: Alejandro Gabriel Hetman y Nicolas Guglielmi

• Get - /users/{userId}/followed/list

Responsable: Edwin Javier Rodriguez

• Post - /products/post

Responsable: Solange Tamara Recayte

• Get - /products/followed/{userId}/list

Responsable: Luciana Yamila Pio Monardez

• Get- /users/{userId}/unfollow/{userIdToUnfollow}

Responsable: Tatiana Elorza

• Get - /users/{UserID}/followers/list?order=name_asc

Responsable: Alejandro Gabriel Hetman y Nicolas Guglielmi

• Get - /products/followed/{userId}/list?order=date_asc

Responsable: Luciana Yamila Pio Monardez

## Endpoints individuales:

• Post - /products/promo-post

Responsable: Tatiana Elorza

• Get - /products/promo-post/count?user_id={userId}

Responsable: Tatiana Elorza

• Get - /products/promo-post/list?user_id={userId}

Responsables: Tatiana Elorza

### Integrantes

• Gonzalo Garcia Aguirre

• Nicolas Guglielmi

• Alejandro Gabriel Hetman

• Edwin Javier Rodriguez

• Solange Tamara Recayte

• Luciana Yamila Pio Monardez

• Tatiana Elorza



### Agradecimientos 

A mis compañeros de equipo para estos sprints. Y a mis compañeros con los que tuve un peer review muy bueno y útil.