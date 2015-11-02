#language: es
Característica: Pantalla de creación de un artículo
Como usuario de la plataforma quiero poder crear un artículo

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
      Y sigo "Artículos Corporativos"
      Y espero a que aparezca el contenido dinámico "No se han cargado contenidos" en "body"
      Y presiono "Nuevo contenido"

    @javascript @loadStandardUserData
    Escenario: Ingreso a una aplicación de contenidos y cargo un contenido nuevo
      Dado espero a que aparezca el contenido dinámico "Título" en "body"
      Cuando lleno el WYSIWYG "title" con "Lorem ipsum... Title"
      Y lleno el WYSIWYG "content" con "Lorem ipsum... Content"
      Y presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Lorem ipsum... Title" en ".main-container"
      Y debo ver "Lorem ipsum... Content"

    @javascript @loadStandardUserData
    Escenario: Ingreso a una aplicación de contenidos y cargo un contenido vacio
      Dado espero a que aparezca el contenido dinámico "Título" en "body"
      Cuando lleno el WYSIWYG "title" con "Lorem ipsum... Title Lorem ipsum... Title Lorem ipsum... Title Lorem ipsum... Title"
      Entonces presiono "Guardar"
      Y debo ver "Atención ¡Existen errores en el formulario!"
      Y debo ver "El título no puede estar vacío y debe tener un máximo de 80 caracteres"
      Y debo ver "El detalle no puede estar vacío"
