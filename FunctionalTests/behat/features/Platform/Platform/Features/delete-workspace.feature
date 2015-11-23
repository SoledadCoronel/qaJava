# language: es
Característica: Como usuario administrador quiero poder eliminar un espacio

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"
    Y sigo "Inicio"
    Y espero a que aparezca el contenido dinámico "Comunidad tres tiras" en ".espacios"

  # este escenario requiere de al menos un espacio activo desde el front para un ambiente
  @javascript @loadWorkspaceListData
  Escenario: Elimino un espacio y verifico que ya no se visualice en la barra izquierda donde figuran los espacios del ambiente
      Dado presiono "dropdown-workspace-menu"
      Y sigo "Administrar espacios"
      Y espero a que aparezca el contenido dinámico "Comunidad tres tiras" en ".spaces-administrator"
      Cuando presiono "Eliminar"
      Y espero a que aparezca el contenedor dinámico "#delete-workspace-modal"
      # el mensaje del confirm debe especificar bien claro que se perderan todos los contenidos sociales o no cargados en ese espacio.
      Y confirmo la eliminación presionando "Confirmar"
      Entonces no debo ver el espacio "Comunidad tres tiras" en "#configureWorkspace"
      Y voy a la página de inicio
      Entonces no debo ver "Comunidad tres tiras"
