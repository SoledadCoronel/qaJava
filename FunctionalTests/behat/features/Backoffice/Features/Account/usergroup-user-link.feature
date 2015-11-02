# language: es
Característica: Relacionar usuario a un grupo de usuarios
    Como usuario administrador del backoffice quiero relacionar un usuario a un grupo de usuarios.

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y sigo "ListAccounts"
        # El listado de cuentas aparece en pantalla
        Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"
        # Entro al listado de plataformas de la cuenta elegida
        Y relleno "filters[name]" con "Cuenta 155"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Cuenta 155" en "#content"
        Y hago click en ".dropdown-toggle"
        Y sigo "Listar plataformas de Cuenta 155"
        # El listado de plataformas aparece en pantalla
        Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".string-cell"
        # Entro al listado de usuarios de la plataforma elegida
        Y relleno "filters[name]" con "Plataforma 155"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Plataforma 155" en ".string-cell"
        Y sigo "Plataforma 155"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"
        Entonces espero a que aparezca el contenido dinámico "Administrar grupos de usuarios" en ".button-bar"
        Y sigo "Administrar grupos de usuarios"
        Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "Grupo de usuarios 10" en ".backoffice-block"
        Y sigo "Grupo de usuarios 10"
        Y espero a que aparezca el contenido dinámico "Agregar o quitar usuarios" en ".usergroup-users"

    @javascript @loadDataForLists
    Escenario: Desrelacionar todos los usuarios al grupo
        Dado sigo "Agregar o quitar usuarios"
        Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".modal-body .string-cell"
        Cuando hago click en ".relate-link:first"
        Y espero a que aparezca el contenedor dinámico ".unrelate-link"
        Y hago click en ".close"
        Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".usergroup-users .string-cell"

        Y sigo "Agregar o quitar usuarios"
        Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".modal-body .string-cell"
        Cuando hago click en ".unrelate-link"
        Y hago click en ".close"
        Entonces espero a que aparezca el contenido dinámico "El grupo no tiene usuarios relacionados" en ".usergroup-users"
