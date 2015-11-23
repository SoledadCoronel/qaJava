# language: es
Característica: Postear en mi muro
                Como usuario de frontend quiero poder postear un contenido de texto en mi muro

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "sarahconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadStandardData
    Escenario: Desde mi perfil y siendo que tengo contratada la aplicación de actividad social debo poder ver mi muro y realizar un post.
        Dado voy a "/profile"
        Entonces espero a que aparezca el contenido dinámico "Publicar" en ".post-form"
        Y relleno "text" con "Este es mi primer post en el muro: Los odio a todos!"
        Cuando presiono "Publicar"
        Y espero a que aparezca el contenido dinámico "Este es mi primer post en el muro: Los odio a todos!" en ".social-feed-content"
        Entonces debo ver "Este es mi primer post en el muro: Los odio a todos!"

    @javascript @loadStandardData
    Escenario: Desde el listado de colaboradores ingreso al perfil de otro usuario y realizo un post
        Dado voy a "/profile/t-800"
        Entonces espero a que aparezca el contenido dinámico "Publicar" en ".post-form"
        Y relleno "text" con "T800 > no me vas a atrapar"
        Y presiono "Publicar"
        Y espero a que aparezca el contenido dinámico "T800 > no me vas a atrapar" en ".social-feed-content"
        Entonces debo ver "T800 > no me vas a atrapar"

