# language: es
Característica: Testing login

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "soledad.coronel@gointegro.com"
      Y relleno "_password" con "coquito25"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
     # Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"





    @javascript
    Escenario: Configurar Home.
        Dado sigo el link "Configurar"
      #  Y espero a que aparezca el contenido dinámico "Aceptar" en "header.app-name"
        Y debo ver "Widget de HTML/Texto"
        Cuando presiono "Aceptar"
      #  Entonces debe aparecer el contenido dinámico "Inicio" en "#environmentHome"
        Y debo estar en "/environment/inicio"

