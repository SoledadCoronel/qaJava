# language: es
Característica: Ver listado de beneficios con y sin cupón.

Antecedentes:
  Dado estoy en "/auth/signin?_lang=es"
  Y relleno "_username" con "johnconnor"
  Y relleno "_password" con "123456"
  Cuando presiono "_submit"
  Entonces debo estar en "/"
  Y sigo "Ver más"
  Y sigo "Mapa de Categorías de Beneficios Corporativos"


@javascript @loadBenefitsPlatformNoCupon @Solr
Escenario: No ver beneficio con cupón.
  Cuando espero a que aparezca el contenido dinámico "Autos y Motos" en ".category"
  Y sigo "Lavado"
  Entonces espero a que aparezca el contenido dinámico "deserunt" en ".benefit-list"
  Y no debo ver "Beneficio con cupón"

@javascript @loadBenefitsStandardData @Solr
Escenario: Ver beneficio con cupón
  Cuando espero a que aparezca el contenido dinámico "Autos y Motos" en ".category"
  Y sigo "Lavado"
  Entonces espero a que aparezca el contenido dinámico "Beneficio con cupón" en ".benefit-list"
