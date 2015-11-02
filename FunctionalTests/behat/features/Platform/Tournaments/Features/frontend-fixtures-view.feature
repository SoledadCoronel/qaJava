# language: es
Característica: Como usuario de frontend quiero ver el fixture de una fase del torneo

    Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

    @javascript @loadTournamentsStandardData
    Escenario: Desde la pagina de inicio debo poder llegar a ver el fixture de la primer fase del
    torneo.
    Cuando sigo "Ver más..."
    Y sigo "Prode Worldcup Brasil 2014"
    Y espero a que aparezca el contenedor dinámico "#team-selection"
    Y hago click en "button.close"
    Y espero a que aparezca el contenido dinámico "Fixture & Resultados" en "#tournaments-navigation"
    Y hago click en "#fixture-tab"
    Y hago click en ":contains(Fase de grupos)"
    Y debo ver "Grupo A"
    Y debo ver "GER"

    @javascript @loadTournamentsStandardData
    Escenario: Desde la pagina de inicio al pedir el fixture de una fase sin partidos cargados debo
    ver el cartel de error correspondiente
    Cuando sigo "Ver más..."
    Y sigo "Prode Worldcup Brasil 2014"
    Y espero a que aparezca el contenido dinámico "Tus equipos favoritos" en "#team-selection"
    Y selecciono "Argentina" de "winners-firstTeam"
    Y selecciono "Brasil" de "winners-secondTeam"
    Y selecciono "Australia" de "winners-thirdTeam"
    Y presiono "Siguiente"
    Y hago click en "#fixture-tab"
    Y hago click en ":contains(Cuartos de final)"
    Y espero a que aparezca el contenido dinámico "No se han encontrado partidos para la fase requerida" en "#tournaments-main"

    @javascript @loadTournamentsStandardData
    Escenario: Desde la pagina debo poder ver el fixture de una fase con partidos cargados y luego ver el de otra fase con
    partidos cargados
    ver el cartel de error correspondiente
    Cuando sigo "Ver más..."
    Y sigo "Prode Worldcup Brasil 2014"
    Y espero a que aparezca el contenedor dinámico "#team-selection"
    Y hago click en "button.close"
    Y espero a que aparezca el contenido dinámico "Fixture & Resultados" en "#tournaments-navigation"
    Y hago click en "#fixture-tab"
    Y hago click en ":contains(Fase de grupos)"
    Y debo ver "Grupo A"
    Y debo ver "GER"
    Y hago click en ":contains(Octavos de final)"
    Entonces debo ver "GER"
