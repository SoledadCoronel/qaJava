# language: es
Característica: Listar Traducciones.
                Como usuario administrador de Backoffice quiero poder ver el listado de traducciones

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Cuando presiono "_submit"
        Entonces estoy en "/backoffice/"

    @javascript @loadTranslations
    Escenario: Ingreso a la sección de traducciones y compruebo el listado.
        Dado estoy en "/backoffice" 
        Y sigo "Traducciones"
        Y espero a que aparezca el contenedor dinámico "#tab-auth-link"
        Y espero a que aparezca el contenido dinámico "GoIntegroAuthBundle" en ".string-cell"

    @javascript @loadTranslations
    Escenario: Ingreso a la sección de palabras custom de cuenta y compruebo listado.
        Dado estoy en "/backoffice"
        Y sigo "ListAccounts"
        Y debe aparecer el contenido dinámico "GoIntegro Argentina" en ".string-cell"
        Y hago click en ".dropdown-toggle:first"
        Cuando sigo "Ver"
        Entonces debe aparecer el contenido dinámico "Información de la cuenta" en "#content"
        Y sigo "Customizar Palabras"
        Y espero a que aparezca el contenido dinámico "GoIntegroAuthBundle" en ".string-cell"

    @javascript @loadTranslations
    Escenario: Ingreso a la sección de palabras custom de plataforma y compruebo listado.
        Dado estoy en "/backoffice"
        Y sigo "ListAccounts"
        Y debe aparecer el contenido dinámico "GoIntegro Argentina" en ".string-cell"
        Y hago click en ".dropdown-toggle:first"
        Cuando sigo "Ver"
        Entonces debe aparecer el contenido dinámico "Información de la cuenta" en "#content"
        Y sigo "Listar Plataformas"
        Y debe aparecer el contenido dinámico "GoIntegro Platform CI" en ".string-cell"
        Y sigo "GoIntegro Platform CI"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Traducciones"
        Y espero a que aparezca el contenido dinámico "GoIntegroAuthBundle" en ".string-cell"