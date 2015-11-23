# language: es

@profile @follow @user
Característica: Perfil de usuario.
    Como usuario básico de la plataforma con funciones sociales activadas, quiero seguir y dejar de seguir a un usuario.

    Antecedentes: Autenticación en la plataforma con email y contraseña.
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "go1234"
        Cuando presiono "_submit"

    @javascript @loadUserAndPostData
    Escenario: Seguir y dejar de seguir a un usuario.
        Dado estoy en "/profile/sarah-connor"
        Y espero a que aparezca el contenido dinámico "Seguir" en "#follow-button"
        Cuando hago click en "#follow-button"
        Entonces el elemento "#unfollow-button" debe contener "Dejar de seguir"
        Cuando hago click en "#unfollow-button"
        Entonces el elemento "#follow-button" debe contener "Seguir"