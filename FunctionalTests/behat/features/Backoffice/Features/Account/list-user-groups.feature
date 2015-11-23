#language: es
Característica: Visualizar el listado completo de usuarios


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
        
    @javascript @loadDataForLists
    Escenario:  Visualizar el listado por defecto de todos los grupos de usuarios de la Plataforma
        Y espero a que aparezca el contenido dinámico "Listado de grupos" en ".breadcrumb"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 1" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 10" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 100" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 101" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 102" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Nuevo grupo de usuarios" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "》》" en ".backoffice-block"

    @javascript @loadDataForLists
    Escenario: 2. Visualizar un listado y filtrarlo busco por el nombre de un Grupo
        Y relleno "filters[name]" con "155"
	Y hago click en "#name-filter-btn-submit"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 155" en ".backoffice-block"
	
        # Filtro por un Grupo que no existe
	Y relleno "filters[name]" con "200"
	Y hago click en "#name-filter-btn-submit"
	Y espero a que aparezca el contenido dinámico "No hay grupos de usuarios" en ".backoffice-block"

	# Reseteo los filtros para ver el listado original
	Cuando hago click en "#name-filter-btn-close"		
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 1" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 10" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 100" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 101" en ".backoffice-block"
	Y espero a que aparezca el contenido dinámico "Grupo de usuarios 102" en ".backoffice-block"