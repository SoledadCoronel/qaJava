# language: es
Característica: Listado de beneficios, filtro de ubicación general determinado por el usuario.
    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Dado estoy en "/benefits/search/result"
        Y espero a que aparezca el contenedor dinámico ".location-text"

    @javascript @loadSearchData @Solr
    Escenario: Carga Ubicación con errores.
        Dado relleno "txt-search" con "Rivendell, Eriador"
        Cuando hago click en ".search-btn"
        Entonces espero a que aparezca el contenido dinámico "Debe ingresar una ubicación válida." en ".help-block"

    @javascript @loadSearchData @Solr
    Escenario: Carga de Ubicación exitosa, redirección y recarga de página.
        Dado relleno "txt-search" con "Buenos Aires, Argentina"
        Cuando hago click en ".location-filter-widget .search-btn"
        Entonces debo estar en "/benefits/search/result?geographical_areas[]=Buenos%20Aires,%20Argentina|-34.7051589,-58.53145219999999|-34.5265464,-58.335144799999966"
        Dado estoy en "/benefits/search/result"
        Y debo ver "Buenos Aires, Argentina" en el campo "txt-search"
        Entonces debo estar en "/benefits/search/result?geographical_areas[]=Buenos%20Aires,%20Argentina|-34.7051589,-58.53145219999999|-34.5265464,-58.335144799999966"
