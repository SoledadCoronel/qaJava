# language: es
Característica: Como usuario básico/admin quiero poder ver el detalle de una foto/vídeo para poder ver la foto/vídeo y su contenido social.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Resistance" en "#spaces"
        Y sigo "Mis fotos"
        Y espero a que aparezca el contenido dinámico "Skynet" en "#album-sidebar"
        Y sigo "Skynet"

    @javascript @loadGalleryData
    Escenario: Acceder al detalle de una imagen con social habilitado
        Dado la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y debe aparecer el contenedor dinámico ".album-image-item"
        Cuando hago click en ".album-image-item:first"
        Y espero a que aparezca el contenedor dinámico ".ui-dialog"
        Entonces debe aparecer el contenedor dinámico ".pic img"
        Y debe aparecer el contenedor dinámico ".social-right"

    @javascript @loadGalleryData
    Escenario: Acceder al detalle de una imagen y eliminarla
        Dado la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y debe aparecer el contenedor dinámico ".album-image-item"
        Cuando hago click en ".album-image-item:first"
        Y espero a que aparezca el contenedor dinámico ".ui-dialog"
        Y debe aparecer el contenedor dinámico ".pic img"
        Y hago click en ".modal-delete-button"
        Y espero a que aparezca el contenido dinámico "Confirmar" en "#delete-modal"
        Entonces hago click en ".confirm-delete"
        Y debe aparecer el contenedor dinámico ".item-off"
