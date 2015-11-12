# language: es
Característica: Olvidé mi contraseña
Para acceder a la plataforma en caso de olvidar mi contraseña
Como usuario común ya registrado
Necesito recuperar mis credenciales

  @javascript @forgotPassword @ignore
  Escenario: Recibo el mail para recuperar la contraseña
    Dado estoy en la página de inicio
    Y sigo "forgotPasswordButton"
    Y espero a que aparezca "#forgotPasswordModal"
    Y relleno "email" con "test.behat@gmail.com"
    Cuando presiono "forgotPasswordSubmit"
    Entonces debe aparecer ".forgot_success"

  @javascript @forgotPassword @ignore
  Escenario: Ingreso un email que no existe
    Dado estoy en la página de inicio
    Y sigo "forgotPasswordButton"
    Y espero a que aparezca "#forgotPasswordModal"
    Y relleno "email" con "email@invalido.com"
    Cuando presiono "forgotPasswordSubmit"
    Entonces debe aparecer ".forgot_error"

  @javascript @forgotPassword
  Esquema del escenario: Ingreso un email inválido o vacío
    Dado estoy en la página de inicio
    Y sigo "forgotPasswordButton"
    Y espero a que aparezca "#forgotPasswordModal"
    Y relleno "email" con "<value>"
    Cuando presiono "forgotPasswordSubmit"
    Entonces debe aparecer el contenido dinámico "<error>" en "#forgotPasswordModal"

    Ejemplos:

    |      value     | error                            |
    |                | Este campo no puede estar vacío  |
    | email_invalido | La dirección de email es inválida |

  @javascript @forgotPassword
  Escenario: Recupero contraseña satisfactoriamente
    Dado estoy en "/auth/recover/token/fake_token?_lang=es"
    Y relleno "password" con "new_password"
    Y relleno "password2" con "new_password"
    Y presiono "recoverPasswordSubmit"
    Entonces  debe cambiar la URL
    Y debo estar en "/auth/signin"
    Cuando relleno "_username" con "test.behat@gmail.com"
    Y relleno "_password" con "new_password"
    Y presiono "_submit"
    Entonces debo estar en "/"

  @javascript @forgotPassword
  Esquema del escenario: Ingreso mal los datos
    Dado estoy en "/auth/recover/token/fake_token?_lang=es"
    Y relleno "password" con "<value1>"
    Y relleno "password2" con "<value2>"
    Cuando presiono "recoverPasswordSubmit"
    Entonces debo ver "<error>"

    Ejemplos:

    | value1 | value2 | error                                   |
    | 123456 | 654321 | El password difiere con la verificación |
    |  123   |  123   | El campo debe tener mas de 6 dígitos    |
    |        |        | Este campo no puede estar vacío         |

  @javascript @forgotPasswordExpired
  Escenario: Intento acceder a recuperar mi contraseña cuando expiró el token
    Dado estoy en "/auth/recover/token/fake_token?_lang=es"
    Entonces debo ver "La recuperación de contraseña es inválida o expiró, inténtelo nuevamente."