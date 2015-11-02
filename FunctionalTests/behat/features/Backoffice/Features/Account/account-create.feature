# language: es
Característica: Creacion de cuentas
  Como usuario de backoffice quiero poder crear cuentas

Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una cuenta regional cumpliendo solo con los campos obligatorios
  Dado estoy en "/backoffice/account/create"
  Y presiono "Cuenta Regional"
  Y relleno "name" con "Cuenta regional"
  Y relleno "webSite" con "http://plataforma-nueva.ci.gointegro.net"
  Y adjunto el archivo "auto.jpg" a "file-logoUrl"
  Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
  Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
  Y relleno "defaultBackgroundColor" con "#D18181"
  Y relleno "defaultBgColorHeaderFooter" con "#853131"
  Cuando presiono "Guardar"
  Y espero a que cambie la URL
  Y la URL debe seguir el patrón "/backoffice/account/\d+/view"
  Entonces debo ver "Cuenta regional"
  Y debo ver "http://plataforma-nueva.ci.gointegro.net"

@javascript @createAccountAndUserAndPlatform
Escenario: Obtener error al intentar crear una cuenta regional sin completar los campos obligatorios
  Dado estoy en "/backoffice/account/create"
  Y presiono "Cuenta Regional"
  Cuando presiono "Guardar"
  Entonces debo ver "Por favor corrija los datos ingresados en el formulario."

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una cuenta regional seleccionando cuentas dependientes
  Dado estoy en "/backoffice/account/create"
  Y presiono "Cuenta Regional"
  Y relleno "name" con "Cuenta regional"
  Y relleno "webSite" con "http://cuenta-nueva.ci.gointegro.net"
  # Y selecciono "GoIntegro Argentina - Test P" del widget de selección "children"
  Y presiono "Buscar cuentas"
  Y espero a que aparezca el contenido dinámico "GoIntegro Argentina - Test P" en "#itemsList"
  Y presiono "Agregar"
  Y sigo "Asociar cuentas seleccionadas"
  Y espero a que aparezca el contenido dinámico "GoIntegro Argentina - Test P" en "ul.selection-list"
  Y adjunto el archivo "auto.jpg" a "file-logoUrl"
  Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
  Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
  Y relleno "defaultBackgroundColor" con "#D18181"
  Y relleno "defaultBgColorHeaderFooter" con "#853131"
  Y selecciono "email" de "uniqueField"
  Cuando presiono "Guardar"
  Y espero a que cambie la URL
  Y la URL debe seguir el patrón "/backoffice/account/\d+/view"
  Entonces debo ver "Cuenta regional"
  Y debo ver "http://cuenta-nueva.ci.gointegro.net"
  Y debo ver "GoIntegro Argentina - Test P"
  Y debo ver "Campo único"
  Y debo ver "email"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una cuenta estándar cumpliendo solamente con los campos obligatorios
  Dado estoy en "/backoffice/account/create"
  Y presiono "Cuenta Estándar/Dependiente"
  Y relleno "name" con "Cuenta estándar de testing"
  Y relleno "salesforceId" con "abcdef123456789"
  Cuando presiono "Guardar"
  Y espero a que cambie la URL
  Y la URL debe seguir el patrón "/backoffice/account/\d+/view"
  Entonces debo ver "Cuenta estándar de testing"

@javascript @createAccountAndUserAndPlatform
Escenario: Crear una cuenta dependiente seleccionando una cuenta principal
  Dado estoy en "/backoffice/account/create"
  Y presiono "Cuenta Estándar/Dependiente"
  Y relleno "name" con "Cuenta estándar de testing"
  Y relleno "salesforceId" con "abcdef123456789"
  Y selecciono "Plataforma regional de testing" del widget de selección "parent"
  Y espero a que aparezca el contenido dinámico "Plataforma regional de testing" en "ul.selection-list"
  Cuando presiono "Guardar"
  Y espero a que cambie la URL
  Y la URL debe seguir el patrón "/backoffice/account/\d+/view"
  Entonces debo ver "Cuenta estándar de testing"
  Y debo ver "Plataforma regional de testing"
