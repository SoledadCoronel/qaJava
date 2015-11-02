# language: es
Característica: Postear en mi muro
                Como usuario de frontend quiero poder postear un archivo en mi muro

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "sarahconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadStandardData
    Escenario: Desde mi perfil debo poder publicar un post de archivo.
        Dado voy a "/profile"
        Entonces espero a que aparezca el contenido dinámico "Archivo" en "body"
        Cuando hago click en ".post-file a:first"
        Y espero a que aparezca el contenido dinámico "Subir archivos desde mi computadora" en ".post-form"
        Y hago visible "attachmentUpload"
        Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
        Y espero a que la barra de progreso ".progress" se cargue completamente
        Y relleno "post-file-input" con "La evolución del hombre según los Simpsons"
        Cuando presiono "post-file"
        Y espero a que aparezca el contenido dinámico "La evolución del hombre según los Simpsons" en ".all-feeds.wall-feed"


    @javascript @loadStandardData
    Escenario: Desde mi perfil no debo poder publicar un post con un archivo prohibido
        Dado voy a "/profile"
        Entonces espero a que aparezca el contenido dinámico "Archivo" en "body"
        Cuando hago click en ".post-file a:first"
        Y espero a que aparezca el contenido dinámico "Subir archivos desde mi computadora" en ".post-form"
        Y hago visible "attachmentUpload"
        Y adjunto el archivo "forbidden-file.exe" a "attachmentUpload"
        Y espero a que aparezca el contenido dinámico "Hubo un problema al subir el archivo: La extensión del archivo no es válida" en "body"

    @javascript @loadStandardData
    Escenario: Desde mi perfil debo poder subir un archivo y eliminarlo antes de publicar.
        Dado voy a "/profile"
        Y espero a que aparezca el contenido dinámico "Archivo" en "body"
        Cuando hago click en ".post-file a"
        Y espero a que aparezca el contenido dinámico "Subir archivos desde mi computadora" en ".post-form"
        Y hago visible "attachmentUpload"
        Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
        Y espero a que la barra de progreso ".progress" se cargue completamente
        Y hago click en "a.deleteUploadedFile"
        Entonces espero a que aparezca el contenido dinámico "Desde mi PC" en ".post-form"
