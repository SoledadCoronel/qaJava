#language: es
Característica: Login Backoffice. 
Como usuario de Backoffice quiero poder ingresar al Backoffice para poder configurar 

        
    @javascript @createAccountAndUserAndPlatform
    Escenario: Completo los campos del formulario de login del BO correctamente e ingreso a la home de BO 
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Cuando presiono "_submit" 
        Entonces debo estar en "/backoffice/" 
        Y debo ver "Bienvenidos al Back Office!" 
        Y sigo "Cerrar Sesión"

    @javascript @createAccountAndUserAndPlatform
    Escenario: Intento ingresar a la home de BO completando los campos con valores invalidos (usuario y password incorrectos) 
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "lalala" 
        Y relleno "_password" con "lalala" 
        Cuando presiono "_submit" 
        Entonces debe aparecer ".error-login" 
        Y debo estar en "/backoffice/signin" 
        Y debo ver "Usuario o contraseña inválidos"

    @javascript @createAccountAndUserAndPlatform
    Escenario: Intento ingresar a la home de BO completando los campos con valores invalidos (valores nulos) 
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "" 
        Y relleno "_password" con "" 
        Cuando presiono "_submit" 
        Entonces debe aparecer ".error-login" 
        Y debo estar en "/backoffice/signin" 
        Y debo ver "Usuario o contraseña inválidos"

    @javascript @createAccountAndUserAndPlatform
    Escenario: Intento ingresar a la home de BO completando los campos con valores invalidos (espacios en blanco) 
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con " " 
        Y relleno "_password" con " " 
        Cuando presiono "_submit" 
        Entonces debe aparecer ".error-login" 
        Y debo estar en "/backoffice/signin" 
        Y debo ver "Usuario o contraseña inválidos"
