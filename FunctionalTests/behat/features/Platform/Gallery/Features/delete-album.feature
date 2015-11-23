# language: es
Característica: Como usuario Administrador debo poder borrar un album.

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
        Y la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y debe aparecer ".album-grid"
        Y hago click en "#album-actions"
        Y hago click en ".delete-album-header"
        Y espero a que aparezca el contenido dinámico "Eliminar álbum" en "body"
        Cuando hago click en ".confirm-delete"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/app/galleries/\d+"
        Y no debo ver "Skynet"


