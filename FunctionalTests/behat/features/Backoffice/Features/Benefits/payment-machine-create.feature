#language: es
Característica:  Como usuario administrador del backoffice quiero crear o editar una terminal

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
      Entonces espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".backgrid-company-list"
      Cuando sigo "Panamericano Bariloche"
      Y espero a que aparezca el contenedor dinámico ".company-view-container"
      Entonces el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Panamericano Bariloche"
      Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".backoffice-header"
      Y sigo "Sucursales (27)"
      Y espero a que aparezca el contenido dinámico "Balvanera" en "#stores"
      Y sigo "Balvanera"
      Y espero a que aparezca el contenido dinámico "Balvanera" en ".backoffice-header"
      Y sigo "Terminales (0)"
      Dado hago click en "#paymentMachines .create-button"
      Y espero a que aparezca el contenido dinámico "Crear Terminal" en ".modal-title"


    @javascript @loadBenefitsData
    Escenario: 1. Cargar una nueva terminal para una sucursal
      Y relleno "number" con "T-0001"
      Y marco "active"
      Y relleno "operator" con "Postet"
      Y relleno "observations" con "Opera de 15 a 20"
      Cuando presiono "Guardar"
      Y espero a que aparezca el contenido dinámico "T-0001" en ".payment-machine-name"


    @javascript @loadBenefitsData
    Escenario: 2. Cargar una nueva terminal sin datos obligatorios
      Y marco "active"
      Cuando presiono "Guardar"
      Entonces debo ver "Este campo no puede estar vacío"

    @javascript @loadBenefitsData
    Escenario: 3- Cargar una terminal sin respetar el máximo de caracteres en los campos
      Y relleno "number" con "T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001T-0001"
      Y relleno "operator" con "PostetGonzalezGonzalezGonzalezGonzalezGonzalezGonzalezGonzalezGonzalezGonzalezGonzalezGonzalezGonzalezGonzalez"
      Y relleno "observations" con "Opera de 15 a 20"
      Cuando presiono "Guardar"
      Entonces debo ver "El número de terminal no puede superar los 80 caracteres"
      Y debo ver "El operador de la terminal no puede superar los 80 caracteres"