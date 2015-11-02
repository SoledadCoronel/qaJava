# language: es
Característica: Visualizacion de detalle de plataforma
  Como usuario quiero ver la configuración de un ambiente, desde el detalle de la plataforma, entonces veo "detalle del ambiente".

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y estoy en "/backoffice/"
        Y sigo "ListAccounts"
        Y debe aparecer el contenido dinámico "GoIntegro Argentina - Test P" en ".string-cell"
        Y hago click en ".dropdown-toggle:first"
        Y sigo "btnListPlatformsFor"
        Y debe aparecer el contenido dinámico "Plataforma Test 2" en ".string-cell"
        Y relleno "filters[name]" con "Plataforma Test 2"
        Y sigo "Plataforma Test 2"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Cuando sigo "Ambientes"
        Entonces espero a que aparezca el contenido dinámico "Nuevo ambiente" en "#content"
        Y sigo "Nuevo ambiente"

    @javascript @createAccountAndUserAndPlatform
    Escenario: Creo un ambiente de Beneficios y verifico en el detalle que lo creado se despliegue correctamente
        Dado espero a que aparezca el contenido dinámico "Información" en ".form-horizontal"
        Y relleno "name" con "Recursos Humanos"
        Y debo ver "Plataforma Test"
        Y selecciono "Beneficios" de "service"
        Y relleno "subdomain" con "urldebeneficios"
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Entonces debo ver "Recursos Humanos"
        Y debo ver "Plataforma Test"
        Y debo ver "0"
        Y debo ver "Beneficios"
        Y debo ver "urldebeneficios.gointegro.beneficios-corporativos.com"
        Y debo ver "Público con Login"

    @javascript @createAccountAndUserAndPlatform
    Escenario: Creo un ambiente común y verifico en el detalle que lo creado se despliegue correctamente
        Dado espero a que aparezca el contenido dinámico "Información" en ".form-horizontal"
        Y relleno "name" con "Recursos Humanos"
        Y debo ver "Plataforma Test"
        Y selecciono "Plataforma" de "service"
        Y la casilla de selección "public" debe estar marcada
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Entonces debo ver "Recursos Humanos"
        Y debo ver "Plataforma Test"
        Y debo ver "0"
        Y debo ver "Plataforma"
        Y debo ver "Ninguno"
        Y debo ver "Ninguno"
        Y debo ver "Público con Login"

    @javascript @createAccountAndUserAndPlatform
    Escenario: Creo un ambiente común y voy a editar el ambiente desde el detalle
        Dado espero a que aparezca el contenido dinámico "Información" en ".form-horizontal"
        Y relleno "name" con "Recursos Humanos"
        Y debo ver "Plataforma Test"
        Y selecciono "Plataforma" de "service"
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Y debo ver "Recursos Humanos"
        Cuando sigo "Editar"
        Entonces la URL debe seguir el patrón "backoffice/platform/\d+/environment/\d+/edit"

    @javascript @createAccountAndUserAndPlatform
    Escenario: Detalle de un Ambiente con la inhibición visual del mismo en el menú principal de la aplicación.
        Dado debe aparecer el contenido dinámico "Información" en ".form-horizontal"
        Y relleno "name" con "Ambiente inhibido"
        Y debo ver "Plataforma Test"
        Y selecciono "Plataforma" de "service"
        Y la casilla de selección "hideEnvironment" debe estar marcada
        Cuando presiono "Guardar"
        Y espero a que aparezca el contenido dinámico "El ambiente se creó correctamente" en "#content"
        Entonces espero a que cambie la URL
        Y la URL debe seguir el patrón "backoffice/platform/\d+/environment/\d+/view"
        Y debo ver "Ambiente inhibido"
        Y debo ver "Ambiente oculto"
        Y debo ver "Si"
        Y debo ver "Público con Login"
