# language: es

Característica: Como usuario debo poder ver los widgets de la home.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Configurar Home.
        Dado sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Aceptar" en "header.app-name
        Y debo ver "Widget de HTML/Texto"
        Cuando presiono "Aceptar"
        Entonces debe aparecer el contenido dinámico "Inicio" en "#environmentHome"
        Y debo estar en "/environment/inicio"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Configurar Home y cancelar.
        Dado sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Aceptar" en "header.app-name"
        Y debo ver "Widget de HTML/Texto"
        Cuando presiono "Cancelar"
        Entonces debo estar en "/environment/inicio"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Home layout grid + wall.
        Dado estoy en "/"
        Y sigo "Grilla + Muro"
        Y debo ver "Widget de HTML/Texto."
        Y espero a que aparezca el contenido dinámico "Publicar" en "#wall"
        Y relleno "text" con "Comentario desde el muro de la home del ambiente Grilla + Muro."
        Cuando presiono "Publicar"
        Entonces espero a que aparezca el contenido dinámico "Comentario desde el muro de la home del ambiente Grilla + Muro." en ".social-feed-content"
