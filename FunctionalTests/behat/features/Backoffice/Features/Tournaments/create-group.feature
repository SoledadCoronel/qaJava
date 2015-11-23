#language: es
Característica: crear un grupo en una fase de un torneo

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
      Y sigo "Nuevo Grupo"
      Cuando espero a que aparezca el contenedor dinámico ".form-horizontal"

@javascript @loadStandardTournamentData
  Escenario: Cargar un nuevo grupo.
      Dado relleno "c1_name_es_ES" con "Grupo ES"
      Y relleno "c1_name_en_US" con "Grupo EP"
      Y relleno "c1_name_pt_BR" con "Grupo PT"
      Y no debo ver "Debe completar todos los campos"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Grupo ES" en "#group-name-display"

  @javascript @loadStandardTournamentData
  Escenario: Cargar un grupo sin nombre.
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Debe completar todos los campos" en "#content"

  @javascript @loadStandardTournamentData
  Escenario: "guardar y nuevo" un grupo.
      Dado relleno "c1_name_es_ES" con "Grupo ES"
      Y relleno "c1_name_en_US" con "Grupo EP"
      Y relleno "c1_name_pt_BR" con "Grupo PT"
      Y no debo ver "Debe completar todos los campos"
      Cuando presiono "Guardar y Nuevo"
      Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"

  @javascript @loadStandardTournamentData
  Escenario: cancelar edición de un grupo.
      Cuando presiono "Cancelar"
      Entonces espero a que aparezca el contenido dinámico "Grupo H" en ".backgrid"