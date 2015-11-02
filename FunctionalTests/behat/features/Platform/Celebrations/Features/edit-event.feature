#language: es

Característica: Edición de un evento de Celebraciones.
    Como usuario administrador de la plataforma quiero poder editar un evento de Celebraciones.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Espacio Público" en ".spaces"
        Y sigo "Celebraciones Corporativas"
        Y espero a que aparezca el contenido dinámico "Categoría de prueba" en ".media-body"
        Y hago click en "#event-options"
        Y sigo "Editar"
        Y espero a que aparezca el contenido dinámico "Desde mi PC" en ".platform"

    @javascript @loadCelebrationsData
    Escenario: Editar un evento de Celebraciones sin título.
        Dado relleno "title" con ""
        Y relleno "description" con "Prueba editada"
        Y relleno la fecha "date" con "01/01/2021"
        Cuando presiono "Guardar"
        Entonces debo ver "No se pudo guardar la Celebración"

    @javascript @loadCelebrationsData
    Escenario: Editar un evento de Celebraciones con un título inválido.
        Dado relleno "title" con "  ^^^"
        Y relleno "description" con "Prueba editada"
        Y relleno la fecha "date" con "01/01/2021"
        Cuando presiono "Guardar"
        Entonces debo ver "El título contiene caracteres inválidos"

    @javascript @loadCelebrationsData
    Escenario: Editar un evento de Celebraciones exitosamente.
        Dado relleno "title" con "Prueba editada"
        Y relleno "description" con "Prueba editada"
        Y relleno la fecha "date" con "01/01/2021"
        Y adjunto el archivo "tyrion.jpg" a "attachmentUpload"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/app/celebrations/\d+"

    @javascript @loadCelebrationsData
    Escenario: Editar un evento de Celebraciones con colaboradores exitosamente.
        Dado relleno "collaborators-container-input" con "800"
        Y espero a que aparezca el contenido dinámico "T 800" en "#collaborators"
        Y hago click en "#collaborators span.text-label"
        Y relleno "collaborators-container-input" con "Sarah"
        Y espero a que aparezca el contenido dinámico "Sarah Connor" en "#collaborators"
        Y hago click en "#collaborators span.text-label"
        Y relleno "title" con "Prueba editada"
        Y relleno "description" con "Prueba editada"
        Y relleno la fecha "date" con "01/01/2021"
        Y adjunto el archivo "tyrion.jpg" a "attachmentUpload"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/app/celebrations/\d+"
