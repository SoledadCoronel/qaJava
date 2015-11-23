# language: es

Característica: Como usuario con permisos de administrador debo poder subir videos.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    # Test ignorado temporalmente hasta estabilizar el entorno de Jenkins.
    @ignore @javascript @loadGalleryData
    Escenario: Subo un video
        Dado estoy en "/"
        Y sigo "Galería Corporativa"
        Y hago click en "#content-upload"
        Y adjunto el archivo "video.mp4" a "file"
        Y relleno "title" con "Video de prueba"
        Y hago click en "#albumId .dropdown-toggle"
        Y espero a que aparezca el contenido dinámico "Empire" en ".dropdown-backbone-select"
        Y sigo "Empire"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
        Y espero a que aparezca el contenedor dinámico ".album-item"
        Y debo ver la imagen "Video de prueba"
