# language: es
Característica: Ver mapa de categorías y beneficios destacados.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y sigo "Ver más"
        Y sigo "Mapa de Categorías de Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Deportes" en ".category"
        Y sigo "Deportes"

    @javascript @loadBenefitStoreData @Solr
    Escenario: Visualizar el detalle de un beneficio
        Dado espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list"
        Y hago click y sigo ".benefit-ticket:eq(0)"
        Y espero a que aparezca el contenido dinámico "cupidatat" en ".benefit-name"
        Y debo ver "Juguetes, Heladerías, Accesorios Deportivos, Actividades Esparcimiento, Cursos y Capacitación"
        Y debo ver "Enim exercitation id aliquip reprehenderit consectetur veniam anim. Duis amet culpa sunt quis laborum sit consequat commodo. Excepteur Lorem consequat ex quis elit esse consequat ea id duis elit ullamco est. Commodo pariatur ea pariatur sunt laborum dolor ullamco aliqua ex sint. Fugiat nostrud proident eu culpa reprehenderit ipsum nisi."
        Y debo ver "Efectivo"
        Y debo ver "Tarjeta de crédito"
        Y debo ver "Tarjeta de débito"
        Y espero a que aparezca el contenido dinámico "Teléfonos" en ".benefit-details"
        Y debo ver "Lomas de Zamora, Lomas de Zamora, Buenos Aires"
        Y debo ver "San Fernando, San Fernando, Buenos Aires"
        Y debo ver "San Martín de los Andes, Lácar, Neuquen"
        Y debo ver "Puerto Madero, Buenos Aires, Ciudad Autónoma de Buenos Aires"
        Y debo ver "Villa Lugano, Buenos Aires, Ciudad Autónoma de Buenos Aires"
        Y debo ver "Eulogio Estigarribia"
        Cuando hago click en ".shop-location .locate:eq(0)"
        Entonces espero a que aparezca el contenido dinámico "Eulogio Estigarribia" en ".map"

    @javascript @loadBenefitsRestrictedPlatformsData @Solr
    Escenario: Visualizar el detalle de un beneficio con categorías restringidas.
        Dado espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list"
        Cuando hago click en "a:contains(Computers Depot)"
        Entonces espero a que aparezca el contenedor dinámico ".tags"
        Y no debo ver "Salud"

    @javascript @loadBenefitStoreData @Solr
    Escenario: Poner "Me gusta" en un beneficio.
        Dado espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list"
        Y hago click y sigo ".benefit-ticket:eq(0)"
        Y espero a que aparezca el contenido dinámico "cupidatat" en ".benefit-name"
        Y debo ver "cupidatat"
        Cuando hago click en ".like-button"
        Y espero a que aparezca el contenido dinámico "Ya no me gusta" en ".actions-likes"
        Y espero a que aparezca el contenido dinámico "Te gusta esto." en ".readable-like-count"
        # Además pruebo "Ya no me gusta".
        Entonces hago click en ".unlike-button"
        Y espero a que aparezca el contenido dinámico "Me gusta" en ".actions-likes"
