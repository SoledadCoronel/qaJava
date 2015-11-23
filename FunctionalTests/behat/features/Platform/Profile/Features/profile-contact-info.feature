# language: es

@profile @contact @info
Característica: Perfil de usuario.
    Como usuario básico de la plataforma, quiero ver mi información de contacto.

    Antecedentes: Autenticación en la plataforma con email y contraseña.
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "go1234"
        Cuando presiono "_submit"

    @javascript @loadUserAndPostData
    Escenario: Visualizar información de contacto de usuario autenticado.
        Dado estoy en "/profile"
        Entonces el elemento "#profile-picture" debe contener "jpg"
        Entonces debo ver "John Connor" en el elemento "#user-name"
        #Comento esto porque esta funcionalidad se va a terminar más adelante
        #Entonces debo ver "Departamento de tecnología" en el elemento "#department"
        #Entonces debo ver "Desarrollador web" en el elemento "#position"
        Entonces debo ver "john.connor@gointegro.com" en el elemento "#email"
        Cuando hago click en "#data-edit"
        Y espero a que aparezca el contenido dinámico "Editar mis datos" en ".profile"
        Y espero a que aparezca el contenido dinámico "Modificar mi contraseña" en ".profile"

    @javascript @loadUserAndPostData
    Escenario: Visualizar información de contacto de usuario.
        Dado estoy en "/profile/sarah-connor"
        Entonces el elemento "#profile-picture" debe contener "jpg"
        Entonces debo ver "Sarah Connor" en el elemento "#user-name"
        #Comento esto porque esta funcionalidad se va a terminar más adelante
        #Entonces debo ver "Departamento de tecnología" en el elemento "#department"
        #Entonces debo ver "Project Manager" en el elemento "#position"
        Entonces debo ver "sarah.connor@gointegro.com" en el elemento "#email"
        Entonces debe aparecer el contenido dinámico "Seguir" en "#follow-button"

    @javascript @loadProfileWithoutMail
    Escenario: Visualizar información de contacto de usuario autenticado con mail deshabilitado para mostrar
        Dado estoy en "/profile"
        Entonces el elemento "#profile-picture" debe contener "jpg"
        Entonces debo ver "John Connor" en el elemento "#user-name"
        Entonces no debo ver "johnconnor@gointegro.com"
