#language: es
Característica: Instalar una aplicación en una plataforma.
Como usuario administrador quiero poder instalar aplicaciones en un espacio desde el front

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"
    Y espero a que aparezca el contenido dinámico "Inicio" en "#environments"
    Y hago click en ":contains(Inicio)"
    Y espero a que aparezca el contenedor dinámico ".workspace-menu"
    Y hago click en ".workspace-menu:first"
    Y sigo "Agregar aplicación"
    Y la URL debe seguir el patrón "workspace/\d+/app/list"
    Y espero a que aparezca el contenedor dinámico ".application-preview"

  @javascript @loadTournamentsStandardData
  Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar. Presiono instalar en la app Torneos Pro,
  completo todos los campos requeridos y envio el formulario. Volviendo Al listado de aplicaciones y viendo un cartel que me indica
  que la aplicación se instalo correctamente
    Dado presiono "Instalar Torneos Pro"
    Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
    Y espero a que aparezca el contenido dinámico "Nombre de la aplicación" en "#application-install"
    Y relleno "name" con "Mi app de Torneos Pro"
    Y relleno "description" con "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum "
    Y selecciono "Copa Mundial Brasil 2014" de "tournamentList"
    Cuando presiono "accept"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "app/tournaments/\d+"
    Y espero a que aparezca el contenido dinámico "Mi app de Torneos Pro" en ".espacios"

  @javascript @loadTournamentsStandardData
  Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar.
  No completo todos los campos requeridos y envío el formulario, teniendo que visualizar un mensaje de error
    Dado presiono "Instalar Torneos Pro"
    Cuando presiono "accept"
    Entonces debo ver "Ingrese el nombre de la aplicación"

  @javascript @loadTournamentsStandardData
  Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar.
  y decido cancelar la operación de instalar.
    Dado presiono "Instalar Torneos Pro"
    Y relleno "name" con "My app cancelada"
    Cuando presiono "cancel"
    Entonces la URL debe seguir el patrón "workspace/\d+/app/list"
    Y no debo ver "La aplicación se instaló correctamente"
    Y no debo ver "My app cancelada"
