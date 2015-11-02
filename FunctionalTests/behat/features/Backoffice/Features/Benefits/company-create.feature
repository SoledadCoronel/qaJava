#language: es
Característica: Como usuario administrador del backoffice quiero crear un comercio

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y sigo "Nuevo comercio"
        Entonces espero a que aparezca el contenedor dinámico ".company-form .form-horizontal"
        
    @javascript @loadBenefitsData
    Escenario: Crear un nuevo comercio
        Dado hago click en "#active"
        Y relleno "name" con "Topper"
        Y relleno "companyName" con "Topper S.A."
        Y relleno "taxId" con "234561232"
        Y relleno "phone" con "01123235689"
        Y relleno "fax" con "0112356489"
        Y relleno "description" con "Esta es la descripción de prueba para cargar un comercio"

        Y adjunto el archivo "homerosapiens.jpg" a "file-image1"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y adjunto el archivo "homerosapiens.jpg" a "file-image2"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y adjunto el archivo "homerosapiens.jpg" a "file-image3"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y adjunto el archivo "darth-vader.jpg" a "file-logo"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y relleno "webSite" con "http://www.topper.com.ar"
        Y agrego tag "deportes" en el elemento "#tag-input"
        Y agrego tag "ropa" en el elemento "#tag-input"
        Y relleno "zipCode" con "1212"
        Y espero a que aparezca ".txt-search"
        Y relleno "txt-search" con "Alvarez Thomas 198 ciudad autónoma de buenos aires"
        Y hago click en ".search-btn"
        Y hago click en ".ms-selectable li:eq(5)"
        Y hago click en ".ms-selectable li:eq(2)"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenedor dinámico ".company-basic-information"
        Y el breadcrumb debe ser "Inicio > Beneficios Corporativos > Listado de Comercios > Topper"
        Y la URL debe seguir el patrón "/backoffice/benefits/company/\d+/view"

    @javascript @loadBenefitsData
    Escenario: Crear un comercio sin los datos obligatorios
        Dado relleno "fax" con "0112356489"
        Y adjunto el archivo "test.txt" a "file-image1"
        Y espero a que aparezca el contenido dinámico "Tipo de archivo inválido" en ".form-image1 .help-block"
        Y relleno "webSite" con "http://www.topper.com.ar"
        Y espero a que aparezca ".txt-search"
        Y relleno "txt-search" con "Alvarez Thomas 198 ciudad autónoma de buenos aires"
        Y hago click en ".search-btn"
        Y hago click en ".ms-selectable li:eq(5)"
        Y hago click en ".ms-selectable li:eq(2)"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-name .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-companyName .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-taxId .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-phone .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-description .help-block"
        Y espero a que aparezca el contenido dinámico "Este campo no puede estar vacío" en ".form-logo .help-block"
        Y debo ver "El código postal no puede estar vacío"

    @javascript @loadBenefitsData
    Escenario: Crear un comercio sin respetar el máximo de caracteres en los campos
        Dado hago click en "#active"
        Y relleno "name" con "TopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopper"
        Y relleno "companyName" con "TopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopper"
        Y relleno "taxId" con "234561232"
        Y relleno "phone" con "01123235689"
        Y relleno "fax" con "0112356489"
        Y relleno "description" con "TopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopperTopper"

        Y adjunto el archivo "homerosapiens.jpg" a "file-image1"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y adjunto el archivo "homerosapiens.jpg" a "file-image2"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y adjunto el archivo "homerosapiens.jpg" a "file-image3"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y adjunto el archivo "darth-vader.jpg" a "file-logo"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y relleno "webSite" con "http://www.topper.com.ar"
        Y espero a que aparezca ".txt-search"
        Y relleno "txt-search" con "Alavarez Thomas 198 ciudad autónoma de buenos aires"
        Y hago click en ".search-btn"
        Y relleno "zipCode" con "1212"
        Y hago click en ".ms-selectable li:eq(5)"
        Y hago click en ".ms-selectable li:eq(2)"
        Cuando presiono "Guardar"
        Entonces debo ver "El nombre del comercio no puede superar los 80 caracteres"
        Y debo ver "La razón social del comercio no puede superar los 80 caracteres"
        Y debo ver "La descripción del comercio no puede superar los 500 caracteres"
