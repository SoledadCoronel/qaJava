# language: es
Característica: Ordenar un listado de beneficios
    
    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es_ES"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Dado estoy en "/benefits/search/result"
        Y espero a que aparezca el contenedor dinámico ".search-bar"

    @javascript @loadBenefitStoreDataUsesCard @Solr
    Escenario: Ordenar listado por orden alfabético
        Y hago click en ".search-bar .links a[data-order=az]"
        Y espero a que aparezca el contenedor dinámico ".benefit-list"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list tr:eq(0) .company"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list tr:eq(1) .company"
        Y espero a que aparezca el contenido dinámico "FC Travel" en ".benefit-list tr:eq(3) .company"
        Y espero a que aparezca el contenido dinámico "Gran Hotel Paraná" en ".benefit-list tr:eq(5) .company"

    @javascript @loadBenefitStoreDataUsesCard @Solr
    Escenario: Ordenar listado por mayor oferta
        # Debido a que por defecto viene ordenado por oferta, primero se ordenara alfabeticamente
        Y hago click en ".search-bar .links a[data-order=az]"
        Y espero a que aparezca el contenedor dinámico ".benefit-list"
        Y espero a que aparezca el contenedor dinámico ".search-bar"
        Y hago click en ".search-bar .links a[data-order=highlight]"
        Y espero a que aparezca el contenido dinámico "Gran Hotel Paraná" en ".benefit-list tr:eq(0) .company"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list tr:eq(1) .company"
