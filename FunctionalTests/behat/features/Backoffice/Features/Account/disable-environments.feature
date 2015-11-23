# language: es
Característica: Desactivar ambientes. 
Como usuario administrador de Backoffice quiero poder desactivar ambientes para evitar que se visualicen en el frontend

  Antecedentes:
    Dado estoy en "/backoffice/signin" 
    Y relleno "_username" con "apibackofficetester" 
    Y relleno "_password" con "apitesterbackoffice" 
    Cuando presiono "_submit"
    Entonces estoy en "/backoffice/"


    @javascript @createAccountAndUserAndPlatformAndEnvironment
    Escenario: Desde el listado de ambientes debo poder desactivar ambientes. Luego desde el frontend ya no deberia poder verse ni accederse al mismo 
        Dado estoy en "/backoffice" 
        Y sigo "Listar Cuentas" 
        Y debe aparecer el contenido dinámico "GoIntegro Argentina - Test P" en ".string-cell"
        Y hago click en ".dropdown-toggle"
        Y sigo "Listar plataformas"
        Y debe aparecer el contenido dinámico "Plataforma Test" en ".string-cell"
        Y sigo "Plataforma Test"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Ambientes"
        Entonces la URL debe seguir el patrón "/backoffice/platform/\d+/environment/list"
        Y debe aparecer el contenido dinámico "Ambiente1" en ".string-cell"
        Cuando presiono "change-state"
        Y  espero a que aparezca el contenido dinámico "Activar" en "#change-state"
        Entonces sigo "Cerrar Sesión"
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Y presiono "Ingresar"
        Entonces no debo ver "Ambiente1"
