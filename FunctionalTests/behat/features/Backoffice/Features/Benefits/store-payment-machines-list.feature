# language: es

Característica: Como usuario administrador del backoffice quiero poder ver las terminales asociadas a una sucursal.

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".backgrid-company-list"
        Y sigo "Computers Depot"
        Y el breadcrumb debe ser "Inicio > Beneficios Corporativos > Listado de Comercios > Computers Depot"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".company-stores"
        Cuando hago click en el índice "0" del elemento que contiene el texto "Computers Depot"
        Entonces espero a que aparezca el contenedor dinámico ".store-benefits"
        Y el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Computers Depot > Sucursales > Computers Depot"

    @javascript @loadPaymentMachinesAndStoreBenefitData
    Escenario: Visualizar el listado por defecto de las terminales de una sucursal.
        Dado espero a que aparezca el contenedor dinámico ".store-paymentmachines"
        Y espero a que aparezca el contenido dinámico "T000-0" en ".store-paymentmachines"
        Y hago click en ".store-paymentmachines .complete-list-link"
        Entonces espero a que aparezca el contenido dinámico "Listado de Terminales" en ".modal-content"
        #Y espero a que aparezca el contenido dinámico "Nueva Terminal" en ".container"
        Y espero a que aparezca el contenido dinámico "T000-0" en ".table-paymentmachine-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "T000-3" en ".table-paymentmachine-list tbody tr:last"

    @javascript @loadPaymentMachinesAndStoreBenefitData
    Escenario: Visualizar y ordenar el listado de las terminales de una sucursal.
        Dado espero a que aparezca el contenedor dinámico ".store-paymentmachines"
        Y espero a que aparezca el contenido dinámico "T000-0" en ".store-paymentmachines"
        Y hago click en ".store-paymentmachines .complete-list-link"
        Entonces espero a que aparezca el contenido dinámico "Listado de Terminales" en ".modal-content"
        Y espero a que aparezca el contenido dinámico "T000-0" en ".table-paymentmachine-list tbody tr:first"
        Y hago click en ".modal-content #head-number"
        Y espero a que aparezca el contenido dinámico "T000-0" en ".table-paymentmachine-list tbody tr:first"
        Cuando hago click en ".modal-content #head-number"
        Y espero a que aparezca el contenido dinámico "T000-9" en ".table-paymentmachine-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "T000-5" en ".table-paymentmachine-list tbody tr:last"

    @javascript @loadPaymentMachinesAndStoreBenefitData
    Escenario: Visualizar el listado de terminales y navegar entre sus páginas haciendo uso de todos los controles del paginador.
        Dado espero a que aparezca el contenedor dinámico ".store-paymentmachines"
        Y espero a que aparezca el contenido dinámico "T000-0" en ".store-paymentmachines"
        Y hago click en ".store-paymentmachines .complete-list-link"
        Entonces espero a que aparezca el contenido dinámico "Listado de Terminales" en ".modal-content"
        Y espero a que aparezca el contenido dinámico "T000-0" en ".table-paymentmachine-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "T000-3" en ".table-paymentmachine-list tbody tr:last"
        Cuando hago click en "#page-2"
        Y espero a que aparezca el contenido dinámico "T000-4" en ".table-paymentmachine-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "T000-8" en ".table-paymentmachine-list tbody tr:last"
        Y hago click en "#page-first"
        Y espero a que aparezca el contenido dinámico "T000-0" en ".table-paymentmachine-list tbody tr:first"
        Y hago click en "#page-next"
        Y espero a que aparezca el contenido dinámico "T000-4" en ".table-paymentmachine-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "T000-8" en ".table-paymentmachine-list tbody tr:last"
