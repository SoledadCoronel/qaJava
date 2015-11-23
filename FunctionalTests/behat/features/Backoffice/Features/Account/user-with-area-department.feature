#language: es
Característica: Crear y editar un usuario en la plataforma desde el backoffice con área y departamento.

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Cuando sigo "Listar Cuentas"
        Entonces debe aparecer el contenido dinámico "Standard Account" en ".string-cell"
        Y hago click en ".dropdown-toggle"
        Y sigo "Listar plataformas de Standard Account"

    @javascript @loadStandardData
    Escenario: Crear un usuario con área y departamento
        Dado espero a que aparezca el contenido dinámico "Hugo" en ".string-cell"
        Y sigo "Hugo"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"
        Y espero a que aparezca el contenido dinámico "Nuevo usuario" en ".block-company-list"
        Y sigo "Nuevo usuario"
        Y espero a que aparezca el contenido dinámico "Áreas y departamentos" en ".hierarchy"
        Y espero a que aparezca el contenido dinámico "laboris" en ".selectable-parent"
        Y marco "enabled"
        Y relleno "name" con "Rodrigo"
        Y relleno "document" con "45454545"
        Y relleno "surname" con "Ledesma"
        Y relleno "usernameId" con "LedesmaRodrigo"
        # Selecciono un área
        Y hago click en ".selectable-parent li:eq(0)"
        Y espero a que aparezca el contenido dinámico "Administración" en ".selectable-child li:eq(1)"
        # Selecciono un departamento
        Y hago click en ".selectable-child li:eq(1)"
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Entonces espero a que aparezca el contenido dinámico "Rodrigo Ledesma" en ".backoffice-header"
        Y debo ver "Área"
        Y debo ver "laboris"
        Y debo ver "Departamento"
        Y debo ver "Administración"

    @javascript @loadStandardData
    Escenario: Editar un usuario con área y departamento
        Dado espero a que aparezca el contenido dinámico "Hugo" en ".string-cell"
        Y sigo "Hugo"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"
        Y espero a que aparezca el contenido dinámico "Listado de Usuarios" en ".backoffice-block"
        Y espero a que aparezca el contenido dinámico "Sarah Connor" en ".backgrid-user-list"
                # Edito Sarah Connor por que es el único usuario con área y departamento
        Y hago click y sigo ".action-icon:eq(3)"
        Y espero a que aparezca el contenido dinámico "Editar usuario" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "laboris" en ".selectable-parent .ms-selected"
        Y espero a que aparezca el contenido dinámico "Administración" en ".selectable-child .ms-selected"
                # Selecciono un área
        Y hago click en ".selectable-parent li:eq(1)"
        Y espero a que aparezca el contenido dinámico "Diseño" en ".selectable-child li:eq(1)"
                # Selecciono un departamento
        Y hago click en ".selectable-child li:eq(1)"
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Entonces espero a que aparezca el contenido dinámico "Sarah Connor" en ".backoffice-header"
        Y debo ver "Área"
        Y debo ver "duis"
        Y debo ver "Departamento"
        Y debo ver "Diseño"
