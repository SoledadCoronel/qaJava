#language: es
Característica: Crear un partido Pro en la plataforma desde el backoffice.

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
    Y espero a que aparezca el contenido dinámico "Partidos" en "#content"
    Y sigo "Nuevo Partido"
    Cuando espero a que aparezca el contenedor dinámico ".form-horizontal"

    @javascript @loadStandardTournamentData
    Escenario: Cargar un nuevo Partido.
      Dado relleno "venue" con "Maracaná"
      Y selecciono "Grupo A" de "groupId"
      Y relleno "date" con "22/06/2014 16:00:00"
      Y marco "Activo"
      Y selecciono "Brasil" de "homeTeam"
      Y selecciono "Alemania" de "awayTeam"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"

    @javascript @loadStandardTournamentData
    Escenario: Error al cargar encuentro sin equipos.
      Dado relleno "venue" con "Maracaná"
      Y selecciono "Grupo A" de "groupId"
      Y relleno "date" con "22/06/2014 16:00:00"
      Y marco "Activo"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Required" en "#content"

    @javascript @loadStandardTournamentData
    Escenario: Cargar una fecha anterior a un nuevo Partido.
      Dado relleno "venue" con "Maracaná"
      Y selecciono "Grupo A" de "groupId"
      Y relleno "date" con "10/02/2014 16:00:00"
      Y marco "Activo"
      Y selecciono "Brasil" de "homeTeam"
      Y selecciono "Alemania" de "awayTeam"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "La fecha ingresada no puede ser menor a la fecha actual." en "#content"