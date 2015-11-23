# language: es
Característica: Selección de idiomas
  Como usuario del backoffice debo poder seleccionar/desseleccionar idiomas para una plataforma

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
    Y sigo "Idiomas (2)"

  @javascript @loadAccountPlatformRoles
  Escenario: Quitar un idioma de la plataforma
    Dado espero a que aparezca el contenido dinámico "English" en ".platform-languages"
    Y hago click en ".platform-languages .relate-button"
    Y espero a que aparezca el contenido dinámico "Seleccione un idioma" en ".modal-header"
    Y espero a que aparezca el contenido dinámico "Español" en ".modal-body"
    Cuando hago click en ".unrelate-link:eq(0)"
    Y espero a que aparezca el contenedor dinámico ".relate-link"
    Y hago click en ".close"
    Entonces espero a que aparezca el contenido dinámico "Português" en ".platform-languages"
    Y no debo ver "Español"
    Y no debo ver "English"

  @javascript @loadAccountPlatformRoles
  Escenario: Agregar un perfil a la plataforma
    Dado espero a que aparezca el contenido dinámico "English" en ".platform-languages"
    Y hago click en ".platform-languages .relate-button"
    Y espero a que aparezca el contenido dinámico "Seleccione un idioma" en ".modal-header"
    Y espero a que aparezca el contenido dinámico "Español" en ".modal-body"
    Cuando hago click en ".relate-link:eq(0)"
    Y espero a que aparezca el contenedor dinámico ".unrelate-link"
    Y hago click en ".close"
    Entonces espero a que aparezca el contenido dinámico "Español" en ".platform-languages"