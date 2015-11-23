# language: es
Característica: Como usuario debo poder ingresar al detaller del album a ver las imagenes.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Resistance" en "#spaces"


    @javascript @loadGalleryData
    Escenario: Acceder al detalle de un album y visualizar las imagenes con scroll infinito
        Dado sigo "Mis fotos"
        Y espero a que aparezca el contenido dinámico "Skynet" en "#album-sidebar"
        Y sigo "Skynet"
