[![Build Status](https://travis-ci.org/rubensa/reservas-server.svg)](https://travis-ci.org/rubensa/reservas-server)
[![codecov](https://codecov.io/gh/rubensa/reservas-server/branch/master/graph/badge.svg)](https://codecov.io/gh/rubensa/reservas-server)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=rubensa_reservas-server&metric=alert_status)](https://sonarcloud.io/dashboard?id=rubensa_reservas-server)
[![Heroku](https://heroku-badge.herokuapp.com/?app=rubensa-reservas-server&style=flat&svg=1)](https://rubensa-reservas-server.herokuapp.com/)
[![Website](https://img.shields.io/website?down_color=red&down_message=down&label=GitHub%20Pages&up_color=green&up_message=up&url=https%3A%2F%2Frubensa.eu.org%2Freservas-server%2Findex.html)](https://rubensa.github.io/reservas-server/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# Plataforma web para la gestión de reservas de aulas y espacios comunes en la Escuela Politécnica de Ingeniería de Gijón

Los administradores de la plataforma podrán definir los recursos disponibles (tales como aulas, salas de reuniones, etc.), así como definir el calendario o las fechas en las que estos recursos pueden ser utilizados. Los usuarios de la plataforma podrán visualizar las reservas efectuadas, así como conocer la disponibilidad de un determinado recurso en un período de tiempo dado o para una fecha concreta. La plataforma soportará carga masiva de datos, para lo que se definirán ficheros de intercambio con las herramientas actuales de gestión de horarios de la Escuela y del sistema de gestión académica SIES.

Las tecnologías a utilizar serán **Java** para la parte del back-end usando como framework de desarrollo **Spring** y **Java Script** para la parte del front-end usando como framework de desarrollo **Angular**.

## Desarrollo

Este proyecto está configurado para ser editado en **[VSCode](https://code.visualstudio.com/)** y sus extensiones para **[Desarrollo Remoto](https://code.visualstudio.com/docs/remote/remote-overview)**.

Concretamente el desarrollo se realiza en un contenedor **Docker** (es necesario tener instalado Docker en tu equipo) con una imagen con **Java 11** y **Maven 3.6**.

Antes de abrir el proyecto en el contedor usando **VSCode**, es necesario adaptar los siguiente parámetros en el fichero **./devcontainer/devcontainer.json**:
*  **runArgs**
    *  **"-u", "1000:1000"**: 1000:1000 se debe cambiar por tu UID, GID.  Para conocerlos puedes ejecutar el comando `echo "$(id -u):$(id -g)"` en una consola.
*   **"--group-add", "1001"**: 1001 se debe cambiar por el GID del grupo **docker**.  Para conocerlo puedes ejecutar el comando `cut -d: -f3 < <(getent group docker)` en una consola.
*   **"--mount", "type=bind,source=/usr/bin/docker,target=/home/user/.local/bin/docker"**: Asegúrate que **/usr/bin/docker** es la ruta correcta al binario de tu instalación de docker local.  Si no es así, actualíza dicha ruta.

Además, deben existir los siguientes directorios en tu directorio **HOME**:
*  **.sdkman/archives**: Se usa para compartir las distribuciones descargadas de Java y Maven entre el host y el contenedor.
*  **.m2/repository**: Se usa para compartir el repositorio de Maven entre el host y el contenedor.
*  **.ssh**: Se usa para compartir las credenciales ssh entre el host y el contenedor.
*  **.gitconfig**: Se usa para compartir la configuración de git entre el host y el contenedor.

## Ejecución de la aplicación

Para ejecutar la aplicación, ejecuata el siguiente comando en una consola del VSCode `./mvnw spring-boot:run`. Navega a `http://localhost:8080/`.
