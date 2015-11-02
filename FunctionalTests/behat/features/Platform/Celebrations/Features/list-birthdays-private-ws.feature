# language: es

Característica: Como usuario admin quiero listar las celebraciones de un espacio privado.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadPrivateWSCelebrationApp
    Escenario: Con una aplicación de celebraciones instalada en un espacio privado, tengo que ver sólo los cumpleaños de los colaboradores de ese espacio y no los de aquellos que no lo sean.
        Dado sigo "Inicio"
        Y espero a que aparezca el contenedor dinámico ".workspace-menu"
        Y sigo "Celebraciones en WS privado"
        Entonces espero a que aparezca el contenido dinámico "privateworkspace user" en ".celebration-list"
        Y no debo ver "non-private-workspace user"
