## Introducción

Este es un proyecto para resolver la prueba tecnica para **"Desarrollador Java Especialista Integración"** que implementa un servicio de creación de usuarios utilizando Java 17, Spring Boot 3.1.9, JPA, H2 Database, Lombok, JUnit 5 con Mockito y Swagger (OpenAPI).
Además, se proporciona un Dockerfile para facilitar la ejecución del servicio en un contenedor Docker, y una pipeline de CI/CD en Gitlab para ejecutar pruebas unitarias, verificar la creación del contenedor y fusionar automáticamente los cambios en la rama main si la pipeline se ejecuta correctamente.

## Versiones y Otros
| Tecnología/Herramienta      | Versión                       |
|-----------------------------|-------------------------------|
| Java                        | 17.0.6 (corretto-17)          |
| Spring Boot                 | 3.1.9                         |
| JUnit                       | 5                             |
| Docker                      | 0.0                           |
| Container OS                | Linux                         |
| H2 Database                 | 2.1.214                       |


## Tabla de Contenido

1. [Introducción](#introducción)
2. [Versiones y Otros](#versiones-y-otros)
3. [Tabla de Contenido](#tabla-de-contenido)
4. [Estructura del Proyecto](#estructura-del-proyecto)
5. [Instalación y Ejecución](#instalación-y-ejecución)
6. [Contenedor Docker](#contenedor-docker)
7. [Pipeline de CICD en Gitlab](#pipeline-de-cicd-en-gitlab)


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
│   │   │               │       └── UserRequestDTO.java
│   │   │               │   └── response/
│   │   │               │       └── UserResponseDTO.java
│   │   │               ├── exception/
│   │   │               │   └── UserException.java
│   │   │               ├── jpa/
│   │   │               │   └── entity/
│   │   │               │       └── UserRequestDTO.java
│   │   │               │   └── repository/
│   │   │               │       └── UserRepository.java
│   │   │               │       └── read/
│   │   │               │           └── UserRepositoryRead.java
│   │   │               │       └── write/
│   │   │               │           └── UserRepositoryWrite.java
│   │   │               │       └── impl/
│   │   │               │           └── UserRepositoryImpl.java
│   │   │               ├── service/
│   │   │               │   └── IUserService.java
│   │   │               │   └── impl/
│   │   │               │       └── UserServiceImpl.java
│   │   │               └── utils/
│   │   │                   └── JwtUtil.java
│   │   │                   └── RegExUtil.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       ├── java/
│       │   └── cl/
│       │       └── bci/
│       │           └── javatest/
|       |               ├── config/
│       │               │   └── TestConfig.java
│       │               ├── controller/
│       │               │   └── UserControllerTest.java
│       │               ├── integration/
│       │               │   └── UserIntegrationTest.java
│       │               └── service/
│       │                   └── UserServiceTest.java
│       └── resources/
├── Dockerfile
├── README.md
└── .gitlab-ci.yml
```


| Ruta                                                        | Descripción                                                                                         |
|-------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| **src/main/java/cl/bci/javatest/**                         | Contiene el código fuente de la aplicación.                                                         |
| **src/main/java/cl/bci/javatest/controller/**              | Contiene el controlador UserController que maneja las solicitudes HTTP.                             |
| **src/main/java/cl/bci/javatest/dto/**                     | Contiene los DTO (Data Transfer Objects) para la comunicación entre el controlador y el servicio.   |
| **src/main/java/cl/bci/javatest/jpa/entity/**              | Contiene la entidad User que representa los usuarios en la base de datos.                            |
| **src/main/java/cl/bci/javatest/jpa/repository/**          | Contiene la interfaz UserRepository para interactuar con la base de datos.                          |
| **src/main/java/cl/bci/javatest/exception/**               | Contiene la excepción InvalidInputException para manejar errores de entrada inválida.                |
| **src/main/java/cl/bci/javatest/service/**                 | Contiene la interfaz UserService y su implementación para la lógica de negocio.                     |
| **src/test/java/cl/bci/javatest/**                         | Contiene el proyecto con las pruebas unitarias.                                                     |
| **src/test/java/cl/bci/javatest/config/**                  | Contiene las clases de configuración de pruebas.                                                    |
| **src/test/java/cl/bci/javatest/controller/**              | Contiene las pruebas unitarias para los controladores.                                               |
| **src/test/java/cl/bci/javatest/integration/**             | Contiene las pruebas unitarias de integración.                                                      |
| **src/test/java/cl/bci/javatest/service/**                 | Contiene las pruebas unitarias para los servicios.                                                  |
| **src/test/java/cl/bci/javatest/utils/**                   | Contiene utilidades para las pruebas unitarias.                                                      |
| **src/test/resources/**                                   | Contiene recursos para las pruebas.                                                                  |
| **Dockerfile**                                            | Define la configuración para construir la imagen Docker del servicio.                                 |
| **README.md**                                             | Este archivo, que proporciona información sobre el proyecto y cómo utilizarlo.                        |
| **.gitlab-ci.yml**                                        | Configuración de la pipeline de CI/CD en Gitlab.                                                     |






## Instalación y Ejecución

Para ejecutar el proyecto localmente, sigue estos pasos:

1) Clona el repositorio:
```
git clone <URL del repositorio>
```

2) Navega al directorio del proyecto:
```
cd <nombre del proyecto>
```

3) Ejecuta la aplicación:
```
mvn spring-boot:run
```

6) Accede a la documentación de la API Swagger en http://localhost:8080/swagger-ui.html

7) Realiza las solicitudes HTTP al servicio según sea necesario.



## Ejecución de Pruebas Unitarias
Para ejecutar las pruebas unitarias, simplemente ejecuta el siguiente comando:
```
mvn test
```


## Contenedor Docker
Para ejecutar la aplicación en un contenedor Docker, primero debes construir la imagen Docker:
```
docker build -t user-registration-service .
```
Y luego ejecuta el contenedor:
```
docker run -p 8080:8080 user-registration-service
```


## Pipeline de CICD en Gitlab

La pipeline de CI/CD en Gitlab se ejecuta automáticamente cuando se hace un merge request de la rama develop a la rama main. La pipeline realiza las siguientes tareas:

1) Ejecuta las pruebas unitarias.
2) Construye la imagen Docker del servicio.
3) Verifica si la construcción del contenedor es exitosa.
4) Si la verificación es exitosa, hace merge automáticamente con la rama main.
5) Recuerda que debes configurar correctamente Gitlab CI/CD y Docker en tu entorno para que esta pipeline funcione correctamente.
