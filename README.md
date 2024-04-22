# Laboratorio N°1 - Taller de Bases de Datos

Laboratorio de Taller de Bases de Datos desarrollado por el equipo 6.

## Integrantes
* [Javiera Godoy](https://github.com/JavieraGodoy)
* [Ignacio Lara](https://github.com/kappita)
* [David Martinez](https://github.com/davidmartinez-esc)
* [Claudio Palma](https://github.com/claudiopalma2001)
* [Paloma Zepeda](https://github.com/cukidev)

## Descripción
PóneleVoluntAPP surge como solución a la necesidad de coordinar eficazmente el flujo de voluntarios espontáneos en situaciones de emergencia en Chile. 

Esta plataforma facilita la gestión de esfuerzos voluntarios, emparejando habilidades y disponibilidades con las necesidades específicas de cada emergencia, y permitiendo a los coordinadores organizar y asignar tareas de forma estratégica para una respuesta ágil y efectiva ante desastres naturales.

El repositorio incluye las siguientes carpetas principales:
* [Carpeta Backend](https://github.com/kappita/lab1-tdb/tree/main/backend): Contiene todo el Backend y las clases de las entidades las cuales se distribuyen en los paquetes: Controllers, Entities, Services y Repositories.
* [Carpeta Frontend](https://github.com/kappita/lab1-tdb/tree/main/frontend): Contiene todo el Frontend y las vistas utilizadas con Vue.
* [Carpeta Database](https://github.com/kappita/lab1-tdb/tree/main/database); Contiene el archivo dbCreate.sql, el cual contiene el script para crear la Base de Datosy el archivo loadData.sql, que sirve para poblar las tablas.

## Requisitos y Versiones de las Tecnologías.

* [Postgres SQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) versión 12 o superior.
* [SQL2O](https://www.sql2o.org/) versión 1.6.0.
* [JJWT](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt) versión 0.12.5.
* [PgAdmin](https://www.pgadmin.org) versión 4.
* [IntelliJ IDEA Ultimate](https://www.jetbrains.com/es-es/idea/download/#section=windows) versión 2024.1, aunque debería funcionar con cualquier versión.
* JDK Versión 17.
* [VUE](https://es.vuejs.org/v2/guide/installation) versión 2.x.
* [axios](https://axios-http.com/es/) versión 1.6.8.
* [Postman](https://www.postman.com/downloads/) versión Postman 10.24.22.

## Instrucciones de Instalación.

1. Clonar el repositorio: Esto proporcionará las tres carpetas principales para el proyecto de Laboratorio. Para clonarlo, se debe usar el siguiente comando en el directorio deseado:
```sh
git clone https://github.com/kappita/lab1-tdb.git
```
2. Instalar PostgreSQL y PGAdmin4: Para ello, se puede instalar un pack en conjunto desde el siguiente [link](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads). Se debe seleccionar la versión deseada para el Sistema Operativo deseado y seguir las instrucciones de instalación. Durante la instalación es necesario configurar un **username** y un **password** para utilizar con PostgreSQL. Estos serán luego necesarios para la creación de la Base de Datos junto con sus tablas.
**DISCLAIMER: Para poder conectarse a la Base de Datos correctamente, se deben configurar las mismas credenciales que están puestas en [aplication.properties](https://github.com/kappita/lab1-tdb/blob/main/backend/src/main/resources/application.properties) en el backend.**

3. Instalar IntelliJ IDEA Ultimate: Ingresar al sitio web oficial de IntelliJ IDEA y seleccionar una opción dependiendo del Sistema Operativo que use:
* Para Windows, utilizar el siguiente [link](https://www.jetbrains.com/idea/download/#section=windows).
* Para Linux, utilizar el siguiente [link](https://www.jetbrains.com/es-es/idea/download/#section=linux).
* Para MacOs, utilizar el siguiente [link](https://www.jetbrains.com/es-es/idea/download/#section=mac).
4. Abrir IntelliJ IDEA Ultimate, abrir un nuevo proyecto y seleccionar la carpeta **Backend**. Debemos esperar unos minutos a que el proyecto se configure y se instalen los plugins necesarios.
5. Configurar las credenciales del aplication.properties del disclaimer del punto 2.
6. Configurar el JDK: Al abrir una clase IntelliJ nos solicitará configurar un JDK. Debemos asegurarnos de seleccionar JDK versión 17. De no tener JDK 17, IntelliJ nos proporciona una opción para instalarlo automáticamente.
- Si no nos aparece esta opción porque ya tenía IntelliJ instalado anteriormente, basta con ir a la navbar. File -> Proyect Structure. En esa sección en el apartado de SDK, se podrá cambiar la versión.
7. Ir al siguiente [link](https://nodejs.org/en/) e instalar la última versión de Node.js, siguiendo las instrucciones de instalación.
8. Abrir una consola / terminal dentro de la carpeta **Frontend** y aplicar el siguiente comando, el cual instalará todas las dependencias necesarias para el proyecto:
```sh
npm install
```
* Si por algún motivo lo anterior falla, se puede utilizar:
```sh
npm install --force
```
9. Ir al siguiente [link](https://www.postman.com/downloads/) e instalar la última versión de Postman.

Una vez finalizado estos nueve pasos, podemos seguir con las instrucciones de uso.

## Instrucciones de Uso.

## Instrucciones de uso
1. En PgAdmin, crear una BD llamada "Tebede", ir a Schemas -> Public y seleccionar la opción "Query tool", y abrir el archivo dbCreate.sql

2. Abrir el archivo loadData.sql y ejecutarlo en la Query tool.
4. Utilizando IntelliJ IDEA Ultimate, asegurarse de que se detecte correctamente Spring Boot y Gradle. Ejecutar la aplicación haciendo click en la opción "Run" dentro de IntelliJ IDEA.
6. Dentro de la carpeta Frontend, abrir una consola / terminal. Ejecutar el siguiente comando:
```sh
npm install
```
Una vez instalado, ejecutar el siguiente comando:
```sh
npm run dev
```
7. Con esto ya tenemos levantado FrontEnd y Backend.
8. Para probar el CRUD de una tabla, debemos colocar la ruta en Postman (Por ejemplo, **localhost:8080/{voluntarios o el nombre de la tabla}/{save,delete,update,getById,getAll}**). Luego seleccionar uno de los métodos a aplicar, dependiendo de si quieres crear, mostrar, editar o eliminar un elemento.
9. Para ir a la vista de Registro, por ejemplo, se debe ir a http://localhost:5173/registro.
