#language: es
Característica: Instalar una aplicación en una plataforma.
Como usuario administrador quiero poder instalar aplicaciones en un espacio desde el front

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"
    Y espero a que aparezca el contenedor dinámico ".workspace-menu"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Ingresar a una aplicacion de Filtro de Beneficios sin filtros
  Dado sigo "Ver más..."
  Y sigo "Filtro de beneficios"
  Y espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list"
  Y espero a que aparezca el contenido dinámico "Lavado" en ".benefit-list"
  Y espero a que aparezca el contenido dinámico "Centros de Belleza" en ".benefit-list"
  Y espero a que aparezca el contenido dinámico "Clubes y Gimnasios" en ".benefit-list"
  Y espero a que aparezca el contenido dinámico "Electrodomésticos" en ".benefit-list"
  Y espero a que aparezca el contenido dinámico "Beneficio con cupón" en ".benefit-list"

  @javascript @loadBenefitsFilterApplicationData @Solr
  Escenario: Ingresar a una aplicacion de Filtro de Beneficios con categorias
  Dado sigo "Ver más..."
  Y sigo "Benefit Filters Application Category"
  Y debo ver "Benefit Filters Application Category"
  Y espero a que aparezca el contenedor dinámico ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Autos y Motos" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Bebés y Niños" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Belleza y Salud" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Comidas y Bebidas" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Deportes" en ".filter-items-list"

  @javascript @loadBenefitsFilterApplicationData @Solr
  Escenario: Ingresar a una aplicacion de Filtro de Beneficios con especial
  Dado sigo "Ver más..."
  Y sigo "Benefit Filters Application Collection"
  Y debo ver "Benefit Filters Application Collection"
  Y espero a que aparezca el contenedor dinámico ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Día del Padre" en ".filter-items-list"

  @javascript @loadBenefitsFilterApplicationData @Solr
  Escenario: Ingresar a una aplicacion de Filtro de Beneficios con categorias y quitar una categoria
  Dado sigo "Ver más..."
  Y sigo "Benefit Filters Application Category"
  Y debo ver "Benefit Filters Application Category"
  Y espero a que aparezca el contenedor dinámico ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Autos y Motos" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Bebés y Niños" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Belleza y Salud" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Comidas y Bebidas" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Deportes" en ".filter-items-list"
  Y hago click en ".filter-items-list li:eq(0) .close"
  Y debo ver "Beneficios Corporativos"
  Y no debo ver "Benefit Filters Application Category"
  Y espero a que aparezca el contenedor dinámico ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Bebés y Niños" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Belleza y Salud" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Comidas y Bebidas" en ".filter-items-list"
  Y espero a que aparezca el contenido dinámico "Deportes" en ".filter-items-list"
