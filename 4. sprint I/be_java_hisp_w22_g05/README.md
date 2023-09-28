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

---

---
## Trabajo Individual

### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
**POST** /products/promo-post

**PAYLOAD:**
```
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
```

### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
**GET:**  /products/promo-post/count?user_id={userId}

**RESPONSE:**

```
{
   "user_id" : 234,
   "user_name": "vendedor1",
   "promo_products_count": 23
}

```

### US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor 

**GET:** /products/promo-post/list?user_id={userId}

```
{
    "user_id": 234,
    "user_name": "vendedor1",
    "posts": [
        {
            “user_id”: 234
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": "100",
            "price": 15000.50,
            "has_promo": true,
            "discount": 0.25
        }
    ]
}

```
Hice el del ejemplo propuesto