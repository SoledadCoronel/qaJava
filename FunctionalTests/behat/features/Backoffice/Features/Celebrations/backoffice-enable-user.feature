#language: es

Característica: Agregar colaboradores a  una aplicación de celebraciones instalada en espacio autojoin.
Como usuario admin de BO  activo un usuario a una plataforma con fecha de nacimiento y quiero que se agregue a todas las app de celebraciones automáticas instalada en espacios autojoin

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y estoy en "/backoffice/"
        Y sigo "ListAccounts"
        Y debe aparecer el contenido dinámico "Standard Account" en ".string-cell"
        Y hago click en ".dropdown-toggle"
        Y sigo "btnListPlatformsFor"
        Y debe aparecer el contenido dinámico "Hugo" en ".string-cell"
        Y sigo "Hugo"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"

    @javascript @loadPrivateWSCelebrationApp
    Escenario: Cambiar la fecha de nacimiento de un usuario.
        Dado espero a que aparezca el contenido dinámico "Roger Rabbit" en ".string-cell"
        Y hago click y sigo ".action-icon:eq(11)"
        Y espero a que aparezca el contenido dinámico "Activo" en ".backoffice-block"
        Y la casilla de selección "enabled" no debe estar marcada
        Y tildo el checkbox "enabled"
        Y la casilla de selección "enabled" debe estar marcada
        Y hago click en ".save-form"
        Y debe aparecer el contenido dinámico "Información básica" en ".user-view-container"
        # Sigo testeando el cambio en frontend
        Dado estoy en "/auth/signin?_lang=en_US"
        Y relleno "_username" con "privateworkspaceuser"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Y espero a que aparezca el contenido dinámico "Espacio Público" en "#workspaces"
        Y sigo "Celebraciones Corporativas"
        Y espero a que aparezca el contenedor dinámico ".datepicker-switch"
        Y seteo el datepicker ".datepicker" con la fecha de hoy
        Y sigo "NON Private WS - Celebration - Category"
        Entonces espero a que aparezca el contenido dinámico "Roger Rabbit" en ".celebration-list"
