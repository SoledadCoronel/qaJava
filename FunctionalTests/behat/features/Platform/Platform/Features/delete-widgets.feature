# language: es

Característica: Como usuario debo poder eliminar los widgets en la home.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Eliminar un widget de la home.
        Dado hago click en ".configure-widget"
        Y sigo el link "Eliminar"
        Y espero a que aparezca el contenido dinámico "Eliminar módulo" en "#delete-modal"
        Y presiono "Confirmar"
        Cuando presiono "Aceptar"
        Y debe aparecer el contenido dinámico "Inicio" en "#environmentHome"
        Y sigo el link "Configurar"
        Entonces no debo ver "Widget de Banner/Imagen"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Elimino un banner y presiono cancelar.
        Dado hago click en ".configure-widget"
        Y sigo el link "Eliminar"
        Y espero a que aparezca el contenido dinámico "Eliminar módulo" en "#delete-modal"
        Y presiono "Confirmar"
        Cuando presiono "Cancelar"
        Y confirmo el popup
        Y debe aparecer el contenido dinámico "Inicio" en "#environmentHome"
        Y sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
        Entonces hago click en ".configure-widget:eq(0)"
        Y sigo el link "Editar"
        Y espero a que aparezca el contenido dinámico "Configuración" en ".modal-body"
