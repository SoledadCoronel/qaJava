# language: es

Característica: Como usuario de frontend quiero poder cargar pronósticos de los partidos de un torneo.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y sigo "Ver más..."
        Y sigo "Prode Worldcup Brasil 2014"
        Y espero a que aparezca el contenido dinámico "Tus equipos favoritos" en "#team-selection"

    @javascript @loadTournamentsStandardData
    Escenario: El usuario ingresa por primera vez a la sección de pronóstico y no selecciona todos los equipos favoritos.
        Dado selecciono "Argentina" de "winners-firstTeam"
        Y el campo "winners-secondTeam" no debe contener "Argentina"
        Y selecciono "Brasil" de "winners-secondTeam"
        Y el campo "winners-thirdTeam" no debe contener "Brasil"
        Cuando presiono "Siguiente"
        Entonces debo ver "Debe seleccionar los 3 equipos"

    @javascript @loadTournamentsStandardData
    Escenario: El usuario ingresa por primera vez a la sección de pronóstico y selecciona sus equipos favoritos.
        Dado selecciono "Argentina" de "winners-firstTeam"
        Y selecciono "Brasil" de "winners-secondTeam"
        Y selecciono "Australia" de "winners-thirdTeam"
        Cuando presiono "Siguiente"
        Entonces debe aparecer el contenido dinámico "Los equipos favoritos fueron guardadas correctamente" en "#tournaments-main"

    @javascript @loadTournamentsStandardData
    Escenario: Edición de selecciones favoritas.
        Dado selecciono "Argentina" de "winners-firstTeam"
        Y selecciono "Brasil" de "winners-secondTeam"
        Y selecciono "Australia" de "winners-thirdTeam"
        Y presiono "Siguiente"
        Y debe aparecer el contenido dinámico "Los equipos favoritos fueron guardadas correctamente" en "#tournaments-main"
        Y recargo la página
        Y debo ver "Edita tus equipos favoritos desde aquí."
        Y debo ver "Editar equipos"
        Y hago click en ".choose-teams"
        Y selecciono "Uruguay" de "winners-firstTeam"
        Y selecciono "Estados Unidos" de "winners-secondTeam"
        Y selecciono "Italia" de "winners-thirdTeam"
        Cuando presiono "Siguiente"
        Entonces debe aparecer el contenido dinámico "Los equipos favoritos fueron guardadas correctamente" en "#tournaments-main"

    @javascript @loadTournamentsStandardData
    Escenario: El usuario ingresa y carga el pronóstico para un partido y debe ver reflejado sus cambios.
        Dado cierro el modal "#team-selection"
        Y relleno el resultado del match "Argentina-Australia" con "2" a "0"
        Cuando presiono "Guardar"
        Entonces debe aparecer el contenido dinámico "Las predicciones se guardaron correctamente" en "#tournaments-main"
        Y recargo la página
        Y cierro el modal "#team-selection"
        Y el match "Argentina-Australia" tiene el resultado "2" a "0"

    @javascript @loadTournamentsStandardData
    Escenario: El usuario acertó la predicción de un partido y debe ver la notificación del hit.
        Dado cierro el modal "#team-selection"
        Entonces debo acertar el resultado del match "Alemania-Argelia" y ver "Acertaste el resultado"

    @javascript @loadTournamentsStandardData
    Escenario: El usuario ingresa su pronóstico para un partido, no guarda el mismo e intenta acceder a otra pestaña. Entonces debe desplegarse el modal de advertencia ligado a la pérdida de información en caso de abandonar la pestaña de pronósticos y el usuario debe optar por permanecer en la pestaña de pronósticos.
        Dado cierro el modal "#team-selection"
        Y relleno el resultado del match "Argentina-Australia" con "2" a "0"
        Cuando hago click en la pestaña "#fixture-tab"
        Entonces espero a que aparezca el contenido dinámico "Pronósticos no guardados" en ".modal-header"
        Y hago click en "#predictions-stay"
        Y debo ver "Pronóstico"
