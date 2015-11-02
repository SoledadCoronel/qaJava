# language: es
Característica: Como usuario administrador del backoffice quiero visualizar una dirección asociada a una plataforma.

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
    Cuando sigo "Dirección 1"
    Entonces la URL debe seguir el patrón "/backoffice/platform/\d+/address/\d+/view"

@javascript @loadStandardData
Escenario: Visualizar una dirección asociada a una plataforma.
    Dado el breadcrumb debe ser "Inicio > Cuentas > Standard Account > Plataformas > Hugo > Dirección 1"
    Y debo ver "Información básica"
    Y debo ver "Si"
    Y debo ver "Dirección 1"
    Y debo ver "Dirección"
    Y debo ver "Av. Alvarez Thomas 198, 6º"
    Y debo ver "De 9 a 18 hs"
    Y debo ver "Ciudad Autónoma de Buenos Aires"
    Y debo ver "Ciudad Autónoma de Buenos Aires"
    Y debo ver "C1427CCO"
    Y debo ver "Argentina"
    Y debo ver "+54 11 5353-6400"
