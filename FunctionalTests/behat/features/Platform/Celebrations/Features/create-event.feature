#language: es
Característica: Como usuario administrador creo un evento en la aplicación de Celebraciones

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Espacio Público" en ".spaces"
      Y sigo "Celebraciones Corporativas"
      Y sigo "Nueva Celebración"
      Y espero a que aparezca el contenido dinámico "Desde mi PC" en ".platform"
      Y debo ver "Nueva Celebración"

    @javascript @loadCelebrationsData
    Escenario: Crear Evento
    Dado relleno "title" con "Prueba"
    Y relleno "description" con "Prueba"
    Y relleno la fecha "date" con "31/12/2020"
    Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
    Y presiono "Guardar"
    Entonces la URL debe seguir el patrón "/app/celebrations/\d+"

    @javascript @loadCelebrationsData
    Escenario: Crear Evento con título invalido
    Dado relleno "title" con "  ^^^"
    Y relleno "description" con "Prueba"
    Y relleno la fecha "date" con "31/12/2020"
    Y presiono "Guardar"
    Entonces debo ver "El título contiene caracteres inválidos"

    @javascript @loadCelebrationsData
    Escenario: Crear Evento con título vacio
    Dado relleno "title" con ""
    Y relleno "description" con "Prueba"
    Y relleno la fecha "date" con "31/12/2020"
    Y presiono "Guardar"
    Entonces debo ver "No se pudo guardar la Celebración"

    @javascript @loadCelebrationsData
    Escenario: Crear Evento con fecha invalida
    Dado relleno "title" con "título"
    Y relleno "description" con "Prueba"
    Y relleno la fecha "date" con ""
    Y presiono "Guardar"
    Entonces debo ver "La fecha no puede estar vacía"

    @javascript @loadCelebrationsData
    Escenario: Crear Evento con vacio
    Dado relleno "title" con ""
    Y relleno "description" con ""
    Y relleno la fecha "date" con ""
    Y presiono "Guardar"
    Entonces debo ver "No se pudo guardar la Celebración"

    @javascript @loadCelebrationsData
    Escenario: Crear categoria
    Dado presiono "form-category-new"
    Y espero a que aparezca el contenido dinámico "Crear categoría" en "body"
    Y relleno "name" con "Categoria Loca"
    Y presiono "new-category"
    Y relleno "title" con "título"
    Y relleno "description" con "Prueba"
    Entonces la URL debe seguir el patrón "/app/celebrations/\d+"

    @javascript @loadCelebrationsData
    Escenario: Crear Evento agregando varios colaboradores
      Dado relleno "title" con "Título de evento con colaboradores"
      Y relleno "collaborators-container-input" con "800"
      Y espero a que aparezca el contenido dinámico "T 800" en "#collaborators"
      Y hago click en "#collaborators span.text-label"
      Y relleno "collaborators-container-input" con "Sarah"
      Y espero a que aparezca el contenido dinámico "Sarah Connor" en "#collaborators"
      Y hago click en "#collaborators span.text-label"
      Y relleno "description" con "Descripción de evento con colaboradores"
      Y relleno la fecha "date" con "31/12/2020"
      Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
      Y presiono "Guardar"
      Entonces la URL debe seguir el patrón "/app/celebrations/\d+"
