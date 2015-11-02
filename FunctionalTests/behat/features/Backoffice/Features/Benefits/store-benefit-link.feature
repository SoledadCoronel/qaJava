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
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".company-stores .string-cell"
        Y hago click y sigo ".company-stores a.string-cell:last"
        Y la URL debe seguir el patrón "backoffice/benefits/store/\d+/view"
        Y espero a que aparezca el contenido dinámico "Relacionar" en ".relate-button"


    @javascript @loadPaymentMachinesAndStoreBenefitData
    Escenario: Relacionar y desrelacionar beneficios a la sucursal
        Y sigo "Relacionar y desrelacionar beneficios a la sucursal"
        Y espero a que aparezca el contenido dinámico "addonna" en ".modal-body .string-cell"
        Cuando hago click en ".relate-link:first"
        Y espero a que aparezca el contenedor dinámico ".unrelate-link"
        Y hago click en ".close"
        Entonces espero a que aparezca el contenido dinámico "addonna" en ".store-benefits .string-cell"

        Y sigo "Relacionar y desrelacionar beneficios a la sucursal"
        Y espero a que aparezca el contenido dinámico "addonna" en ".modal-body .string-cell"
        Cuando hago click en ".unrelate-link"
        Y hago click en ".close"
        Entonces espero a que aparezca el contenido dinámico "El comercio no tiene beneficios relacionados" en ".store-benefits"

    @javascript @loadPaymentMachinesAndStoreBenefitData
    Escenario: Relacionar y desrelacionar todos los beneficios a la sucursal
        Y sigo "Relacionar y desrelacionar beneficios a la sucursal"
        Y espero a que aparezca el contenido dinámico "addonna" en ".modal-body .string-cell"
        Cuando hago click en ".relate-all"
        Y espero a que aparezca el contenedor dinámico ".relate-all.unrelate"
        Y hago click en ".close"
        Entonces espero a que aparezca el contenido dinámico "addonna" en ".store-benefits .string-cell"

        Y sigo "Relacionar y desrelacionar beneficios a la sucursal"
        Y espero a que aparezca el contenido dinámico "addonna" en ".modal-body .string-cell"
        Cuando hago click en ".relate-all"
        Y espero a que aparezca el contenedor dinámico ".relate-all.relate"
        Y hago click en ".close"
        Entonces espero a que aparezca el contenido dinámico "El comercio no tiene beneficios relacionados" en ".store-benefits"