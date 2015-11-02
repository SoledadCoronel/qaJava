#language: es

Característica: Edición de un artículo de Novedades.
    Como usuario administrador de la plataforma quiero poder editar un artículo de Novedades.

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
        Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
        Cuando presiono "Guardar"
        Entonces espero a que cambie la URL
        Y la URL debe seguir el patrón "/app/news/\d+/article/\d+"
        Y debe aparecer ".dropdown-options"
        Y hago click en ".dropdown-options"
        Y debo ver "Editar Novedad"
        Y hago click en ".editArticle"

    @javascript @newsStandardData
    Escenario: Editar una novedad sin título.
        Dado espero a que aparezca el contenido dinámico "Título" en "body"
        Y relleno "title" con ""
        Cuando presiono "Guardar"
        Entonces debo ver "El título no puede estar vacío."

    @javascript @newsStandardData
    Escenario: Editar una novedad sin detalle.
        Dado espero a que aparezca el contenido dinámico "Título" en "body"
        Y lleno el WYSIWYG "content" con ""
        Cuando presiono "Guardar"
        Entonces debo ver "El detalle no puede estar vacío."

    @javascript @newsStandardData
    Escenario: Editar una novedad con un detalle superior a 32 mil caracteres.
        Dado espero a que aparezca el contenido dinámico "Título" en "body"
        Y lleno el WYSIWYG "content" con más de 32 mil caracteres
        Cuando presiono "Guardar"
        Entonces debo ver "El detalle no puede superar los 32000 caracteres."

    @javascript @newsStandardData
    Escenario: Editar una novedad con una fecha de publicación vacía.
        Dado espero a que aparezca el contenido dinámico "Título" en "body"
        Y relleno la fecha "publicationDate" con ""
        Cuando presiono "Guardar"
        Entonces debo ver "La fecha de publicación es obligatoria."

    @javascript @newsStandardData
    Escenario: Editar una novedad con una hora de publicacion inválida.
        Dado espero a que aparezca el contenido dinámico "Título" en "body"
        Y relleno "publicationHour" con "16.15"
        Cuando presiono "Guardar"
        Entonces debo ver "La hora ingresada es inválida."

    @javascript @newsStandardData
    Escenario: Editar una novedad exitosamente.
        Dado espero a que aparezca el contenido dinámico "Título" en "body"
        Y relleno "title" con "L'Odissea"
        Y lleno el WYSIWYG "content" con "Già tutti i greci, che la nera parca rapiti non avea, ne' loro alberghi fuor dell'arme sedeano e fuor dell'onde."
        Y relleno "publicationDate" con la fecha de hoy
        Y relleno la fecha "publicationHour" con "18:30"
        Y adjunto el archivo "tyrion.jpg" a "attachmentUpload"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "L'Odissea" en "body"
