#language: es
Característica: Crear  widgets de Beneficios tipo Especial

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
    Y sigo el link "Configurar"
    Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
    Y presiono "Agregar Módulo"
    Y sigo "Nuevo Módulo"
    Y espero a que aparezca el contenido dinámico "Continuar" en ".modal-footer"
    Y hago click en ".benefits-app-radio"
    Y hago click en ".modal-footer .next-button"
    Y espero a que aparezca el contenido dinámico "Especiales" en ".config"
    Y hago click en "#radio-collection"
    Y hago click en ".modal-footer .next-button"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y relleno "name" con "Beneficios Especiales TEST"
    Y hago click en ".showTitle"

  @javascript @loadBenefitCollectionData @Solr
  Escenario: Crear Widget de Tipo Especial sin ubicaciones
    Y selecciono "Navidad" de "collection"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Beneficios Especiales TEST" en ".widget-title"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo Especial con ubicación exitosa
    # Selecciono Ubicaciones
    Y hago click en ".has-locations-checkbox"
    Y espero a que aparezca el contenido dinámico "Agregar otra ubicación" en ".add-new-location"
    # Completo el campo de ubicación
    Y relleno "txt-search" con "Buenos Aires, Argentina"
    # Presiono Search
    Y hago click en ".input-append .search-btn"
    # Cierra la modal
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Beneficios Especiales TEST" en ".widget-title"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo Especial con ubicación vacía y muestra error
    # Selecciono Ubicaciones
    Y hago click en ".has-locations-checkbox"
    Y espero a que aparezca el contenido dinámico "Agregar otra ubicación" en ".add-new-location"
    # Cierra la modal
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Revise los campos indicados." en ".error"
