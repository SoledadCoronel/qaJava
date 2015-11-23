# language: es
Característica: Ver mapa de categorías y beneficios destacados.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Espacio Autojoin" en ".espacios"

    @javascript @loadBenefitsStandardData
    Escenario: Visualizar todas las Categorías y subcategorías.
        Dado sigo "Ver más..."
        Cuando sigo "Mapa de Categorías de Beneficios Corporativos"
        Y espero a que aparezca el contenedor dinámico ".subcategories"
        Entonces debo ver "Autos y Motos"
        Y debo ver "Accesorios de Autos y Motos"
        Y debo ver "Mecánica y Servicios"
        Y espero a que aparezca el contenedor dinámico ".featured-category"

    @javascript @loadBenefitsRestrictedPlatformsData
    Escenario: Visualizar todas las categorías y subcategorías a excepción de aquellas restringidas.
        Dado sigo "Ver más..."
        Cuando sigo "Mapa de Categorías de Beneficios Corporativos"
        Y espero a que aparezca el contenedor dinámico ".subcategories"
        Entonces no debo ver "Belleza y Salud"
        Y no debo ver "Delicatessen"
