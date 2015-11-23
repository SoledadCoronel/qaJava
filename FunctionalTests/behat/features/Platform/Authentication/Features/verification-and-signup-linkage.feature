# language: es
Característica: Verificacion y rellenar datos en el registro
    Para registrarme en una plataforma no regional
    Como usuario común con datos cargados y activo pero sin registrar
    Necesito verificar mis datos y luego registrarme

    @javascript @simpleVerificationData
    Esquema del escenario: Verificacion de un dato correcto y registro (Login por username)
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Cuando presiono "verificationSubmit"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/auth/signup/platformId/\d+/value1/<value1>"
        Y el campo "email" debe contener "tyrion.lannister@gointegro.com"
        Y el campo "name" debe contener "Tyrion"
        Y el campo "surname" debe contener "Lannister"
        Y marco "termsAndConditions"
        Cuando presiono "submitRegistration"
        Y espero a que cambie la URL
        Entonces debo estar en "/auth/signin"

        Ejemplos:
            | description |               host               |             value1             |
            |     id      | http://platform1.ci.gointegro.net |             tyrion             |
            |     doc     | http://platform2.ci.gointegro.net |            99999999            |
            |    email    | http://platform3.ci.gointegro.net | tyrion.lannister@gointegro.com |

    @javascript @doubleVerificationData
    Esquema del escenario: Verificacion de dos datos correctos y registro (Login por email)
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Y relleno "_verificationValue2" con "<value2>"
        Cuando presiono "verificationSubmit"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/auth/signup/platformId/\d+/value1/<value1>/value2/<value2>"
        Y el campo "email" debe contener "tyrion.lannister@gointegro.com"
        Y el campo "name" debe contener "Tyrion"
        Y marco "termsAndConditions"
        Cuando presiono "submitRegistration"
        Y espero a que cambie la URL
        Entonces debo estar en "/auth/signin"

        Ejemplos:
            | description |            host                  |             value1             |             value2             |
            |   id+doc    | http://platform1.ci.gointegro.net |             tyrion             |            99999999            |
            |  id+email   | http://platform2.ci.gointegro.net |             tyrion             | tyrion.lannister@gointegro.com |
            |   doc+id    | http://platform3.ci.gointegro.net |            99999999            |             tyrion             |
            |  doc+email  | http://platform4.ci.gointegro.net |            99999999            | tyrion.lannister@gointegro.com |
            |  email+id   | http://platform5.ci.gointegro.net | tyrion.lannister@gointegro.com |             tyrion             |
            |  email+doc  | http://platform6.ci.gointegro.net | tyrion.lannister@gointegro.com |            99999999            |

    @javascript @regionalVerificationData
    Esquema del escenario: Verificacion y registro de un usuario sin mail precargado
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Y selecciono "<platform>" de "_platform"
        Cuando presiono "verificationSubmit"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/auth/signup/platformId/\d+/value1/<value1>"
        Y el campo "email" debe contener ""
        Y el campo "name" debe contener "Usuario"
        Y relleno "email" con "<email>"
        Y marco "termsAndConditions"
        Cuando presiono "submitRegistration"
        Y espero a que cambie la URL
        Entonces debo estar en "/auth/signin"
        Y relleno "_username" con "<dataLogin>"
        Cuando presiono "_submit"
        Y espero a que cambie la URL
        Entonces debo estar en "/"

        Ejemplos:
            | description |               host              |             value1             |        platform          |        email            |        dataLogin        |
            |     id      | http://company1.ci.gointegro.net |             test               |        IdWorks           |   test@gointegro.com    |   test@gointegro.com    |
            |     doc     | http://company2.ci.gointegro.net |            12345678            |        DocWorks          |   test@gointegro.com    |         12345678        |

    @javascript @regionalVerificationData
    Esquema del escenario: Verificacion y registro de un usuario sin mail precargado, dejando el mail vacío en el registro
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Y selecciono "<platform>" de "_platform"
        Cuando presiono "verificationSubmit"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/auth/signup/platformId/\d+/value1/<value1>"
        Y el campo "email" debe contener ""
        Y el campo "name" debe contener "Usuario"
        Y marco "termsAndConditions"
        Cuando presiono "submitRegistration"
        Entonces debo ver "El correo electrónico no puede estar vacío"

        Ejemplos:
            | description |               host              |             value1             |        platform          |
            |     id      | http://company1.ci.gointegro.net |             test               |        IdWorks           |
            |     doc     | http://company2.ci.gointegro.net |            12345678            |        DocWorks          |
