#language: es
Característica: Registrarme en la plataforma como usuario en una cuenta regional.

        Antecedentes:
        Dado estoy en "http://regional.ci.gointegro.net/auth/signout"

        @javascript @regionalSignupData
        Escenario: Registrarme como usuario en una cuenta sin verificacion, seleccionando la plataforma
        Dado estoy en "http://regional.ci.gointegro.net/auth/signin?_lang=es"
        Y sigo "signupButton"
        Y debo estar en "http://regional.ci.gointegro.net/auth/signup"
        Y relleno "name" con "Jorge"
        Y relleno "surname" con "Perez"
        Y relleno "email" con "mi@email.com"
        Y relleno "document" con "Y2K386"
        Y relleno "password" con "go1234"
        Y relleno "repeatPassword" con "go1234"
        Y selecciono "30" de "birthdate-day"
        Y selecciono "Mayo" de "birthdate-month"
        Y selecciono "1998" de "birthdate-year"
        Y marco "termsAndConditions"
        Y selecciono "GoIntegro Platform 2" de "platform"
        Y presiono "submitRegistration"
        Y espero a que cambie la URL
        Y debo estar en "http://regional.ci.gointegro.net/auth/signin"
        Y relleno "_username" con "Y2K386"
        Y relleno "_password" con "go1234"
        Cuando presiono "_submit"
        Y espero a que cambie la URL
        Entonces debo estar en "/"
        Y voy a "http://platform2.ci.gointegro.net/auth/signout"

        @javascript @regionalVerificationSignupData
        Escenario: Registrarme en una cuenta con verificacion, seleccionando la plataforma.
        Dado estoy en "http://regional.ci.gointegro.net/auth/signin?_lang=es"
        Y espero a que aparezca el contenido dinámico "Registrarme" en ".form-signin"
        Y sigo "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "Usuario1"
        Y selecciono "GoIntegro Platform 2" de "_platform"
        Y presiono "verificationSubmit"
        Y espero a que cambie la URL
        Y la URL debe seguir el patrón "/auth/signup/platformId/\d+/value1/Usuario1"
        Y relleno "name" con "Nombre"
        Y relleno "password" con "go1234"
        Y relleno "repeatPassword" con "go1234"
        Y selecciono "30" de "birthdate-day"
        Y selecciono "Mayo" de "birthdate-month"
        Y selecciono "1998" de "birthdate-year"
        Y marco "termsAndConditions"
        Cuando presiono "submitRegistration"
        Y espero a que cambie la URL
        Entonces debo estar en "/auth/signin"
        Y relleno "_username" con "abc11122"
        Y relleno "_password" con "go1234"
        Y presiono "_submit"
        Y espero a que cambie la URL
        Y debo estar en "/"
        Y voy a "http://platform2.ci.gointegro.net/auth/signout"
