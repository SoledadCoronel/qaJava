# language: es
Característica: Como usuario administrador necesito ordenar los espacios ya creados

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

  @javascript @loadWorkspaceSortData
  Escenario: Ordeno espacios y verifico que se actualice
    Dado sigo "Inicio"
    Y espero a que aparezca el contenido dinámico "Nuevo espacio" en "#workspaces"
    Y presiono "dropdown-workspace-menu"
    Y sigo "Administrar espacios"
    Y espero a que aparezca el contenedor dinámico ".spaces-administrator"
    Cuando muevo "Espacio 1" a "Espacio 2" en "#middle-section"
    Y espero a que aparezca el contenido dinámico "Se cambió el orden de los espacios" en ".alert-success"
    Y sigo "Inicio"
    Y espero a que aparezca el contenedor dinámico "#spaces"
    Entonces el orden de "li.nav-header" debe ser "ESPACIO 2, ESPACIO 1, ESPACIO INACTIVO"

  @javascript @loadWorkspaceSortData
  Escenario: Chequeo comportamiento en ambiente sin espacios
    Dado sigo "Institucional"
    Y espero a que aparezca el contenido dinámico "Nuevo espacio" en "#workspaces"
    Y presiono "dropdown-workspace-menu"
    Cuando sigo "Administrar espacios"
    Entonces debo ver "No se encontraron espacios disponibles para este ambiente."
