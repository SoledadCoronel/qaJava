# language: es
Característica: Como usuario comun debo poder ingresar a la home de la aplicación y ver los albums de la galeria

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Resistance" en "#spaces"

    @javascript @loadAlbumsData
    Escenario: Acceder al homey ver los albumes
        Dado sigo "Mis fotos"
        Y debe aparecer ".album-container"
        Entonces debo ver "Album 1"
