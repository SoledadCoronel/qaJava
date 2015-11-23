#language: es
Característica: editar un grupo de un torneo en la plataforma desde el backoffice.

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
      Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#basic-grid"
      Y relleno "filters[name]" con "Fase de grupos"
      Y hago click en "#name-filter-btn-submit"
      Y espero a que desaparezca el contenido dinámico "Final" en "#basic-grid"
      Y espero a que aparezca el contenido dinámico "Fase de grupos" en "#basic-grid"
      Y hago click en ".dropdown-toggle"
      Entonces espero a que aparezca el contenido dinámico "Listar grupos" en ".dropdown-menu"
      Y hago click en ".listar-grupos"
      Entonces espero a que aparezca el contenido dinámico "Grupo H" en ".backgrid"
      Y relleno "filters[name]" con "Grupo A"
      Y hago click en "#name-filter-btn-submit"
      Y espero a que desaparezca el contenido dinámico "Grupo B" en "#basic-grid"
      Y espero a que aparezca el contenido dinámico "Grupo A" en "#basic-grid"
      Y sigo "Editar"

  @javascript @loadStandardTournamentData
  Escenario: Editar un grupo.
      Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
      Y relleno "c1_name_es_ES" con "TEST ES"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "TEST ES" en "#group-name-display"

  @javascript @loadStandardTournamentData
  Escenario: cancelar edición de un grupo.
      Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
      Cuando presiono "Cancelar"
      Entonces espero a que aparezca el contenido dinámico "Grupo A" en "#group-name-display"