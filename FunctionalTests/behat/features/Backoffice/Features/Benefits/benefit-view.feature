
#language: es
Característica: Como usuario administrador del backoffice quiero editar un beneficio

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
        Y espero a que aparezca el contenido dinámico "aute" en "#benefits"
        Entonces el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Panamericano Bariloche"


        @javascript @loadBenefitsData
        Escenario: Ver beneficio
        Dado sigo "aute"
        Y el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Panamericano Bariloche > Listado de Beneficios > aute"
        Y espero a que aparezca el contenido dinámico "aute" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Si" en "#active"
        Y debo ver "Maria Fernandez"
        Y debo ver "Empleados"
        Y debo ver "40%"
        Y debo ver "23/04/2013"
        Y debo ver "No"
        Y debo ver "Mobile"
        Y debo ver "Tarjeta"
        Y debo ver "Tarjeta de crédito"
        Y debo ver "Tarjeta de débito"
        Y debo ver "Martes"
        Y debo ver "Miércoles"
        Y debo ver "Jueves"
        Y debo ver "Viernes"
        Y debo ver "Lorem"
        Y debo ver "Ea minim esse enim deserunt in veniam tempor nulla do aliqua ex et cupidatat ad. Ea qui ullamco dolore tempor sit sunt enim ex. Laboris sint consequat cillum ut ea qui. Dolor nulla labore eu ea consequat enim duis do aliqua excepteur. Quis ullamco amet non culpa nostrud commodo id."

        #Categorias:
        Y espero a que aparezca el contenido dinámico "Categorías" en "#categories"
        Y espero a que aparezca el contenido dinámico "Comidas y Bebidas" en "#categories"
        Y espero a que aparezca el contenido dinámico "Deportes" en "#categories"
        Y espero a que aparezca el contenido dinámico "Electrónica y Tecnología" en "#categories"
        Y espero a que aparezca el contenido dinámico "Entretenimiento" en "#categories"
        Y espero a que aparezca el contenido dinámico "Hogar y Decoración" en "#categories"

        #Adjuntos:
        Y espero a que aparezca el contenido dinámico "Documentos Internos" en "#files"
        Y espero a que aparezca el contenido dinámico "Contrato" en "#files .string-cell"

        #Adjuntos para frontend:
        Y espero a que aparezca el contenido dinámico "Anexos Públicos" en "#visible-files"
        Y espero a que aparezca el contenido dinámico "Términos y condiciones" en "#visible-files .string-cell"

        

