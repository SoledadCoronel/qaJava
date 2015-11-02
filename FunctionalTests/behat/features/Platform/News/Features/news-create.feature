#language: es

Característica: Creación de un artículo de Novedades.
    Como usuario administrador de la plataforma quiero poder crear un artículo de Novedades.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo "Noticias Corporativas"
        Y presiono "Nueva Novedad"
        Dado espero a que aparezca el contenido dinámico "Título" en "body"
        Dado espero a que aparezca el contenedor dinámico ".mce-container.mce-edit-area"

    @javascript @loadStandardUserData
    Escenario: Cargar una novedad sin título.
        Cuando presiono "Guardar"
        Entonces debo ver "El título no puede estar vacío."

    @javascript @loadStandardUserData
    Escenario: Cargar una novedad sin detalle.
        Cuando presiono "Guardar"
        Entonces debo ver "El detalle no puede estar vacío."

    @javascript @loadStandardUserData
    Escenario: Cargar una novedad con un detalle superior a 32 mil caracteres.
        Y lleno el WYSIWYG "content" con más de 32 mil caracteres
        Cuando presiono "Guardar"
        Entonces debo ver "El detalle no puede superar los 32000 caracteres."

    @javascript @loadStandardUserData
    Escenario: Cargar una novedad con una fecha de publicación vacía.
        Cuando hago click en "#accept"
        Entonces espero a que aparezca el contenido dinámico "La fecha de publicación es obligatoria." en "#publicationDate-error"

    @javascript @loadStandardUserData
    Escenario: Cargar una novedad con una hora de publicacion inválida.
        Y relleno "publicationHour" con "16.15"
        Cuando presiono "Guardar"
        Entonces debo ver "La hora ingresada es inválida."

    @javascript @loadStandardUserData
    Escenario: Cargar una novedad exitosamente.
        Y relleno "title" con "La Divina Commedia"
        Y lleno el WYSIWYG "content" con "Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita."
        Y relleno "publicationDate" con la fecha de hoy
        Y relleno la fecha "publicationHour" con "16:15"
        Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Últimas" en "body"
        Y la URL debe seguir el patrón "/app/news/\d+"
