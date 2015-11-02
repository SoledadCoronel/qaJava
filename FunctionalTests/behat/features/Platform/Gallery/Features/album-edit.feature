# language: es

Característica: Como usuario con permisos de administrador debo poder subir imágenes.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Y debo estar en "/"
        Y sigo "Mis fotos"
        Y espero a que aparezca el contenido dinámico "Skynet" en "#album-sidebar"
        Y sigo "Skynet"
        Cuando hago click en "#album-actions"
        Y sigo "Editar"
        Entonces la URL debe seguir el patrón "/app/galleries/\d+/album/\d+/edit"
        Y espero a que aparezca el contenedor dinámico ".album-item"

    @javascript @loadGalleryData
    Escenario: Accedo a editar, agrego una imagen, edito el título de otra y cambio el título del album
        Dado relleno "name" con "Skynet modificado"
        Y hago visible "contents-upload-new"
        Y adjunto el archivo "auto.jpg" a "contents-upload-new"
        Y debe aparecer el contenedor dinámico ".album-item"
        Y completo campo "input[name=\'title\']:first" con "Tyrion modificado"
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y espero a que aparezca el contenedor dinámico ".span18"
        Y debo ver "Skynet modificado"
        Y debo ver la imagen "Tyrion modificado"

    @javascript @loadGalleryData
    Escenario: Desde la página principal de la plataforma ingreso a la aplicación de Galerías y subo un archivo no permitido a través de la opción "Subir Imagen" del menú desplegable del cabezal. Entonces debo ver el error correspondiente.
        Dado hago click en ".delete-btn:first"
        Y espero a que aparezca el contenido dinámico "Eliminar imagen" en "body"
        Y hago click en ".confirm-delete"
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y espero a que aparezca el contenedor dinámico ".span18"
        Y no debo ver "Tyrion 0"


