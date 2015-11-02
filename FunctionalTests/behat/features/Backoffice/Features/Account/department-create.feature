#language: es
Característica: Visualizar la vista detallada de áreas de una plataforma

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Listar Cuentas"
        Entonces espero a que aparezca el contenido dinámico "Standard Account" en "#content"
        Y hago click en ".dropdown-toggle"
        Y sigo "Listar plataformas de Standard Account"
        Entonces espero a que aparezca el contenido dinámico "Hugo" en ".table-company-list"
        Y sigo "Hugo"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"
        Y espero a que aparezca el contenido dinámico "Administrar áreas y departamentos" en ".table-content"
        Y espero a que aparezca el contenido dinámico "John Connor" en ".backgrid-user-list"
        Y sigo "Administrar áreas y departamentos"
        Y espero a que aparezca el contenido dinámico "aliqua" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "quis" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nueva área" en ".container"
        Y sigo "aliqua"
        Y espero a que aparezca el contenido dinámico "aliqua" en "#name"
        Y espero a que aparezca el contenido dinámico "Nuevo departamento" en ".area-departments"
        Y sigo "Nuevo departamento"

    @javascript @loadStandardData
    Escenario: Visualizar el formulario de creación de un departamento
        Dado espero a que aparezca el contenido dinámico "Crear Departamento" en ".container"
        Y relleno "name" con "Departamento"
        Y tildo el checkbox "active"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "Departamento" en "#name"

    @javascript @loadStandardData
    Escenario: 2. Crear un Departamento sin datos obligatorios
        Dado espero a que aparezca el contenido dinámico "Crear Departamento" en ".container"
        Cuando presiono "Guardar"
        Entonces debo ver "Este campo no puede estar vacío"

    @javascript @loadStandardData
    Escenario: 3- Cargar un Departamento sin respetar el máximo de caracteres en los campos.
        Dado espero a que aparezca el contenido dinámico "Crear Departamento" en ".container"
        Y relleno "name" con "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
        Cuando presiono "Guardar"
        Entonces debo ver "El nombre del departamento no puede superar los 80 caracteres"