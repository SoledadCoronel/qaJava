# language: es
Característica: Como usuario con permisos de administrador debo poder subir imágenes.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadGalleryData
    Escenario: Desde la página principal de la plataforma ingreso a la aplicación de Galerías y subo un archivo no permitido a través de la opción "Subir imagen/video" del menú del cabezal. Entonces debo ver el error correspondiente.
        Dado estoy en "/"
        Y sigo "Mis fotos"
        Cuando hago click en "#content-upload"
        Y hago visible "content-upload"
        Y adjunto el archivo "test.txt" a "file"
        Entonces debe aparecer el contenido dinámico "Este archivo no es de un tipo válido de imagen: test.txt" en "#upload-errors"

    @javascript @loadGalleryData
    Escenario: Subo una imagen
        Dado estoy en "/"
        Y sigo "Mis fotos"
        Y hago click en "#content-upload"
        Y adjunto el archivo "tyrion-grande.jpg" a "file"
        Y relleno "title" con "Tyrion"
        Y hago click en "#albumId .dropdown-toggle"
        Y espero a que aparezca el contenido dinámico "Skynet" en ".dropdown-backbone-select"
        Y sigo "Skynet"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"

    @javascript @loadGalleryData
    Escenario: Subo una imagen y creo un album
      Dado estoy en "/"
      Y sigo "Mis fotos"
      Y hago click en "#content-upload"
      Y adjunto el archivo "tyrion-grande.jpg" a "file"
      Y relleno "title" con "Tyrion"
      Y hago click en "#albumId .dropdown-toggle"
      Y espero a que aparezca el contenido dinámico "Skynet" en ".dropdown-backbone-select"
      Y completo campo ".dropdown-new-item #albumId" con "Album nuevo"
      Cuando presiono "Guardar"
      Y espero a que cambie la URL
      Entonces la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"

    @javascript @loadGalleryData
    Escenario: Subo una imagen con título incorrecto
        Dado estoy en "/"
        Y sigo "Mis fotos"
        Y hago click en "#content-upload"
        Y adjunto el archivo "tyrion-grande.jpg" a "file"
        Cuando relleno "title" con "€"
        Y presiono "Guardar"
        Entonces debo ver "El título contiene caracteres inválidos."

    @javascript @loadGalleryData
    Escenario: Subo una imagen, la elimino e intento subir otra imagen
        Dado estoy en "/"
        Y sigo "Mis fotos"
        Y hago click en "#content-upload"
        Y adjunto el archivo "tyrion-grande.jpg" a "file"
        Y relleno "title" con "Tyrion"
        Y hago click en ".delete-btn"
        Y espero a que aparezca el contenido dinámico "Eliminar imagen" en "body"
        Cuando hago click en ".confirm-delete"
        Entonces no debo ver "Tyrion"
        Y hago visible "contents-upload-new"
        Y adjunto el archivo "tyrion.jpg" a "contents-upload-new"
        Y hago click en "#albumId .dropdown-toggle"
        Y espero a que aparezca el contenido dinámico "Skynet" en ".dropdown-backbone-select"
        Y sigo "Skynet"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/app/galleries/\d+/album/\d+"
