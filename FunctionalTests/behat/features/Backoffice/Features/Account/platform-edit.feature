# language: es
Característica: Edición de plataformas
    Como usuario del backoffice quiero poder editar una plataforma

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Cuando presiono "_submit"
        Y sigo "Listar Cuentas"
        Y debe aparecer el contenido dinámico "GoIntegro Argentina" en ".string-cell"
        Y sigo "Child"
        Y sigo "Listar Plataformas"
        Y debe aparecer el contenido dinámico "Plataforma Test" en ".string-cell"
        Y hago click y sigo ".action-icon:first"
        Entonces debe aparecer el contenido dinámico "Editar plataforma" en ".backoffice-header"

  @javascript @createAccountAndUserAndPlatform
  Escenario: Edito una plataforma existente cargando cuando menos los campos obligatorios viendo luego la pagina de detalle de la plataforma editada
        Dado relleno "name" con "Plataforma de testing editada"
        Y relleno "storage" con "800"
        Y relleno "webSite" con "http://plataformatest.ci.gointegro.net"
        Y selecciono "Bodegas" de "industry"
        Y selecciono "0-100" de "usersRange"
        Y tildo el checkbox "showUserEmail"
        Y tildo el checkbox "countries-0"
        Y adjunto el archivo "auto.jpg" a "file-logoUrl"
        Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
        Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Entonces debo ver "Plataforma de testing editada"
        Y espero a que aparezca el contenido dinámico "Si" en "#showUserEmail"

  @javascript @createAccountAndUserAndPlatform
  Escenario: Edito la plataforma existente eligiendo un nombre para esa cuenta que ya existe en la base de datos
        Dado relleno "name" con "Plataforma Test 2"
        Y relleno "storage" con "800"
        Y relleno "webSite" con "http://plataformatest.ci.gointegro.net"
        Y selecciono "Bodegas" de "industry"
        Y selecciono "0-100" de "usersRange"
        Y tildo el checkbox "countries-0"
        Y adjunto el archivo "auto.jpg" a "file-logoUrl"
        Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
        Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Ya existe una plataforma con este nombre para la cuenta GoIntegro Argentina - Test P Child" en ".alert-error"

  @javascript @createAccountAndUserAndPlatform
  Escenario: Editar una plataforma existente dejando sin completar los campos obligatorios.
        Dado relleno "name" con ""
        Y relleno "storage" con ""
        Y relleno "webSite" con ""
        Y hago click en ".form-logoUrl .close"
        Y hago click en ".form-logoUrlFooter .close"
        Y hago click en ".form-signinBannerUrl .close"
        Y lleno el WYSIWYG "termsAndConditions" con ""
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-name"
        Y debo ver "Este campo no puede estar vacío" en el elemento ".form-storage"
        Y debo ver "Este campo no puede estar vacío" en el elemento ".form-webSite"
        Y debo ver "Este campo no puede estar vacío" en el elemento ".form-logoUrl"
        Y debo ver "Este campo no puede estar vacío" en el elemento ".form-logoUrlFooter"
        Y debo ver "Este campo no puede estar vacío" en el elemento ".form-signinBannerUrl"
        Y debo ver "Este campo no puede estar vacío" en el elemento ".form-termsAndConditions"

  @javascript @createRegionalAccountWithPlatform
  Escenario: Editar una plataforma existente para una cuenta regional verificando que no haya campos de registro/login ni customizacion.
        Dado relleno "name" con "Plataform regional editada"
        Y relleno "storage" con "400"
        Y relleno "webSite" con "http://plataformaEditada.ci.gointegro.net"
        Y selecciono "Bodegas" de "industry"
        Y selecciono "0-100" de "usersRange"
        Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
        Y no debo ver "Logo principal"
        Y no debo ver "Logo secundario"
        Y no debo ver "Banner para inicio de sesión"
        Y no debo ver "Usa tarjeta"
        Y no debo ver "Usa fecha de nacimiento"
        Y no debo ver "Usa género"
        Y no debo ver "Configuración de inicio de sesión y registro"
        Y no debo ver "Tipo de Login"
        Y no debo ver "Campo usuario"
        Y no debo ver "Recuperar contraseña"
        Y no debo ver "Requiere verificación"
        Y no debo ver "Fondo plataforma"
        Y no debo ver "Fondo header y footer"
        Y no debo ver "Texto header y footer"
        Y no debo ver "Texto botones"
        Y no debo ver "Fondo botones"
        Y no debo ver "Borde header y footer"
        Y no debo ver "Íconos home"
        Y no debo ver "Texto del login"
        Cuando presiono "Guardar"
        Y espero a que cambie la URL
        Entonces espero a que aparezca el contenido dinámico "Plataform regional editada" en ".company-site"

  @javascript @createAccountAndUserAndPlatform
  Escenario: Cancelar la edicion de una plataforma existente.
        Cuando presiono "Cancelar"
        Entonces la URL debe seguir el patrón "/backoffice/account/\d+/platform/list"

  @javascript @createAccountAndUserAndPlatform
  Escenario: Edito la plataforma existente con un host ya existente
        Dado relleno "webSite" con "http://platform2.ci.gointegro.net"
        Y tildo el checkbox "countries-0"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "La URL ingresada ya está siendo utilizada en el sistema" en ".alert-error"

  @javascript @createRegionalAccountWithPlatform
     Escenario: Ingresar en el campo de tamaño máximo de imagen un valor no númerico y obtener un error.
    Dado relleno "storage" con "aaaaa"
    Y relleno "imageSize" con "123123asdasd"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "El valor ingresado debe ser un número entero" en ".form-storage"
    Y debo ver "El valor ingresado debe ser un número entero" en el elemento ".form-imageSize"

  @javascript @createAccountAndUserAndPlatform
    Escenario: Deshabilito la opción de mostrar mail del usuario y compruebo que no aparezca en la plataforma
    Dado destildo el checkbox "showUserEmail"
    Y tildo el checkbox "countries-0"
    Cuando presiono "Guardar"
    Y espero a que cambie la URL
    Entonces espero a que aparezca el contenido dinámico "No" en "#showUserEmail"

