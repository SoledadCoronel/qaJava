#language: es

Característica: Actualizar colaboradores de una aplicación de celebraciones de un espacio privado.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenedor dinámico ".space-option"
        Y debo ver "Espacio Privado"
        Y presiono "dropdown-workspace-menu"
        Y sigo "Unirme a otro espacio"


    @javascript @loadPrivateWSCelebrationApp
    Escenario: Agregar usuario a espacio privado y se debe actualizar la aplicacion de celebraciones
        Dado espero a que aparezca el contenido dinámico "Unirme a un espacio" en ".app-title"
        Y espero a que aparezca el contenido dinámico "Unirme" en ".spaces-list"
        Cuando presiono "Unirme"
        Y sigo "Celebraciones en WS privado"
        Entonces espero a que aparezca el contenido dinámico "Cumpleaños de John Connor" en ".celebration-list"
