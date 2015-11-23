# language: es
Característica: Contratar aplicación.
  Como usuario administrador de Backoffice quiero poder contratar aplicaciones para una plataforma

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "ListAccounts"
    Y espero a que aparezca el contenido dinámico "GoIntegro Argentina - Test P" en "#content"
    Y hago click en ".dropdown-toggle"
    Y sigo "Listar plataformas"
    Y espero a que aparezca el contenido dinámico "Plataforma Test" en ".string-cell"
    Cuando sigo "Plataforma Test"
    Entonces espero a que aparezca el contenido dinámico "Plataforma Test" en ".backoffice-header"
    Y sigo "Aplicaciones (0)"

  @javascript @loadAccountPlatformRoles
  Escenario: Desde el detalle de una plataforma contrato una aplicaciones exitosamente.
    Dado espero a que aparezca el contenido dinámico "No hay aplicaciones relacionadas" en ".platform-applications"
    Y hago click en ".platform-applications .relate-button"
    Y espero a que aparezca el contenido dinámico "Seleccione una aplicación" en ".modal-header"
    Y espero a que aparezca el contenido dinámico "Contenidos" en ".modal-body"
    Cuando hago click en ".relate-link:eq(0)"
    Y espero a que aparezca el contenedor dinámico ".unrelate-link"
    Y hago click en ".close"
    Entonces espero a que aparezca el contenido dinámico "Contenidos" en ".platform-applications"


  @javascript @loadAccountPlatformRoles
  Escenario: Desde el detalle de una plataforma contrato y des-contrato dos aplicaciones exitosamente.
    Dado espero a que aparezca el contenido dinámico "No hay aplicaciones relacionadas" en ".platform-applications"
    Y hago click en ".platform-applications .relate-button"
    Y espero a que aparezca el contenido dinámico "Seleccione una aplicación" en ".modal-header"
    Y espero a que aparezca el contenido dinámico "Contenidos" en ".modal-body"
    Cuando hago click en ".relate-link:eq(0)"
    Y hago click en ".relate-link:eq(1)"
    Y espero a que aparezca el contenedor dinámico ".unrelate-link"
    Y hago click en ".close"
    Entonces espero a que aparezca el contenido dinámico "Contenidos" en ".platform-applications"
    Y debo ver "Novedades" en el elemento ".platform-applications"
    Y hago click en ".platform-applications .relate-button"
    Y espero a que aparezca el contenido dinámico "Seleccione una aplicación" en ".modal-header"
    Y espero a que aparezca el contenido dinámico "Contenidos" en ".modal-body"
    Cuando hago click en ".unrelate-link:first"
    Y hago click en ".unrelate-link:eq(1)"
    Y espero a que aparezca el contenedor dinámico ".relate-link"
    Y hago click en ".close"
    Entonces espero a que aparezca el contenido dinámico "No hay aplicaciones relacionadas" en ".platform-applications"