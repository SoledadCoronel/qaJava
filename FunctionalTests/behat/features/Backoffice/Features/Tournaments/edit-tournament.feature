#language: es
Característica: Crear un Torneo Pro en la plataforma desde el backoffice.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "Torneos Pro"
    Cuando espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014" en "#content"
    Y sigo "Editar"
    Entonces debe aparecer el contenedor dinámico ".form-horizontal"

  @javascript @loadStandardTournamentData
  Escenario: Visualizar el formulario de edición de torneo.
  #El elemento nombre y descripción permite caracteres alfanuméricos.
    Dado relleno "c1_name_es_ES" con "Brasil Edited 2014"
    Y relleno "c1_name_en_US" con "Brazil Edited 2014"
    Y relleno "c1_name_pt_BR" con "Brasil 2014"
    Y marco "Torneo Finalizado"
    Y selecciono "Alemania" de "c1_firstPosition"
    Y selecciono "Colombia" de "c1_secondPosition"
    Y selecciono "Brasil" de "c1_thirdPosition"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Brasil Edited 2014" en "#content"