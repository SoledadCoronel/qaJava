#language: es

Característica: Instalar una aplicación de Novedades en la plataforma.
    Como usuario administrador de la plataforma quiero poder instalar una aplicación de Novedades en un espacio.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y sigo "Inicio"
        Y espero a que aparezca el contenedor dinámico ".workspace-menu"
        Y hago click en ".workspace-menu:first"
        Y sigo "Agregar aplicación"
        Y la URL debe seguir el patrón "workspace/\d+/app/list"
        Y espero a que aparezca el contenedor dinámico ".application-preview"

    @javascript @loadStandardUserData
    Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles y procedo a instalar la aplicación de Novedades.
        Dado presiono "Instalar Novedades"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y espero a que aparezca el contenido dinámico "Nombre de la aplicación" en ".application-form"
        Y relleno "name" con "Novedades Corporativas"
        Y relleno "description" con "Descripción de Novedades Corporativas."
        Cuando presiono "accept"
        Entonces espero a que cambie la URL
        Y la URL debe seguir el patrón "/app/news/\d+"
