# language: es
Característica: Login Simple
  Para ingresar a la plataforma
  Como usuario común
  Necesito validar mis credenciales

  Antecedentes:
    Dado estoy en "/auth/signout"

  @javascript @mailAndPasswordPlatform
  Escenario: Loguearme a la plataforma de email y password
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "tyrion.lannister@gointegro.com"
    Y relleno "_password" con "go1234"
    Y presiono "_submit"
    Y debo estar en "/"
    Cuando voy a "/auth/signout"
    Entonces debo estar en "auth/signin"

