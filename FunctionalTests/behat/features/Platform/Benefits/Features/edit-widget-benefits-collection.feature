#language: es
Característica: Editar widgets de Beneficios tipo Special

  Antecedentes:
    Dado estoy en la página de inicio
    Y sigo "Iniciar Sesión"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
    Y sigo el link "Configurar"
    Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"


  @javascript @loadBenefitsStandardData @Solr
  Escenario: Editar Widget de Tipo Especial
    Y hago click en ".benefits-collection .widget-edit .configure-widget"
    Y sigo el link "Editar"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y relleno "name" con "Widget editado"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Widget editado" en ".widget-title"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Editar Widget de Tipo Especial cambiando la Location
    Y hago click en ".benefits-collection .widget-edit .configure-widget"
    Y sigo el link "Editar"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y relleno "name" con "Widget editado"
    Y hago click en ".has-locations-checkbox"
    Y espero a que aparezca el contenido dinámico "Agregar otra ubicación" en ".add-new-location"
    Y relleno "txt-search" con "Buenos Aires, Argentina"
    Y hago click en ".input-append .search-btn"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Widget editado" en ".widget-title"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Editar Widget de Tipo Especial
    Y hago click en ".benefits-collection .widget-edit .configure-widget"
    Y sigo el link "Editar"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y hago click en ".has-locations-checkbox"
    Y espero a que aparezca el contenido dinámico "Agregar otra ubicación" en ".add-new-location"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Revise los campos indicados." en ".error"
