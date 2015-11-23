#language: es
Característica: Editar una cuenta regional desde el backoffice.

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Cuando presiono "_submit"
        Entonces debo estar en "/backoffice/"

    @javascript @createRegionalAccounts
    Escenario: Ver formulario de edición de cuenta con los datos pre cargados.
      Dado que estoy en el detalle de la cuenta "Cuenta regional uno"
      Cuando sigo "Editar"
      Entonces el campo "name" debe contener "Cuenta regional uno"
      Y el campo "webSite" debe contener "http://regional.ci.gointegro.net"
      Y la casilla de selección "requireRegistration" debe estar marcada
      Y la casilla de selección "requireVerification" debe estar marcada
      Y la casilla de selección "usesBirthDate" debe estar marcada
      Y el campo "defaultBackgroundColor" debe contener "#106A91"
      Y el campo "defaultBgColorHeaderFooter" debe contener "#1888C8"
      Y el campo "defaultFontColor" debe contener "#FFFFFF"
      Y el campo "buttonFontColor" debe contener "#FFFFFF"
      Y el campo "buttonBackgroundColor" debe contener "#106A91"
      Y el campo "defaultBorderColor" debe contener "#106A91"
      Y el campo "iconsColor" debe contener "000000"
      Y el campo "htmlLogin" debe contener "esto es una prueba de cuenta regional"

    @javascript @createRegionalAccounts
    Escenario: Ingresamos datos duplicados utilizados en otra cuenta.
      Dado que estoy en el detalle de la cuenta "Cuenta regional uno"
      Y sigo "Editar"
      Y relleno "webSite" con "http://regionaldos.ci.gointegro.net"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Ya existe una cuenta o plataforma con el host regionaldos.ci.gointegro.net" en "#content"

    @javascript @createRegionalAccounts
    Escenario: Realizamos modificaciones en la cuenta y verificamos que se guarden correctamente.
      Dado que estoy en el detalle de la cuenta "Cuenta regional uno"
      Cuando sigo "Editar"
      Y relleno "webSite" con "http://cuentaregionalmodificada.ci.gointegro.net"
      Y debo ver "Configuración de Verificación"
      Y desmarco "requireRegistration"
      Y adjunto el archivo "auto.jpg" a "file-logoUrl"
      Y espero a que aparezca el contenido dinámico "auto.jpg" en ".field-logoUrl"
      Y adjunto el archivo "auto.jpg" a "file-logoUrlFooter"
      Y espero a que aparezca el contenido dinámico "auto.jpg" en ".field-logoUrlFooter"
      Y relleno "defaultFontColor" con "#CCCCCC"
      Y presiono "Guardar"
      Y espero a que aparezca el contenido dinámico "Cuenta regional uno" en "#content"
      Entonces espero a que aparezca el contenido dinámico "http://cuentaregionalmodificada.ci.gointegro.net" en "#content"
