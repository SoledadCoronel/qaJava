# language: es
Característica: Ver los tags frecuentes en los diferentes muros de la plataforma

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadTags
    Escenario: Desde mi perfil y dado que hay cargados posteos y comentarios con hashtags debo ver la lista de tags frecuentes ordenada correctamente
        Dado voy a "/profile"
        Y espero a que aparezca el contenido dinámico "Publicar" en ".post-form"
        Entonces el orden de "ul.hashtags li a.tag" debe ser "#tagsocialusercomment,#tagworkspace,#otrotemafrequente1,#otrotemafrequente10,#otrotemafrequente11,#otrotemafrequente12,#otrotemafrequente13,#otrotemafrequente14,#otrotemafrequente15,#otrotemafrequente2,#otrotemafrequente3,#otrotemafrequente4,#otrotemafrequente5,#otrotemafrequente6,#otrotemafrequente7,#otrotemafrequente8,#otrotemafrequente9,#tagotheruser,#tagplatform,#taguser"

    @javascript @loadTags
    Escenario: Desde un espacio y dado que hay cargados posteos y comentarios con hashtags debo ver la lista de tags frecuentes ordenada correctamente
      Dado sigo "Actividad Social Corporativa"
      Y espero a que aparezca el contenido dinámico "Publicar" en ".post-form"
      Entonces el orden de "ul.hashtags li a.tag" debe ser " #tagsocialusercomment,#tagworkspace"

    @javascript @loadTags
    Escenario: Desde el muero de la plataforma y dado que hay cargados posteos y comentarios con hashtags debo ver la lista de tags frecuentes ordenada correctamente
      Dado voy a "/social/wall"
      Y espero a que aparezca el contenido dinámico "Publicar" en ".post-form"
      Entonces el orden de "ul.hashtags li a.tag" debe ser "#tagsocialusercomment,#tagworkspace,#otrotemafrequente1,#otrotemafrequente10,#otrotemafrequente11,#otrotemafrequente12,#otrotemafrequente13,#otrotemafrequente14,#otrotemafrequente15,#otrotemafrequente2,#otrotemafrequente3,#otrotemafrequente4,#otrotemafrequente5,#otrotemafrequente6,#otrotemafrequente7,#otrotemafrequente8,#otrotemafrequente9,#tagotheruser,#tagplatform,#taguser"
