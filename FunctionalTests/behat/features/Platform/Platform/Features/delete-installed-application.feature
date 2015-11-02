# language: es
Característica: Como usuario administrador quiero poder eliminar una aplicación instalada

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
  Escenario: Elimino una aplicación instalada y verifico que ya no se visualice en la barra izquierda donde figuran las apps de un espacio
      Dado presiono "Eliminar Contenidos GoIntegro"
      Y espero a que aparezca el contenedor dinámico "#delete-modal"
      Y confirmo la eliminación presionando "Confirmar"
      Entonces voy a la página de inicio
      Y no debo ver "Contenidos GoIntegro"
