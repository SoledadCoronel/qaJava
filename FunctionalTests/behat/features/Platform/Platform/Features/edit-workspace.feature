# language: es
Característica: Crear espacios en los ambientes de la plataforma

Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

    @javascript @loadWorkspaceStandardData
    Escenario: Editar espacio del ambiente default cuando me logueo en la plataforma como usuario admin
        Dado sigo "Inicio"
        Y espero a que aparezca el contenido dinámico "Intranet" en "li.nav-header"
        Y hago click en ".workspace-menu:first"
        Y sigo "Configurar"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        Y relleno "name" con "Intranet editado"
        Y relleno "description" con "Editando los datos"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"

    @javascript @loadWorkspaceStandardData
    Escenario: Editar espacio activado a desactivado
        Dado sigo "Inicio"
        Y espero a que aparezca el contenido dinámico "Intranet" en "li.nav-header"
        Y hago click en ".workspace-menu:first"
        Y sigo "Configurar"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        Y selecciono del radio "disable" el valor "1"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"

    @javascript @loadWorkspaceStandardData
    Escenario: Editar espacio con el nombre de uno existente en el mismo ambiente
        Dado sigo "Inicio"
        Y espero a que aparezca el contenido dinámico "Intranet" en "li.nav-header"
        Y hago click en ".workspace-menu:first"
        Y sigo "Configurar"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        Y relleno "name" con "Segundo espacio"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "El nombre del espacio ya existe para este ambiente" en ".alert-error"

    @javascript @loadWorkspaceStandardData
    Escenario: Editar espacio con url externa
        Dado sigo "Institucional"
        Y debo ver "Con url"
        Y hago click en ".workspace-menu:first"
        Y sigo "Configurar"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        Y relleno "externalUrl" con "http://www.youtube.com"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"

    @javascript @loadWorkspaceStandardData
    Escenario: Editar un espacio con url externa, quitándosela y el espacio quede listo para instalar apps
        Dado sigo "Institucional"
        Y hago click en ".workspace-menu:first"
        Y sigo "Configurar"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        Y presiono "close-url"
        Y debo ver "Aplicaciones visibles"
        Y relleno "visibleApp" con "2"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"

    @javascript @loadWorkspaceListData
    Escenario: Editar un espacio con apps instaladas para que sea con url externa
        Dado sigo "Inicio"
        Y espero a que aparezca el contenido dinámico "Comunidad tres tiras" en "li.nav-header"
        Y hago click en ".workspace-menu:first"
        Y sigo "Configurar"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        Y sigo "Direccionar a una URL externa"
        Y no debo ver "Aplicaciones visibles"
        Y relleno "externalUrl" con "http://www.google.com"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"

    @javascript @loadWorkspaceListData
    Escenario: Editar un espacio para etiquetarlo como 'nuevo'
        Dado sigo "Inicio"
        Y espero a que aparezca el contenido dinámico "Comunidad tres tiras" en "li.nav-header"
        Y hago click en ".workspace-menu:first"
        Y sigo "Configurar"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        Y hago click en "#workspace-label"
        Y relleno "labelDate" con la fecha de hoy
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"
        Y debo ver "NUEVO"

    @javascript @loadWorkspaceWithCollaborators
    Escenario: Editar espacio agregando colaboradores
        Dado sigo "Inicio"
        Y espero a que aparezca el contenido dinámico "Comunidad tres tiras" en "li.nav-header"
        Y hago click en ".workspace-menu:first"
        Y debo ver "Configurar espacio"
        Y sigo "Configurar espacio"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        # Agrego colaboradores.
        Y presiono "Agregar colaboradores"
        Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en "#addcolabsresponsive"
        Y hago click en "button.btnSelectCollaborator:eq(2)"
        Y espero a que aparezca el contenido dinámico "Quitar" en "button.btnSelectCollaborator:eq(2)"
        Y hago click en "#btnJoin"
        Y hago click en "a.btn.btn-primary.pull-left"
        # Compruebo que los colaboradores se agregaron correctamente luego de guardar.
        Y hago click en "#added-collabs-btn"
        Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".infinite-scroll-list"
        Y hago click en "a.btn.btn-primary.pull-left"
        
    @javascript @loadWorkspaceWithCollaborators
    Escenario: Editar espacio agregando colaboradores con paginacion
      Dado sigo "Inicio"
      Y espero a que aparezca el contenido dinámico "Comunidad tres tiras" en "li.nav-header"
      Y hago click en ".workspace-menu:first"
      Y debo ver "Configurar espacio"
      Y sigo "Configurar"
      Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
      # Agrego colaboradores
      Dado presiono "Agregar colaboradores"
      Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en "#addcolabsresponsive"
      Cuando escroleo "div.add-colabs" hacia abajo 1000 px
      Y espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en "#addcolabsresponsive"
      Y hago click en "button.btnSelectCollaborator"
      Y hago click en "#btnJoin"
      Y espero a que aparezca el contenido dinámico "Quitar" en "button.btnSelectCollaborator:eq(1)"
      # Compruebo que los colaboradores se agregaron correctamente luego de guardar.
      Y hago click en "#added-collabs-btn"
      Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".infinite-scroll-list"
      Y hago click en "a.btn.btn-primary.pull-left"

    @javascript @loadWorkspaceWithCollaborators
    Escenario: Editar espacio agregando colaboradores con filtro
      Dado sigo "Inicio"
      Y espero a que aparezca el contenido dinámico "Comunidad tres tiras" en "li.nav-header"
      Y hago click en ".workspace-menu:first"
      Y debo ver "Configurar espacio"
      Y sigo "Configurar"
      Y espero a que aparezca el contenido dinámico "Guardar" en "#save"

      # Agrego colaboradores
      Dado presiono "Agregar colaboradores"
      Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en "#addcolabsresponsive"

      Y relleno "filters_fullname" con "Apellido 50"

      Y espero a que aparezca el contenido dinámico "Nombre 50 Apellido 50" en "#addcolabsresponsive"
      Y hago click en "button.btnSelectCollaborator"
      Y hago click en "#btnJoin"

      # Compruebo que fueron agregados
      Y espero a que aparezca el contenido dinámico "Quitar" en "button.btnSelectCollaborator"
      Y hago click en "#added-collabs-btn"
      Y espero a que aparezca el contenido dinámico "Nombre 50 Apellido 50" en ".infinite-scroll-list"

    @javascript @loadWorkspaceWithCollaborators
    Escenario: Quitar los colaboradores agregados
       Dado sigo "Inicio"
        Y espero a que aparezca el contenido dinámico "Comunidad tres tiras" en "li.nav-header"
        Y hago click en ".workspace-menu:first"
        Y debo ver "Configurar espacio"
        Y sigo "Configurar espacio"
        # Espero que aparezca el formulario controlando que el boton save exista
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
        # Agrego colaboradores.
        Y presiono "Agregar colaboradores"
        Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en "#addcolabsresponsive"
        Y hago click en "button.btnSelectCollaborator:eq(1)"
        Y espero a que aparezca el contenido dinámico "Quitar" en "button.btnSelectCollaborator:eq(1)"
        Y hago click en "button.btnSelectCollaborator:eq(1)"
        Y espero a que aparezca el contenido dinámico "Agregar" en "button.btnSelectCollaborator:eq(1)"
 
