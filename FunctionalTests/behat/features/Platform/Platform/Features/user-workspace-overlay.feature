# language: es
Característica: Como usuario comun
Necesito poder ver todos los usuarios que participen de un espacio sin autojoin
Para poder seguirlos o dejar de seguirlos

Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "123456"
    Cuando presiono "_submit"

  @javascript @loadUsersWorkspaceData
  Escenario: Valido que se modifique el valor
    Dado sigo "Inicio"
    Y presiono "dropdown-workspace-menu"
    Y sigo "Unirme a otro espacio"
    Y espero a que aparezca el contenido dinámico "1 colaborador" en ".showCollaborators"
    Cuando presiono "Unirme"
    Entonces debe aparecer el contenido dinámico "2 colaboradores" en ".showCollaborators"

  @javascript @loadUsersWorkspaceData
  Escenario: Listo los usuarios de un espacio y sigo/dejo de seguir a un usuario
    Dado sigo "Inicio"
      Y espero a que aparezca el contenido dinámico "Nuevo espacio" en "button.btn.workspace-create"
      Y presiono "dropdown-workspace-menu"
      Y sigo "Unirme a otro espacio"
      Y espero a que aparezca el contenido dinámico "1 colaborador" en ".showCollaborators"
      Y sigo "1 colaborador"
      Y espero a que aparezca el contenido dinámico "Tyrion Lannister" en ".infinite-scroll-list"
    Cuando presiono "Seguir"
      Y sigo "Tyrion Lannister"
    Entonces debe aparecer el contenido dinámico "Dejar de seguir" en ".profile-action"

    Dado sigo "Inicio"
      Y espero a que aparezca el contenido dinámico "Nuevo espacio" en "button.btn.workspace-create"
      Y presiono "dropdown-workspace-menu"
      Y sigo "Unirme a otro espacio"
      Y espero a que aparezca el contenido dinámico "1 colaborador" en ".showCollaborators"
      Y sigo "1 colaborador"
      Y espero a que aparezca el contenido dinámico "Tyrion Lannister" en ".infinite-scroll-list"
      Y espero a que aparezca el contenido dinámico "Dejar de seguir" en ".follow-box"
    Cuando presiono "Dejar de seguir"
      Y sigo "Tyrion Lannister"
    Entonces no debo ver "Dejar de seguir"
      Y debo ver "Seguir"

  @javascript @loadUsersWorkspaceData
  Escenario: Listo los usuarios y escroleo
    Dado sigo "Inicio"
      Y presiono "dropdown-workspace-menu"
      Y sigo "Unirme a otro espacio"
      Y espero a que aparezca el contenido dinámico "30 colaboradores" en ".showCollaborators"
      Y sigo "30 colaboradores"
      Y espero a que aparezca el contenido dinámico "Test1 Test" en ".infinite-scroll-list"
    Cuando escroleo ".modal-body" hacia abajo 400 px
    Entonces debe aparecer el contenido dinámico "Test29 Test" en ".infinite-scroll-list"