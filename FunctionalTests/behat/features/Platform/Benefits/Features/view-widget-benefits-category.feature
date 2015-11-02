#language: es
Característica: Ver widget de beneficios por categorías
    Como usuario debo poder ver los widgets instalados de categoría de beneficios

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"

    @javascript @loadBenefitsCategoryWidget @Solr
    Escenario: Ver widget de beneficios por categorías
        Dado espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(0) .company"
        Y debe aparecer el contenido dinámico "cupidatat" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(0) .saving"
        #Y debe aparecer el contenido dinámico "Accesorios Deportivos" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(0) .tags"
        Y debe aparecer el contenido dinámico "Pinturerías del Centro" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(1) .company"
        Y debe aparecer el contenido dinámico "occaecat" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(1) .saving"
        #Y debe aparecer el contenido dinámico "Actividades Esparcimiento" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(1) .tags"
        Y debe aparecer el contenido dinámico "Fenix Seguros" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(2) .company"
        Y debe aparecer el contenido dinámico "exercitation" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(2) .saving"
        #Y debe aparecer el contenido dinámico "Delivery" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(2) .tags"
