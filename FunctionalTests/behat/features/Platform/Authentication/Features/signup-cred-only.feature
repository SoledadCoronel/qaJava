#language: es
Característica: Registrarme en la plataforma como usuario común segun la estrategia de login. 

        Antecedentes:
        Dado estoy en "auth/signout"

        @javascript @registerSimpleSignupEmail
        Escenario: Registrarme a la plataforma con Email dejando todos los campos vacíos
          Dado estoy en "auth/signup"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El nombre no puede estar vacío."
          

        @javascript @registerSimpleSignupEmail
        Escenario: Registrarme a la plataforma con Email solo
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Y espero a que cambie la URL
          Entonces debo estar en "/auth/signin"
          Y relleno "_username" con "mi@email.com"
          Cuando presiono "_submit"
          Entonces debo estar en "/"

        @javascript @registerSimpleSignupEmail
        Escenario: Registrarme a la plataforma con Email invalido
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mail_invalido@a"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico ingresado es inválido."


        @javascript @registerSimpleSignupEmail
        Escenario: Registrarme a la plataforma con Email vacío
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico no puede estar vacío."

        @javascript @registerSimpleSignupEmailAndPassword
        Escenario: Registrarme a la plataforma con Email y Password dejando todos los campos vacíos
          Dado estoy en "auth/signup"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico no puede estar vacío."

        @javascript @registerSimpleSignupEmailAndPassword
        Escenario: Registrarme a la plataforma con Email y Password con verificacion inválida
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y relleno "password" con "go1234"
          Y relleno "repeatPassword" con "go4321"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "Las contraseñas ingresadas no coinciden." 

        @javascript @registerSimpleSignupEmailAndPassword
        Escenario: Registrarme a la plataforma con Email invalido y Password
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@d"
          Y relleno "password" con "go1234"
          Y relleno "repeatPassword" con "go1234"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico ingresado es inválido."
        
        @javascript @registerSimpleSignupEmailAndPassword
        Escenario: Registrarme a la plataforma con Email vacío y Password
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "password" con "go1234"
          Y relleno "repeatPassword" con "go1234"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico no puede estar vacío."

        
        @javascript @registerSimpleSignupIdPassword
        Escenario: Registrarme a la plataforma con Id y Password dejando todos los campos vacíos
          Dado estoy en "auth/signup"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico no puede estar vacío."

        @javascript @registerSimpleSignupIdPassword
        Escenario: Registrarme a la plataforma con Id y Password
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y relleno "usernameId" con "jorgeperez"
          Y relleno "password" con "go1234"
          Y relleno "repeatPassword" con "go1234"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Y espero a que cambie la URL
          Entonces debo estar en "/auth/signin"
          Y relleno "_username" con "jorgeperez"
          Y relleno "_password" con "go1234"
          Cuando presiono "_submit"
          Entonces debo estar en "/"

        @javascript @registerSimpleSignupIdPassword
        Escenario: Registrarme a la plataforma con Id vacío y Password
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y relleno "password" con "go1234"
          Y relleno "repeatPassword" con "go1234"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El Id no puede estar vacío."


        @javascript @registerSimpleSignupId
        Escenario: Registrarme a la plataforma con Id dejando todos los campos vacíos
          Dado estoy en "auth/signup"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico no puede estar vacío."

        @javascript @registerSimpleSignupId
        Escenario: Registrarme a la plataforma con Id
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y relleno "usernameId" con "jorgeperez"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Y espero a que cambie la URL
          Entonces debo estar en "/auth/signin"
          Y relleno "_username" con "jorgeperez"
          Cuando presiono "_submit"
          Entonces debo estar en "/"

        @javascript @registerSimpleSignupIdPassword
        Escenario: Registrarme a la plataforma con Id vacío
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El Id no puede estar vacío."


        @javascript @registerSimpleSignupDocumentPassword
        Escenario: Registrarme a la plataforma con Document y Password dejando todos los campos vacíos
          Dado estoy en "auth/signup"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico no puede estar vacío."
        
        @javascript @registerSimpleSignupDocumentPassword
        Escenario: Registrarme a la plataforma con Documento y Password
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y relleno "document" con "m0000090"
          Y relleno "password" con "go1234" 
          Y relleno "repeatPassword" con "go1234"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Y espero a que cambie la URL
          Entonces debo estar en "/auth/signin"
          Y relleno "_username" con "m0000090"
          Y relleno "_password" con "go1234"
          Cuando presiono "_submit"
          Entonces debo estar en "/"

        @javascript @registerSimpleSignupDocumentPassword
        Escenario: Registrarme a la plataforma con Documento vacío y Password
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y relleno "password" con "go1234"
          Y relleno "repeatPassword" con "go1234"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El documento no puede estar vacío."

        @javascript @registerSimpleSignupDocument
        Escenario: Registrarme a la plataforma con Document dejando todos los campos vacíos
          Dado estoy en "auth/signup"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El documento no puede estar vacío."

        @javascript @registerSimpleSignupDocument
        Escenario: Registrarme a la plataforma con documento
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y relleno "document" con "m0000090"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Y espero a que cambie la URL
          Entonces debo estar en "/auth/signin"
          Y relleno "_username" con "m0000090"
          Cuando presiono "_submit"
          Entonces debo estar en "/"

        @javascript @registerSimpleSignupDocument
        Escenario: Registrarme a la plataforma con Documento vacío
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El documento no puede estar vacío."


        @javascript @registerSimpleSignupDocument
        Escenario: Registrarme a la plataforma escribiendo un espacio en los campos nombre y apellido
          Dado estoy en "auth/signup"
          Y relleno "name" con " "
          Y relleno "surname" con " "
          Y relleno "email" con "mi@email.com"
          Y relleno "document" con "m0000090"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo estar en "/auth/signup"
          Y debo ver "El nombre no puede estar vacío"
          Y debo ver "El apellido no puede estar vacío"

        @javascript @registerSimpleSignupDocument
        Escenario: Registrarme a la plataforma escribiendo un espacio en los campos nombre, apellido y documento
          Dado estoy en "auth/signup"
          Y relleno "name" con " "
          Y relleno "surname" con " "
          Y relleno "email" con "mi@email.com"
          Y relleno "document" con " "
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Entonces debo estar en "/auth/signup"
          Y debo ver "El nombre no puede estar vacío"
          Y debo ver "El apellido no puede estar vacío"
          Y debo ver "El documento ingresado es inválido"
