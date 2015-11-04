# language: es
Característica: Login Simple
  Para ingresar a la plataforma 
  Como usuario común 
  Necesito validar mis credenciales

  @javascript
  Escenario: Loguearme a la plataforma de email y password
    Dado me logueo con "tyrion.lannister@gointegro.com" "go1234"
    #Dado estoy en "/auth/signin?_lang=es"
    #Y relleno "_username" con "tyrion.lannister@gointegro.com"
    #Y relleno "_password" con "go1234"
    #Cuando presiono "_submit"
    Entonces debo estar en el inicio de la plataforma

  @javascript @mailAndPasswordPlatform
  Escenario: Loguearme con un password erroneo a la plataforma de email y password
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "tyrion.lannister@gointegro.com"
    Y relleno "_password" con "mal password"
    Cuando presiono "_submit"
    Entonces debe aparecer ".error-login"
    Y debo estar en "/auth/signin"

  @javascript @documentAndPasswordPlatform
  Escenario: Loguearme a la plataforma de documento y password
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "99999999"
    Y relleno "_password" con "go1234"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

  @javascript @documentAndPasswordPlatform
  Escenario: Loguearme  a la plataforma de documento y password, con un documento erroneo
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "XXXXXXXX"
    Y relleno "_password" con "go1234"
    Cuando presiono "_submit"
    Entonces debe aparecer ".error-login"
    Y debo estar en "/auth/signin"

  @javascript @usernameOnlyPlatform
  Escenario: Loguearme a la plataforma de usuario sin password
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "tyrion"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

  @javascript @usernameOnlyPlatform
  Escenario: Loguearme a la plataforma de usuario sin password con un usuario que no existe
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "ned.stark"
    Cuando presiono "_submit"
    Entonces debe aparecer ".error-login"
    Y debo estar en "/auth/signin"
