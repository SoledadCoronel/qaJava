# language: es
Característica: Como usuario necesito poder unirme/abandonar a espacios públicos sin autojoin

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadWorkspaceSortData
    Escenario: Me uno a un espacio
        Dado sigo "Social"
        Y presiono "dropdown-workspace-menu"
        Y sigo "Unirme a otro espacio"
        Y espero a que aparezca el contenido dinámico "Unirme" en ".spaces-list"
        Cuando presiono "Unirme"
        Y sigo "Social"
        Entonces el orden de "li.nav-header" debe ser "ESPACIO PARA UNIRSE, ESPACIO PARA ABANDONAR"

    @javascript @loadWorkspaceSortData
    Escenario: Abandono un espacio
        Dado sigo "Social"
        Y presiono "dropdown-workspace-menu"
        Y sigo "Unirme a otro espacio"
        Y espero a que aparezca el contenido dinámico "Abandonar" en ".spaces-list"
        Cuando presiono "Abandonar"
        Y sigo "Social"
        # Se comenta porque los usuarios administradores ahora ven todos los espacios aunque no esten unidos
        # @todo usar usuario común para este test
        # Entonces debo ver "No se encontraron espacios disponibles para este ambiente."

    @javascript @loadWorkspaceSortData
    Escenario: Abandono un espacio privado
        Dado sigo "Privado"
        Y presiono "dropdown-workspace-menu"
        Y sigo "Unirme a otro espacio"
        Y espero a que aparezca el contenido dinámico "Abandonar" en ".spaces-list"
        Cuando presiono "Abandonar"
        Y sigo "Privado"
        # Se comenta porque los usuarios administradores ahora ven todos los espacios aunque no esten unidos
        # @todo usar usuario común para este test
        # Entonces debo ver "No se encontraron espacios disponibles para este ambiente."

    @javascript @loadWorkspaceSortData
    Escenario: Me uno a un espacio como usuario básico
        Dado voy a "/auth/signout"
        Y debo estar en "/auth/signin"
        Y relleno "_username" con "tyrion.lannister"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Cuando estoy en "/"
        Y sigo "Social"
        Y no debo ver "dropdown-workspace-menu"
        Y debo ver "Unirme a otro espacio"
        Y sigo "Unirme a otro espacio"
        Y espero a que aparezca el contenido dinámico "Unirme" en ".spaces-list"
        Y presiono "Unirme"
        Y sigo "Social"
        Entonces el orden de "li.nav-header" debe ser "ESPACIO PARA UNIRSE, ESPACIO PARA ABANDONAR"