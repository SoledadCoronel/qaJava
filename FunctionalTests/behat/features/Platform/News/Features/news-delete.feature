#language: es

Característica: Eliminación de un artículo de Novedades.
    Como usuario administrador de la plataforma quiero poder eliminar un artículo de Novedades.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Y debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo "Noticias Corporativas"
        Y presiono "Nueva Novedad"
        Y espero a que aparezca el contenido dinámico "Título" en "body"
        Y relleno "title" con "La Divina Commedia"
        Y lleno el WYSIWYG "content" con "Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita."
        Y relleno "publicationDate" con la fecha de hoy
        Y relleno la fecha "publicationHour" con "16:15"
        Cuando presiono "Guardar"
        Entonces espero a que cambie la URL
        Y la URL debe seguir el patrón "/app/news/\d+/article/\d+"
        Y debe aparecer ".dropdown-options"
        Y hago click en ".dropdown-options"
        Y debo ver "Eliminar Novedad"
        Y hago click en ".delete-article"

    @javascript @newsStandardData
    Escenario: Cancelar la eliminación de una novedad.
        Dado espero a que aparezca el contenido dinámico "Eliminar Novedad" en ".modal-header"
        Cuando presiono "Cancelar"
        Y recargo la página
        Entonces debo ver "La Divina Commedia"

    @javascript @newsStandardData
    Escenario: Eliminar una novedad exitosamente.
        Dado espero a que aparezca el contenido dinámico "Eliminar Novedad" en ".modal-header"
        Cuando presiono "Confirmar"
        Entonces espero a que aparezca el contenido dinámico "Últimas" en "body"
        Y la URL debe seguir el patrón "/app/news/\d+"
