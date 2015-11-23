#language: es
Característica: Eliminar una Fase.

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

  @javascript @loadStandardTournamentData
  Escenario: 1. Eliminar una Fase sin grupos asociados
    Dado espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
    Cuando relleno "filters[name]" con "Cuartos de final"
    Y hago click en "#name-filter-btn-submit"
    Y espero a que desaparezca el contenido dinámico "Fase de grupos" en "#content"
    Y espero a que aparezca el contenido dinámico "Cuartos de final" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar la fase seleccionada?" en "#delete-modal"
    Y hago click en ".confirm-delete"
    Y espero a que desaparezca el contenido dinámico "Cuartos de final" en "#content"

  @javascript @loadStandardTournamentData
  Escenario: 2. Eliminar una Fase sin grupos asociados - cancelar
    Dado espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar la fase seleccionada?" en "#delete-modal"
    Y hago click en ".btn-secondary"
    Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"

  @javascript @loadStandardTournamentData
  Escenario: 3. Mensaje de error al intentar eliminar una fase que contiene grupos asociados
    Dado espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar la fase seleccionada?" en "#delete-modal"
    Y hago click en ".confirm-delete"
    Y espero a que aparezca el contenido dinámico "No se puede eliminar la fase ya que contiene grupos" en "#message-container"
    Y espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
