#language: es

Característica: Actualizar fechas de nacimiento de colaboradores en la app de clebraciones.
Como usuario admin o básico modifico mi fecha de nacimiento en mi perfil

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
        Dado espero a que aparezca el contenido dinámico "privateworkspace user" en ".string-cell"
        Y hago click y sigo ".action-icon:eq(9)"
        Y espero a que aparezca el contenido dinámico "Fecha de nacimiento" en ".form-birthdate"
        Y relleno la fecha "birthdate" con la fecha actual
        Y hago click en ".save-form"
        Y debe aparecer el contenido dinámico "Información básica" en ".user-view-container"
        # Sigo testeando esl cambio en frontend
        Dado estoy en "/auth/signin?_lang=en_US"
        Y relleno "_username" con "privateworkspaceuser"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Y espero a que aparezca el contenido dinámico "Espacio Privado" en "#workspaces"
        Y sigo "Celebraciones en WS privado"
        Y espero a que aparezca el contenedor dinámico ".datepicker-switch"
        Y seteo el datepicker ".datepicker" con la fecha de hoy
        Entonces espero a que aparezca el contenido dinámico "privateworkspace user" en ".celebration-list"
