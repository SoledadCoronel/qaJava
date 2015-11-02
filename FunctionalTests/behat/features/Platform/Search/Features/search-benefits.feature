# language: es
Característica: Resultado de búsqueda de beneficios
    Como usuario debo poder buscar beneficios por texto y categoría

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es_ES"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadBenefitData @Solr
    Escenario: Busco beneficios por el título del beneficio
        Dado relleno "q" con "cupidatat"
        Y presiono "search-button"
        Entonces espero a que aparezca el contenedor dinámico ".results-amount"
        Y hago click y sigo ".filter-items-list li:eq(1) a"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list"
        Y espero a que aparezca el contenido dinámico "Juguetes" en ".benefit-list"
        Y espero a que aparezca el contenido dinámico "cupidatat" en ".benefit-list"
        Y espero a que aparezca el contenido dinámico "90%" en ".benefit-list"

    @javascript @loadBenefitData @Solr
    Escenario: Busco beneficios por categoría
        Dado sigo "Ver más"
        Y sigo "Mapa de Categorías de Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Juguetes" en ".subcategories"
        Y sigo "Juguetes"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list"

    @javascript @loadBenefitStoreDataUsesCard @Solr
    Escenario: Busco beneficios por categoría, descuento y modo de acceso
        Dado estoy en "/benefits/search/result"
        Y espero a que aparezca el contenido dinámico "Deportes (6)" en ".filter-items-list"
        Y sigo "Deportes (6)"
        Y espero a que aparezca el contenido dinámico "Deportes" en ".active-filters"
        Y espero a que aparezca el contenido dinámico "90% (3)" en ".filter-items-list"
        Y debo ver "Clubes y Gimnasios"
        Y debo ver "Fenix Seguros"
        Cuando sigo "90% (3)"
        Y espero a que aparezca el contenido dinámico "Deportes" en ".active-filters"
        Y espero a que aparezca el contenido dinámico "90%" en ".active-filters"
        Y espero a que aparezca el contenido dinámico "Cupón impreso (2)" en ".filter-items-list"
        Entonces debo ver "Gran Hotel Paraná"
        Y debo ver "Pinturerías del Centro"
        Y debo ver "Computers Depot"
        Y no debo ver "Fenix Seguros"
        Cuando sigo "Cupón impreso (2)"
        Y espero a que aparezca el contenido dinámico "Deportes" en ".active-filters"
        Y espero a que aparezca el contenido dinámico "90%" en ".active-filters"
        Y espero a que aparezca el contenido dinámico "Cupón impreso" en ".active-filters"
        Y espero a que aparezca el contenido dinámico "Accesorios Deportivos (1)" en ".filter-items-list"
        Entonces debo ver "Gran Hotel Paraná"
        Y debo ver "Computers Depot"
        Y no debo ver "Pinturerías del Centro"