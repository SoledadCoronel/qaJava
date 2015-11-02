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
        Dado espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list"
        Y sigo "Computers Depot"
        Y espero a que aparezca el contenedor dinámico ".call-to-action"
        Y sigo "Hay 2 beneficios más de este comercio"
        Cuando espero a que aparezca el contenedor dinámico "#home-main-description"
        Y debo ver "Computers Depot"

    @javascript @loadBenefitsStandardData @Solr
    Escenario: Visualizar el detalle de una compañía.
        Entonces debo ver "Esta es la descripción del comercio 2"
        Y debo ver "Juguetes"
        Y debo ver "Ropa de niños"
        Y debo ver "Libros educativos"
        Y debo ver "Visitar Sitio Web"
        Y espero a que aparezca el contenido dinámico "cupidatat" en "#home-main-benefits"
        Y espero a que aparezca el contenido dinámico "enim" en "#home-main-benefits"
        Y espero a que aparezca el contenido dinámico "excepteur" en "#home-main-benefits"

    @javascript @loadBenefitsStandardData @Solr
    Escenario: Poner 'Me gusta' en un comercio
        Cuando hago click en ".like-button"
        Entonces espero a que aparezca el contenido dinámico "Ya no me gusta" en ".actions-likes"
        Y espero a que aparezca el contenido dinámico "Te gusta esto." en ".readable-like-count"
        # Además pruebo "Ya no me gusta"
        Cuando hago click en ".unlike-button"
        Entonces espero a que aparezca el contenido dinámico "Me gusta" en ".actions-likes"

    @javascript @loadBenefitsStandardData @Solr
    Escenario: Seguir un comercio
        Cuando hago click en "#follow-button"
        Entonces espero a que aparezca el contenido dinámico "Dejar de seguir" en ".actions-likes"
        # Además pruebo "Ya no me gusta"
        Cuando hago click en "#unfollow-button"
        Entonces espero a que aparezca el contenido dinámico "Seguir" en ".actions-likes"

    @javascript @loadBenefitsStandardData @Solr
    Escenario: Visualizar el detalle de una compañía con categorías restringidas.
        Y espero a que aparezca el contenedor dinámico ".tags"
        Entonces no debo ver "Salud"
