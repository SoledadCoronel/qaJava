#language: es
Característica: Ver widget de beneficios por especial
    Como usuario debo poder ver los widgets instalados de especiales de beneficios

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"

    @javascript @loadBenefitCollectionWigetData @Solr
    Escenario: Ver widget de beneficios por especial
        Dado espero a que aparezca el contenido dinámico "Pinturerías del Centro" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(0) .company"
        Y debe aparecer el contenido dinámico "tempor" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(0) .saving"
        Y debe aparecer el contenido dinámico "Pinturerías del Centro" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(1) .company"
        Y debe aparecer el contenido dinámico "occaecat" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(1) .saving"
        Y debe aparecer el contenido dinámico "Computers Depot" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(2) .company"
        Y debe aparecer el contenido dinámico "excepteur" en ".benefit-list-widget:not(.benefits-ranking) tr:eq(2) .saving"
