# language: es
Característica: Como Administrador debo poder crear Albums.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Espacio Público" en "#spaces"
        Y sigo "Galería"
        Y espero a que aparezca el contenido dinámico "ÁLBUMES" en "#album-sidebar"

    @javascript @loadGalleryDataProvisional
    Escenario: Crear un Album
        Dado hago click en "#albumes"
        Y espero a que aparezca el contenido dinámico "Nuevo" en ".dropdown-menu"
        Y hago click en ".new-album-header"
        Y espero a que aparezca el contenido dinámico "Nuevo Álbum" en "body"
        Y relleno "album-name" con "Este es un nuevo album"
        Cuando hago click en ".album-save"
        Entonces espero a que aparezca el contenido dinámico "Este es un nuev..." en "#album-sidebar"

    @javascript @loadGalleryDataProvisional
    Escenario: Crear un Album con mas de 80 caracteres
        Dado hago click en "#albumes"
        Y espero a que aparezca el contenido dinámico "Nuevo" en ".dropdown-menu"
        Y hago click en ".new-album-header"
        Y espero a que aparezca el contenido dinámico "Nuevo Álbum" en "body"
        Y relleno "album-name" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam arcu nisi, imperdiet metus."
        Cuando hago click en ".album-save"
        Entonces espero a que aparezca el contenido dinámico "El título supera el máximo de 80 caracteres" en "form"

    @javascript @loadGalleryDataProvisional
    Escenario: Crear un Album con el titulo vacio
        Dado hago click en "#albumes"
        Y espero a que aparezca el contenido dinámico "Nuevo" en ".dropdown-menu"
        Y hago click en ".new-album-header"
        Y espero a que aparezca el contenido dinámico "Nuevo Álbum" en "body"
        Cuando hago click en ".album-save"
        Entonces espero a que aparezca el contenido dinámico "El título del álbum es requerido" en "form"

    @javascript @loadGalleryDataProvisional
    Escenario: Crear un Album con caracteres invalidos
        Dado hago click en "#albumes"
        Y espero a que aparezca el contenido dinámico "Nuevo" en ".dropdown-menu"
        Y hago click en ".new-album-header"
        Y espero a que aparezca el contenido dinámico "Nuevo Álbum" en "body"
        Y relleno "album-name" con "___"
        Cuando hago click en ".album-save"
        Entonces espero a que aparezca el contenido dinámico "El título contiene caracteres inválidos" en "form"

    @javascript @loadGalleryDataProvisional
    Escenario: Crear un Album con titulo duplicado
        Dado hago click en "#albumes"
        Y espero a que aparezca el contenido dinámico "Nuevo" en ".dropdown-menu"
        Y hago click en ".new-album-header"
        Y espero a que aparezca el contenido dinámico "Nuevo Álbum" en "body"
        Y relleno "album-name" con "Este es un nuevo album"
        Y hago click en ".album-save"
        Y espero a que aparezca el contenido dinámico "Este es un nuev..." en "#album-sidebar"
        Y hago click en ".new-album-header"
        Y espero a que aparezca el contenido dinámico "Nuevo Álbum" en "body"
        Y relleno "album-name" con "Este es un nuevo album"
        Cuando hago click en ".album-save"
        Entonces espero a que aparezca el contenido dinámico "Ya existe un álbum con el mismo nombre" en "form"
