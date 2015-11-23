#language: es
Característica: Como usuario administrador del backoffice quiero crear contactos

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y relleno "filters[name]" con "Regalos al Mundo"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Regalos al Mundo" en ".backgrid-company-list"
        Cuando sigo "Regalos al Mundo"
        Y espero a que aparezca el contenedor dinámico ".company-view-container"
        Entonces el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Regalos al Mundo"
        Y espero a que aparezca el contenido dinámico "Regalos al Mundo" en ".backoffice-header"
        Y sigo "Contactos (10)"
        Y espero a que aparezca el contenido dinámico "Artemio Burga Valdivia" en "#contacts"

    @javascript @loadBenefitsData
    Escenario: Crear un nuevo contacto desde el detalle de un comercio
        Dado hago click en "#contacts .create-button"
        Entonces espero a que aparezca el contenido dinámico "Crear contacto" en ".modal-title"
        Y relleno "name" con "Daniel"
        Y relleno "surname" con "Gonzalez"
        Y relleno "document" con "30116290"
        Y selecciono "Marketing" de "area"
        Y relleno "position" con "Gerente"
        Y relleno "email" con "danielgonzalez@gmail.com"
        Y relleno "phone" con "01125236548"
        Y relleno "cellPhone" con "01125236548"
        Y relleno "observations" con "Solo contactar de 9 a 18"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Daniel Gonzalez" en "#contacts"

    @javascript @loadBenefitsData
    Escenario: Crear un nuevo contacto desde el detalle de un comercio sin datos obligatorios
        Dado hago click en "#contacts .create-button"
        Entonces espero a que aparezca el contenido dinámico "Crear contacto" en ".modal-title"
        Y relleno "document" con "30116290"
        Y relleno "position" con "Gerente"
        Y relleno "email" con "danielgonzalez@gmail.com"
        Y relleno "phone" con "01125236548"
        Y relleno "cellPhone" con "01125236548"
        Y relleno "observations" con "Solo contactar de 9 a 18"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-name .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-surname .help-block"

    @javascript @loadBenefitsData
    Escenario: Crear un nuevo contacto desde el detalle de un comercio sin respetar el máximo de caracteres
        Dado hago click en "#contacts .create-button"
        Entonces espero a que aparezca el contenido dinámico "Crear contacto" en ".modal-title"
        Y relleno "name" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis"
        Y relleno "surname" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis"
        Y relleno "observations" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis mattis placerat. Morbi sit amet porta nisl, ac laoreet sem. Fusce blandit urna sem. Vestibulum at gravida tellus, quis posuere quam. Cras ut arcu nisi. Morbi enim est, iaculis vel mi in, bibendum pellentesque leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus quis aliquet mi. Duis et felis tortor. Morbi ornare congue ligula, in dictum magna interdum ut. Nulla ligula elit, condimentum vitae dictum sit amet."
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "El nombre del contacto no puede superar los 80 caracteres" en ".form-name .help-block"
        Y espero a que aparezca el contenido dinámico "El apellido del contacto no puede superar los 80 caracteres" en ".form-surname .help-block"
        Y espero a que aparezca el contenido dinámico "El campo observaciones no puede superar los 500 caracteres" en ".form-observations .help-block"