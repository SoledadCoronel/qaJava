# language: es
Característica: Verificacion de dos datos en una plataforma común
    Para poder registrarme en una plataforma no regional
    Como usuario común con datos cargados y activo pero sin registrar
    Necesito verificar mis datos

    @javascript @doubleVerificationData
    Esquema del escenario: Verificacion de dos datos correctos
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y espero a que aparezca "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Y relleno "_verificationValue2" con "<value2>"
        Cuando presiono "verificationSubmit"
        Entonces debe cambiar la URL
        Y la URL debe seguir el patrón "/auth/signup/platformId/\d+/value1/<value1>/value2/<value2>"

        Ejemplos:
            | description |            host                  |             value1             |             value2             |
            |   id+doc    | http://platform1.ci.gointegro.net |             tyrion             |            99999999            |
            |  id+email   | http://platform2.ci.gointegro.net |             tyrion             | tyrion.lannister@gointegro.com |
            |   doc+id    | http://platform3.ci.gointegro.net |            99999999            |             tyrion             |
            |  doc+email  | http://platform4.ci.gointegro.net |            99999999            | tyrion.lannister@gointegro.com |
            |  email+id   | http://platform5.ci.gointegro.net | tyrion.lannister@gointegro.com |             tyrion             |
            |  email+doc  | http://platform6.ci.gointegro.net | tyrion.lannister@gointegro.com |            99999999            |

    @javascript
    Esquema del escenario: Verificacion de dos datos, el primero incorrecto
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y espero a que aparezca "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Y relleno "_verificationValue2" con "<value2>"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer ".verification_error"

        Ejemplos:
            | description |            host                  |         value1          |             value2             |
            |   id+doc    | http://platform1.ci.gointegro.net |        ned.stark        |            99999999            |
            |  id+email   | http://platform2.ci.gointegro.net |        ned.stark        | tyrion.lannister@gointegro.com |
            |   doc+id    | http://platform3.ci.gointegro.net |        XXXXXXXX         |             tyrion             |
            |  doc+email  | http://platform4.ci.gointegro.net |        XXXXXXXX         | tyrion.lannister@gointegro.com |
            |  email+id   | http://platform5.ci.gointegro.net | ned.stark@gointegro.com |             tyrion             |
            |  email+doc  | http://platform6.ci.gointegro.net | ned.stark@gointegro.com |            99999999            |

    @javascript
    Esquema del escenario: Verificacion de dos datos, el segundo incorrecto
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y espero a que aparezca "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Y relleno "_verificationValue2" con "<value2>"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer ".verification_error"

        Ejemplos:
            | description |            host                  |             value1             |         value2          |
            |   id+doc    | http://platform1.ci.gointegro.net |             tyrion             |        XXXXXXXX         |
            |  id+email   | http://platform2.ci.gointegro.net |             tyrion             | ned.stark@gointegro.com |
            |   doc+id    | http://platform3.ci.gointegro.net |            99999999            |        ned.stark        |
            |  doc+email  | http://platform4.ci.gointegro.net |            99999999            | ned.stark@gointegro.com |
            |  email+id   | http://platform5.ci.gointegro.net | tyrion.lannister@gointegro.com |        ned.stark        |
            |  email+doc  | http://platform6.ci.gointegro.net | tyrion.lannister@gointegro.com |        XXXXXXXX         |

    @javascript
    Esquema del escenario: Verificacion de dos datos incorrectos
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y espero a que aparezca "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Y relleno "_verificationValue2" con "<value2>"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer ".verification_error"

        Ejemplos:
            | description |            host                  |         value1          |         value2          |
            |   id+doc    | http://platform1.ci.gointegro.net |        ned.stark        |        XXXXXXXX         |
            |  id+email   | http://platform2.ci.gointegro.net |        ned.stark        | ned.stark@gointegro.com |
            |   doc+id    | http://platform3.ci.gointegro.net |        XXXXXXXX         |        ned.stark        |
            |  doc+email  | http://platform4.ci.gointegro.net |        XXXXXXXX         | ned.stark@gointegro.com |
            |  email+id   | http://platform5.ci.gointegro.net | ned.stark@gointegro.com |        ned.stark        |
            |  email+doc  | http://platform6.ci.gointegro.net | ned.stark@gointegro.com |        XXXXXXXX         |

    @javascript
    Esquema del escenario: Verificacion de dos datos, el segundo vacío
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y espero a que aparezca "#verificationModal"
        Y relleno "_verificationValue1" con "<value1>"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer "#verification-input-error2"

        Ejemplos:
            | description |            host                  |             value1             |
            |   id+doc    | http://platform1.ci.gointegro.net |             tyrion             |
            |  id+email   | http://platform2.ci.gointegro.net |             tyrion             |
            |   doc+id    | http://platform3.ci.gointegro.net |            99999999            |
            |  doc+email  | http://platform4.ci.gointegro.net |            99999999            |
            |  email+id   | http://platform5.ci.gointegro.net | tyrion.lannister@gointegro.com |
            |  email+doc  | http://platform6.ci.gointegro.net | tyrion.lannister@gointegro.com |

    @javascript
    Esquema del escenario: Verificacion de dos datos, el primero vacío
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y espero a que aparezca "#verificationModal"
        Y relleno "_verificationValue2" con "<value2>"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer "#verification-input-error1"

        Ejemplos:
            | description |            host                  |             value2             |
            |   id+doc    | http://platform1.ci.gointegro.net |            99999999            |
            |  id+email   | http://platform2.ci.gointegro.net | tyrion.lannister@gointegro.com |
            |   doc+id    | http://platform3.ci.gointegro.net |             tyrion             |
            |  doc+email  | http://platform4.ci.gointegro.net | tyrion.lannister@gointegro.com |
            |  email+id   | http://platform5.ci.gointegro.net |             tyrion             |
            |  email+doc  | http://platform6.ci.gointegro.net |            99999999            |

    @javascript
    Esquema del escenario: Verificacion de dos datos, el ambos vacíos
        Dado estoy en "<host>"
        Y presiono "signupButton"
        Y espero a que aparezca "#verificationModal"
        Cuando presiono "verificationSubmit"
        Entonces debe aparecer "#verification-input-error1"
        Y debe aparecer "#verification-input-error2"

        Ejemplos:
            | description |            host                  |
            |   id+doc    | http://platform1.ci.gointegro.net |
            |  id+email   | http://platform2.ci.gointegro.net |
            |   doc+id    | http://platform3.ci.gointegro.net |
            |  doc+email  | http://platform4.ci.gointegro.net |
            |  email+id   | http://platform5.ci.gointegro.net |
            |  email+doc  | http://platform6.ci.gointegro.net |
