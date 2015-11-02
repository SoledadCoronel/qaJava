# language: es

# @todo En este momento colaboradores no es configurable para la lista de usuarios
# de la plataforma, en el futuro esto deberá ser configurable para que colaboradores pueda tener
# distinto nombre, colaboradores, gointegros , etc.
Característica: Ver El listado de colaboradores y poder realizar una búsqueda.
    Para poder listar colaboradores
    Como usuario logueado
    Necesito ver el listado de colaboradores y poder filtrar la información.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Y debo estar en "/"
        Y sigo "Colaboradores"
        Entonces debo estar en "/collaborators"

    @javascript @loadCollaboratorData
    Esquema del escenario: Listado de colaboradores con mail y sin filtros
        Dado debe aparecer el contenido dinámico "Jon Conan" en "#collaborators-grid"
        Y debe aparecer el contenido dinámico "Email" en "#collaborators-grid"
        Y espero a que aparezca el contenido dinámico "John Connor" en "#collaborators-grid"
        Y el elemento "#collaborators-grid" debe contener "<fullname>"
        Y el elemento "#collaborators-grid" debe contener "<email>"
    
        Ejemplos:
            | fullname       |          email              |
            | John Connor    | johnconnor@gointegro.com   |
            | jon Conan      | johnconnor2@gointegro.com  |

    @javascript @loadCollaboratorData
    Escenario: Listado de colaboradores utilizando el filtro de busqueda con un solo resultado.
        Dado espero a que aparezca el contenido dinámico "Jon Conan" en "#collaborators-grid"
        Cuando relleno "filters[fullname]" con "Connor"
        Y hago click en "#fullname-filter-btn-submit"
        Y espero a que desaparezca el contenido dinámico "Jon Conan" en "#collaborators-grid"
        Entonces espero a que aparezca el contenido dinámico "John Connor" en "#collaborators-grid"

    @javascript @loadCollaboratorData
    Escenario: Listado de colaboradores utilizando el filtro de búsqueda con más de un resultado.
        Dado espero a que aparezca el contenido dinámico "Colaborador" en "#collaborators-grid"
        Cuando relleno "filters[fullname]" con "Con"
        Y hago click en "#fullname-filter-btn-submit"
        Y espero a que aparezca el contenido dinámico "John Connor" en "#collaborators-grid"
        Entonces debo ver "Jon Conan"

    @javascript @loadCollaboratorData
    Esquema del escenario: Lista de colaboradores utilizando filtro de nombre y mail
        Dado espero a que aparezca el contenido dinámico "Jon Conan" en "#collaborators-grid"
        Cuando relleno "<filter>" con "<search>"
        Y hago click en "<filterBtn>"
        Entonces espero a que aparezca el contenido dinámico "<result>" en "#collaborators-grid"

        Ejemplos:
           | filter              | search                  |           filterBtn         |            result                 |
           | filters[fullname]   | Conan                   | #fullname-filter-btn-submit |           Jon Conan               |
           | filters[email]      | surname1@gointegro.com  |   #email-filter-btn-submit  | username1.surname1@gointegro.com  |

    @javascript @loadCollaboratorData
    Escenario: Paginación en el listado de colaboradores
        Dado debe aparecer el contenido dinámico "Jon Conan" en "#collaborators-grid"
        Entonces espero a que aparezca el contenido dinámico "Apellido 1" en "#collaborators-grid"
        Entonces espero a que aparezca el contenido dinámico "Apellido 38" en "#collaborators-grid"

        Y hago click en "#page-2"
        Entonces espero a que aparezca el contenido dinámico "Apellido 39" en "#collaborators-grid"
        Entonces espero a que aparezca el contenido dinámico "Apellido 83" en "#collaborators-grid"

        Y hago click en "#page-3"
        Entonces espero a que aparezca el contenido dinámico "Apellido 84" en "#collaborators-grid"
        Entonces espero a que aparezca el contenido dinámico "Apellido 99" en "#collaborators-grid"

        Y hago click en "#page-prev"
        Entonces espero a que aparezca el contenido dinámico "Apellido 39" en "#collaborators-grid"
        Entonces espero a que aparezca el contenido dinámico "Apellido 83" en "#collaborators-grid"

        Y hago click en "#page-first"
        Entonces espero a que aparezca el contenido dinámico "Apellido 1" en "#collaborators-grid"
        Entonces espero a que aparezca el contenido dinámico "Apellido 38" en "#collaborators-grid"


    @javascript @loadCollaboratorData
    Escenario: Listado de colaboradores con paginación y filtros
      Dado debe aparecer el contenido dinámico "Jon Conan" en "#collaborators-grid"
      Entonces espero a que aparezca el contenido dinámico "Apellido 1" en "#collaborators-grid"
      Entonces espero a que aparezca el contenido dinámico "Apellido 38" en "#collaborators-grid"

      Cuando relleno "filters[fullname]" con "Nombre"
      Y hago click en "#fullname-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "Apellido 1" en "#collaborators-grid"
      Entonces espero a que aparezca el contenido dinámico "Apellido 4" en "#collaborators-grid"

      Y hago click en "#page-2"
      Entonces espero a que aparezca el contenido dinámico "Apellido 40" en "#collaborators-grid"
      Entonces espero a que aparezca el contenido dinámico "Apellido 85" en "#collaborators-grid"

      Y hago click en "#page-prev"
      Entonces espero a que aparezca el contenido dinámico "Apellido 1" en "#collaborators-grid"
      Entonces espero a que aparezca el contenido dinámico "Apellido 4" en "#collaborators-grid"

      Y hago click en "#page-last"
      Entonces espero a que aparezca el contenido dinámico "Apellido 86" en "#collaborators-grid"
      Entonces espero a que aparezca el contenido dinámico "Apellido 99" en "#collaborators-grid"
