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
    Y relleno "filters[name]" con "Computers Depot"
    Y hago click en "#name-filter-btn-submit"
    Entonces espero a que aparezca el contenido dinámico "Computers Depot" en ".backgrid-company-list"
    Cuando sigo "Computers Depot"
    Y espero a que aparezca el contenedor dinámico ".company-view-container"
    Y espero a que aparezca el contenedor dinámico ".company-stores table tr"
    Y espero a que aparezca el contenido dinámico "Computers Depot" en ".company-stores"
    Y hago click y sigo ".company-stores table a.string-cell:first"
    Y espero a que aparezca el contenido dinámico "T000-0" en "#paymentMachines"

  @javascript @loadPaymentMachinesAndStoreBenefitData
  Escenario: 1. Visualizar los datos de la terminal en un modal
    Dado sigo "T000-0"
    Entonces espero a que aparezca el contenido dinámico "T000-0" en "#number"
    Y espero a que aparezca el contenido dinámico "Si" en "#active"
    Y espero a que aparezca el contenido dinámico "Es un postnet" en "#observations"
    Y espero a que aparezca el contenido dinámico "Argentina Postnet" en "#operator"