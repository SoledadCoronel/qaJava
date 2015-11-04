# language: es
Característica: Login Regional
  Para ingresar a la plataforma desde una companía regional
  Como usuario común
  Necesito validar mis credenciales

  @javascript @documentAndPasswordRegional
  Escenario: Loguearme a la plataforma de documento y password
    Dado estoy en "http://company.ci.gointegro.net/auth/signin?_lang=es"
    Y relleno "_username" con "99999999"
    Y relleno "_password" con "go1234"
    Cuando presiono "_submit"
    Entonces espero a que cambie la URL
    Y debo estar en "/"
    Y voy a "http://regional.ci.gointegro.net/auth/signout"

  @javascript @documentAndPasswordRegionalWithTwoUsers
  Escenario: Loguearme  a la plataforma de documento y password, con un documento erroneo
    Dado estoy en "http://company.ci.gointegro.net/auth/signin?_lang=es"
    Y relleno "_username" con "XXXXXXXX"
    Y relleno "_password" con "go1234"
    Cuando presiono "_submit"
    Entonces debe aparecer el contenido dinámico "El usuario no corresponde a esta cuenta" en ".error-login"
    Y debo estar en "http://company.ci.gointegro.net/auth/signin?_lang=es"

  @javascript @documentAndPasswordRegionalWithTwoUsers
  Escenario: Loguearme a la plataforma de documento y password
    Dado estoy en "http://company.ci.gointegro.net/auth/signin?_lang=es"
    Y relleno "_username" con "99999999"
    Y relleno "_password" con "go1234"
    Y presiono "_submit"
    Y espero a que aparezca "#platform-selection-overlay"
    Y espero a que aparezca el contenido dinámico "GoIntegro Platform AR" en "#platform-selection-overlay"
    Cuando presiono "GoIntegro Platform AR"
    Y debo estar en "/"
    Y voy a "http://regional.ci.gointegro.net/auth/signout"
