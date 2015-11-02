# language: es
Característica: Crear espacios en los ambientes de la plataforma

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

  @javascript @loadWorkspaceStandardData
  Escenario: Crear espacio del ambiente default cuando me logueo en la plataforma como usuario admin
    Dado presiono "Nuevo espacio"
    Y debe aparecer el contenido dinámico "Nuevo espacio" en "body"
    Entonces selecciono del radio "disable" el valor "0"
    Y relleno "name" con "Comunidad tres tiras"
    Y relleno "description" con "Este espacio es creado a modo de prueba"
    Y selecciono del radio "public" el valor "1"
    Y relleno "visibleApp" con "2"
    Cuando presiono "Guardar"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"

  @javascript @loadWorkspaceStandardData
  Escenario: Crear espacio con caracteres especiales en el ambiente default cuando me logueo en la plataforma como usuario admin
    Dado presiono "Nuevo espacio"
    Y debe aparecer el contenido dinámico "Nuevo espacio" en "body"
    Entonces selecciono del radio "disable" el valor "0"
    Y relleno "name" con "àÀáÁãÃâÂçÇéÉêÊÍíóÓõÕúÚüÜÑñ"
    Y relleno "description" con "Este espacio es creado a modo de prueba"
    Y selecciono del radio "public" el valor "1"
    Y relleno "visibleApp" con "2"
    Cuando presiono "Guardar"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"
    Y debo ver "àÀáÁãÃâÂçÇéÉêÊÍíóÓõÕúÚüÜÑñ"

  @javascript @loadWorkspaceStandardData
  Escenario: Crear espacio del ambiente default con url externa
    Dado presiono "Nuevo espacio"
    Y debe aparecer el contenido dinámico "Nuevo espacio" en "body"
    Entonces selecciono del radio "disable" el valor "0"
    Y relleno "name" con "Comunidad tres tiras"
    Y sigo "Direccionar a una URL externa"
    Y relleno "externalUrl" con "http://www.google.com"
    Y relleno "description" con "Este espacio es creado a modo de prueba"
    Y selecciono del radio "public" el valor "1"
    Y hago click en "#workspace-label"
    Y relleno "labelDate" con la fecha de hoy
    Cuando presiono "Guardar"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"

  @javascript @loadWorkspaceStandardData
  Escenario: Crear espacio del ambiente default con el nombre de un espacio existente
    Dado presiono "Nuevo espacio"
    Y debe aparecer el contenido dinámico "Nuevo espacio" en "body"
    Entonces selecciono del radio "disable" el valor "0"
    Y relleno "name" con "Intranet"
    Y relleno "description" con "Este espacio es creado a modo de prueba"
    Y selecciono del radio "public" el valor "1"
    Y relleno "visibleApp" con "2"
    Cuando presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "El nombre del espacio ya existe para este ambiente" en ".alert-error"

  @javascript @loadWorkspaceStandardData
  Escenario: Crear espacio del ambiente default dejando el formulario vacío
    Dado presiono "Nuevo espacio"
    Entonces debe aparecer el contenido dinámico "Nuevo espacio" en "body"
    Cuando presiono "Guardar"
    Entonces debo ver "Campo obligatorio"

  @javascript @loadWorkspaceStandardData
  Escenario: Crear espacio desactivado
    Y espero a que aparezca el contenido dinámico "Nuevo espacio" en "button.btn.workspace-create"
    Dado presiono "Nuevo espacio"
    Y debe aparecer el contenido dinámico "Nuevo espacio" en "body"
    Entonces selecciono del radio "disable" el valor "1"
    Y relleno "name" con "Espacio inactivo"
    Y relleno "description" con "Este espacio esta desactivado"
    Y selecciono del radio "public" el valor "1"
    Y relleno "visibleApp" con "2"
    Cuando presiono "Guardar"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"
    Y debo ver "Espacio inactivo"
    Y debo ver el espacio "Espacio inactivo" desactivado

  @javascript @loadInstallApplicationWidgetData
  Escenario: Creando un espacio en un ambiente público sin login
    Dado sigo "Sin Login"
    Y presiono "Nuevo espacio"
    Y debe aparecer el contenido dinámico "Nuevo espacio" en "body"
    Entonces selecciono del radio "disable" el valor "0"
    Y relleno "name" con "Comunidad tres tiras"
    Y relleno "description" con "Este espacio es creado a modo de prueba"
    Y no debo ver "Preferencias de acceso"
    Cuando presiono "Guardar"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"
