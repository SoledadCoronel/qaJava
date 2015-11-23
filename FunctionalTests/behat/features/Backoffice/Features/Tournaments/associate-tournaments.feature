# language: es
Característica: Asociacion de torneos a una aplicación de torneos contratada por una plataforma
  Como usuario del backoffice quiero poder asociar torneos a una aplicación de torneos

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "ListAccounts"
    Y debe aparecer el contenido dinámico "Standard Account" en ".string-cell"
    Y hago click en ".dropdown-toggle:first"
    Y sigo "btnListPlatformsFor"
    Y debe aparecer el contenido dinámico "Hugo" en ".string-cell"
    Y sigo "Hugo"
    Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
    Y hago click en ".more-options"
    Y hago click y sigo ".tournaments-list"

  @javascript @loadNoAssociatedTournamentsData
  Escenario: Ingreso a asociar torneos y hago submit del formulario sin seleccionar ninguno
    Dado espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014" en "#tournaments"
    Cuando hago click en "#save"
    Y espero a que aparezca el contenido dinámico "Debe seleccionar al menos un torneo" en ".help-inline"
    Entonces debo ver "Debe seleccionar al menos un torneo"

  @javascript @loadNoAssociatedTournamentsData
  Escenario: Ingreso a asociar torneos y hago submit del formulario sin seleccionar ninguno
    Dado espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014" en "#tournaments"
    Y selecciono "Copa Mundial Brasil 2014" de "tournaments"
    Cuando hago click en "#save"
    Y espero a que aparezca el contenido dinámico "Los torneos se han asociado exitosamente" en "#success-message"
    Entonces debo ver "Los torneos se han asociado exitosamente"
