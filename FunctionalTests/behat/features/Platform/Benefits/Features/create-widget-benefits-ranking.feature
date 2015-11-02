#language: es
Característica: Crear  widgets de Beneficios tipo Ranking

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
    Y espero a que aparezca el contenido dinámico "Ranking" en ".modal.benefit-widget-setup .config"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo Ranking mas visitados
    Y hago click en "#radio-ranking"
    Y hago click en ".modal-footer .next-button"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y relleno "name" con "Lo mejor en beneficios"
    Y selecciono "Más visitados" de "ranking"
    Y hago click en ".showTitle"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Lo mejor en beneficios" en ".widget-title"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo Ranking mas nuevos
    Y hago click en "#radio-ranking"
    Y hago click en ".modal-footer .next-button"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y relleno "name" con "Ordenado por los últimos"
    Y selecciono "Los más nuevos" de "ranking"
    Y hago click en ".showTitle"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Ordenado por los últimos" en ".widget-title"

  @javascript @loadBenefitsStandardData @Solr
  Escenario: Crear Widget de Tipo Ranking sin datos obligatorios
    Y hago click en "#radio-ranking"
    Y hago click en ".modal-footer .next-button"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y hago click en ".modal-footer .install-button"
    Entonces debo ver "Este campo es obligatorio."

