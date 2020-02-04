# Start with a base image containing Java runtime
FROM openjdk:8-jre-alpine

# Add Maintainer Info
LABEL maintainer="rubensa@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's exploded jar file
ARG DEPENDENCY

# Add the application's jar to the container
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

# Run the app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-cp","app:app/lib/*","org.eu.rubensa.uniovi.reservas.ReservasServerApplication"]