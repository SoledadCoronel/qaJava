#language: es
Característica: Ver un comercio.
Como usuario administrador del backoffice quiero ver un comercio

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "45 minutos" en ".table-company-list"
        Y relleno "filters[name]" con "Panamericano Bariloche"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".backgrid-company-list"
        Cuando sigo "Panamericano Bariloche"
        Entonces espero a que aparezca el contenedor dinámico ".company-view-container"

    @javascript @loadBenefitsData
    Escenario: Visualizar los datos del comercio
        # Breadcrumb
        Dado el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Panamericano Bariloche"
        Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".backoffice-header"

        # Entidades relacionadas
        Y debo ver "Contactos (10)"
        Y debo ver "Categorías (3)"
        Y debo ver "Sucursales (27)"
        Y debo ver "Beneficios (9)"

        # Información Básica
        Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en "#name"
        Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en "#companyName"
        Y espero a que aparezca el contenido dinámico "30-58719721-5" en "#taxId"
        Y espero a que aparezca el contenido dinámico "+54 2944 409 200" en "#phone"
        Y espero a que aparezca el contenedor dinámico "#logo"
        Y espero a que aparezca el contenido dinámico "www.panamericanobariloche.com" en "#webSite"
        Y espero a que aparezca el contenido dinámico "Si" en "#active"
        Y espero a que aparezca el contenido dinámico "Esta es la descripción del comercio 5" en "#description"
        Y espero a que aparezca el contenido dinámico "San Martín" en "#street"
        Y espero a que aparezca el contenido dinámico "536" en "#streetNumber"
        Y espero a que aparezca el contenido dinámico "19" en "#floor"
        Y espero a que aparezca el contenido dinámico "8400" en "#zipCode"
        Y espero a que aparezca el contenido dinámico "Rio Negro" en "#administrative_area_level_1"
        Y espero a que aparezca el contenido dinámico "Bariloche" en "#administrative_area_level_2"
        Y espero a que aparezca el contenido dinámico "Belgrano" en "#administrative_area_level_3"
        Y espero a que aparezca el contenido dinámico "Argentina" en "#country"

        #Imagenes
        Y espero a que aparezca el contenedor dinámico "#image1"
        Y espero a que aparezca el contenedor dinámico "#image2"
        Y espero a que aparezca el contenedor dinámico "#image3"

        # Categorías
        Y espero a que aparezca el contenido dinámico "Categorías" en "#categories"
        Y espero a que aparezca el contenido dinámico "Comidas y Bebidas" en "#categories"
        Y hago click en ".category-tree li:first span"
        Y debo ver "Bares"
        Y debo ver "Delicatessen"
        Y debo ver "Delivery"

        # Contactos
        Y espero a que aparezca el contenido dinámico "Contactos" en "#contacts"
        Y espero a que aparezca el contenido dinámico "Goya" en "#contacts .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "Dirección" en "#contacts .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "Dueño" en "#contacts .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "5 resultados de 10" en "#contacts .table tfoot"
        Y espero a que aparezca el contenido dinámico "Ver todos" en "#contacts .table tfoot"

        # Beneficios
        Y espero a que aparezca el contenido dinámico "Beneficios" en "#benefits"
        Y espero a que aparezca el contenido dinámico "aute" en "#benefits .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "40%" en "#benefits .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "Vencimiento" en "#benefits .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "5 resultados de 9" en "#benefits .table tfoot"
        Y espero a que aparezca el contenido dinámico "Ver todos" en "#benefits .table tfoot"

        # Sucursales
        Y espero a que aparezca el contenido dinámico "Sucursales" en "#stores"
        Y espero a que aparezca el contenido dinámico "Balvanera" en "#stores .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "outlet" en "#stores .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "Valentin Gomez 2851, Balvanera, Autonomous City of Buenos Aires, Buenos Aires, Argentina" en "#stores .table tbody tr:first"
        Y espero a que aparezca el contenido dinámico "5 resultados de 27" en "#stores .table tfoot"
        Y espero a que aparezca el contenido dinámico "Ver todos" en "#stores .table tfoot"