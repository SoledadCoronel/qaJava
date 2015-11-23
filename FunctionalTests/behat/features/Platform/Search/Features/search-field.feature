# language: es

Característica: Test para la busqueda de resultados.
    Como usuario debo poder buscar en el campo de búsqueda ubicado en el header

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es_ES"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadSearchData @Solr
    Escenario: Aplicaciones coincidentes a la key de búsqueda
        Dado relleno "q" con "goIntegro"
        Y presiono "search-button"
        Entonces espero a que aparezca el contenedor dinámico ".results-amount"
        Y espero a que aparezca el contenido dinámico "3 resultados" en ".number"
        Y espero a que aparezca el contenido dinámico "goIntegro" en ".keyword"
        Y espero a que aparezca el contenedor dinámico ".search-listing"
        Y espero a que aparezca el contenido dinámico "Album test" en ".name"
        Y espero a que aparezca el contenido dinámico "Articulo" en ".name"
        Y espero a que aparezca el contenido dinámico "Novedad" en ".name"

    @javascript @loadSearchData @Solr
    Escenario: Test filtros de facets
      Dado relleno "q" con "goIntegro"
      Y presiono "search-button"
      Entonces espero a que aparezca el contenedor dinámico ".search-filter"
      Y espero a que aparezca el contenido dinámico "Filtrar por" en ".filters"
      Y espero a que aparezca el contenido dinámico "Todos los resultados (3)" en ".filter-items-list"
      Y espero a que aparezca el contenedor dinámico ".workspace"
      Y espero a que aparezca el contenido dinámico "Inicio" en ".name"
      Y espero a que aparezca el contenido dinámico "Espacio Público" en ".filter-block"
      Y espero a que aparezca el contenido dinámico "Artículos Corporativos (1)" en ".filter-items-list"
      Y espero a que aparezca el contenido dinámico "Galería Corporativa (1)" en ".filter-items-list"
      Y espero a que aparezca el contenido dinámico "Noticias Corporativas (1)" en ".filter-items-list"

    @javascript @loadSearchData @Solr
    Escenario: Búsqueda de un colaborador
      Dado relleno "q" con "sarah"
      Y presiono "search-button"
      Entonces espero a que aparezca el contenedor dinámico ".results-amount"
      Y espero a que aparezca el contenido dinámico "1 resultados" en ".number"
      Y espero a que aparezca el contenido dinámico "sarah" en ".keyword"
      Y espero a que aparezca el contenedor dinámico ".search-listing"
      Y espero a que aparezca el contenido dinámico "Sarah Connor" en ".name"
      Y espero a que aparezca el contenido dinámico "sarahconnor@gointegro.com" en ".text"
      Y espero a que aparezca el contenido dinámico "Seguir" en "#follow-button"
