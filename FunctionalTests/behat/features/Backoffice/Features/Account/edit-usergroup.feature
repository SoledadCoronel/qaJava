# language: es
Característica: Edicion de un grupo de usuarios y de un subgrupo.
    Como usuario administrador del backoffice quiero editar un grupo de usuarios y un subgrupo

    Antecedentes:
      Dado estoy en "/backoffice/signin"
      Y relleno "_username" con "apibackofficetester"
      Y relleno "_password" con "apitesterbackoffice"
      Y presiono "_submit"
      Y sigo "ListAccounts"
      # El listado de cuentas aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Cuenta 1" en "#content"
      # Entro al listado de plataformas de la cuenta elegida
      Y relleno "filters[name]" con "Cuenta 155"
      Y hago click en "#name-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "Cuenta 155" en "#content"
      Y hago click en ".dropdown-toggle"
      Y sigo "Listar plataformas de Cuenta 155"
      Y relleno "filters[name]" con "Plataforma 155"
      Y hago click en "#name-filter-btn-submit"
      Entonces espero a que aparezca el contenido dinámico "Plataforma 155" en ".string-cell"
      Y sigo "Plataforma 155"
      Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
      Y hago click en ".more-options"
      Y sigo "Usuarios"
      Entonces espero a que aparezca el contenido dinámico "Administrar grupos de usuarios" en ".table-content"
      Y sigo "Administrar grupos de usuarios"
      Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
      Y espero a que aparezca el contenido dinámico "Grupo de usuarios 10" en ".backoffice-block"


    @javascript @loadDataForLists
    Escenario: Editar un grupo de usuarios desde el listado de grupos
      Dado hago click y sigo ".action-icon:first"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "Grupo de usuarios editado"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Grupo de usuarios editado" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario: Editar un grupo de usuarios con el campo nombre mayor a 80 caracteres
      Dado hago click y sigo ".action-icon:first"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut leo nec metus dapibus tristique egestas sed enim. Vestibulum nulla libero volutpat."
      Cuando presiono "Guardar"
      Y espero a que aparezca el contenido dinámico "El campo Nombre de grupo no puede superar los 80 caracteres" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario: Editar un grupo de usuarios dejando los campos vacios
      Dado hago click y sigo ".action-icon:first"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y relleno "name" con ""
      Cuando presiono "Guardar"
      Y espero a que aparezca el contenido dinámico "El campo es obligatorio" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario: Editar un grupo de usuarios desde el view
      Dado hago click y sigo ".string-cell:first"
      Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
      Y espero a que aparezca el contenido dinámico "Editar" en ".backoffice-header"
      Y presiono "Editar"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "Grupo de usuarios editado"
      Cuando presiono "Guardar"
      Entonces espero a que cambie la URL
      Y debo ver "Grupo de usuarios editado"

    @javascript @loadDataForLists
    Escenario: Editar un subgrupo de usuarios desde el list
      Dado hago click y sigo ".string-cell:first"
      Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
      Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 13" en "#subgroups"
      Y hago click y sigo "#subgroups .action-icon:first"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "SubGrupo 1"
      Cuando presiono "Guardar"
      Entonces espero a que cambie la URL
      Y debo ver "SubGrupo 1"


    @javascript @loadDataForLists
    Escenario: Editar un subgrupo de usuarios desde el view
      Dado hago click y sigo ".string-cell:first"
      Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
      Y espero a que aparezca el contenido dinámico "Subgrupo de usuarios 13" en "#subgroups"
      Y hago click y sigo "#subgroups .string-cell:first"
      Y espero a que aparezca el contenido dinámico "Editar" en ".backoffice-header"
      Y presiono "Editar"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "SubGrupo 1"
      Cuando presiono "Guardar"
      Entonces espero a que cambie la URL
      Y debo ver "SubGrupo 1"
