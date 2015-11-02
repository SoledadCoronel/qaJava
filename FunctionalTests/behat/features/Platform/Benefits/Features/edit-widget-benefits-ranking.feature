#language: es
Característica: Editar widgets de Beneficios tipo Ranking

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
    Y sigo el link "Configurar"
    Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"

  @javascript @loadRankingWidgetData @Solr
  Escenario: Editar Widget de Tipo Ranking
    Y hago click en ".benefits-ranking .widget-edit .configure-widget"
    Y sigo el link "Editar"
    Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
    Y relleno "name" con "Widget editado"
    Y hago click en ".modal-footer .install-button"
    Entonces espero a que aparezca el contenido dinámico "Widget editado" en ".widget-title"
