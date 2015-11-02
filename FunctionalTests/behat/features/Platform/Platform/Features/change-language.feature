# language: es
Característica: Como usuario debo poder ver la plataforma en diferentes idiomas
    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"

    @javascript @loadLanguageTestData
    Escenario: Cambiar de idioma en la pantalla de sign in
        Dado debo ver "Español"
        Y Selecciono idioma English
        Y debo estar en "/auth/signin?_lang=en_US"
        Entonces debo ver "English"

    @javascript @loadLanguageTestData
    Escenario: Ingresar a la plataforma en inglés y luego ver el sign in en ese idioma
        Y Selecciono idioma English
        Y debo estar en "/auth/signin?_lang=en_US"
        Y relleno "_username" con "john-salchichon"
        Y relleno "_password" con "cabezona"
        Cuando presiono "_submit"
        Y debo estar en "/"
        Entonces debo ver "New Workspace"
        Y voy a "/auth/signout"
        Y voy a "/auth/signin"
        Y debo ver "English"