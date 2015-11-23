# language: es
Característica: Como usuario debo poder instalar widgets estándar en la home.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
        Y presiono "Agregar Módulo"
        Y sigo "Nuevo Módulo"
        Y espero a que aparezca el contenido dinámico "Continuar" en ".modal-footer"
        Y presiono "Continuar"
        Y espero a que aparezca el contenido dinámico "Tipo de módulos" en ".modal-body"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Instalar un widget de banner en la home
        Dado presiono "Continuar"
        Y espero a que aparezca el contenido dinámico "Configuración" en ".widget-form"
        Y relleno "name" con "Banner 2"
        Y hago visible "banner-image-upload"
        Y hago click en ".hasLink"
        Y relleno "externalUrl" con "http://www.google.com"
        Y adjunto el archivo "tyrion.jpg" a "banner-image-upload"
        Y presiono "Finalizar"
        Y presiono "Aceptar"
        Y debe aparecer el contenido dinámico "Inicio" en "#environmentHome"
        Y sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
        Cuando hago click en ".configure-widget:eq(2)"
        Y sigo el link "Editar"
        Entonces espero a que aparezca el contenedor dinámico ".widget-title"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Instalar un widget de banner en la home y ver errores
        Dado presiono "Continuar"
        Y espero a que aparezca el contenido dinámico "Configuración" en ".widget-form"
        Y hago click en ".hasLink"
        Cuando presiono "Finalizar"
        Entonces debo ver "Es necesario que suba una imagen."
        Y debo ver "Este campo es obligatorio."
        Y debo ver "Ingrese una URL válida."

    @javascript @loadInstallApplicationWidgetData
    Escenario: Desde el modal de instaláción de widgets me dispongo a instalar un widget de texto / HTML pero no completo los datos requeridos. Entonces debo ver los correspondientes mensajes de error.
        Dado hago click en ".html-text-radio"
        Y presiono "Continuar"
        Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
        Y espero a que aparezca el contenedor dinámico ".mce-tinymce"
        Cuando presiono "Finalizar"
        Entonces debo ver "Este campo es obligatorio."

    @javascript @loadInstallApplicationWidgetData
    Escenario: Desde el modal de instalación de widgets me dispongo a instalar un widget de texto / HTML completando los datos requeridos. Entonces debo ver un mensaje de confirmación y posteriormente acceder a la pantalla de visualización y administración de widgets.
        Dado hago click en ".html-text-radio"
        Y presiono "Continuar"
        Y espero a que aparezca el contenido dinámico "Configuración" en ".widget-form"
        Y relleno "name" con "Widget de texto"
        Y completo el WYSIWYG "htmlText" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        Y presiono "Finalizar"
        Cuando presiono "Aceptar"
        Entonces espero a que aparezca el contenido dinámico "Inicio" en "#environmentHome"
        Y debo ver "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
