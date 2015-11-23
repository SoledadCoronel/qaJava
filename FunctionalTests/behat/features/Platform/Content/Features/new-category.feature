#language: es
Característica: Crear categoría en la aplicación de contenidos
Como usuario administrador de la plataforma quiero poder crear una categoría en la aplicación de contenidos

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Espacio Autojoin" en ".espacios"

    @javascript @loadArticlesAndCategories
    Escenario: Creo una nueva categoría desde el detalle de un artículo
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "btn-category-new"
    Y sigo "Nueva categoría"
    Y espero a que aparezca el contenido dinámico "Crear categoría" en "#modal-new-cat"
    Y relleno "name" con "Nueva categoría de prueba"
    Cuando presiono "Guardar"
    Y presiono "btn-category-new"
    Y sigo "Administrar categorías"
    Entonces espero a que aparezca el contenido dinámico "Nueva categoría de prueba" en ".categories-list"

    @javascript @loadArticlesAndCategories
    Escenario: Creo una nueva categoría desde el detalle de un artículo con un nombre ya existente
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "btn-category-new"
    Y sigo "Nueva categoría"
    Y espero a que aparezca el contenido dinámico "Crear categoría" en "#modal-new-cat"
    Y relleno "name" con "Categoría de prueba 1"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "El nombre de la categoría ya existe" en ".alert-error"

    @javascript @loadArticlesAndCategories
    Escenario: Creo una nueva categoría desde el detalle de un artículo con un nombre vacío
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "btn-category-new"
    Y sigo "Nueva categoría"
    Y espero a que aparezca el contenido dinámico "Crear categoría" en "#modal-new-cat"
    Y relleno "name" con ""
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Ocurrió un error al crear la categoría" en ".alert-error"
    Y debo ver "El nombre de la categoría no puede ser vacío"

    @javascript @loadArticlesAndCategories
    Escenario: Creo una nueva categoría desde el detalle de un artículo con más de 80 caracteres
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "btn-category-new"
    Y sigo "Nueva categoría"
    Y espero a que aparezca el contenido dinámico "Crear categoría" en "#modal-new-cat"
    Y relleno "name" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non tellus turpis molestie."
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Ocurrió un error al crear la categoría" en ".alert-error"
    Y debo ver "El nombre de la categoría debe contener como máximo 80 caracteres"

    @javascript @loadArticlesAndCategories
    Escenario: Creo una nueva categoría desde el administrador de categorías
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "btn-category-new"
    Y sigo "Administrar categorías"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba 1" en ".categories-list"
    Cuando presiono "Nueva categoría"
    Y debo ver "Guardar"
    Y relleno "name" con "Categoría de prueba"
    Y presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Categoría de prueba" en ".categories-list"

    @javascript @loadArticlesAndCategories
    Escenario: Creo una nueva categoría desde un nuevo articulo
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "Nuevo contenido"
    Y espero a que aparezca el contenido dinámico "Sin Clasificar" en ".categories-list"
    Y hago click en "#category-new"
    Y espero a que aparezca el contenido dinámico "Crear categoría" en "#modal-new-cat"
    Y relleno "name" con "Lorem ipsum"
    Cuando hago click en ".category-save"
    Entonces espero a que aparezca el contenido dinámico "Lorem ipsum" en ".categories-list"
