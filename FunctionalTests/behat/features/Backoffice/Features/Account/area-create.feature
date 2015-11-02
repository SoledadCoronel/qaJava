# language: es
Característica: Creacion de cuentas
Como usuario de backoffice quiero poder crear area

Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "Listar Cuentas"
    Entonces espero a que aparezca el contenido dinámico "Standard Account" en "#content"
    Y hago click en ".dropdown-toggle"
    Y sigo "Listar plataformas de Standard Account"
    Entonces espero a que aparezca el contenido dinámico "Hugo" en ".table-content"
    Y sigo "Hugo"
    Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
    Y hago click en ".more-options"
    Y sigo "Usuarios"
    Y espero a que aparezca el contenido dinámico "Administrar áreas y departamentos" en ".table-content"
    Y sigo "Administrar áreas y departamentos"
    Y sigo "Nueva área"

@javascript @loadStandardData
Escenario: 1. Crear Area
    Dado espero a que aparezca el contenido dinámico "Crear área" en ".container"
    Y relleno "name" con "Area"
    Y tildo el checkbox "active"
    Cuando presiono "Guardar"
    Y sigo "Listado de áreas"
    Entonces debe aparecer el contenido dinámico "Area" en ".area-listing"

@javascript @loadStandardData
Escenario: 2. Crear un Area sin datos obligatorios
    Dado espero a que aparezca el contenido dinámico "Crear área" en ".container"
    Cuando presiono "Guardar"
    Entonces debo ver "Este campo no puede estar vacío"

@javascript @loadStandardData
Escenario: 3- Cargar un Area sin respetar el máximo de caracteres en los campos.
    Dado espero a que aparezca el contenido dinámico "Crear área" en ".container"
    Y relleno "name" con "TecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnologíaTecnología"
    Cuando presiono "Guardar"
    Entonces debo ver "El nombre del area no puede superar los 80 caracteres"