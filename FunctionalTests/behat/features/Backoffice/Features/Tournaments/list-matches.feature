#language: es
  Característica: Visualizar el listado completo de partidos

    Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y espero a que aparezca el contenedor dinámico ".nav"
    Y sigo "tournament"
    Entonces espero a que aparezca el contenido dinámico "Torneo Copa Mundial de la FIFA" en "#basic-grid"
    Y hago click en ".dropdown-toggle"
    Y sigo "Listar Fases"
    Y espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
    Cuando relleno "filters[name]" con "Fase de grupos"
    Y hago click en "#name-filter-btn-submit"
    Y espero a que desaparezca el contenido dinámico "Octavos de final" en ".stage-name-backgrid"
    Y espero a que aparezca el contenido dinámico "Fase de grupos" en ".stage-name-backgrid"

  # LISTADO DEFAULT
  @javascript @loadTournamentsStandardData
  Escenario: Visualizar el listado por defecto de todos los partidos del torneo
  Dado espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
  Cuando hago click en ".dropdown-toggle"
  Y sigo "Listar partidos"
  Y espero a que aparezca el contenido dinámico "Alemania" en "#content"

  # Desplegar acciones
  @javascript @loadTournamentsStandardData
  Escenario: Desplegar opciones
  Dado espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
  Cuando hago click en ".dropdown-toggle"
  Y sigo "Listar partidos"
  Y espero a que aparezca el contenido dinámico "Alemania" en "#content"
  Y hago click en ".dropdown-toggle:first"
  Entonces debo ver "Editar"
  Y debo ver "Desactivar"
  Y debo ver "Eliminar"
