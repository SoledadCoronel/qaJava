# language: es
Característica: Login Simple
  Para ingresar a la plataforma
  Como usuario común
  Necesito validar mis credenciales

  Antecedentes:
    Dado estoy en "/auth/signout"

  @javascript
  Escenario: Loguearme a la plataforma de email y password
    Dado me logueo con "johnconnor" "12346"
    Cuando voy a "/auth/signout"
    Entonces debo estar en "auth/signin"

