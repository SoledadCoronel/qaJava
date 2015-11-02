# language: es
Característica: Como usuario con permisos de administrador debo poder eliminar videos.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Entonces debo estar en "/"
        Y sigo "Mis fotos"
        Y espero a que aparezca el contenido dinámico "Album test" en "#album-sidebar"
        Y sigo "Album test"

    @javascript @loadGalleryData
        Escenario: Elimino un video que fue previamente subido.
        Dado la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y debe aparecer el contenedor dinámico ".album-image-item"
        Cuando hago click en ".album-image-item:first"
        Y espero a que aparezca el contenedor dinámico ".ui-dialog"
        Entonces hago click en ".modal-delete-button"
        Y espero a que aparezca el contenedor dinámico "#delete-modal"
        Y presiono "Confirmar"
        Y no debo ver "Video 01"
        Y la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"

    @javascript @loadGalleryData
        Escenario: Elimino un video que fue previamente subido desde edición de galería.
        Dado la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y hago click en ".editar .dropdown-toggle"
        Y sigo "Editar"
        Entonces hago click en ".uploaded-images .delete-btn:first"
        Y espero a que aparezca el contenedor dinámico "#delete-modal"
        Y presiono "Confirmar"
        Y no debo ver "Video 01"
        Y presiono "Guardar"
        Y la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"

    @javascript @loadGalleryData
        Escenario: Elimino un video fallido
        Dado la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y debe aparecer el contenedor dinámico ".album-image-item"
        Y debo ver "Se ha producido un error. Por favor vuelva a subir el video"
        Cuando hago click en ".delete-btn"
        Y espero a que aparezca el contenido dinámico "Eliminar video" en "#delete-modal-label"
        Entonces presiono "Confirmar"
        Y espero a que aparezca el contenedor dinámico ".item-off"
