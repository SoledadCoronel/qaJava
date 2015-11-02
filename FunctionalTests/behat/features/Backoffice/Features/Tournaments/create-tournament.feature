#language: es
Característica: Crear un Torneo Pro en la plataforma desde el backoffice.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "Torneos Pro"
    Entonces espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014" en "#content"
    Y sigo "Nuevo Torneo Pro"
    Cuando espero a que aparezca el contenedor dinámico ".form-horizontal"

  @javascript @createTournament
  Escenario: Visualizar el formulario de creación de torneo.
    #El elemento nombre y descripción permite caracteres alfanuméricos.
    Dado relleno "c2_name_es_ES" con "Brasil 2014"
    Y relleno "c2_name_en_US" con "Brazil 2014"
    Y relleno "c2_name_pt_BR" con "Brasil 2014"
    #El elemento descripción
    Y relleno "c2_description_es_ES" con "Copa del mundo 2014"
    Y relleno "c2_description_en_US" con "Copa del mundo 2014"
    Y relleno "c2_description_pt_BR" con "Copa del mundo 2014"
    #El elemento descripción Pronóstico
    Y relleno "c2_forecastDescription_es_ES" con "Ponóstico Brasil 2014"
    Y relleno "c2_forecastDescription_en_US" con "forecast Brasil 2014"
    Y relleno "c2_forecastDescription_pt_BR" con "Ponostico Brasil 2014"
    #El elemento descripción fixture
    Y relleno "c2_fixtureDescription_es_ES" con "Fixture Brasil 2014"
    Y relleno "c2_fixtureDescription_en_US" con "Fixture Brasil 2014"
    Y relleno "c2_fixtureDescription_pt_BR" con "Fixture Brasil 2014"
    #El elemento descripción ranking
    Y relleno "c2_rankingDescription_es_ES" con "Ranking Brasil 2014"
    Y relleno "c2_rankingDescription_en_US" con "Ranking Brasil 2014"
    Y relleno "c2_rankingDescription_pt_BR" con "Ranking Brasil 2014"
    #Tipo de torneo
    Y selecciono "Fase de grupos y eliminación directa" de "c2_configuration"
    Y marco "Activo"
    Y relleno "c2_firstPoints" con "10"
    Y relleno "c2_secondPoints" con "100"
    Y relleno "c2_thirdPoints" con "80"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Brasil 2014" en "#content"

  @javascript @createTournament
  Escenario: Carga de un torneo sin título.
    #El elemento descripción
    Dado relleno "c2_description_es_ES" con "Copa del mundo 2014"
    Y relleno "c2_description_en_US" con "Copa del mundo 2014"
    Y relleno "c2_description_pt_BR" con "Copa del mundo 2014"
        #El elemento descripción Pronóstico
    Y relleno "c2_forecastDescription_es_ES" con "Pronóstico Brasil 2014"
    Y relleno "c2_forecastDescription_en_US" con "forecast Brasil 2014"
    Y relleno "c2_forecastDescription_pt_BR" con "Pronóstico Brasil 2014"
        #El elemento descripción fixture
    Y relleno "c2_fixtureDescription_es_ES" con "Fixture Brasil 2014"
    Y relleno "c2_fixtureDescription_en_US" con "Fixture Brasil 2014"
    Y relleno "c2_fixtureDescription_pt_BR" con "Fixture Brasil 2014"
        #El elemento descripción ranking
    Y relleno "c2_rankingDescription_es_ES" con "Ranking Brasil 2014"
    Y relleno "c2_rankingDescription_en_US" con "Ranking Brasil 2014"
    Y relleno "c2_rankingDescription_pt_BR" con "Ranking Brasil 2014"
        #Tipo de torneo
    Y selecciono "Fase de grupos y eliminación directa" de "c2_configuration"
    Y marco "Activo"
    Y relleno "c2_firstPoints" con "10"
    Y relleno "c2_secondPoints" con "100"
    Y relleno "c2_thirdPoints" con "80"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Debe completar todos los campos" en "#content"

  @javascript @createTournament
  Escenario: Carga de un torneo con un título mayor a 40 caracteres.
    #El elemento nombre y descripción permite caracteres alfanuméricos.
    Dado relleno "c2_name_es_ES" con "Brasil1111111111111122222222222222222222222222222222223333333333333333333sssssssssssssssssssssssfffffffffffff"
    Y relleno "c2_name_en_US" con "Brazil 2014"
    Y relleno "c2_name_pt_BR" con "Brasil 2014"
        #El elemento descripción
    Y relleno "c2_description_es_ES" con "Copa del mundo 2014"
    Y relleno "c2_description_en_US" con "Copa del mundo 2014"
    Y relleno "c2_description_pt_BR" con "Copa del mundo 2014"
        #El elemento descripción Pronóstico
    Y relleno "c2_forecastDescription_es_ES" con "Pronóstico Brasil 2014"
    Y relleno "c2_forecastDescription_en_US" con "forecast Brasil 2014"
    Y relleno "c2_forecastDescription_pt_BR" con "Pronóstico Brasil 2014"
        #El elemento descripción fixture
    Y relleno "c2_fixtureDescription_es_ES" con "Fixture Brasil 2014"
    Y relleno "c2_fixtureDescription_en_US" con "Fixture Brasil 2014"
    Y relleno "c2_fixtureDescription_pt_BR" con "Fixture Brasil 2014"
        #El elemento descripción ranking
    Y relleno "c2_rankingDescription_es_ES" con "Ranking Brasil 2014"
    Y relleno "c2_rankingDescription_en_US" con "Ranking Brasil 2014"
    Y relleno "c2_rankingDescription_pt_BR" con "Ranking Brasil 2014"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Solo se pueden ingresar 40 caracteres" en "#content"

  @javascript @createTournament
  Escenario: Carga de un torneo con descripción mayor a 800 caracteres
    #El elemento nombre y descripción permite caracteres alfanuméricos.
    Dado relleno "c2_name_es_ES" con "Brasileirao 2014"
    Y relleno "c2_name_en_US" con "Brazil 2014"
    Y relleno "c2_name_pt_BR" con "Brasil 2014"
    #El elemento descripción
    Y relleno "c2_description_es_ES" con "Copa del mundo 2014CopaCopa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014 del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014CopaCopa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014 del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014Copa del mundo 2014"
    Y relleno "c2_description_en_US" con "Copa del mundo 2014"
    Y relleno "c2_description_pt_BR" con "Copa del mundo 2014"
    #El elemento descripción Pronóstico
    Y relleno "c2_forecastDescription_es_ES" con "Pronóstico Brasil 2014"
    Y relleno "c2_forecastDescription_en_US" con "forecast Brasil 2014"
    Y relleno "c2_forecastDescription_pt_BR" con "Pronóstico Brasil 2014"
    #El elemento descripción fixture
    Y relleno "c2_fixtureDescription_es_ES" con "Fixture Brasil 2014"
    Y relleno "c2_fixtureDescription_en_US" con "Fixture Brasil 2014"
    Y relleno "c2_fixtureDescription_pt_BR" con "Fixture Brasil 2014"
    #El elemento descripción ranking
    Y relleno "c2_rankingDescription_es_ES" con "Ranking Brasil 2014"
    Y relleno "c2_rankingDescription_en_US" con "Ranking Brasil 2014"
    Y relleno "c2_rankingDescription_pt_BR" con "Ranking Brasil 2014"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Solo se pueden ingresar 255 caracteres" en "#content"


