# language: es
Característica: Como usuario administrador del backoffice quiero ver las direcciones cargadas para una plataforma.

Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "Listar Cuentas"
    Y espero a que aparezca el contenido dinámico "Standard Account" en ".string-cell"
    Y sigo "Standard Account"
    Y sigo "Listar Plataformas"
    Y espero a que aparezca el contenido dinámico "Hugo" en ".string-cell"
    Cuando sigo "Hugo"
    Entonces la URL debe seguir el patrón "/backoffice/platform/\d+/view"
    Y el breadcrumb debe ser "Inicio > Cuentas > Standard Account > Plataformas > Hugo"

@javascript @loadStandardData
Escenario: Visualizar el listado reducido de las direcciones creadas para una plataforma.
    Dado espero a que aparezca el contenido dinámico "Nueva dirección" en "#addresses"
    Cuando espero a que aparezca el contenido dinámico "Dirección 1" en ".platform-address"
    Y espero a que aparezca el contenido dinámico "Dirección 5" en ".platform-address"
    Entonces debo ver "Ver todos"

@javascript @loadStandardData
Escenario: Visualizar el listado completo de todas las direcciones para una plataforma.
    Dado espero a que aparezca el contenido dinámico "Dirección 1" en ".platform-address"
    Y hago click en ".platform-address .complete-list-link"
    Y la URL debe seguir el patrón "/backoffice/platform/\d+/address/list"
    Y el breadcrumb debe ser "Inicio > Cuentas > Standard Account > Plataformas > Hugo > Direcciones"
    Y debo ver "Listado de direcciones"
    Y espero a que aparezca el contenido dinámico "Dirección 1" en ".backgrid-platform-address-list"
    Y espero a que aparezca el contenido dinámico "Dirección 6" en ".backgrid-platform-address-list"
