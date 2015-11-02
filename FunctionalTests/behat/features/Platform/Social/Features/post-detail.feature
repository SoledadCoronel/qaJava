# language: es
Característica: Ver el detalle de un post
                Como usuario de frontend quiero ver el detalle de un post

    @javascript @loadStandardData
    Escenario: Desde mi perfil y siendo que tengo contratada la aplicación de actividad social debo poder ver mi muro y realizar un post.
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "t800"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Dado voy a "/social/wall"
        Y espero a que aparezca el contenido dinámico "Publicar" en ".post-form"
        Y relleno "text" con "Este es mi primer post en el muro: Los odio a todos!"
        Y presiono "Publicar"
        Y espero a que aparezca el contenido dinámico "Este es mi primer post en el muro: Los odio a todos!" en ".social-feed-content"
        Y debo ver "Este es mi primer post en el muro: Los odio a todos!"
        Y sigo "Compartir"
        Y espero a que aparezca el contenido dinámico "Compartir" en ".share-content-overlay"
        Y espero a que aparezca el contenido dinámico "T 800" en "#sharing-targets"
        Y sigo "share-btn"
        Y voy a "/profile"
        Y espero a que aparezca el contenido dinámico "Este es mi primer post en el muro: Los odio a todos!" en ".all-feeds"
        Cuando sigo "publicación"
        Entonces la URL debe seguir el patrón "/post/view/\d+"
