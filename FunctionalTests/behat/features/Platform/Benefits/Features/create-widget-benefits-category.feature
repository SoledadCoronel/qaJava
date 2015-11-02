#language: es
Característica: Crear  widgets de Beneficios tipo Categoría

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
    Y hago click en "#radio-categories"
    Y hago click en ".modal-footer .next-button"
    Y espero a que aparezca el contenido dinámico "Autos y Motos" en ".tree-container .nav-list"
    Y relleno "name" con "Beneficios por Categoría"
    # Muestra el título del Widget
    Y hago click en ".showTitle"
    # Muestra el borde del Widget
    Y hago click en ".showBorder"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo Categoría sin ubicaciones

    # Hace click en el primer elemento del árbol de categorías. Expande a los hijos
    Y hago click en ".tree-toggler:first"
    # Selecciona uno de los hijos
    Y espero a que aparezca el contenido dinámico "Accesorios de Autos y Motos" en ".tree"
    Y hago click en ".child-from-tree-editor:first"
    # Cierra la modal
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Beneficios por Categoría" en ".widget-title"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo Categoría con ubicación vacía y muestra error
    # Selecciono Ubicaciones
    Y hago click en ".has-locations-checkbox"
    Y espero a que aparezca el contenido dinámico "Agregar otra ubicación" en ".add-new-location"

    # Cierra la modal
    Y hago click en ".modal-footer .install-button"
    Y espero a que aparezca el contenido dinámico "Seleccione por lo menos una opción." en ".widget-type-form"
    Entonces espero a que aparezca el contenido dinámico "Debe ingresar una ubicación válida." en ".help-block"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo Categoría con ubicación exitosa

    # Hace click en el primer elemento del árbol de categorías. Expande a los hijos
    Y hago click en ".tree-toggler:first"
    # Selecciona uno de los hijos
    Y espero a que aparezca el contenido dinámico "Accesorios de Autos y Motos" en ".tree"
    Y hago click en ".child-from-tree-editor:first"

    # Selecciono Ubicaciones
    Y hago click en ".has-locations-checkbox"
    Y espero a que aparezca el contenido dinámico "Agregar otra ubicación" en ".add-new-location"
    # Completo el campo de ubicación
    Y relleno "txt-search" con "Buenos Aires, Argentina"
    # Presiono Search
    Y hago click en ".input-append .search-btn"

    # Cierra la modal
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Beneficios por Categoría" en ".widget-title"
