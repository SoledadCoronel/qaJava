# language: es
Característica: Comentario de un post de mi muro
                Como usuario de frontend quiero poder comentar el post en el muro de otro usuario

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "sarahconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

        @javascript @loadStandardData
        Escenario: Desde mi perfil y siendo que tengo contratada la aplicación de actividad social debo poder ver mi muro y realizar un post. Luego desde otro usuario entro al perfil anterior y a la publicacion anterior le genero un comentario
            Dado voy a "/profile"
            Y debo ver un elemento ".content-text"
            Y relleno "text" con "Primer post de testing en mi propio muro"
            Y presiono "Publicar"
            Y espero a que aparezca el contenido dinámico "Primer post de testing en mi propio muro" en "section.post"
            Y voy a "/auth/signout"
            Y debo estar en "/auth/signin"
            Y relleno "_username" con "johnconnor"
            Y relleno "_password" con "123456"
            Cuando presiono "_submit"
            Entonces debo estar en "/"
            Y voy a "/profile/sarah-connor"
            Y espero a que aparezca el contenido dinámico "Primer post de testing en mi propio muro" en "section.post" por 90 segundos
            Y debo ver un elemento ".comment-area"
            Y espero a que aparezca el contenedor dinámico ".comment-area ~ div"
            Y relleno "comment-content" con "Mi comentario al post de testing en el muro de otro usuario" y presiono enter
            Entonces espero a que aparezca el contenido dinámico "Mi comentario al post de testing en el muro de otro usuario" en ".comment-list"
