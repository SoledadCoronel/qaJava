# language: es
Característica: Visualizar el listado de espacios en los ambientes de la plataforma

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"

  @javascript @loadWorkspaceListData
  Escenario: Ver listado de espacios del ambiente default cuando me logueo en la plataforma
    Dado sigo "Inicio"
    Y debo ver "Comunidad tres tiras"
    Y debo ver "Contenidos Corporativ"
    Y debo ver "Novedades"
    Y debo ver "Galería"
    Y no debo ver "Fechas Sociales"
    Y no debo ver "Documentos Compartido"
    Cuando sigo "Ver más..."
    Entonces debo ver "Fechas Sociales"
    Y debo ver "Documentos Compartido"
    Cuando sigo "Ver menos..."
    Entonces debo ver "Contenidos Corporativ"
    Y debo ver "Novedades"
    Y debo ver "Galería"
    Y no debo ver "Fechas Sociales"
    Y no debo ver "Documentos Compartido"

  @javascript @loadWorkspaceListData
  Escenario: Ver listado de espacios de un ambiente específico
    Dado sigo "Recursos Humanos"
    Entonces debo ver "Intranet"
    Y debo ver "Contenidos 2"
    Y debo ver "Novedades 2"
    Y no debo ver "Galería 2"
    Y no debo ver "Fechas 2"
    Y no debo ver "Documentos 2"
    Y debo ver "Nuevo test"
    Y debo ver "Contenidos 3"
    Y debo ver "Novedades 3"

  @javascript @loadWorkspaceListData
  Escenario: Ver listado de espacios vacío
    Dado sigo "iRecognition"
    Entonces debo ver "No se encontraron espacios disponibles para este ambiente."
