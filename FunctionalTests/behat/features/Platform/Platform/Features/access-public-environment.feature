# language: es
Característica: Acceder a un ambiente público
  Para poder acceder a los ambientes públicos
  Como usuario logueado
  Necesito ver listados los ambientes y poder navegarlos

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

  @javascript @LoadEnvironmentData
  Escenario: Listado de ambientes
    Dado estoy en la página de inicio
    Entonces debo ver "Inicio" en el elemento "#environments"
    Y debo ver "Recursos Humanos" en el elemento "#environments"
    Y debo ver "Institucional" en el elemento "#environments"
    Y no debo ver "Ambiente Externo" en el elemento "#environments"

  @javascript @LoadEnvironmentData
  Escenario: Acceder a un ambiente público
    Dado estoy en la página de inicio
    Cuando sigo "Recursos Humanos"
    Entonces debo estar en "/environment/recursos-humanos"
    Y "Recursos Humanos" debe estar activo