# Usar una imagen de Gradle para compilar y ejecutar pruebas unitarias
FROM gradle:8.7-jdk17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo de compilación y las dependencias Gradle
COPY build.gradle .
COPY settings.gradle .
COPY gradle.properties .
COPY gradlew .
COPY gradle/ ./gradle

# Copiar el código fuente
COPY src/ src/

# Compilar el proyecto y ejecutar pruebas unitarias
RUN ./gradlew build

# Usar una imagen de OpenJDK 17 como base para el contenedor final
FROM adoptopenjdk/openjdk17:alpine-jre

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo JAR de la aplicación compilada desde el contenedor de compilación
COPY --from=build /app/build/libs/tu_aplicacion.jar .

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
CMD ["java", "-jar", "tu_aplicacion.jar"]
