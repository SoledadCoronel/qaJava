# language: es
Característica: Visualizacion de detalle de una sucursal 
  Como usuario quiero ver la informacion de una sucursal asociada a un comercio 



    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice" 
        Cuando presiono "_submit" 
        Y sigo "Beneficios Corporativos"
        Entonces espero a que aparezca el contenido dinámico "Computers Depot" en ".template .string-cell"


    @javascript @loadPaymentMachinesAndStoreBenefitData
    Escenario: Visualizar los datos de la sucursal
    Dado sigo "Computers Depot"
    Y espero a que aparezca el contenido dinámico "Computers Depot" en ".company-stores .template .string-cell"
    Y hago click y sigo ".company-stores a.string-cell:first"
    Y espero a que aparezca el contenido dinámico "addonna" en ".string-cell"
    Y la URL debe seguir el patrón "backoffice/benefits/store/\d+/view"
    Y debo ver "Computers Depot" 
    #chequeo el breadcum
    Y el breadcrumb debe ser "Inicio > Beneficios Corporativos > Listado de Comercios > Computers Depot > Sucursales > Computers Depot"
    Y debo ver "Inicio"
    Y debo ver "Beneficios Corporativos"
    Y debo ver "Listado de Comercios"
    Y debo ver "Computers Depot"
    #chequeo los datos del store
    Y debo ver "Si"
    Y debo ver "Local"
    Y debo ver "27-17142787-3"
    Y debo ver "Rivadavia"
    Y debo ver "6897"
    Y debo ver "Argentina"
    Y debo ver "Flores"
    Y debo ver "sebastian@solme.info"
    Y debo ver "C1406GLL"
    Y espero a que aparezca el contenido dinámico "addonna" en ".string-cell"
    Y espero a que aparezca el contenido dinámico "T000-0" en ".string-cell"
    Y espero a que aparezca el contenido dinámico "T000-1" en ".string-cell"
    Y espero a que aparezca el contenido dinámico "T000-10" en ".string-cell"
    Y espero a que aparezca el contenido dinámico "T000-2" en ".string-cell"
    Y espero a que aparezca el contenido dinámico "T000-3" en ".string-cell"


    @javascript @loadPaymentMachinesAndStoreBenefitData
    Escenario: Visualizar los datos de la sucursal con Area
    Dado hago click en "li #page-2"
    Y espero a que aparezca el contenido dinámico "Gran Hotel Paraná" en ".template .string-cell"
    Y sigo "Gran Hotel Paraná"
    Y espero a que aparezca el contenido dinámico "San Borja" en ".company-stores .template .string-cell"
    Y hago click y sigo ".company-stores .template .string-cell:eq(0)"
    Y espero a que aparezca el contenido dinámico "Lomas de Zamora" en ".item-collapse"
    Y la URL debe seguir el patrón "backoffice/benefits/store/\d+/view"
    Entonces debo ver "San Borja" 
    #chequeo el breadcum
    Y debo ver "Inicio"
    Y debo ver "Beneficios Corporativos"
    Y debo ver "Listado de Comercios"
    Y debo ver "Gran Hotel Paraná"
    Y debo ver "San Borja"
    #chequeo los datos del store
    Y debo ver "Si"
    Y debo ver "Telefónica"
    Y debo ver "01 372 3458"
    Y debo ver "30-52960811-6"
    Y debo ver "Argentina"
    Y debo ver "djathbisuteria@hotmail.com"
    Y debo ver "Lomas de Zamora"
    Y debo ver "Buenos Aires"
    Y debo ver "Argentina"
    Y espero a que aparezca el contenido dinámico "commodo" en ".table td"
