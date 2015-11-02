# language: es
Característica: Selección de perfiles
  Como usuario del backoffice debo poder seleccionar/desseleccionar perfiles para la plataforma

  Antecedentes:
    Dado estoy en "/backoffice/signin" 
    Y relleno "_username" con "apibackofficetester" 
    Y relleno "_password" con "apitesterbackoffice" 
    Y presiono "_submit"
    Y sigo "ListAccounts"
    Y espero a que aparezca el contenido dinámico "GoIntegro Argentina - Test P" en "#content"
    Y hago click en ".dropdown-toggle"
    Y sigo "Listar plataformas"
    Entonces espero a que aparezca el contenido dinámico "Plataforma Test" en ".string-cell"
    Y sigo "Plataforma Test"
    Entonces espero a que aparezca el contenido dinámico "Plataforma Test" en ".backoffice-header"
    Y sigo "Perfiles (2)"

  @javascript @loadAccountPlatformRoles
  Escenario: Quitar un perfil de la plataforma
    Dado espero a que aparezca el contenido dinámico "ROLE_ADMIN" en ".platform-roles"
    Y hago click en ".platform-roles .relate-button"
    Y espero a que aparezca el contenido dinámico "Seleccione un perfil" en ".modal-header"
    Y espero a que aparezca el contenido dinámico "ROLE_ADVANCED" en ".modal-body"
    Cuando hago click en ".unrelate-link:eq(0)"
    Y espero a que aparezca el contenedor dinámico ".relate-link"
    Y hago click en ".close"
    Entonces espero a que aparezca el contenido dinámico "ROLE_BASIC" en ".platform-roles"
    Y no debo ver "ROLE_ADVANCED"
    Y no debo ver "ROLE_ADMIN"

  @javascript @loadAccountPlatformRoles
  Escenario: Agregar un perfil a la plataforma
    Dado espero a que aparezca el contenido dinámico "ROLE_ADMIN" en ".platform-roles"
    Y hago click en ".platform-roles .relate-button"
    Y espero a que aparezca el contenido dinámico "Seleccione un perfil" en ".modal-header"
    Y espero a que aparezca el contenido dinámico "ROLE_ADVANCED" en ".modal-body"
    Cuando hago click en ".relate-link:eq(0)"
    Y espero a que aparezca el contenedor dinámico ".unrelate-link"
    Y hago click en ".close"
    Entonces espero a que aparezca el contenido dinámico "ROLE_ADVANCED" en ".platform-roles"