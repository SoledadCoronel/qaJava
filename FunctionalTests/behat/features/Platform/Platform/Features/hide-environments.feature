#language: es
Característica: Ver un larga colleccion de ambientes ocultos en la barra
	Como usuario comun, debo ver que una barra con gran cantidad de ambientes se organiza en un dropdown
    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadPlatformAndEnvironments
  	Escenario: Ver que los ambientes no rompan la barra
	  	Dado estoy en "/"
		Y espero a que aparezca el contenido dinámico "Inicio" en "#environments"
		Y debo ver "Beneficios Corporativos"
		Y debo ver "Grilla + Muro"
        Y debo ver "Sin Login"
		Y no debo ver "Test Environment 4"
		Y hago click en ".more-options .dropdown-toggle"
        Y debo ver "Test Environment 1"
		Y debo ver "Test Environment 2"
		Y debo ver "Test Environment 3"
		Y debo ver "Test Environment 4"
		Y debo ver "Test Environment 5"
		Y debo ver "Test Environment 6"
