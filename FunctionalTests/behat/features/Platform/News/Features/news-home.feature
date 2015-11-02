#language: es

Característica: Home de Novedades.
    Como usuario de la plataforma quiero poder ingresar a la home de Novedades.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo "Noticias Corporativas"

    @javascript @newsStandardData
    Esquema del escenario: Mostrar las primeras 5 novedades.
        Dado espero a que aparezca el contenido dinámico "Últimas" en ".main-container"
        Entonces espero a que aparezca el contenido dinámico "<title>" en "#articles-list"
        Ejemplos:
            | title                |
            | La Divina Commedia 1 |
            | La Divina Commedia 2 |
            | La Divina Commedia 3 |
            | La Divina Commedia 4 |
            | La Divina Commedia 5 |

    @javascript @newsStandardData
    Escenario: Scrollear las novedades.
        Dado espero a que aparezca el contenido dinámico "Últimas" en ".main-container"
        Y espero a que aparezca el contenido dinámico "La Divina Commedia 1" en "#articles-list"
        Cuando escroleo "html, body" hacia abajo 400 px
        Entonces espero a que aparezca el contenido dinámico "La Divina Commedia 6" en "#articles-list"
        Y espero a que aparezca el contenido dinámico "La Divina Commedia 7" en "#articles-list"
        Y espero a que aparezca el contenido dinámico "La Divina Commedia 8" en "#articles-list"
        Y espero a que aparezca el contenido dinámico "La Divina Commedia 9" en "#articles-list"

    @javascript @loadEmptyData
    Escenario: Ingresar como usuario admin a aplicación de novedades vacía.
        Dado espero a que aparezca el contenedor dinámico ".main-container"
        Entonces no debo ver "Últimas"

    @javascript @loadEmptyData
    Escenario: Ingresar como usuario básico a aplicación de novedades vacía.
        Dado estoy en "/auth/signout"
        Y estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "sarahconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y sigo "Noticias Corporativas"
        Y espero a que aparezca el contenedor dinámico ".main-container"
        Y no debo ver "Últimas"

    @javascript @newsStandardData
    Esquema del escenario: Ver listado de novedades.
        Dado espero a que aparezca el contenido dinámico "Últimas" en ".main-container"
        Entonces espero a que aparezca el contenido dinámico "<title>" en "#articles-list"
        Y espero a que aparezca el contenido dinámico "<description>" en "#articles-list"
        Ejemplos:
            | title | description |
            | La Divina Commedia 1 | Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita. |
            | La Divina Commedia 2 | Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita. |
            | La Divina Commedia 3 | Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita. |
            | La Divina Commedia 4 | Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita. |
            | La Divina Commedia 5 | Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura, ché la diritta via era smarrita. |

    @javascript @newsStandardData
    Escenario: Ingresar como usuario admin a la aplicación de novedades.
        Dado espero a que aparezca el contenido dinámico "Últimas" en ".main-container"
        Y espero a que aparezca el contenido dinámico "La Divina Commedia 1" en "#articles-list"
        Cuando hago click en ".dropdown-toggle"
        Entonces debo ver "Editar Novedades"
        Y debo ver "Eliminar Novedades"

    @javascript @newsStandardData
    Escenario: Desplegar mes del árbol de novedades.
        Dado espero a que aparezca el contenido dinámico "Últimas" en ".sidebar-nav"
        Y espero a que aparezca el contenido dinámico "Semana pasada" en ".sidebar-nav"
        Y espero a que aparezca el contenido dinámico "2013" en ".sidebar-nav"
        Cuando hago click en ".filter-year-2013"
        Entonces debo ver "Octubre"
