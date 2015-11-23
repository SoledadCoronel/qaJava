#language: es
Característica: Pantalla de edición de un artículo
Como usuario de la plataforma quiero poder editar un artículo

      Antecedentes:
            Dado estoy en "/auth/signin?_lang=es"
            Y relleno "_username" con "johnconnor"
            Y relleno "_password" con "123456"
            Cuando presiono "_submit"
            Entonces debo estar en "/"
            Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
            Y sigo "Contenidos Cargados"
            Y espero a que aparezca el contenido dinámico "Título Contenido de test" en "body"
            Y hago click en ".article-actions"
            Y sigo "Editar"

      @javascript @loadArticleContentApp
      Escenario: Ingreso a una aplicación de contenidos y edito un contenido
      Dado lleno el WYSIWYG "title" con "Lorem ipsum... Title"
      Y lleno el WYSIWYG "content" con "Lorem ipsum... Content"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Lorem ipsum... Title" en ".main-container"
      Y debo ver "Lorem ipsum... Content"

      @javascript @loadArticleContentApp
      Escenario: Ingreso a una aplicación de contenidos edito un contenido y lo guardo sin modificaciones
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Título Contenido de test" en ".main-container"
      Y espero a que aparezca el contenido dinámico "Contenido de test yeah" en "body"
