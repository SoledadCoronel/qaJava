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
        Cuando sigo "Agustin Ponticorvo"
        Entonces espero a que aparezca el contenedor dinámico ".modal-content"

    @javascript @loadBenefitsData
    Escenario: Visualizar los datos del  contacto
        Dado espero a que aparezca el contenido dinámico "Agustin Ponticorvo" en ".modal-body"
        Y espero a que aparezca el contenido dinámico "Administración" en ".modal-body"
        Y espero a que aparezca el contenido dinámico "31045429" en ".modal-body"
        Y espero a que aparezca el contenido dinámico "+54 11 4777 3698" en ".modal-body"
        Y espero a que aparezca el contenido dinámico "agustinponticorvo@hotmail.com" en ".modal-body"