# language: es

@notificationPreference
Característica: Modificar mis preferencias de notificaciones.
    Como usuario básico de la plataforma quiero poder modificar mis preferencias de notificaciones.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "go1234"
        Cuando presiono "_submit"

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Configuración de notificaciones", entonces debo ver las opciones y espacios correspondientes al usuario.
        Dado estoy en "/profile"
        Cuando hago click en "#data-edit"
        Entonces espero a que aparezca el contenido dinámico "Configuración de notificaciones" en ".profile"
        Y hago click en "#notification-preference-modal-link"
        Y debe aparecer "#notification-preference-modal"
        Y debo ver "Sí deseo recibir notificaciones"
        Y debo ver "Me siguen"
        Y debo ver "Realizan una publicación en mi perfil"
        Y debo ver "Ocurre una actividad en los contenidos que sigo"
        Y debo ver "Me mencionan"
        Y debo ver "Diaria"
        Y debo ver "Semanal"
        Y debo ver "Mensual"
        Y debo ver "Deseo que cada espacio tenga una frecuencia de notificacion particular"
        Y debo ver "La Cabe"
        Y debo ver "Zona"
        Y debo ver "Comunidad tres tiras"
        Y debo ver "Intranet"

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Configuración de notificaciones", modifico la frecuencia general de las notificaciones y guardo. Entonces debo ver un mensaje de confirmación.
        Dado estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Configuración de notificaciones" en ".profile"
        Y hago click en "#notification-preference-modal-link"
        Y debe aparecer "#notification-preference-modal"
        Y hago click en "#frequency-1"
        Cuando presiono "saveNotificationPreference"
        Entonces espero a que aparezca el contenido dinámico "Sus preferencias fueron actualizadas exitosamente." en "#notification-preference-modal-message"

    @javascript @loadUserAndPostData
    Escenario: Desde mi perfil de usuario ingreso al menú desplegable de opciones y selecciono "Configuración de notificaciones", modifico la frecuencia de notificaciones por espacios y guardo. Entonces debo ver un mensaje de confirmación.
        Dado estoy en "/profile"
        Y hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Configuración de notificaciones" en ".profile"
        Y hago click en "#notification-preference-modal-link"
        Y debe aparecer "#notification-preference-modal"
        Y hago click en "#workspaceEnabledContainer"
        Y hago click en "#workspaceNotificationFrequency input:eq(1)"
        Y hago click en "#workspaceNotificationFrequency input:eq(6)"
        Y hago click en "#workspaceNotificationFrequency input:eq(9)"
        Y hago click en "#workspaceNotificationFrequency input:eq(14)"
        Cuando presiono "saveNotificationPreference"
        Entonces espero a que aparezca el contenido dinámico "Sus preferencias fueron actualizadas exitosamente." en "#notification-preference-modal-message"