# language: es
Característica: Como usuario de la plataforma veo los espacios listados en mi perfil.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"

    @javascript @loadWorkspaceData
    Escenario: Desde la solapa espacios en mi perfil voy a un espacio con al menos una aplicación instalada
        Dado voy a "/profile"
        Y debo ver "John Connor"
        Y sigo "Espacios"
        Y espero a que aparezca el contenido dinámico "Intranet" en ".spaces-profile"
        Y debo ver "Acceso Google"
        Y debo ver "Espacio privado"
        Cuando presiono "Intranet-workspace-link"
        Entonces la URL debe seguir el patrón "/social/app/\d+"

    @javascript @loadWorkspaceData
    Escenario: Desde la solapa espacios en mi perfil voy a un espacio con url externa
        Dado voy a "/profile"
        Y debo ver "John Connor"
        Y sigo "Espacios"
        Y espero a que aparezca el contenido dinámico "Intranet" en ".spaces-profile"
        Y debo ver "Acceso Google"
        Y debo ver "Espacio privado"
        Cuando presiono "Acceso Google-workspace-link"
        Entonces debo estar en "http://www.google.com.ar/"
        Y voy a "/auth/signout"

    @javascript @loadWorkspaceData
    Escenario: Desde la solapa espacios en mi perfil abandono un espacio
        Dado voy a "/profile"
        Y debo ver "John Connor"
        Y sigo "Espacios"
        Y espero a que aparezca el contenido dinámico "Intranet" en ".spaces-profile"
        Y debo ver "Acceso Google"
        Y debo ver "Espacio privado"
        Cuando presiono "Acceso Google-unjoin"
        Entonces debo ver "Intranet"
        Y debo ver "Espacio privado"
        Y no debo ver "Acceso Google"

    @javascript @loadWorkspaceData
    Escenario: Desde la solapa espacios, del perfil de otro usuario, me uno a un espacio público sin autojoin
        Dado voy a "/profile/usuario-test"
        Y debo ver "Usuario Test"
        Y sigo "Espacios"
        Y espero a que aparezca el contenido dinámico "Intranet" en ".spaces-profile"
        Y debo ver "Espacio privado"
        Y debo ver "Espacio público"
        Y debo ver "Unirme al espacio"
        Cuando hago click en ".joinButton"
        Entonces debe desaparecer el contenido dinámico "Unirme al espacio" en  ".joinButton"
