# language: es
Característica: Como usuario básico/admin quiero poder ver el detalle de un vídeo.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Resistance" en "#spaces"
        Y sigo "Mis fotos"
        Y espero a que aparezca el contenido dinámico "Album test" en "#album-sidebar"
        Y sigo "Album test"

    @javascript @loadGalleryData
    Escenario: Acceder al detalle de un video con social habilitado
        Dado la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y debe aparecer el contenedor dinámico ".album-image-item"
        Cuando hago click en ".album-image-item:first"
        Y espero a que aparezca el contenedor dinámico ".ui-dialog"
        Entonces debe aparecer el contenedor dinámico ".pic #video-player"
        Y espero a que aparezca el contenedor dinámico ".vjs-tech"
        Y debe aparecer el contenedor dinámico ".social-right"
        Y espero a que aparezca el contenido dinámico "Video 01" en "#album-image-title"
