# language: es
Característica: Listado de beneficios destacados en resultado de búsqueda de beneficios
    
    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es_ES"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadBenefitStoreDataUsesCard @Solr
    Escenario: Visualizar Beneficios Destacados
        Dado estoy en "/benefits/search/result"
        Y espero a que aparezca el contenedor dinámico "#highlights-result-list"
        Y espero a que aparezca el contenedor dinámico "#highlights-result-list .featured-item"
        Y espero a que aparezca el contenido dinámico "Beneficio con cupón" en "#highlights-result-list"
        Y espero a que aparezca el contenido dinámico "tempor" en "#highlights-result-list"
        Y espero a que aparezca el contenido dinámico "cupidat" en "#highlights-result-list"