# language: es
Característica: Ver listado de torneos en Torneos Pro.
                Como usuario administrador de Backoffice quiero poder ver el listado de torneos Pro

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Cuando presiono "_submit"
        Y sigo "Torneos Pro"

    @javascript @createTournament
    Escenario: Visualizar el listado por defecto de un torneo pro de una plataforma.
        # El listado aparece en pantalla
        Dado espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 1" en "#content"
        Entonces espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 2" en "#content"
        # El paginador funciona correctamente
        Y espero a que aparezca el contenido dinámico "》》" en "#content"
        # Al menos un filtro aparece correctamente
        Y espero a que aparezca el contenido dinámico "Buscar torneo" en "#content"

    # Ordenar por algún campo
    @javascript @createTournament
    Escenario: Ordenar por algún campo.
        # El listado aparece en pantalla
        Dado espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 1" en "#content"
        # Presiono 2 veces en el titulo de la columna name para que ordene por nombre descendentemente
        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 1" en "#content"
        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 9" en "#content"

    @javascript @createTournament
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre de un Torneo Pro.
      # El listado aparece en pantalla
      Dado espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 1" en "#content"
      Y espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 2" en "#content"
      # Filtro por nombre del torneo
      Y relleno "filters[name]" con "Brasil 2014 50"
      Cuando hago click en "#name-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 50" en "#content"
      # Filtro por un torneo que no existe
      Y relleno "filters[name]" con "no existe"
      Y hago click en "#name-filter-btn-submit"
      Y espero a que aparezca el contenido dinámico "No hay torneos" en "#content"
      # Reseteo los filtros para ver el listado original
      Y hago click en "#name-filter-btn-close"
      Y espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 1" en "#content"
      Y espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014 2" en "#content"
