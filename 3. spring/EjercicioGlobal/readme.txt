Buscar vehículos por dimensiones

Como: Usuario de la API.
Quiero: Listar vehículos basados en un rango de dimensiones (largo, ancho).
Para: Encontrar vehículos que se adapten a mis necesidades de espacio.
Endpoint: GET /vehicles/dimensions?length={min_length}-{max_length}&width={min_width}-{max_width}

Respuestas:
200 OK: Devuelve una lista de vehículos que cumplen con los criterios de dimensiones.
404 Not Found: No se encontraron vehículos con esas dimensiones.