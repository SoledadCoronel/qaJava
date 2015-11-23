#language: es
Característica: Registrarme en la plataforma como usuario común debiendo completar los campos variables que requiere el formulario.

        @javascript @registerSimpleSignupEmailAndGender
        Escenario: Registrarme a la plataforma seleccionando el sexo Masculino.
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y marco "gender-0"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Y espero a que cambie la URL
          Entonces debo estar en "/auth/signin"
          Y relleno "_username" con "mi@email.com"
          Cuando presiono "_submit"
          Entonces debo estar en "/"

        @javascript
        Escenario: Registrarme a la plataforma seleccionando el sexo Femenino.
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge Pablo"
          Y relleno "surname" con "Rodriguez"
          Y relleno "email" con "rodriguez@email.com"
          Y marco "gender-1"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Y espero a que cambie la URL
          Entonces debo estar en "/auth/signin"
          Y relleno "_username" con "mi@email.com"
          Cuando presiono "_submit"
          Entonces debo estar en "/"


        @javascript @registerSimpleSignupEmailAndBirthDate
        Escenario: Registrarme a la plataforma ingresando la fecha de nacimiento.
          Dado estoy en "auth/signup"
          Y relleno "name" con "Jorge"
          Y relleno "surname" con "Perez"
          Y relleno "email" con "mi@email.com"
          Y selecciono "30" de "birthdate-day"
          Y selecciono "Octubre" de "birthdate-month"
          Y selecciono "1980" de "birthdate-year"
          Y marco "termsAndConditions"
          Cuando presiono "submitRegistration"
          Y espero a que cambie la URL
          Entonces debo estar en "/auth/signin"
          Y relleno "_username" con "mi@email.com"
          Cuando presiono "_submit"
          Entonces debo estar en "/"

        @javascript @registerSimpleSignupEmailAndBirthDateAndGenderAndCard
        Escenario: Registrarme a la plataforma dejando en blanco todos los campos 
          Dado estoy en "auth/signup"
          Cuando presiono "submitRegistration"
          Entonces debo ver "El correo electrónico no puede estar vacío."
