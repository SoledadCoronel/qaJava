#language: es
Característica: Ver grupo de usuarios
                Como usuario administrador del backoffice quiero ver un grupo

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
        Y espero a que aparezca el contenido dinámico "Plataforma 155" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"
        Entonces espero a que aparezca el contenido dinámico "Administrar grupos de usuarios" en ".button-bar"
        Y sigo "Administrar grupos de usuarios"
        Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "Grupo de usuarios 1" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario:  Visualizar los datos del grupo
        Dado sigo "Grupo de usuarios 1"
        Y espero a que aparezca el contenido dinámico "Grupo de usuarios 1" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Información básica" en ".usergroup-basic-information"
        Y debo ver "Usuarios (25)"
        Y debo ver "Subgrupos (25)"
        Y debo ver "Si"
        Y debo ver "Grupo de usuarios 1"
        Y espero a que aparezca el contenido dinámico "Usuarios" en ".usergroup-users"
        Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".usergroup-users"
        Y espero a que aparezca el contenido dinámico "Nombre 13 Apellido 13" en ".usergroup-users"
        Y espero a que aparezca el contenido dinámico "Subgrupos" en ".usergroup-subgroups"
        Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 1" en ".usergroup-subgroups"
        Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 13" en ".usergroup-subgroups"

    @javascript @loadDataForLists
    Escenario:  Visualizar el listado de usuarios relacionados a un grupo de usuarios
        Dado sigo "Grupo de usuarios 1"
        Y espero a que aparezca el contenido dinámico "Grupo de usuarios 1" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Usuarios" en ".usergroup-users"
        Y espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".usergroup-users"
        Cuando hago click en el elemento "#users .complete-list-link" que contiene el texto "Ver todos"
        Y espero a que aparezca el contenido dinámico "Usuarios de Grupo de usuarios 1" en ".breadcrumb"
        Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".string-cell"
        Y espero a que aparezca el contenido dinámico "Nombre 4 Apellido 4" en ".string-cell"
        Y espero a que aparezca el contenido dinámico "》》" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario:  Visualizar el listado de subgrupos de un grupo de usuarios
        Dado sigo "Grupo de usuarios 1"
        Y espero a que aparezca el contenido dinámico "Grupo de usuarios 1" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Subgrupos" en ".usergroup-subgroups"
        Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 1" en ".usergroup-subgroups"
        Cuando hago click en el elemento "#subgroups .complete-list-link" que contiene el texto "Ver todos"
        Y espero a que aparezca el contenido dinámico "Subgrupos de usuarios" en ".breadcrumb"
        Entonces espero a que aparezca el contenido dinámico "Subgrupo de usuarios 1" en ".string-cell"
        Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 4" en ".string-cell"
        Y espero a que aparezca el contenido dinámico "》》" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario:  Visualizar los datos de un subgrupo
        Dado sigo "Grupo de usuarios 1"
        Y espero a que aparezca el contenido dinámico "Grupo de usuarios 1" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Subgrupos" en ".usergroup-subgroups"
        Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 1" en ".usergroup-subgroups"
        Cuando sigo "Subgrupo de usuarios 1"
        Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 1" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 1" en ".backoffice-header"
        Entonces debo ver "Usuarios (0)"
        Y debo ver "El grupo no tiene usuarios relacionados"
        Y no debo ver "Subgrupos"