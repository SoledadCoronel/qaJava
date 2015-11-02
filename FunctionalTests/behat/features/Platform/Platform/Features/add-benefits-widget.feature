# language: es

Característica: Agregar widget de beneficios.
    Como usuario administrador de la plataforma quiero poder instalar widgets de beneficios desde el gestor de widgets.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        #Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
        Y presiono "Agregar Módulo"
        Y sigo "Nuevo Módulo"
        Y espero a que aparezca el contenido dinámico "Continuar" en ".modal-footer"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Agregar widget de beneficios
        Dado hago click en ".benefits-app-radio"
        Y presiono "Continuar"
        Y debo ver "Especiales"
        Y debo ver "Categorías"
        Y debo ver "Ranking"
