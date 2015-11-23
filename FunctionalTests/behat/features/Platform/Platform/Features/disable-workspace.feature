# language: es
Característica: Como usuario administrador necesito activar y desactivar los espacios ya creados

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

  @javascript @loadWorkspaceSortData
    Escenario: Activo espacios y verifico que se actualice
      Dado sigo "Inicio"
      Y espero a que aparezca el contenido dinámico "Espacio 1" en "#workspaces"
      Y presiono "dropdown-workspace-menu"
      Y sigo "Administrar espacios"
      Y espero a que aparezca el contenido dinámico "Activar" en ".spaces-administrator"
      Cuando presiono "Activar"
      Y voy a la página de inicio
      Entonces debo ver el espacio "Espacio inactivo" activado

  @javascript @loadWorkspaceSortData
    Escenario: Desactivo espacios y verifico que se actualice
      Dado sigo "Recursos Humanos"
      Y presiono "dropdown-workspace-menu"
      Y sigo "Administrar espacios"
      Y espero a que aparezca el contenido dinámico "Desactivar" en ".spaces-administrator"
      Cuando presiono "Desactivar"
      Y sigo "Recursos Humanos"
      Entonces debo ver "Espacio activo"
      Y debo ver el espacio "Espacio activo" desactivado