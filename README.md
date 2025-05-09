Request: Crear una película
Cuerpo de la solicitud (Request Body):
json
{
    "titulo": "Inception",
    "director": "Christopher Nolan",
    "anioLanzamiento": 2010,
    "genero": "Ciencia Ficción"
}

Respuesta exitosa
Si la película se crea correctamente:
Código de estado: 200 OK
Cuerpo de la respuesta (Response Body):
{
    "id": 1,
    "titulo": "Inception",
    "director": "Christopher Nolan",
    "anioLanzamiento": 2010,
    "genero": "Ciencia Ficción"
}

Respuesta con error
Si hay un error en los datos (por ejemplo, el anioLanzamiento es menor a 1895):

Código de estado: 400 Bad Request
Cuerpo de la respuesta (Response Body):

Y tirara un mensaje personalizado.

2. Documentación de Validaciones
En este proyecto, las validaciones se encuentran distribuidas en diferentes componentes, cada uno responsable de validaraspectos específicos de la película,
como el año de lanzamiento, la combinación de título y director.
 A continuación se describe dónde se encuentra cada tipo de validación y su propósito.

2.1 Validaciones de Película

Las validaciones relacionadas con los datos de la película (por ejemplo, anioLanzamiento, titulo, y director) se encuentran en la clase PeliculaValidator. 
Métodos:
validarAnio(Integer anio): Valida que el año de lanzamiento de la película esté dentro de un rango aceptable (mayor o igual a 1985 y menor o igual al año actual más 2).

validarTituloYDirector(String titulo, String director, PeliculaRepository repo): Verifica que no exista otra película con el mismo título y director en la base de datos.
