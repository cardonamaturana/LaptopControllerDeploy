# Imagen base de Java
FROM openjdk:17

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR del controlador REST en el contenedor
COPY target/OpenBootcampCrudApiRest-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Exponer el puerto en el que se ejecuta la aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "/app/myapp.jar"]
