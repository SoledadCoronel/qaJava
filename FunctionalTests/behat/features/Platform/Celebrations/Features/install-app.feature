#language: es

Característica: Como usuario admin quiero instalar una aplicación de celebraciones

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

    @javascript @loadCelebrationsData
    Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles y procedo a instalar la aplicación de celebraciones.
        Dado presiono "Instalar Celebraciones"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y relleno "name" con "Celebraciones Corporativas"
        Y relleno "description" con "Descripción de Celebraciones Corporativas."
        Cuando presiono "accept"
        Entonces espero a que aparezca el contenido dinámico "Celebraciones Corporativas" en "body"

    @javascript @loadCelebrationsData
    Escenario: Instalo la aplicación de celebraciones para que se muestren las de 10 días antes a la fecha actual.
        Dado presiono "Instalar Celebraciones"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y relleno "name" con "Celebraciones Corporativas"
        Y relleno "description" con "Descripción de Celebraciones Corporativas."
        Y relleno "daysPast" con "10"
        Cuando presiono "accept"
        Entonces espero a que aparezca el contenido dinámico "Celebraciones Corporativas" en "body"

    @javascript @loadCelebrationsData
    Escenario: Instalo la aplicación de celebraciones para que muestren las del mes anterior.
        Dado presiono "Instalar Celebraciones"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y relleno "name" con "Celebraciones Corporativas"
        Y relleno "description" con "Descripción de Celebraciones Corporativas."
        Y selecciono del radio "displayStrategy" el valor "monthsPast"
        Y selecciono "anterior" de "monthsPast"
        Cuando presiono "accept"
        Entonces espero a que aparezca el contenido dinámico "Celebraciones Corporativas" en "body"

    @javascript @loadStandardData
    Escenario: No completo datos obligatorios.
        Dado presiono "Instalar Celebraciones"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Existen errores en el formulario" en ".alert-error"
