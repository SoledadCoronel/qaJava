#language: es
Característica: Editar ambiente de una plataforma como usuario administrador desde el backoffice.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Cuando presiono "_submit"
    Entonces estoy en "/backoffice/"
    Y sigo "ListAccounts"
    Y debe aparecer el contenido dinámico "GoIntegro Argentina - Test P" en ".string-cell"
    Y hago click en ".dropdown-toggle"
    Y sigo "btnListPlatformsFor"
    Y debe aparecer el contenido dinámico "Plataforma Test" en ".string-cell"
    Y sigo "Plataforma Test"
    Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
    Y hago click en ".more-options"
    Y sigo "Ambientes"
    Y la URL debe seguir el patrón "/backoffice/platform/\d+/environment/list"
    Y debe aparecer el contenido dinámico "Ambiente1" en ".string-cell"
    Y hago click en ".dropdown-toggle:first"
    Cuando sigo "Editar"
    Entonces debe aparecer el contenido dinámico "Información" en ".form-horizontal"

  @javascript @createAccountAndUserAndPlatformAndEnvironment
  Escenario: Editar un ambiente asociado a una plataforma desde el backoffice con los campos requeridos viendo el detalle del ambiente editado
    Dado relleno "name" con "Mis beneficios corporativos"
    Y debo ver "Plataforma Test"
    Y selecciono "Beneficios" de "service"
    Y el campo "accessType" debe estar deshabilitado
    Y relleno "environment-subdomain" con "beneficios.afip"
    Cuando presiono "Guardar"
    Y espero a que cambie la URL
    Entonces debo ver "Mis beneficios corporativos"
    Y debo ver "Plataforma Test"
    Y debo ver "Beneficios"
    Y debo ver "beneficios.afip.gointegro.beneficios-corporativos.com"

  @javascript @createAccountAndUserAndPlatformAndEnvironment
  Escenario: Editar un ambiente asociado a una plataforma desde el backoffice con nombre de ambiente existente
    Dado relleno "name" con "Ambiente2"
    Y debo ver "Plataforma Test"
    Cuando presiono "Guardar"
    Entonces debe aparecer el contenido dinámico "El nombre de ambiente ya existe para esta plataforma." en "#content"

  @javascript @createAccountAndUserAndPlatformAndEnvironment
  Escenario: Editar un ambiente asociado a una plataforma desde el backoffice con nombre de ambiente inválido
    Dado relleno "name" con "@kaka  de paloma©"
    Y debo ver "Plataforma Test"
    Y selecciono "Beneficios" de "service"
    Y relleno "subdomain" con "sitiodeprueba"
    Cuando presiono "btnSave"
    Entonces debe aparecer el contenido dinámico "Atención! Existen errores en el formulario." en "#content"

  @javascript @createAccountAndUserAndPlatformAndEnvironment
  Escenario: Editar un ambiente asociado a una plataforma desde el backoffice con servicio de reconocimientos y un subdominio vacío
    Dado relleno "name" con "iRecognition"
    Y debo ver "Plataforma Test"
    Y selecciono "Beneficios" de "service"
    Cuando presiono "Guardar"
    Entonces debe aparecer el contenido dinámico "El campo url no puede ser vacío." en "#content"

  @javascript @createAccountAndUserAndPlatformAndEnvironment
  Escenario: Editar un ambiente asociado a una plataforma desde el backoffice con servicio de reconocimientos y un subdominio inválido
    Dado relleno "name" con "iBeneficios"
    Y debo ver "Plataforma Test"
    Y selecciono "Beneficios" de "service"
    Y relleno "subdomain" con "http://ibeneficios"
    Cuando presiono "Guardar"
    Entonces debe aparecer el contenido dinámico "El campo url no puede contener 'http://' ni 'https://'" en "#content"

  @javascript @createAccountAndUserAndPlatformAndEnvironment
  Escenario: Edición de un Ambiente con la inhibición visual del mismo en el menú principal de la aplicación.
    Dado relleno "name" con "Ambiente inhibido"
    Y debo ver "Plataforma Test"
    Y selecciono "Plataforma" de "service"
    Y la casilla de selección "hideEnvironment" debe estar marcada
    Cuando presiono "Guardar"
    Y espero a que aparezca el contenido dinámico "El ambiente se creó correctamente" en "#content"
    Entonces espero a que cambie la URL
    Y la URL debe seguir el patrón "backoffice/platform/\d+/environment/\d+/view"
    Y debo ver "Ambiente inhibido"
    Y debo ver "Ambiente oculto"
    Y debo ver "Si"