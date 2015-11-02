#language: es
Característica: Editar categoría en la aplicación de contenidos
Como usuario administrador de la plataforma quiero poder editar una categoría existente

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Espacio Autojoin" en ".espacios"

    @javascript @loadArticlesAndCategories
    Escenario: Edito una categoría desde el administrador de categorías
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "btn-category-new"
    Y sigo "Administrar categorías"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba 1" en ".categories-list"
    Cuando hago click en ".btn-edit:first"
    Y debo ver "Guardar"
    Y relleno "name" con "Categoría de prueba"
    Y presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Categoría de prueba" en ".categories-list"

    @javascript @loadArticlesAndCategories
    Escenario: Edito una categoría desde el administrador de categorías con un nombre duplicado
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "btn-category-new"
    Y sigo "Administrar categorías"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba 1" en ".categories-list"
    Cuando hago click en ".btn-edit:first"
    Y debo ver "Guardar"
    Y relleno "name" con "Categoría de prueba 2"
    Y presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "El nombre de la categoría ya existe" en ".alert-error"

    @javascript @loadArticlesAndCategories
    Escenario: Edito una categoría desde el administrador de categorías con un nombre vacío
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y presiono "btn-category-new"
    Y sigo "Administrar categorías"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba 1" en ".categories-list"
    Cuando hago click en ".btn-edit:first"
    Y debo ver "Guardar"
    Y relleno "name" con " "
    Y presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Ocurrió un error al editar la categoría" en ".alert-error"
    Y debo ver "El nombre de la categoría no puede ser vacío"
