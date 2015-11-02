# language: es
Característica: Visualizacion de detalle de plataforma
  Como usuario del backoffice quiero poder ver el detalle de una cuenta

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"

  @javascript @createRegionalViewableAccounts
  Escenario: Veo el detalle de una cuenta regional. Por ende tengo que poder visualizar los campos basicos y los de registracion/login y customizacion
    Dado estoy en "/backoffice/"
    Y sigo "ListAccounts"
    Y debe aparecer el contenido dinámico "Regional Account" en ".string-cell"
    Y hago click en ".dropdown-toggle:first"
    Cuando sigo "Ver"
    Entonces debe aparecer el contenido dinámico "Información de la cuenta" en "#content"
    Y debo ver "Regional Account"
    Y debo ver "Si"
    Y debo ver "Cuentas dependientes"
    Y debo ver "Regional Child"
    Y debo ver "Información de login y registro"
    Y debo ver "Usuario"
    Y debo ver "email"
    Y debo ver "No"
    Y debo ver "No"
    Y debo ver "Si"
    Y debo ver "Si"
    #Y debo ver "Nominada"
    Y debo ver "Si"
    Y debo ver "Personalización de la plataforma"
    Y debo ver "http://regional.ci.gointegro.net"
    Y debo ver "Personalización de colores"
    Y debo ver "Personalización texto login"

  @javascript @createAccountAndUserAndPlatform
  Escenario: Veo el detalle de una cuenta. Por ende tengo que poder visualizar los campos basicos y los de registracion/login y customizacion
    Dado estoy en "/backoffice/"
    Y sigo "ListAccounts"
    Y debe aparecer el contenido dinámico "GoIntegro Argentina - Test P" en ".string-cell"
    Y hago click en ".dropdown-toggle:first"
    Cuando sigo "Ver"
    Entonces debe aparecer el contenido dinámico "Información de la cuenta" en "#content"
    Y debo ver "No Posee"
    Y debo ver "No"
    Y no debo ver "Información de login y registro"
    Y no debo ver "Personalización de la plataforma"
    Y no debo ver "Personalización de colores"
    Y no debo ver "Personalización texto login"

  @javascript @createRegionalChildViewableAccount
  Escenario: Veo el detalle de una cuenta hija. Por ende tengo que poder visualizar el link del padre
    Dado estoy en "/backoffice/"
    Y sigo "ListAccounts"
    Y debe aparecer el contenido dinámico "Child" en ".string-cell"
    Y hago click en ".dropdown-toggle:first"
    Cuando sigo "Ver"
    Entonces debe aparecer el contenido dinámico "Información de la cuenta" en "#content"
    Y debo ver "Child"
    Y debo ver "No Posee"
    Y debo ver "No"
    Y debo ver "Cuenta principal"
    Y debo ver "Father"
    Y no debo ver "Información de login y registro"
    Y no debo ver "Personalización de la plataforma"
    Y no debo ver "Personalización de colores"
    Y no debo ver "Personalización texto login"
