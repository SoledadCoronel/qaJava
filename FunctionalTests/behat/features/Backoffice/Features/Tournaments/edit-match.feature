#language: es
Característica: Editar un partido en la plataforma desde el backoffice.

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
    Y hago click en ".dropdown-toggle"
    Y sigo "Listar partidos"
    Y espero a que aparezca el contenido dinámico "São Paulo" en "#content"
    Y hago click en ".dropdown-toggle:first"
    Y sigo "Editar"
    Cuando espero a que aparezca el contenedor dinámico ".form-horizontal"

  @javascript @loadStandardTournamentData
  Escenario: Editar score de un Partido.
    Dado relleno "homeScore" con "1"
    Y relleno "awayScore" con "2"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"