@javascript @createAccountAndUserAndPlatform
Escenario: Edito la plataforma existente activando beneficios y que se vean beneficios con cupón
  Dado relleno "name" con "Plataforma Test cupón"
  Y relleno "storage" con "800"
  Y relleno "webSite" con "http://plataformatest.ci.gointegro.net"
  Y selecciono "Bodegas" de "industry"
  Y selecciono "0-100" de "usersRange"
  Y tildo el checkbox "countries-0"
  Y adjunto el archivo "auto.jpg" a "file-logoUrl"
  Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
  Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
  Y tildo el checkbox "usesCoupon"
  Y tildo el checkbox "benefitsEnabled"
  Cuando presiono "Guardar"
  Y espero a que aparezca el contenido dinámico "Plataforma Test cupón" en ".company-site"
  Entonces debo ver "Si" en el elemento "#usesCoupon"

@javascript @createAccountAndUserAndPlatform
Escenario: Editar la configuración del catálogo de premios.
    Dado relleno "name" con "Plataforma con catálogo de premios"
    Y relleno "storage" con "800"
    Y relleno "webSite" con "http://plataformapremios.ci.gointegro.net"
    Y selecciono "Bodegas" de "industry"
    Y selecciono "0-100" de "usersRange"
    Y adjunto el archivo "auto.jpg" a "file-logoUrl"
    Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
    Y adjunto el archivo "auto.jpg" a "file-signinBannerUrl"
    Y lleno el WYSIWYG "termsAndConditions" con "Lorem ipsum..."
    Y selecciono "email" de "uniqueField"
    Y tildo el checkbox "countries-0"
    Y tildo el checkbox "countries-1"
    Cuando presiono "Guardar"
    Entonces espero a que cambie la URL
    Y espero a que aparezca el contenido dinámico "Plataforma con catálogo de premios" en ".breadcrumb"
