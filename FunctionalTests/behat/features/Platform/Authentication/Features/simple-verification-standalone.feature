# language: es
Característica: Verificacion de un dato en una plataforma común
    Para poder registrarme en una plataforma no regional
    Como usuario común con datos cargados y activo pero sin registrar
    Necesito verificar mis datos

    @javascript @simpleVerificationData
    Esquema del escenario: Verificacion de un dato correcto
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Cuando presiono "verificationSubmit"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/auth/signup/platformId/\d+/value1/<value1>"

        Ejemplos:
            | description |               host               |             value1             |
            |     id      | http://platform1.ci.gointegro.net |             tyrion             |
            |     doc     | http://platform2.ci.gointegro.net |            99999999            |
            |    email    | http://platform3.ci.gointegro.net | tyrion.lannister@gointegro.com |

    @javascript
    Esquema del escenario: Verificacion de un dato incorrecto
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer ".verification_error"

        Ejemplos:
            | description |               host               |        value1           |
            |     id      | http://platform1.ci.gointegro.net |       ned.stark         |
            |     doc     | http://platform2.ci.gointegro.net |       XXXXXXXX          |
            |    email    | http://platform3.ci.gointegro.net | ned.stark@gointegro.com |

    @javascript
    Esquema del escenario: Verificacion de un dato vacío
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer "#verification-input-error1"

        Ejemplos:
            | description |               host               |
            |     id      | http://platform1.ci.gointegro.net |
            |     doc     | http://platform2.ci.gointegro.net |
            |    email    | http://platform3.ci.gointegro.net |
