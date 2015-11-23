#language: es
Característica: Visualizar el listado completo de cuentas

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y estoy en "/backoffice/"
        Y sigo "ListAccounts"

    # LISTADO DEFAULT
    @javascript @loadDataForLists
    Escenario: Visualizar el listado por defecto de las cuentas
      # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"
      # El paginador funciona correctamente
      Y espero a que aparezca el contenido dinámico "》》" en "#content"
      # Al menos un filtro aparece correctamente
      Entonces espero a que aparezca el contenido dinámico "Buscar cuenta" en "#content"

    # NAVEGAR ENTRE PAGINAS
    @javascript @loadDataForLists
    Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador
      # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 143" en "#content"

      # Navego hasta la ultima pagina navegando por los numeros de cada pagina
      Y hago click en "#page-2"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 144" en "#content"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 49" en "#content"

      Y hago click en "#page-3"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 5" en "#content"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 94" en "#content"

      Y hago click en "#page-prev"

      Entonces espero a que aparezca el contenido dinámico "Cuenta 144" en "#content"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 49" en "#content"

      Y hago click en "#page-first"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 143" en "#content"

    @javascript @loadDataForLists
    Escenario: Visualizar y ordenar un listado
       # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"

      # Presiono 2 veces en el titulo de la columna name para que ordene por nombre descendentemente
      Y hago click en "#head-name"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"

      Y hago click en "#head-name"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 99" en "#content"


    # FILTRAR LISTADO
    @javascript @loadDataForLists
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre de la cuenta
      # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"

      # Filtro por nombre
      Y relleno "filters[name]" con "Cuenta 100"
      Y hago click en "#name-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 100" en "#content"

      # Filtro por un sitio web que no existe
      Y relleno "filters[name]" con "Cuenta 99999"
      Y hago click en "#name-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "No hay cuentas" en "#content"

      # Reseteo los filtros para ver el listado original
      Y hago click en "#name-filter-btn-close"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"


