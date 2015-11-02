# language: es
Característica: Como usuario administrador del backoffice quiero editar una dirección asociada a una plataforma.

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
    Y sigo "Hugo"
    Y espero a que aparezca el contenido dinámico "Dirección 1" en ".platform-address"
    Y sigo "Dirección 1"
    Cuando hago click en ".edit-link"
    Entonces la URL debe seguir el patrón "/backoffice/platform/\d+/address/\d+/edit"
    Y el breadcrumb debe ser "Inicio > Cuentas > Standard Account > Plataformas > Hugo > Editar dirección"

@javascript @loadStandardData
Escenario: Intentar editar una dirección asociada a una plataforma sin los datos obligatorios.
    Dado relleno "name" con ""
    Y relleno "address" con ""
    Y relleno "locality" con ""
    Y relleno "province" con ""
    Y relleno "zipCode" con ""
    Y relleno "country" con ""
    Y relleno "addressAditional" con ""
    Cuando presiono "Guardar"
    Entonces debo ver "Este campo no puede estar vacío."

@javascript @loadStandardData
Escenario: Editar una dirección asociada a una plataforma.
    Dado relleno "name" con "Dirección de 1 editada"
    Cuando presiono "Guardar"
    Entonces espero a que cambie la URL
    Y la URL debe seguir el patrón "/backoffice/platform/\d+/address/\d+/view"
