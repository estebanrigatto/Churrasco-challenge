# Churrasco-challenge

## API Rest de servicios desarrollada en Java/Springboot

### Endpoints:

	(POST) /auth/signup : Registro de nuevos usuarios
	(POST) /auth/signin : LogIn

	(GET) /products : Devuelve la lista de poductos
	(GET) /products/{id} : Devuelve un producto por su id
	(POST) /products : Registro de un producto
	(PUT) /products/{id} : Modificación de un producto por su id

### Encoder:

	Para encriptar las claves su utilizó MessageDigestPasswordEncoder (el cual está deprecado por no ser seguro),
	dado que el password en la base de datos está almacenado como un hash SHA256, aunque es recomendable encriptar las claves con BCrypt.

### Postman:

	En la carpeta doc se encuentra el archivo de Postman