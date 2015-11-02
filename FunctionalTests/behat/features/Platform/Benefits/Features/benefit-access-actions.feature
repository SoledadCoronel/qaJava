#language: es
Característica: Ver acciones de acceso a beneficios

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
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-list"
        Y hago click y sigo ".benefit-ticket:eq(1)"
        Y espero a que aparezca el contenido dinámico "cupidatat" en ".benefit-name"

    @javascript @loadBenefitStoreDataUsesCard @Solr
    Escenario: Visualizar modal informativo de Celular.
        Dado espero a que aparezca el contenedor dinámico ".benefit-access-pill"
        Cuando hago click en "span[data-type=mobile]"
        Entonces espero a que aparezca el contenedor dinámico "#benefit-overlay"
        Y debo ver "Accedé al beneficio presentando tu celular"
        Y debo ver "Descargá la aplicación desde GooglePlay o AppStore"
        Y debo ver "Cerrar"

    @javascript @loadBenefitStoreDataUsesCard @Solr
    Escenario: Visualizar modal informativo de Tarjeta
        Dado hago click en "span[data-type=card]"
        Cuando espero a que aparezca el contenedor dinámico "#benefit-overlay"
        Entonces debo ver "Accedé al beneficio presentando tu tarjeta"
        Y debo ver "Acércate a cualquiera de las sucursales con tu tarjeta de Beneficios Corporativos."
        Y debo ver "Cerrar"

    @javascript @loadBenefitStoreDataUsesCard @Solr
    Escenario: Visualizar modal informativo de Telefono
        Dado hago click en "span[data-type=phone]"
        Cuando espero a que aparezca el contenedor dinámico "#benefit-overlay"
        Entonces debo ver "Accedé al beneficio telefonicamente"
        Y debo ver "gointegro1234"
        Y debo ver "Cerrar"

    @javascript @loadBenefitStoreDataUsesCard @Solr
    Escenario: Visualizar modal informativo de Cupon
        Dado hago click en "span[data-type=coupon]"
        Cuando espero a que aparezca el contenedor dinámico "#benefit-overlay"
        Entonces debo ver "Accedé al beneficio presentando tu cupón impreso"
        Y debo ver "gointegro1234"
        Y debo ver "Cerrar"
        Y debo ver "Imprimir"
