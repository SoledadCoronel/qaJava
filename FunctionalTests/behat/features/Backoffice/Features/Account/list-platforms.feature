#language: es
Característica: Visualizar el listado completo de plataformas

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

        # LISTADO DEFAULT
        @javascript @loadDataForLists
        Escenario: Visualizar el listado por defecto de todas las plataformas de una cuenta

          # El listado aparece en pantalla
          Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".table-content"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 116" en ".table-content"

          # El paginador funciona correctamente
          Y espero a que aparezca el contenido dinámico "》》" en ".paginator"

        # NAVEGAR ENTRE PAGINAS
        @javascript @loadDataForLists
        Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador

          # El listado aparece en pantalla
          Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".table-content"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 116" en ".table-content"

          # Navego hasta la ultima pagina navegando por los numeros de cada pagina
          Y hago click en "#page-2"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 117" en ".table-content"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 134" en ".table-content"

          Y hago click en "#page-3"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 135" en ".table-content"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 152" en ".table-content"

          Y hago click en "#page-prev"

          Entonces espero a que aparezca el contenido dinámico "Plataforma 117" en ".table-content"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 134" en ".table-content"

          Y hago click en "#page-first"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".table-content"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 116" en ".table-content"


        @javascript @loadDataForLists
        Escenario: Visualizar y ordenar un listado

          # El listado aparece en pantalla
          Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".table-content"

          # Presiono 2 veces en el titulo de la columna name para que ordene por nombre descendentemente
          Y hago click en "#head-name"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".table-content"

          Y hago click en "#head-name"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 99" en ".table-content"


        # FILTRAR LISTADO
        @javascript @loadDataForLists
        Escenario: Visualizar un listado y filtrarlo buscando por el nombre de una plataforma

          # El listado aparece en pantalla
          Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".table-content"

          # Filtro por nombre
          Y relleno "filters[name]" con "Plataforma 100"
          Y hago click en "#name-filter-btn-submit"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 100" en ".table-content"

          # Reseteo los filtros para ver el listado original
          Y hago click en "#name-filter-btn-close"
          Entonces espero a que aparezca el contenido dinámico "Plataforma 116" en ".table-content"


