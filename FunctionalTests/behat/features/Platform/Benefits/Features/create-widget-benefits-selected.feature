#language: es
Característica: Crear widgets de beneficios seleccionados

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
    Y sigo el link "Configurar"
    Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header button.dropdown-toggle"
    Y presiono "Agregar Módulo"
    Y sigo "Nuevo Módulo"
    Y espero a que aparezca el contenido dinámico "Continuar" en ".modal-footer"
    Y hago click en ".benefits-app-radio"
    Y hago click en ".modal-footer .next-button"
    Y espero a que aparezca el contenido dinámico "Categorías" en ".config"
    Y hago click en "#radio-selected"
    Y hago click en ".modal-footer .next-button"
    Y espero a que aparezca el contenido dinámico "Módulo de beneficios destacados" en ".modal-header"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear widget de tipo destacado de beneficios seleccionados
    Dado hago click en ".wg-select-type-editor input[type=radio]:eq(1)"
    Y espero a que aparezca el contenido dinámico "Gran Hotel Paraná" en ".benefits-list"
    Y espero a que aparezca el contenido dinámico "Beneficios Seleccionados (0 de 5)" en ".benefits-selected"
    Y relleno "name" con "Beneficios Destacados"
    # Muestra el título del Widget
    Y hago click en ".showTitle"
    # Muestra el borde del Widget
    Y hago click en ".showBorder"
    # Hace click en el primer elemento del listado de Beneficios
    Y hago click en ".checkbox-benefit:first"
    Y espero a que aparezca el contenido dinámico "Beneficios Seleccionados (1 de 5)" en ".benefits-selected"
    # Cierra la modal
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Beneficios Destacados" en ".widget-title"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear widget de tipo destacado de beneficios seleccionados con errores
    Dado hago click en ".wg-select-type-editor input[type=radio]:eq(1)"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Debe seleccionar al menos un beneficio Destacado." en ".help-block"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo destacado con errores
    Dado hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Debe seleccionar una opción" en ".help-block"

  @javascript @loadGalleryBenefitsData @Solr
  Escenario: Crear widget de tipo destacado de una galería de beneficios
    Dado hago click en ".wg-select-type-editor input[type=radio]:eq(0)"
    Y espero a que aparezca el contenido dinámico "Telepark" en "#galleries-list"
    Y relleno "name" con "Beneficios de una galería"
    Y hago click en ".showTitle"
    Y hago click en ".showBorder"
    Y selecciono "Telepark" de "gallery"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Beneficios de una galería" en ".widget-title"
