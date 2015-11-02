#language: es
Característica: Elimina un equipo.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y espero a que aparezca el contenedor dinámico ".nav"
    Y sigo "tournament"
    Entonces espero a que aparezca el contenido dinámico "Torneo Copa Mundial de la FIFA" en "#basic-grid"
    Y hago click en ".dropdown-toggle"
    Y sigo "Listar Equipos"

  @javascript @loadStandardTournamentData
    Escenario: 1. Eliminar un equipo que no tiene partidos asociados ni es candidato a campeon/2do/3ro de ningún usuari
    Dado espero a que aparezca el contenido dinámico "Argentina" en "#content"
    Y relleno "filters[name]" con "Camerún"
    Y hago click en "#name-filter-btn-submit"
    Dado espero a que desaparezca el contenido dinámico "Argentina" en "#content"
    Y espero a que aparezca el contenido dinámico "Camerún" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar el equipo seleccionado?" en "#delete-modal"
    Y hago click en ".confirm-delete"
    Y espero a que desaparezca el contenido dinámico "Camerún" en "#content"

  @javascript @loadStandardTournamentData
    Escenario: 2. Eliminar un equipo que no tiene partidos asociados - Cancelar
    Dado espero a que aparezca el contenido dinámico "Alemania" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar el equipo seleccionado?" en "#delete-modal"
    Y hago click en ".btn-secondary"
    Y espero a que aparezca el contenido dinámico "Alemania" en "#content"

  @javascript @loadStandardTournamentData
    Escenario: 3. Mensaje de error al intentar eliminar un equipo que tiene partidos asociados
    Dado espero a que aparezca el contenido dinámico "Alemania" en "#content"
    Y relleno "filters[name]" con "Australia"
    Y hago click en "#name-filter-btn-submit"
    Y espero a que desaparezca el contenido dinámico "Alemania" en "#content"
    Y espero a que aparezca el contenido dinámico "Australia" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar el equipo seleccionado?" en "#delete-modal"
    Y hago click en ".confirm-delete"
    Y espero a que aparezca el contenido dinámico "No se puede eliminar el equipo porque tiene partidos asociados" en ".alert"
    Y espero a que aparezca el contenido dinámico "Australia" en "#content"

  @javascript @loadStandardTournamentData
    Escenario: 4. Mensaje de error al intentar eliminar un equipo que tiene usuarios que lo candidatearon campeon, 2do o 3ro
    Dado espero a que aparezca el contenido dinámico "Argentina" en "#content"
    Entonces hago click en ".dropdown-toggle:first"
    Y sigo "Eliminar"
    Y espero a que aparezca el contenido dinámico "¿Seguro que desea eliminar el equipo seleccionado?" en "#delete-modal"
    Y hago click en ".confirm-delete"
    Y espero a que aparezca el contenido dinámico "No se puede eliminar el equipo porque es candidato de al menos un usuario" en ".alert"
    Y espero a que aparezca el contenido dinámico "Argentina" en "#content"