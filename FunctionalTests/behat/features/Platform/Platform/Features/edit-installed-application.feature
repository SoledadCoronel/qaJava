#language: es
Característica: Editar la configuración de una aplicación instalada en una plataforma.
                Como usuario administrador quiero poder editar la configuración de una aplicación instalada en un espacio desde el front

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
  Escenario: Desde la configuración de un espacio ingreso a la sección de administrar aplicaciones. Presiono configurar en la app de contenidos: Contenidos GoIntegro,
             edito los datos y envio el formulario. Volviendo Al listado de aplicaciones y viendo un cartel que me indica
             que la aplicación se actualizó correctamente.
    Dado presiono "Configurar Contenidos GoIntegro"
    Y la URL debe seguir el patrón "app/\d+/edit"
    Y relleno "name" con "EDITED Cont"
    Y relleno "description" con "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum"
    Cuando presiono "accept"
    Y espero a que cambie la URL
    Entonces la URL debe seguir el patrón "app/articles/\d+"
    Y  espero a que aparezca el contenido dinámico "EDITED Cont" en ".espacios"

  @javascript @loadWorkspaceStandardData
  Escenario: Desde la configuración de un espacio ingreso a la sección de administrar aplicaciones. Presiono configurar en la app de contenidos: Contenidos GoIntegro,
             edito los datos con un nombre de aplicación duplicado y envio el formulario, teniendo que visualizar un mensaje de error.
    Dado presiono "Configurar Contenidos GoIntegro"
    Y la URL debe seguir el patrón "app/\d+/edit"
    Y relleno "name" con "Activity stream"
    Cuando presiono "accept"
    Entonces espero a que aparezca el contenido dinámico "Ya existe una aplicación con el nombre ingresado" en ".alert-error"

  @javascript @loadWorkspaceStandardData
  Escenario: Desde la configuración de un espacio ingreso a la sección de administrar aplicaciones. Presiono configurar en la app de contenidos: Contenidos GoIntegro,
             edito los datos dejando el nombre vacío y envio el formulario, teniendo que visualizar un mensaje de error.
    Dado presiono "Configurar Contenidos GoIntegro"
    Y la URL debe seguir el patrón "app/\d+/edit"
    Y relleno "name" con " "
    Cuando presiono "accept"
    Entonces debo ver "Ingrese el nombre de la aplicación"

@javascript @loadWorkspaceStandardData
Escenario: Desde la configuración de un espacio ingreso a la sección de administrar aplicaciones. Presiono configurar en la app de contenidos: Contenidos GoIntegro
           y decido cancelar la operación de editar.
    Dado presiono "Configurar Contenidos GoIntegro"
    Y la URL debe seguir el patrón "app/\d+/edit"
    Cuando presiono "cancel"
    Entonces la URL debe seguir el patrón "workspace/\d+/app/sort"
    Y espero a que aparezca el contenedor dinámico "#configureApplication"
