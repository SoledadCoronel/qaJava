# language: es
Característica: Ver detalle de usuario.
                Como usuario administrador de Backoffice quiero poder ver el detalle de un usuario

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y estoy en "/backoffice/"
        Y sigo "ListAccounts"
        Y debe aparecer el contenido dinámico "GoIntegro Argentina - Test P Child" en ".string-cell"
        Y hago click en ".dropdown-toggle:eq(0)"
        Y sigo "Listar plataformas de GoIntegro Argentina - Test P Child"
        Y espero a que aparezca el contenido dinámico "Plataforma Test" en ".string-cell"
        Y sigo "Plataforma Test"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"
        Y espero a que aparezca el contenido dinámico "John Connor" en ".backgrid-user-list"

    @javascript @createAccountAndUserAndPlatform
    Escenario: Ver detalle de un usuario
        Dado sigo "John Connor"
        Y espero a que aparezca el contenido dinámico "John Connor" en ".breadcrumb"
        Entonces debo ver "Información básica"
        Y debo ver "Si"
        Y debo ver "John"
        Y debo ver "Connor"
        Y debo ver "john.connor@gointegro.com"
        Y debo ver "01/01/2010"
        Y debo ver "01/01/2000"
        Y debo ver "99999999"
        Y debo ver "Masculino"
        Y debo ver "44444444"
        Y debo ver "1544444444"
        Y debo ver "ROLE_ADMIN"
        Y debo ver "Información de registro"
        Y debo ver "johnconnor"
        Y debo ver "Si"
        Y debo ver "01/01/2010"
        Y debo ver "Fecha de creación"
        Y debo ver "Última actualización"
