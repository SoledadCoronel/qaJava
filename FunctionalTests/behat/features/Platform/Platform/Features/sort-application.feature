# language: es
Característica: Como usuario administrador necesito ordenar las aplicaciones instaladas en un espacio

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"
    Y sigo "Inicio"
    Y espero a que aparezca el contenedor dinámico ".workspace-menu"
    Y hago click en ".workspace-menu:first"
    Y sigo "Administrar aplicaciones"
    Y la URL debe seguir el patrón "workspace/\d+/app/sort"
    Y espero a que aparezca el contenedor dinámico "#configureApplication"

  @javascript @loadWorkspaceStandardData
  Escenario: Ordeno aplicaciones y verifico que se actualice
    Cuando muevo "Activity stream" a "Contenidos GoIntegro" en "#middle-section"
    Y espero a que aparezca el contenido dinámico "Se cambió el orden de las aplicaciones" en ".alert-success"
    Y sigo "Inicio"
    Y espero a que aparezca el contenedor dinámico "#spaces"
    Entonces el orden de "ul.spaces li.space" debe ser "Contenidos GoIntegro, Activity stream"
