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

    @javascript @loadShowUserEmail
    Esquema del escenario: Listado de colaboradores sin mail y sin filtros
        Dado debe aparecer el contenido dinámico "Sarah Connor" en "#collaborators-grid"
        Y no debo ver "Email"
        Y espero a que aparezca el contenido dinámico "John Connor" en "#collaborators-grid"
        Y el elemento "#collaborators-grid" debe contener "<fullname>"
        Y no debo ver "<email>"
    
        Ejemplos:
            | fullname            |           email               |
            | John Connor         |  johnconnor@gointegro.com    |
            | John Salchichón     | johnsalchichon@gointegro.com  |