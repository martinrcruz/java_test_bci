## Introducción

Este es un proyecto para resolver la prueba tecnica para **"Desarrollador Java Especialista Integración"** que implementa un servicio de creación de usuarios utilizando Java 17, Spring Boot 3.1.9, JPA, H2 Database, Lombok, JUnit 5 con Mockito y Swagger (OpenAPI).

## Tabla de Contenido

1. [Introducción](#introducción)
2. [Tabla de Contenido](#tabla-de-contenido)
3. [Diagrama de solución](#diagrama-de-solución)
4. [Modelo de Datos](#modelo-de-datos)
5. [Versiones y Otros](#versiones-y-otros)
6. [Estructura del Proyecto](#estructura-del-proyecto)
7. [Instalación y Ejecución](#instalación-y-ejecución)


## Diagrama de solución
![Diagrama API](https://github.com/martinrcruz/java_test_bci/assets/30867462/bbbafa53-5675-4bce-88b7-a210a6003032)


## Modelo de Datos
![Modelo de Datos](https://github.com/martinrcruz/java_test_bci/assets/30867462/99375e1d-47f9-4ba8-962e-6e08190b97be)


## Versiones y Otros
| Tecnología/Herramienta      | Versión                       |
|-----------------------------|-------------------------------|
| Java                        | 17.0.6 (corretto-17)          |
| Spring Boot                 | 3.1.9                         |
| JUnit                       | 5.x.x                         |
| H2 Database                 | 2.1.214                       |


## Estructura del Proyecto
```
|-java-test/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── cl/
│   │   │       └── bci/
│   │   │           └── javatest/
│   │   │               ├── config/
│   │   │               │   └── SecurityConfig.java
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── controller/
│   │   │               │   └── UserController.java
│   │   │               ├── dto/
│   │   │               │   └── request/
│   │   │               │       └── CreateUserRequestDTO.java
│   │   │               │   └── response/
│   │   │               │       └── CreateUserResponseDTO.java
│   │   │               │       └── ListUsersResponseDTO.java
│   │   │               │       └── ResponseMessage.java
│   │   │               ├── exception/
│   │   │               │   └── UserException.java
│   │   │               │   └── BciException.java
│   │   │               ├── jpa/
│   │   │               │   └── entity/
│   │   │               │       └── Phone.java
│   │   │               │       └── User.java
│   │   │               │   └── repository/
│   │   │               │       └── UserRepository.java
│   │   │               │       └── read/
│   │   │               │           └── UserRepositoryRead.java
│   │   │               │       └── write/
│   │   │               │           └── UserRepositoryWrite.java
│   │   │               │       └── impl/
│   │   │               │           └── UserRepositoryImpl.java
│   │   │               ├── mapper/
│   │   │               │   └── UserMapper.java
│   │   │               ├── service/
│   │   │               │   └── IUserService.java
│   │   │               │   └── impl/
│   │   │               │       └── UserServiceImpl.java
│   │   │               └── utils/
│   │   │                   └── enums/
│   │   │                       └── ResponseCode.java
│   │   │                   └── JwtUtil.java
│   │   │                   └── RegExUtil.java
│   │   │                   └── BciHttpResponseBuilder.java
│   │   │                   └── BciResponse.java
│   │   └── resources/
│   │       └── application.yml
│   │       └── schema.sql
│   │       └── data.sql
│   └── test/
│       ├── java/
│       │   └── cl/
│       │       └── bci/
│       │           └── javatest/
|       |               ├── config/
│       │               └── controller/
│       │                   └── UserControllerTest.java
│       └── resources/
├── README.md
├── LICENSE
├── mvnw
├── mvnw.cmd
└── pom.xml

```




## Instalación y Ejecución

Para ejecutar el proyecto localmente, sigue estos pasos:

1) Clona el repositorio:
```
git clone https://github.com/martinrcruz/java_test_bci.git
```

2) Navega al directorio del proyecto:
```
cd /ruta_ejemplo/java_test_bci
```

3) Ejecuta la aplicación:
```
mvn spring-boot:run
```

4) Accede a la documentación de la API Swagger en http://localhost:8080/swagger-ui.html

5) Realiza las solicitudes HTTP al servicio según sea necesario.

NOTA: El script de base de datos esta integrado en la carpeta resources, por lo que carga el Schema al iniciar.

## Ejecución de Pruebas Unitarias
Para ejecutar las pruebas unitarias, simplemente ejecuta el siguiente comando en el directorio del proyecto:
```
mvn test
```

