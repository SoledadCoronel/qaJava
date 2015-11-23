# language: es
Característica: Desactivar plataformas.
Como usuario administrador de Backoffice quiero poder desactivar plataformas para evitar que se visualicen en el frontend

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Cuando presiono "_submit"
    Entonces estoy en "/backoffice/"


    @javascript @createAccountAndUserAndPlatformAndEnvironment
    Escenario: Desde el listado de plataformas debo poder desactivarlas. Luego desde el frontend ya no deberia poder verse ni accederse a la misma
        Dado estoy en "/backoffice"
        Y sigo "Listar Cuentas"
        Y espero a que aparezca el contenido dinámico "GoIntegro Argentina - Test P" en ".string-cell"
        Y hago click en ".dropdown-toggle"
        Y sigo "Listar plataformas"
        Y espero a que aparezca el contenido dinámico "Plataforma Test" en ".string-cell"
        Y hago click y sigo ".action-icon:first"
        Y debe aparecer el contenido dinámico "Editar plataforma" en ".backoffice-header"
        Y tildo el checkbox "disable"
        Y presiono "Guardar"
        Entonces sigo "Cerrar Sesión"
        Dado estoy en "/"
        Entonces debo ver "¡Lo sentimos!"