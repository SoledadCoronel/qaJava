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
        # Entro al listado de usuarios de la plataforma elegida
        Y relleno "filters[name]" con "Plataforma 155"
        Cuando hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Plataforma 155" en ".string-cell"
        Y sigo "Plataforma 155"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"

    # LISTADO DEFAULT
    @javascript @loadDataForLists
    Escenario: Visualizar el listado por defecto de todas los usuarios de una plataforma

      # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"

      # El paginador funciona correctamente
      Y espero a que aparezca el contenido dinámico "》》" en ".paginator"


    # NAVEGAR ENTRE PAGINAS
    @javascript @loadDataForLists
    Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador

      # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"

      # Navego hasta la ultima pagina navegando por los numeros de cada pagina
      Y hago click en "#page-2"
      Entonces espero a que aparezca el contenido dinámico "Nombre 26 Apellido 26" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 50 Apellido 50" en ".backgrid-user-list  tbody tr:last"

      Y hago click en "#page-3"
      Entonces espero a que aparezca el contenido dinámico "Nombre 51 Apellido 51" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 75 Apellido 75" en ".backgrid-user-list  tbody tr:last"

      Y hago click en "#page-4"
      Entonces espero a que aparezca el contenido dinámico "Nombre 76 Apellido 76" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 100 Apellido 100" en ".backgrid-user-list  tbody tr:last"

      Y hago click en "#page-5"
      Entonces espero a que aparezca el contenido dinámico "Nombre 101 Apellido 101" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 125 Apellido 125" en ".backgrid-user-list  tbody tr:last"

      Y hago click en "#page-6"
      Entonces espero a que aparezca el contenido dinámico "Nombre 126 Apellido 126" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 150 Apellido 150" en ".backgrid-user-list  tbody tr:last"

      Y hago click en "#page-last"
      Entonces espero a que aparezca el contenido dinámico "Nombre 151 Apellido 151" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 155 Apellido 155" en ".backgrid-user-list  tbody tr:last"

      Y hago click en "#page-first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"



    # ORDENAR LISTADO
    @javascript @loadDataForLists
    Escenario: Visualizar y ordenar un listado

      # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"

      # Presiono 2 veces en el titulo de la columna name para que ordene por nombre descendentemente
      Y hago click en "#head-fullName"
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"

      Y hago click en "#head-fullName"
      Entonces espero a que aparezca el contenido dinámico "Nombre 99 Apellido 99" en ".backgrid-user-list  tbody tr:first"


    # FILTRAR LISTADO
    @javascript @loadDataForLists
    Escenario: Visualizar un listado y filtrarlo buscando por el apellido de un usuario

      # El listado aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"

      # Filtro por Nombre y Apellido
      Y relleno "filters[queryString]" con "Apellido 100"
      Y hago click en "#queryString-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "Nombre 100 Apellido 100" en ".backgrid-user-list  tbody tr:first"

      # Filtro por un usuario que no existe
      Y relleno "filters[queryString]" con "apellido99999"
      Y hago click en "#queryString-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "No hay usuarios" en ".backgrid-user-list"

      # Reseteo los filtros para ver el listado original
      Y hago click en "#queryString-filter-btn-close"
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"

    @javascript @loadDataForLists
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre, documento, ID y mail de un usuario
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"
      Y relleno "filters[queryString]" con "Nombre 10"
      Cuando hago click en "#queryString-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "Nombre 10 Apellido 10" en ".backgrid-user-list  tbody tr:first"

    @javascript @loadDataForLists
    Escenario: Visualizar un listado y filtrarlo buscando por el documento de un usuario
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"
      Y relleno "filters[queryString]" con "9999"
      Cuando hago click en "#queryString-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "99999999" en ".backgrid-user-list  tbody tr:first"
      Y debo ver "Nombre 50 Apellido 50"

    @javascript @loadDataForLists
    Escenario: Visualizar un listado y filtrarlo buscando por el mail de un usuario
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"
      Y relleno "filters[queryString]" con "usuario95@"
      Cuando hago click en "#queryString-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "usuario95@platform.com" en ".backgrid-user-list  tbody tr:first"
      Y debo ver "Nombre 95 Apellido 95"

    @javascript @loadDataForLists
    Escenario: Visualizar un listado y filtrarlo buscando por usernameId de un usuario
      Entonces espero a que aparezca el contenido dinámico "Nombre 1 Apellido 1" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "Nombre 25 Apellido 25" en ".backgrid-user-list  tbody tr:last"
      Y relleno "filters[queryString]" con "Usuario 43"
      Cuando hago click en "#queryString-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "Nombre 43 Apellido 43" en ".backgrid-user-list  tbody tr:first"
      Entonces espero a que aparezca el contenido dinámico "usuario43@platform.com" en ".backgrid-user-list  tbody tr:first"