# language: es
Característica: Verificacion de un dato en una cuenta regional
    Para poder registrarme en una plataforma regional
    Como usuario común con datos cargados y activo pero sin registrar
    Necesito verificar mis datos desde la cuenta regional

    @javascript @regionalVerificationData
    Esquema del escenario: Verificacion de un dato correcto
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Cuando presiono "verificationSubmit"
        Y espero a que cambie la URL
        Entonces la URL debe seguir el patrón "/auth/signup/platformId/\d+/value1/<value1>"

        Ejemplos:
            | description |              host                                    |             value1             |
            |     id      | http://company1.ci.gointegro.net/auth/signin?_lang=es |             tyrion             |
            |     doc     | http://company2.ci.gointegro.net/auth/signin?_lang=es |            99999999            |
            |    email    | http://company3.ci.gointegro.net/auth/signin?_lang=es | tyrion.lannister@gointegro.com |

    @javascript @regionalVerificationData
    Esquema del escenario: Verificacion de un dato incorrecto
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer ".verification_error"

        Ejemplos:
            | description |               host                                   |        value1           |
            |     id      | http://company1.ci.gointegro.net/auth/signin?_lang=es |       ned.stark         |
            |     doc     | http://company2.ci.gointegro.net/auth/signin?_lang=es |       XXXXXXXX          |
            |    email    | http://company3.ci.gointegro.net/auth/signin?_lang=es | ned.stark@gointegro.com |

    @javascript @regionalVerificationData
    Esquema del escenario: Verificacion de un usuario de otra plataforma
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y debe aparecer "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Y selecciono "<platform>" de "_platform"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer ".verification_error"

        Ejemplos:
            | description |               host                                   |             value1             |       platform           |
            |     id      | http://company1.ci.gointegro.net/auth/signin?_lang=es |             tyrion             |        IdFails           |
            |     doc     | http://company2.ci.gointegro.net/auth/signin?_lang=es |            99999999            |       DocFails           |
            |    email    | http://company3.ci.gointegro.net/auth/signin?_lang=es | tyrion.lannister@gointegro.com |      EmailFails          |
