#language: es
Característica: Como usuario administrador del backoffice quiero crear un adjunto para un beneficio

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y relleno "filters[name]" con "Panamericano Bariloche"
        Y hago click en "#name-filter-btn-submit"
        Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".backgrid-company-list"
        Y sigo "Panamericano Bariloche"
        Y espero a que aparezca el contenido dinámico "aute" en "#benefits"
        Y el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Panamericano Bariloche"
        Cuando sigo "aute"
        Entonces el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Panamericano Bariloche > Listado de Beneficios > aute"
        Y espero a que aparezca el contenido dinámico "aute" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Contrato" en "#files"

    @javascript @loadBenefitsData
    Escenario: Crear un adjunto desde la vista de un beneficio
        Dado hago click en "#files .create-button"
        Y espero a que aparezca el contenido dinámico "Crear Adjunto" en ".modal-title"
        Y adjunto el archivo "test.txt" a "file-url"
        Y relleno "name" con "Nuevo Contrato"
        Y relleno "description" con "Este es un nuevo contrato"

        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Nuevo Contrato" en "#files"

    @javascript @loadBenefitsData
    Escenario: Crear adjunto desde el detalle de un beneficio sin datos obligatorios
        Dado hago click en "#files .create-button"
        Entonces espero a que aparezca el contenido dinámico "Crear Adjunto" en ".modal-title"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Debe subir un archivo" en ".form-url .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-name .help-block"

    @javascript @loadBenefitsData
    Escenario: Crear un adjunto desde el detalle de un beneficio sin respetar el máximo de caracteres
        Dado hago click en "#files .create-button"
        Entonces espero a que aparezca el contenido dinámico "Crear Adjunto" en ".modal-title"
        Y relleno "name" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis"
        Y relleno "description" con "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis mattis placerat. Morbi sit amet porta nisl, ac laoreet sem. Fusce blandit urna sem. Vestibulum at gravida tellus, quis posuere quam. Cras ut arcu nisi. Morbi enim est, iaculis vel mi in, bibendum pellentesque leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus quis aliquet mi. Duis et felis tortor. Morbi ornare congue ligula, in dictum magna interdum ut. Nulla ligula elit, condimentum vitae dictum sit amet.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis mattis placerat. Morbi sit amet porta nisl, ac laoreet sem. Fusce blandit urna sem. Vestibulum at gravida tellus, quis posuere quam. Cras ut arcu nisi. Morbi enim est, iaculis vel mi in, bibendum pellentesque leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus quis aliquet mi. Duis et felis tortor. Morbi ornare congue ligula, in dictum magna interdum ut. Nulla ligula elit, condimentum vitae dictum sit amet.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis mattis placerat. Morbi sit amet porta nisl, ac laoreet sem. Fusce blandit urna sem. Vestibulum at gravida tellus, quis posuere quam. Cras ut arcu nisi. Morbi enim est, iaculis vel mi in, bibendum pellentesque leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus quis aliquet mi. Duis et felis tortor. Morbi ornare congue ligula, in dictum magna interdum ut. Nulla ligula elit, condimentum vitae dictum sit amet.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis mattis placerat. Morbi sit amet porta nisl, ac laoreet sem. Fusce blandit urna sem. Vestibulum at gravida tellus, quis posuere quam. Cras ut arcu nisi. Morbi enim est, iaculis vel mi in, bibendum pellentesque leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus quis aliquet mi. Duis et felis tortor. Morbi ornare congue ligula, in dictum magna interdum ut. Nulla ligula elit, condimentum vitae dictum sit amet.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis mattis placerat. Morbi sit amet porta nisl, ac laoreet sem. Fusce blandit urna sem. Vestibulum at gravida tellus, quis posuere quam. Cras ut arcu nisi. Morbi enim est, iaculis vel mi in, bibendum pellentesque leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus quis aliquet mi. Duis et felis tortor. Morbi ornare congue ligula, in dictum magna interdum ut. Nulla ligula elit, condimentum vitae dictum sit amet.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum a risus sed turpis mattis placerat. Morbi sit amet porta nisl, ac laoreet sem. Fusce blandit urna sem. Vestibulum at gravida tellus, quis posuere quam. Cras ut arcu nisi. Morbi enim est, iaculis vel mi in, bibendum pellentesque leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus quis aliquet mi. Duis et felis tortor. Morbi ornare congue ligula, in dictum magna interdum ut. Nulla ligula elit, condimentum vitae dictum sit amet."
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "El nombre no puede superar los 80 caracteres" en ".form-name .help-block"
        Y espero a que aparezca el contenido dinámico "La descripción no puede superar los 3000 caracteres" en ".form-description .help-block"