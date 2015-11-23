#language: es
Característica: Administrar álbumes en una aplicación de galerías

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Resistance" en "#workspaces"
      Y sigo "Mis fotos"
      # @todo Una vez que haya contenido real cambiar esto esperando que aparezca ese contenido
      #Y espero a que aparezca el contenido dinámico "Titulo del álbum" en "body"
      Y espero a que aparezca el contenido dinámico "ÁLBUMES" en "#album-sidebar"
      Y hago click en "#albumes"
      Y espero a que aparezca el contenido dinámico "Administrar albumes" en ".dropdown-menu"
      Y sigo "Administrar albumes"
      Y espero a que aparezca el contenido dinámico "Album 1" en "#album-grid"

    @javascript @loadAlbumsData
    Escenario: Ordenar albumes
    Cuando muevo "Album 1" a "Album 2" en "ul#albums-list"
    Y espero a que aparezca el contenido dinámico "Se cambió el orden de los álbumes" en ".alert-success"
    Entonces el orden de "ul.albums-list span.album-name" debe ser "Album 2,Album 1"


    @javascript @loadAlbumsData
    Escenario: Crear un nuevo álbum
    Y presiono "new-album-btn"
    Y relleno "name" con "Album nuevo"
    Y presiono "btn-album-save"
    Y espero a que aparezca el contenido dinámico "Album nuevo" en "#album-grid"


    @javascript @loadAlbumsData
    Escenario: Editar un álbum
    Y hago click en "ul#albums-list i.icon-pencil:first"
    Y relleno "name" con "Album de prueba 1 modificado"
    Y presiono "btn-album-save"
    Y espero a que aparezca el contenido dinámico "Album de prueba 1 modificado" en "#album-grid"


    @javascript @loadAlbumsData
    Escenario: Eliminar un álbum
    Y hago click en "ul#albums-list i.icon-trash:first"
    Y espero a que aparezca el contenedor dinámico "#delete-modal"
    Y confirmo la eliminación presionando "Confirmar"
    Y espero a que desaparezca el contenido dinámico "Album  1" en "#album-list"
