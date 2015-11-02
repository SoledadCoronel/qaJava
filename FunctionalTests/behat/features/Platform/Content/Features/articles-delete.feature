#language: es
Característica: Como usuario administrador de la plataforma necesito poder eliminar artículos

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
      Y sigo "Contenidos Cargados"
      Y espero a que aparezca el contenido dinámico "Contenido de test" en "body"
      Y hago click en ".article-actions"

    @javascript @loadArticleContentApp
    Escenario: Ingreso a una aplicación de contenidos y elimino un artículo
      Cuando hago click en ".delete-article"
      Y espero a que aparezca el contenido dinámico "Eliminar Contenido" en ".modal-header"
      Y presiono "Confirmar"
      Entonces espero a que aparezca el contenido dinámico "No se han cargado contenidos" en "body"
      Y la URL debe seguir el patrón "/app/articles/\d+"

    @javascript @loadArticleContentApp
    Escenario: Ingreso a una aplicación de contenidos y cancelo la eliminación de un artículo
      Cuando hago click en ".delete-article"
      Y espero a que aparezca el contenido dinámico "Eliminar Contenido" en ".modal-header"
      Y presiono "Cancelar"
      Y recargo la página
      Entonces debo ver "Contenido de test"
