# language: es
Característica: Contratar aplicaciones de beneficios cuando se habilitan los beneficios en la creación/edición de una cuenta.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Cuando presiono "_submit"
    Y sigo "ListAccounts"
    Y debe aparecer el contenido dinámico "Standard Account" en ".string-cell"
    Y sigo "Standard Account"
    Y sigo "Listar Plataformas"
    Y espero a que aparezca el contenido dinámico "Hugo" en ".string-cell"


  @javascript @loadStandardData
  Escenario: Crear una nueva plataforma cargando cuando menos los campos obligatorios viendo la pagina de detalle de la plataforma creada
    Dado sigo "Nueva Plataforma"
    Y espero a que aparezca el contenido dinámico "Crear plataforma" en ".backoffice-header"
    Y espero a que aparezca el contenido dinámico "Datos de la cuenta" en ".backoffice-block"    
    Y relleno "name" con "Plataforma de testing"
    Y relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformaNueva.ci.gointegro.net"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "0-100" de "usersRange"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Y selecciono "email" de "uniqueField"
    Y tildo el checkbox "countries-0"
    Y tildo el checkbox "benefitsEnabled"
    Cuando presiono "Guardar"
    Y espero a que aparezca el contenido dinámico "Plataforma de testing" en ".company-site"
    Entonces debo ver "Aplicaciones (1)" en el elemento ".backoffice-header"
    Y sigo "Aplicaciones (1)"
    Y espero a que aparezca el contenido dinámico "Mapa de Categorías de Beneficios" en ".platform-applications"

  @javascript @loadStandardData
  Escenario: Editar una plataforma inhabilitando Beneficios
    Dado hago click y sigo ".action-icon"
    Y espero a que aparezca el contenido dinámico "Editar plataforma" en ".backoffice-header"
    Y espero a que aparezca el contenido dinámico "Datos de la cuenta" en ".backoffice-block"
    Y espero a que aparezca el contenido dinámico "Argentina" en ".field-countries"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Y destildo el checkbox "benefitsEnabled"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Configuración básica de la plataforma" en ".platform-basic-information"
    Y debo ver "Aplicaciones (6)" en el elemento ".backoffice-header"
    Y espero a que aparezca el contenido dinámico "Actividad social" en ".platform-applications"
    Y no debo ver "Mapa de Categorías de Beneficios"

  @javascript @loadStandardData
  Escenario: Editar una plataforma habilitando Beneficios
    Dado hago click y sigo ".action-icon"
    Y espero a que aparezca el contenido dinámico "Editar plataforma" en ".backoffice-header"
    Y espero a que aparezca el contenido dinámico "Datos de la cuenta" en ".backoffice-block"
    Y destildo el checkbox "benefitsEnabled"
    Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
    Cuando presiono "Guardar"
    Y espero a que aparezca el contenido dinámico "Configuración básica de la plataforma" en ".platform-basic-information"
    Y debo ver "Aplicaciones (6)" en el elemento ".backoffice-header"
    Y sigo "Aplicaciones (6)"
    Y espero a que aparezca el contenido dinámico "Actividad social" en ".platform-applications"
    Y no debo ver "Mapa de Categorías de Beneficios"
    Y presiono "Editar"
    Y espero a que aparezca el contenido dinámico "Argentina" en ".field-countries"
    Y tildo el checkbox "benefitsEnabled"
    Cuando presiono "Guardar"
    Y espero a que aparezca el contenido dinámico "Configuración básica de la plataforma" en ".platform-basic-information"
    Y debo ver "Aplicaciones (8)" en el elemento ".backoffice-header"
    Y sigo "Aplicaciones (8)"
    Y espero a que aparezca el contenido dinámico "Mapa de Categorías de Beneficios" en ".platform-applications"