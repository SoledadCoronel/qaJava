#language: es
Característica: Visualizar el listado completo de usuarios


    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "ListAccounts"

        # El listado de cuentas aparece en pantalla
        Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"

        # Entro al listado de plataformas de la cuenta elegida
        Y relleno "filters[name]" con "Cuenta 155"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Cuenta 155" en "#content"
        Y hago click en ".dropdown-toggle"
        Y sigo "Listar plataformas de Cuenta 155"
        # El listado de plataformas aparece en pantalla
        Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".string-cell"

        # Entro al listado de ambientes de la plataforma elegida
        Y relleno "filters[name]" con "Plataforma 155"
        Cuando hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Plataforma 155" en ".string-cell"
        Y sigo "Plataforma 155"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Ambientes"

    @javascript @loadDataForLists
    Escenario: Visualizar el listado por defecto de todas los ambientes de una plataforma
      # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Ambiente 1" en "#content"
      Entonces espero a que aparezca el contenido dinámico "Ambiente 10" en "#content"

    @javascript @loadDataForLists
    Escenario: Reordenar ambientes utilizando drag and drop

     # El listado aparece en pantalla
     Entonces espero a que aparezca el contenido dinámico "Ambiente 1" en "#content"
     Entonces espero a que aparezca el contenido dinámico "Ambiente 10" en "#content"
     Cuando muevo del listado dinamico "Ambiente 1" a "Ambiente 2"
     Entonces el orden del listado dinamico de ".backgrid .string-cell" debe ser "Ambiente 2,Ambiente 1"
