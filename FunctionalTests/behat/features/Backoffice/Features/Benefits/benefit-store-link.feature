# language: es
Característica: Relacionar beneficio a una sucursal
    Como usuario administrador del backoffice quiero relacionar un beneficio a una Sucursal.

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice" 
        Cuando presiono "_submit" 
        Y sigo "Beneficios Corporativos"
        Entonces espero a que aparezca el contenido dinámico "Computers Depot" en ".template .string-cell"
        Y sigo "Computers Depot"
        Y espero a que aparezca el contenido dinámico "addonna" en ".company-benefits .string-cell"
        Y hago click y sigo ".company-benefits a.string-cell:first"
        Y la URL debe seguir el patrón "backoffice/benefits/benefit/\d+/view"
        Y espero a que aparezca el contenido dinámico "Relacionar y desrelacionar sucursales al beneficio" en ".relate-button"
    
    @javascript @loadPaymentMachinesAndStoreBenefitData
    Escenario: Relacionar y desrelacionar todos las sucursales del beneficio
        Y sigo "Relacionar y desrelacionar sucursales al beneficio"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".modal-body .string-cell"
        Cuando hago click en ".relate-all"
        Y espero a que aparezca el contenedor dinámico ".relate-all.unrelate"
        Y hago click en ".close"
        Entonces espero a que aparezca el contenido dinámico "Computers Depot" en ".benefit-stores .string-cell"

        Y sigo "Relacionar y desrelacionar sucursales al beneficio"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".modal-body .string-cell"
        Cuando hago click en ".relate-all"
        Y espero a que aparezca el contenedor dinámico ".relate-all.relate"
        Y hago click en ".close"
        Entonces espero a que aparezca el contenido dinámico "No hay sucursales relacionadas" en ".benefit-stores"