#language: es
Característica: Eliminar un grupo.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "Torneos Pro"
    Cuando espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014" en "#content"
    Y hago click en ".dropdown-toggle"
    Y sigo "Listar Fases"
    Y espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
    Cuando relleno "filters[name]" con "Fase de grupos"
    Y hago click en "#name-filter-btn-submit"
    Y espero a que desaparezca el contenido dinámico "Octavos de final" en ".stage-name-backgrid"
    Y espero a que aparezca el contenido dinámico "Fase de grupos" en ".stage-name-backgrid"
    Cuando hago click en ".dropdown-toggle"
    Y sigo "Listar grupos"

  @javascript @loadStandardTournamentData
  Escenario: 1. Eliminar un grupo sin partidos asociados
    Dado espero a que aparezca el contenido dinámico "Grupo de la muerte" en "#content"
    Y relleno "filters[name]" con "Grupo de la muerte"
    Y hago click en "#name-filter-btn-submit"
    Y espero a que desaparezca el contenido dinámico "Grupo A" en "#content"
    Y espero a que aparezca el contenido dinámico "Grupo de la muerte" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar el grupo seleccionado?" en "#delete-modal"
    Y hago click en ".confirm-delete"
    Y espero a que desaparezca el contenido dinámico "Grupo de la muerte" en "#content"

  @javascript @loadStandardTournamentData
  Escenario: 2. Eliminar un grupo sin partidos asociados - cancelar
    Dado espero a que aparezca el contenido dinámico "Grupo A" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar el grupo seleccionado?" en "#delete-modal"
    Y hago click en ".btn-secondary"
    Y espero a que aparezca el contenido dinámico "Grupo A" en "#content"

  @javascript @loadStandardTournamentData
  Escenario: 3. Mensaje de error al intentar eliminar un grupo que contiene partidos asociados
    Dado espero a que aparezca el contenido dinámico "Grupo A" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar el grupo seleccionado?" en "#delete-modal"
    Y hago click en ".confirm-delete"
    Y espero a que aparezca el contenido dinámico "No se puede eliminar el grupo porque tiene partidos asociados" en ".alert"
    Y espero a que aparezca el contenido dinámico "Grupo A" en "#content"