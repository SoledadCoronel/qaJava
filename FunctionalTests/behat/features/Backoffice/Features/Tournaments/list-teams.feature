#language: es
Característica: Visualizar el listado completo de equipos

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

    # LISTADO DEFAULT
    @javascript @loadTournamentsStandardData
    Escenario: Visualizar el listado por defecto de todos los equipos del torneo
    Entonces espero a que aparezca el contenido dinámico "Argentina" en "#basic-grid"
    Entonces espero a que aparezca el contenido dinámico "Brasil" en "#basic-grid"
    Entonces espero a que aparezca el contenido dinámico "Chile" en "#basic-grid"

    @javascript @loadTournamentsStandardData
    Escenario: Debo ver las opciones de Eliminar, editar y desactivar equipo.
    Entonces espero a que aparezca el contenido dinámico "Argentina" en "#basic-grid"
    Y espero a que aparezca el contenedor dinámico ".dropdown-toggle"
    Y hago click en ".dropdown-toggle"
    Entonces debo ver "Eliminar"
    Entonces debo ver "Desactivar"

  @javascript @loadTournamentsStandardData
    Escenario: Debo poder desactivar un equipo
    Entonces espero a que aparezca el contenido dinámico "Argentina" en "#basic-grid"
    Y relleno "filters[name]" con "Alemania"
    Y hago click en "#name-filter-btn-submit"
    Y espero a que desaparezca el contenido dinámico "Argentina" en "#basic-grid"
    Y espero a que aparezca el contenido dinámico "Alemania" en "#basic-grid"
    Y hago click en ".dropdown-toggle"
    Y sigo "Desactivar"
    Y no debo ver ".icon-ok"