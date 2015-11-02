#language: es
Característica: Ver una Categoría.
  Como usuario administrador del backoffice quiero ver una Categoría

    Antecedentes:
      Dado estoy en "/backoffice/signin"
      Y relleno "_username" con "apibackofficetester"
      Y relleno "_password" con "apitesterbackoffice"
      Cuando presiono "_submit"
      Y sigo "Beneficios Corporativos"
      Y espero a que aparezca el contenido dinámico "45 minutos" en ".table-company-list"
      Y espero a que aparezca el contenido dinámico "Administrar categorías" en ".btn-primary"
      Y sigo "Administrar categorías"
      Y espero a que aparezca el contenedor dinámico ".table-category-list"
      Entonces espero a que aparezca el contenido dinámico "Autos y Motos" en ".table-category-list"
      Y sigo "Autos y Motos"
      Entonces espero a que aparezca el contenedor dinámico "#category-container"

  @javascript @loadBenefitsData
  Escenario: 1. Visualizar los datos de la categoría
    # Visualizo los datos de la categoría
    Dado el breadcrumb debe ser "Inicio > Beneficios Corporativos > Listado de categorias > Autos y Motos"
    Y debo ver "Autos y Motos"
    Y debo ver "Carros e Motos"
    Y debo ver "Cars and Motorcycles"
    Entonces espero a que aparezca el contenedor dinámico ".btn-primary"
    Y espero a que aparezca el contenedor dinámico ".edit-link"

  @javascript @loadBenefitsData
  Escenario: 2. Visualizar los datos de las sub-categorías
    # Visualizo los datos de la sub-categoría
    Dado el breadcrumb debe ser "Inicio > Beneficios Corporativos > Listado de categorias > Autos y Motos"
    Y debo ver "Autos y Motos"
    Y debo ver "Carros e Motos"
    Y debo ver "Cars and Motorcycles"
    Entonces espero a que aparezca el contenido dinámico "Accesorios de Autos y Motos" en ".category-categories"
    Y sigo "Accesorios de Autos y Motos"
    Y debo ver "Accesorios de Autos y Motos"
    Y debo ver "Accesorios de Autos y Motos"
    Y debo ver "autos and motos accesories"
    Y espero a que aparezca el contenedor dinámico ".category-tags"
    Y debo ver "Tubos"
    Y debo ver "motos"
    Y debo ver "tuercas"