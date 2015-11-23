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

    # LISTADO DEFAULT
    @javascript @loadTournamentsStandardData
    Escenario: Visualizar el listado por defecto de todos las fases del torneo
    Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#basic-grid"
    Entonces espero a que aparezca el contenido dinámico "Semifinal" en "#basic-grid"
    Y espero a que aparezca el contenedor dinámico ".new-stage"

    @javascript @loadTournamentsStandardData
    Escenario: Debo ver las opciones de Eliminar, editar y fase default.
    Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#basic-grid"
    Y espero a que aparezca el contenedor dinámico ".dropdown-toggle"
    Y hago click en ".dropdown-toggle"
    Entonces debo ver "Eliminar"
    Entonces debo ver "Fase default"
    Entonces debo ver "Listar partidos"
    Entonces debo ver "Listar grupos"

  @javascript @loadTournamentsStandardData
    Escenario: Debo poder definir una fase como default
    Entonces espero a que aparezca el contenido dinámico "Semifinal" en "#content"
    Y relleno "filters[name]" con "Semifinal"
    Y hago click en "#name-filter-btn-submit"
    Y espero a que desaparezca el contenido dinámico "Final" en "#content"
    Y espero a que aparezca el contenido dinámico "Semifinal" en "#content"
    Y hago click en ".dropdown-toggle"
    Entonces debo ver "Fase default"
    Y sigo "Fase default"
    Y espero a que aparezca el contenedor dinámico ".icon-ok"

  @javascript @loadTournamentsStandardData
    Escenario: Reordenar fases utilizando drag and drop
    Entonces espero a que aparezca el contenido dinámico "Tercer puesto" en "#content"
    Entonces espero a que aparezca el contenido dinámico "Final" en "#content"
    Cuando muevo del listado dinamico "Tercer puesto" a "Final"
    Entonces el orden del listado dinamico de ".backgrid .stage-name-backgrid" debe ser "Fase de grupos,Octavos de final,Cuartos de final,Semifinal,Final,Tercer puesto"