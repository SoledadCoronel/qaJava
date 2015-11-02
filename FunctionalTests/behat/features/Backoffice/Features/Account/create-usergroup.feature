# language: es
Característica: Crear un grupo de usuarios
    Como usuario administrador del backoffice quiero crear un grupo de usuarios y un subgrupo.

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
      # El listado de plataformas aparece en pantalla
      Entonces espero a que aparezca el contenido dinámico "Plataforma 1" en ".string-cell"
      # Entro al listado de usuarios de la plataforma elegida
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
    Escenario: Crear un grupo de usuarios
      Dado sigo "Nuevo grupo de usuarios"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "Analistas"
      Cuando presiono "Guardar"
      Entonces espero a que cambie la URL
      Y debo ver "Analistas"

    @javascript @loadDataForLists
    Escenario: Crear un grupo de usuarios dejando los campos vacios
      Dado sigo "Nuevo grupo de usuarios"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Cuando presiono "Guardar"
      Y espero a que aparezca el contenido dinámico "El campo es obligatorio" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario: Crear un grupo de usuarios con el campo nombre mayor a 80 caracteres
      Dado sigo "Nuevo grupo de usuarios"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut leo nec metus dapibus tristique egestas sed enim. Vestibulum nulla libero volutpat."
      Cuando presiono "Guardar"
      Y espero a que aparezca el contenido dinámico "El campo Nombre de grupo no puede superar los 80 caracteres" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario: Crear un Sub Grupo de usuarios
      Dado sigo "Grupo de usuarios 10"
      Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
      Y espero a que aparezca el contenido dinámico "Nuevo subgrupo de usuarios" en "#subgroups"
      Y sigo "Nuevo subgrupo de usuarios"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "Analistas funcinoales"
      Cuando presiono "Guardar"
      Entonces espero a que cambie la URL
      Y espero a que aparezca el contenido dinámico "Analistas funcinoales" en ".usergroup-basic-information"

    @javascript @loadDataForLists
    Escenario: Crear un Sub Grupo de usuarios con los campos vacios
      Dado sigo "Grupo de usuarios 10"
      Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
      Y espero a que aparezca el contenido dinámico "Nuevo subgrupo de usuarios" en "#subgroups"
      Y sigo "Nuevo subgrupo de usuarios"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Cuando presiono "Guardar"
      Y espero a que aparezca el contenido dinámico "El campo es obligatorio" en ".backoffice-block"


    @javascript @loadDataForLists
    Escenario: Crear un Sub Grupo de usuarios con los campos vacios
      Dado sigo "Grupo de usuarios 10"
      Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
      Y espero a que aparezca el contenido dinámico "Nuevo subgrupo de usuarios" en "#subgroups"
      Y sigo "Nuevo subgrupo de usuarios"
      Y espero a que aparezca el contenedor dinámico ".form-horizontal"
      Y marco "active"
      Y relleno "name" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut leo nec metus dapibus tristique egestas sed enim. Vestibulum nulla libero volutpat."
      Cuando presiono "Guardar"
      Y espero a que aparezca el contenido dinámico "El campo Nombre de grupo no puede superar los 80 caracteres" en ".backoffice-block"