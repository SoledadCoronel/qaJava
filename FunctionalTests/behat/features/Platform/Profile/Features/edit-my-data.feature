# language: es

@editMyData
Característica: Editar datos de perfil.
    Como usuario de frontend quiero poder editar mis datos de perfil.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "go1234"
        Cuando presiono "_submit"

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Editar mis datos", pero ingreso un documento y una fecha de nacimiento inválidos. Entonces debo ver dos mensajes de error.
        Dado estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Editar mis datos" en ".profile"
        Y hago click en "#data-edit-modal-link"
        Y debe aparecer "#data-edit-modal"
        Y debo ver "Seleccione..."
        Y relleno con "@~123456" a "document"
        Y relleno la fecha "birthdate" con "31/12/2020"
        Cuando presiono "saveProfileData"
        Entonces debo ver "El documento ingresado es inválido."
        Y debo ver "La fecha de nacimiento no puede ser mayor a la fecha actual."

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Editar mis datos", modifico mi documento y fecha de nacimiento. Entonces debo ver un mensaje de confirmación.
        Dado estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Editar mis datos" en ".profile"
        Y hago click en "#data-edit-modal-link"
        Y debe aparecer "#data-edit-modal"
        Y debo ver "Seleccione..."
        Y relleno con "23456789" a "document"
        Y relleno la fecha "birthdate" con "31/12/1970"
        Cuando presiono "saveProfileData"
        Entonces espero a que aparezca el contenido dinámico "Sus datos fueron actualizados exitosamente." en "#data-edit-modal-message"

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario quiero editar el idioma
        Dado voy a "/auth/signout"
        Y debo estar en "/auth/signin"
        Y relleno "_username" con "sarahconnor"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Cuando estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Editar mis datos" en ".profile"
        Y hago click en "#data-edit-modal-link"
        Y debe aparecer "#data-edit-modal"
        Y debo ver "Español"
        Cuando presiono "saveProfileData"
        Entonces espero a que aparezca el contenido dinámico "Sus datos fueron actualizados exitosamente." en "#data-edit-modal-message"

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario quiero editar la zona horaria
      Dado estoy en "/profile"
      Y hago click en "#data-edit"
      Y espero a que aparezca el contenido dinámico "Editar mis datos" en ".profile"
      Y hago click en "#data-edit-modal-link"
      Y debe aparecer "#data-edit-modal"
      Y debo ver "America/Argentina/Buenos_Aires"
      Y selecciono "Africa/Abidjan" de "timezone"
      Cuando presiono "saveProfileData"
      Entonces espero a que aparezca el contenido dinámico "Sus datos fueron actualizados exitosamente." en "#data-edit-modal-message"
