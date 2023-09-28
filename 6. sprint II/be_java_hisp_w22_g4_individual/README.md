
# Social Meli - Sprint 2

API de proyecto grupal para el Bootcamp Java que permite seguir usuarios en la plataforma Social Meli, crear publicaciones y ver las publicaciones creadas por otros usuarios de la plataforma.

Abrir el archivo pom.xml en IntelliJ para levantar el servidor, las pruebas se pueden realizar desde la carpeta de Tests bajo el siguiente orden:

### Tests Unit grupal

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

### Tests Integral individual
------- ProductControllerTest -----
- US 0005 : Se verifico que se agregara un posteo correctamente. Se controlo que el PAYLOAD tenga validacion en sus atributo. Por ultimo se controlo la excepcion de que un usuario no exista.

- US 0006 : Se verifico todo el circuito de la consulta de publicaciones realizadas se encuentre en las ultimas dos semana, y su correcto ordenamiento. Tambien que se controle la excepcion de que el usuario no exista.

------- UserControllerTest -----

- US 0001 : Se verifico que un usuario puede seguir a otro usuario. Tambien si ya lo seguia que lo advierta.

- US 0002 : Se Verifico la cantidad de usuarios que siguen a un determinado vendedor. Tambien que ese usuario exista.

- US 0004 : Se verifico el listado de todos los vendedores a los cuales sigue un determinado usuario y su correcto ordenamiento.

- US 0007 : Se Valido que un usuario pueda dejar de seguir a otro correctamente. Se controlo que se advierta que ya se dejo de seguir al usurio. Tambien se valido que el usuario se deje de seguir a si mismo. Por ultimo que exita el usuario al que quiera dejar de seguir.

Responsable: Solange Tamara Recayte

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

