# language: es

Característica: Como usuario debo poder editar los widgets en la home.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
        Y hago click en ".widget-border.banner .configure-widget"
        Y sigo el link "Editar"
        Y espero a que aparezca el contenido dinámico "Configuración" en ".modal-body"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Configurar un widget de banner en la home.
        Dado relleno "name" con "Banner editado"
        Y hago visible "banner-image-upload"
        Y hago click en ".hasLink"
        Y relleno "externalUrl" con "http://www.google.com"
        Y adjunto el archivo "tyrion.jpg" a "banner-image-upload"
        Y presiono "Finalizar"
        Y espero a que aparezca el contenedor dinámico ".gridster"
        Y presiono "Aceptar"
        Y debe aparecer el contenido dinámico "Inicio" en "#environmentHome"
        Y sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
        Cuando hago click en ".configure-widget:eq(0)"
        Y sigo el link "Editar"
        Entonces espero a que aparezca el contenedor dinámico ".widget-title"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Configurar un widget de banner en la home y ver errores.
        Dado hago click en ".hasLink"
        Y hago click en ".delete"
        Cuando presiono "Finalizar"
        Entonces debo ver "Es necesario que suba una imagen"
        Y debo ver "El título ingresado es inválido"
        Y debo ver "Ingrese una URL válida"
