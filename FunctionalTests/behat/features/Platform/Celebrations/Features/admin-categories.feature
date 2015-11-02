#language: es
Característica: Administrar categorías en una aplicación de celebraciones

    Antecedentes:
      Dado estoy en "/auth/signin"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Espacio Público" en "#spaces"
      Y sigo "Celebraciones Corporativas"
      #Y espero a que aparezca el contenido dinámico "Titulo de contenido de prueba sin categoria" en "body"
      # @todo Cambiar esto cuando este hecha la home de celebraciones
      Y espero a que aparezca el contenido dinámico "Espacio Público" en "body"
      Y presiono "btn-admin-categories"
      Y sigo "Administrar categorías"
      Y espero a que aparezca el contenido dinámico "Categoría de prueba 1" en "#categories-list"


    @javascript @loadCelebrationsData
    Escenario: Ordenar categorias
    Cuando muevo "Categoría de prueba 1" a "Categoría de prueba 2" en "ul#categories-list"
    Entonces el orden de "ul.categories-list span.category-name" debe ser "Categoría de prueba 2, Categoría de prueba 1"


    @javascript @loadCelebrationsData
    Escenario: Crear una nueva categoría
    Y presiono "new-category-btn"
    Y relleno "name" con "Categoria nueva"
    Y presiono "btn-category-save"
    Y espero a que aparezca el contenido dinámico "Categoria nueva" en "#categories-list"


    @javascript @loadCelebrationsData
    Escenario: Crear una nueva categoría con automatización
    Y presiono "new-category-btn"
    Y relleno "name" con "Categoria nueva"
    Y la casilla de selección ".automation" debe estar marcada
    Y presiono "btn-category-save"
    Y espero a que aparezca el contenido dinámico "Categoria nueva" en "#categories-list"
    Y espero a que aparezca el contenido dinámico "Fecha de nacimiento" en "#categories-list"


    @javascript @loadCelebrationsData
    Escenario: Editar una categoría
    Y hago click en "ul.categories-list i.icon-pencil:first"
    Y relleno "name" con "Categoría de prueba 1 modificada"
    Y presiono "btn-category-save"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba 1 modificada" en "#categories-list"


    @javascript @loadCelebrationsData
    Escenario: Eliminar una categoría
    # Hago click en el segundo elemento "Categoria 2"
    Y hago click en "ul.categories-list li:first-child + li i.icon-trash:first"
    Y espero a que aparezca el contenedor dinámico "#delete-modal"
    Y confirmo la eliminación presionando "Confirmar"
    Y espero a que desaparezca el contenido dinámico "Categoría de prueba 2" en "#categories-list"
