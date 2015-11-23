# language: es
Característica: Como usuario de frontend quiero poder cargar pronósticos de los partidos de un torneo.

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

  @javascript @loadUserScoreForRankingData
  Escenario: El usuario ingresa por primera vez a la sección de pronóstico y selecciona sus equipos favoritos.
  Cuando sigo "Ver más..."
  Y sigo "Prode Worldcup Brasil 2014"
  Y espero a que aparezca el contenido dinámico "Tus equipos favoritos" en "#team-selection"
  Y selecciono "Argentina" de "winners-firstTeam"
  Y selecciono "Brasil" de "winners-secondTeam"
  Y selecciono "Australia" de "winners-thirdTeam"
  Y presiono "Siguiente"
  Entonces debe aparecer el contenido dinámico "Los equipos favoritos fueron guardadas correctamente" en "#tournaments-main"

  @javascript @loadUserScoreForRankingData
  Escenario: Desde la pagina de inicio debo poder llegar a ver la sección de ranking.
  Cuando sigo "Ver más..."
  Y sigo "Prode Worldcup Brasil 2014"
  Y espero a que aparezca el contenido dinámico "Tus equipos favoritos" en "#team-selection"
  Y selecciono "Argentina" de "winners-firstTeam"
  Y selecciono "Brasil" de "winners-secondTeam"
  Y selecciono "Australia" de "winners-thirdTeam"
  Y presiono "Siguiente"
  Entonces hago click en "#ranking-tab"
  Y espero a que aparezca el contenido dinámico "Posición" en ".myRankingTable"
  Y espero a que aparezca el contenido dinámico "Danilo Gerlo" en ".rankingTable"

  @javascript @loadUserScoreForRankingData
  Escenario: Desde la sección de ranking debo poder buscar un usuario por el filtro.
  Cuando sigo "Ver más..."
  Y sigo "Prode Worldcup Brasil 2014"
  Y espero a que aparezca el contenido dinámico "Tus equipos favoritos" en "#team-selection"
  Y cierro el modal "#team-selection"
  Y hago click en "#ranking-tab"
  Entonces espero a que aparezca el contenido dinámico "Posición" en ".myRankingTable"
  Y espero a que aparezca el contenido dinámico "Danilo Gerlo" en ".rankingTable"
  # Filtro por nombre y apellido
  Y relleno "search-ranking-text" con "Massimo Monopoli"
  Y hago click en "#search-ranking-button"
  Y espero a que desaparezca el contenido dinámico "Diego Ftacla" en "#ranking-content"
  Y espero a que aparezca el contenido dinámico "Massimo Monopoli" en "#ranking-content"

  @javascript @loadUserScoreForRankingData
  Escenario: Debo poder ver el ranking sin seleccioanr favoritos.
  Cuando sigo "Ver más..."
  Y sigo "Prode Worldcup Brasil 2014"
  Y espero a que aparezca el contenido dinámico "Tus equipos favoritos" en "#team-selection"
  Y cierro el modal "#team-selection"
  Y hago click en "#ranking-tab"
  Entonces espero a que aparezca el contenido dinámico "Posición" en ".myRankingTable"
  Y espero a que aparezca el contenido dinámico "Danilo Gerlo" en ".rankingTable"
