# language: es
Característica: Editar Traducción.
                Como usuario administrador de Backoffice quiero poder editar una traducción

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Cuando presiono "_submit"
        Entonces estoy en "/backoffice/"

    @javascript @loadTranslations
    Escenario: Ingreso a la sección de traducciones y edito la primer traducción del bundle Auth
        Dado estoy en "/backoffice" 
        Y sigo "Traducciones"
        Y espero a que aparezca el contenido dinámico "GoIntegroAuthBundle" en ".string-cell"
        Y hago click en "#tab-auth table.backgrid tbody tr:first td:eq(3)"
        Y completo campo "#tab-auth table.backgrid tbody tr:first td:eq(3) input" con "forgot?"
        Y hago click en "#tab-auth table.backgrid tbody tr:first td.template .btn-toggle"
        Y espero a que aparezca el contenedor dinámico "#alert-messages div.alert-success"

    @javascript @loadTranslations
    Escenario: Ingreso a la sección de traducciones y edito la primer traducción del bundle Auth y agrego placeholders indebidos.
        Dado estoy en "/backoffice" 
        Y sigo "Traducciones"
        Y espero a que aparezca el contenido dinámico "GoIntegroAuthBundle" en ".string-cell"
        Y hago click en "#tab-auth table.backgrid tbody tr:first td:eq(3)"
        Y completo campo "#tab-auth table.backgrid tbody tr:first td:eq(3) input" con "<%=forgot%>"
        Cuando hago click en "#tab-auth table.backgrid tbody tr:first td.template .btn-toggle"
        Entonces espero a que aparezca el contenedor dinámico ".alert-error"