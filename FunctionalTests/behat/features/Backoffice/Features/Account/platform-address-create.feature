# language: es
Característica: Como usuario administrador del backoffice quiero crear una dirección asociada a una plataforma.

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
    Y espero a que aparezca el contenido dinámico "Nueva dirección" en "#addresses"
    Y sigo "Nueva dirección"

@javascript @loadStandardData
Escenario: Intentar crear una dirección asociada a una plataforma sin los datos obligatorios.
    Dado debo ver "Información básica"
    Y debo ver "Dirección"
    Cuando presiono "Guardar"
    Entonces debo ver "Este campo no puede estar vacío."

@javascript @loadStandardData
Escenario: Crear una dirección asociada a una plataforma.
    Dado espero a que aparezca el contenedor dinámico ".field-name"
    Y relleno "name" con "Dirección de prueba"
    Y relleno "address" con "Av. Alvarez Thomas 198, 6º"
    Y relleno "addressAditional" con "De 9 a 18 hs"
    Y relleno "locality" con "Ciudad Autónoma de Buenos Aires"
    Y relleno "province" con "Ciudad Autónoma de Buenos Aires"
    Y relleno "zipCode" con "C1427CCO"
    Y relleno "country" con "Argentina"
    Y relleno "phone" con "+54 11 5353-6400"
    Cuando presiono "Guardar"
    Entonces espero a que cambie la URL
    Y la URL debe seguir el patrón "/backoffice/platform/\d+/address/\d+/view"
