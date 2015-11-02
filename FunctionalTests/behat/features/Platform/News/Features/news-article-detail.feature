#language: es

Característica: Home de Novedades.
    Como usuario de la plataforma quiero poder ingresar al detalle de un artículo de Novedades.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Y debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo "Noticias Corporativas"

    @javascript @newsStandardData
    Escenario: Ver el detalle de un artículo de Novedades.
        Dado espero a que aparezca el contenido dinámico "La Divina Commedia 1" en "#articles-list"
        Y sigo "La Divina Commedia 1"
        Y espero a que aparezca el contenido dinámico "La Divina Commedia 1" en ".main-container"
        Y espero a que aparezca el contenido dinámico "Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita." en ".content"
        Cuando hago click en ".dropdown-toggle"
        Entonces debo ver "Editar Novedad"
        Y debo ver "Eliminar Novedad"
