#language: es
Característica: Pantalla de inicio de Artículos
Como usuario de la plataforma quiero poder ingresar al home de artículos

    Antecedentes:
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
      Cuando presiono "_submit"
      Entonces debo estar en "/"
      Y espero a que aparezca el contenido dinámico "Espacio Autojoin" en "#spaces"

    @javascript @loadArticlesAndCategories
    Escenario: Ingreso a una aplicación de contenidos y veo que no hay contenidos cargados
      Dado sigo "Novedades del espacio"
      Y espero a que aparezca el contenido dinámico "No se han cargado contenidos" en "body"

    @javascript @loadArticlesAndCategories
    Escenario: Ingreso a una aplicación de contenidos y veo un contenido por defecto
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Contenido del espacio" en "body"
    Y espero a que aparezca el contenido dinámico "Título de contenido de prueba sin categoría" en "body"
    Y espero a que aparezca el contenido dinámico "Contenido de prueba sin categoría" en "body"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba 1" en "aside"

    @javascript @loadArticlesAndCategories
    Escenario: Ingreso al home de una aplicación de contenidos y sigo el contenido por defecto.
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Contenido del espacio" en "body"
    Y espero a que aparezca el contenido dinámico "Titulo de contenido de prueba" en "body"
    Y espero a que aparezca el contenido dinámico "Contenido de prueba" en "body"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba" en "aside"
    Y espero a que aparezca el contenido dinámico "Seguir" en ".actions-likes"
    Cuando hago click en "#follow-button"
    Y espero a que aparezca el contenido dinámico "Dejar de seguir" en ".actions-likes"
    # Además pruebo que pueda dejar de seguirlo.
    Entonces hago click en "#unfollow-button"
    Y espero a que aparezca el contenido dinámico "Seguir" en ".actions-likes"

    @javascript @loadArticlesAndCategories
    Escenario: Ingreso al home de una aplicación de contenidos y pongo 'Me gusta' el contenido por defecto
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Contenido del espacio" en "body"
    Y espero a que aparezca el contenido dinámico "Titulo de contenido de prueba" en "body"
    Y espero a que aparezca el contenido dinámico "Contenido de prueba" en "body"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba" en "aside"
    Y espero a que aparezca el contenido dinámico "Seguir" en ".actions-likes"
    Cuando hago click en ".like-button"
    Entonces espero a que aparezca el contenido dinámico "Ya no me gusta" en ".actions-likes"
    Y espero a que aparezca el contenido dinámico "Te gusta esto." en ".readable-like-count"
    # Además pruebo "Ya no me gusta"
    Cuando hago click en ".unlike-button"
    Entonces espero a que aparezca el contenido dinámico "Me gusta" en ".actions-likes"

    @javascript @loadArticlesAndCategories
    Escenario: Ingreso al home de una aplicación de contenidos y comento el contenido por defecto
    Dado hago click en ".more-button"
    Y sigo "Contenido del espacio"
    Y espero a que aparezca el contenido dinámico "Contenido del espacio" en "body"
    Y espero a que aparezca el contenido dinámico "Titulo de contenido de prueba" en "body"
    Y espero a que aparezca el contenido dinámico "Contenido de prueba" en "body"
    Y espero a que aparezca el contenido dinámico "Categoría de prueba" en "aside"
    Y espero a que aparezca el contenido dinámico "Seguir" en ".actions-likes"
    Y relleno "comment-content" con "Comentando el artículo por default" y presiono enter
    Entonces espero a que aparezca el contenido dinámico "hace unos segundos" en ".timeago"
    # Además pruebo eliminar un comentario
    Cuando presiono "comment-delete"
    Entonces no debo ver "hace unos segundos"
