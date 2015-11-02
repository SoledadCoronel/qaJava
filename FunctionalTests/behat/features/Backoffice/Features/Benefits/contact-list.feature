#language: es
Característica: Como usuario administrador del backoffice quiero ver los contactos de un comercio

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y relleno "filters[name]" con "A Fondo"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "A Fondo" en ".backgrid-company-list"
        Cuando sigo "A Fondo"
        Y espero a que aparezca el contenedor dinámico ".company-view-container"
        Entonces el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > A Fondo"
        Y espero a que aparezca el contenido dinámico "A Fondo" en ".backoffice-header"
        Y sigo "Contactos"
        Y espero a que aparezca el contenido dinámico "Agustin Ponticorvo" en "#contacts"
        Y hago click en "#contacts .complete-list-link"
        Y espero a que aparezca el contenido dinámico "Listado de contactos" en ".modal-title"

    @javascript @loadBenefitsData
    Escenario: Visualizar el listado de contactos del comercio
        Dado espero a que aparezca el contenido dinámico "Agustin Ponticorvo" en ".table-contact-list"
        Y espero a que aparezca el contenido dinámico "Bruno Marinelli" en ".table-contact-list"
        Y espero a que aparezca el contenido dinámico "Claudia Andrea Assadourian" en ".table-contact-list"