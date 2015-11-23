# language: es

@passwordChange
Característica: Modificar mi contraseña.
    Como usuario de la plataforma quiero poder cambiar mi contraseña.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "go1234"
        Cuando presiono "_submit"

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Modificar mi contraseña", pero ingreso mal mi contraseña actual. Entonces debo ver un mensaje de error.
        Dado estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Modificar mi contraseña" en ".profile"
        Y hago click en "#password-change-modal-link"
        Y debe aparecer "#password-change-modal"
        Y relleno con "go4321" a "oldPassword"
        Y relleno con "go1234" a "newPassword"
        Y relleno con "go1234" a "repeatNewPassword"
        Cuando presiono "savePassword"
        Entonces espero a que aparezca el contenido dinámico "La contraseña ingresada es incorrecta." en "#oldPasswordError"

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Modificar mi contraseña", pero ingreso una nueva contraseña inválida. Entonces debo ver un mensaje de error.
        Dado estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Modificar mi contraseña" en ".profile"
        Y hago click en "#password-change-modal-link"
        Y debe aparecer "#password-change-modal"
        Y relleno con "go1234" a "oldPassword"
        Y relleno con "go integro" a "newPassword"
        Y relleno con "go integro" a "repeatNewPassword"
        Cuando presiono "savePassword"
        Entonces debo ver "Ingrese de 6 a 16 caracteres alfanuméricos sin colocar espacios."

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Modificar mi contraseña", pero ingreso una nueva contraseña inválida en el campo de verificación de contraseña. Entonces debo ver un mensaje de error.
        Dado estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Modificar mi contraseña" en ".profile"
        Y hago click en "#password-change-modal-link"
        Y debe aparecer "#password-change-modal"
        Y relleno con "go1234" a "oldPassword"
        Y relleno con "go4321" a "newPassword"
        Y relleno con "go4312" a "repeatNewPassword"
        Cuando presiono "savePassword"
        Entonces debo ver "Las contraseñas ingresadas no coinciden."

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Modificar mi contraseña", modifico mi contraseña. Entonces debo ver un mensaje de confirmación.
        Dado estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Modificar mi contraseña" en ".profile"
        Y hago click en "#password-change-modal-link"
        Y debe aparecer "#password-change-modal"
        Y relleno con "go1234" a "oldPassword"
        Y relleno con "go4321" a "newPassword"
        Y relleno con "go4321" a "repeatNewPassword"
        Cuando presiono "savePassword"
        Entonces espero a que aparezca el contenido dinámico "Su contraseña fue actualizada exitosamente." en "#password-change-modal-message"
