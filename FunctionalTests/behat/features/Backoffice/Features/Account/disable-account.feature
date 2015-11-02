# language: es
Característica: Desactivar cuenta.
Como usuario administrador de Backoffice quiero poder desactivar cuentas.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Cuando presiono "_submit"
    Entonces estoy en "/backoffice/"


    @javascript @createAccountAndUserAndPlatformAndEnvironment
    Escenario: Desde el listado de cuentas deberia poder desactivarla. Luego desde el frontend ya no deberia poder verse ni accederse al mismo
        Dado estoy en "/backoffice"
        Y sigo "Listar Cuentas"
        Y espero a que aparezca el contenido dinámico "GoIntegro Argentina - Test P" en ".string-cell"
        Y sigo "Desactivar"
        Y espero a que aparezca el contenido dinámico "Activar" en ".btn-toggle"
        Entonces sigo "Cerrar Sesión"
        Dado estoy en "/"
        Entonces debo ver "¡Lo sentimos!"

    @javascript @createRegionalChildViewableAccount
    Escenario: Desde el listado de cuentas deberia poder desactivar una cuenta regional. Luego desde el frontend ya no deberia poder verse ni accederse a ninguna de las cuentas hijas.
        Dado estoy en "/backoffice"
        Y sigo "Listar Cuentas"
        Y espero a que aparezca el contenedor dinámico "#name-filter"
        Y relleno "filters[name]" con "Father"
        Y espero a que aparezca el contenido dinámico "Father" en ".string-cell"
        Y hago click en "#name-filter-btn-submit"
        Y espero a que aparezca el contenido dinámico "Father" en ".string-cell"
        Y sigo "Desactivar"
        Y espero a que aparezca el contenido dinámico "Activar" en ".btn-toggle"
        Entonces sigo "Cerrar Sesión"
        Dado estoy en "/"
        Entonces debo ver "¡Lo sentimos!"
