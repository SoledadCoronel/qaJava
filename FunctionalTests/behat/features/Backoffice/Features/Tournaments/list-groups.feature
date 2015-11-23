#language: es
Característica: Visualizar el listado completo de fases

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
      Y sigo "Listar grupos"
      Entonces espero a que aparezca el contenido dinámico "Grupo H" en ".backgrid"

  @javascript @loadTournamentsStandardData
  Escenario: Filtrar un grupo.
    Y relleno "filters[name]" con "Grupo H"
    Y hago click en "#name-filter-btn-submit"
    Y espero a que desaparezca el contenido dinámico "Grupo A" en "#basic-grid"

  @javascript @loadTournamentsStandardData
  Escenario: Debo ver las opciones de Eliminar y editar.
      Y espero a que aparezca el contenedor dinámico ".btn-group"
      Y espero a que aparezca el contenedor dinámico ".dropdown-toggle"
      Y hago click en ".dropdown-toggle"
      Entonces debo ver "Eliminar"