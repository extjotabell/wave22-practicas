## SocialMeli 💛 🤝

## Equipo: 🚀

- Magui Cagna
- Gonzalo Gabriel Messina
- Emmanuel Schenoni
- Iara Grisel Roldan
- Julio Alvarez
- Rodrigo Balliani

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

✅ POST /users/{userId}/follow/{userIdToFollow} --> 

✅ GET /users/{userId}/followers/count --> 

✅ GET /users/{userId}/followers/list --> 

✅ GET /users/{userId}/followed/list --> 

✅ POST /products/post --> Iara Roldán

✅ GET /products/followed/{userId}/list --> 

✅ POST /users/{userId}/unfollow/{userIdToUnfollow} -->

✅ GET /users/{UserID}/followers/list?order --> 

✅ GET /products/followed/{userId}/list?order --> 

















# Desarrollo INDIVIDUAL 👩🏻‍💻

### Disclaimer

Para el desarrollo individual tanto como el bonus, modifiqué ciertos componentes del desarrollo grupal. 

✅ Eliminé la entidad Promotion y todas sus capas en la aplicación, ya que consideré que podía reutilizar Post y simplemente agregarle los campos 'hasPromo' y 'discount' que, siendo primitivos, tienen valores por default (false y 0.0) en caso de que se omitan al dar de alta una publicación que no esté en promo. 

✅ Reutilicé métodos de postService y postRepository para el guardado del post en promoción y lo relacioné con el user_id para luego poder realizar los endpoints donde requiero obtener tanto la cantidad como la lista de productos en promo de un determinado usuario.

✅ Agregué un paquete extra 'validations' donde implementé una interfaz genérica IValidator donde agrupé métodos de validaciones que se repetían entre los distintos services de entidades, con lógica de validación que se podía reutilizar. 

✅ A su vez hice que Postvalidator implemente la interfaz IValidator para aplicar polimorfismo y que pudiera modificar el método boolean valid(T e) como lo necesite. Como mejora sumaría también un UserValidator que implemente la misma interfaz y replique el comportamiento del método valid con sus necesidades específicas. 

✅ Por último agregué una clase Validator genérica que contiene métodos de validación aún más genéricos, del tipo isValidInt o isValidBoolean para reutilizar y no tener que repetirlos en cada Validator. 

## US 0010: Llevar a cabo la publicación de un nuevo producto en promoción

POST /products/promo-post

PAYLOAD:
{

    "user_id": 234,
    "date": "29-04-2021",
    "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "has_promo": true,
    "discount": 0.25
}

Response:

✅ Status Code 200 (OK)

❌ Status Code 400 (Bad request)


## US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

GET /products/promo-post/count?user_id={userId}

Response:
{

    "user_id": 234,
    "user_name": "vendedor1",
    "promo_products_count": 3
}


# Requerimiento Bonus (Desarrollo INDIVIDUAL)
## US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor

GET /products/promo-post/list?user_id={userId}

## Postman Collection 

Se adjuntan en la carpeta /resources

