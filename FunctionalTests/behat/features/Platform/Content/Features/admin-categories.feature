#language: es
Característica: Administrar categorías en una aplicación de contenidos

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Espacio Autojoin" en "#spaces"
      Dado hago click en ".more-button"
      Y sigo "Contenido del espacio"
      Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
      Y presiono "btn-category-new"
      Y sigo "Administrar categorías"
      Y espero a que aparezca el contenido dinámico "Categoría de prueba 1" en "#admin-categories"


    @javascript @loadArticlesAndCategories
    Escenario: Ordenar categorias
    Cuando muevo "Categoría de prueba 1" a "Categoría de prueba 2" en "ul.categories-list"
    Y espero a que aparezca el contenido dinámico "Se cambió el orden de las categorías" en ".alert-success"
    Entonces el orden de "ul.categories-list span.category-name" debe ser "Categoría de prueba 2, Categoría de prueba 1"


    @javascript @loadArticlesAndCategories
    Escenario: Crear una nueva categoría
    Y presiono "newCategoryBtn"
    Y relleno "name" con "Categoria nueva"
    Y presiono "btnCategorySave"
    Y espero a que aparezca el contenido dinámico "Categoria nueva" en "#admin-categories"


    @javascript @loadArticlesAndCategories
    Escenario: Editar una categoría
    Y hago click en "ul.categories-list i.icon-pencil:first"
    Y relleno "name" con "Categoría de prueba 1 modificada"
    Y presiono "btnCategorySave"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba 1 modificada" en "#admin-categories"


    @javascript @loadArticlesAndCategories
    Escenario: Eliminar una categoría
    Y hago click en "ul.categories-list i.icon-trash:first"
    Y espero a que aparezca el contenedor dinámico "#delete-modal"
    Y confirmo la eliminación presionando "Confirmar"
    Y espero a que desaparezca el contenido dinámico "Categoría de prueba 1" en "#admin-categories"
