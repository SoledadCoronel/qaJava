#language: es
Característica: Editar widgets de beneficios seleccionados

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
    Y sigo el link "Configurar"
    Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header button.dropdown-toggle"

  @javascript @loadSelectedBenefitsWidgetData @Solr
  Escenario: Editar widget de una galería de beneficios
    Y hago click en ".benefits-selected .widget-edit .configure-widget"
    Y sigo el link "Editar"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y relleno "name" con "WG Galería de beneficios editado"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "WG Galería de beneficios editado" en ".widget-title"
    Y hago click en ".configuration-commit"
    Y espero a que aparezca el contenido dinámico "Computers Depot" en ".benefits-selected"
