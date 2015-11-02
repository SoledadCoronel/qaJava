#language: es
Característica: Instalar una aplicación en una plataforma.
                Como usuario administrador quiero poder instalar aplicaciones en un espacio desde el front

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"
    Y sigo "Inicio"
    Y espero a que aparezca el contenedor dinámico ".workspace-menu"
    Y hago click en ".workspace-menu:first"
    Y sigo "Agregar aplicación"
    Y la URL debe seguir el patrón "workspace/\d+/app/list"
    Y espero a que aparezca el contenedor dinámico ".application-preview"

  @javascript @loadWorkspaceStandardData
  Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar. Presiono instalar en la app de Activity stream,
             completo todos los campos requeridos y envio el formulario. Volviendo Al listado de aplicaciones y viendo un cartel que me indica
             que la aplicación se instalo correctamente
    Dado presiono "Instalar Contenidos"
    Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
    Y relleno "name" con "Mi app de contenidos test"
    Y relleno "description" con "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum "
    Cuando presiono "accept"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "app/articles/\d+"
    Y  espero a que aparezca el contenido dinámico "Mi app de contenidos" en ".espacios"

  @javascript @loadWorkspaceStandardData
  Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar. Presiono instalar en la app de Activity stream,
             completo el nombre con caracteres especiales y todos los campos requeridos y envio el formulario. Volviendo Al listado de aplicaciones y viendo un cartel que me indica
             que la aplicación se instalo correctamente
    Dado presiono "Instalar Contenidos"
    Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
    Y relleno "name" con "àÀáÁãÃâÂçÇéÉêÊÍíóÓõÕúÚüÜÑñ"
    Y relleno "description" con "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum "
    Cuando presiono "accept"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "app/articles/\d+"
    Y  espero a que aparezca el contenido dinámico "àÀáÁãÃâÂçÇéÉêÊÍíóÓõÕúÚüÜÑñ" en ".espacios"

 @javascript @loadWorkspaceStandardData
 Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar.
            Intento instalar la aplicación de Activity Stream que ya tengo instalada para ese espacio. El botón de instalar debería estar
            des habilitado y no debería de poder instalarla nuevamente
    Entonces El botón "Instalar Actividad social" debe estar deshabilitado

 @javascript @loadWorkspaceStandardData
 Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar.
            No completo todos los campos requeridos y envío el formulario, teniendo que visualizar un mensaje de error
    Dado presiono "Instalar Contenidos"
    Cuando presiono "accept"
    Entonces debo ver "Ingrese el nombre de la aplicación"

@javascript @loadWorkspaceStandardData
Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar.
           y decido cancelar la operación de instalar.
    Dado presiono "Instalar Contenidos"
    Y relleno "name" con "My app cancelada"
    Cuando presiono "cancel"
    Entonces la URL debe seguir el patrón "workspace/\d+/app/list"
    Y no debo ver "La aplicación se instaló correctamente"
    Y no debo ver "My app cancelada"

 @javascript @loadWorkspaceStandardData
 Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar.
            Completo el nombre con el mismo de alguna aplicación previamente instalada.
    Dado presiono "Instalar Contenidos"
    Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
    Y relleno "name" con "Activity stream"
    Cuando presiono "accept"
    Entonces espero a que aparezca el contenido dinámico "Ya existe una aplicación con el nombre ingresado" en ".alert-error"
