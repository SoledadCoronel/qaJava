# language: es

@helpCenterMessage
Característica: Enviar un mensaje desde el formulario de Centro de Ayuda.
    Como visitante o usuario de la plataforma quiero poder enviar un mensaje desde el formulario de Centro de Ayuda.

    @javascript @loadHelpCenterData
    Escenario: Desde la página principal de la plataforma ingreso a Centro de Ayuda en caracter de visitante y completo erróneamente el formulario. Entonces debo ver los correspondientes mensajes de error.
        Dado estoy en "/auth/signin?_lang=es"
        Y sigo "Centro de Ayuda"
        Y debo estar en "/help-center/"
        Y relleno con "1234" a "name"
        Y relleno con "4321" a "surname"
        Y relleno con "@" a "email"
        Y relleno con "1234" a "document"
        Y relleno con "abcd" a "phone"
        Y relleno con "" a "issue"
        Y relleno con "" a "description"
        Cuando presiono "submit"
        Entonces debo ver "El nombre ingresado es inválido."
        Y debo ver "El apellido ingresado es inválido."
        Y debo ver "El correo electrónico ingresado es inválido."
        Y debo ver "El documento ingresado es inválido."
        Y debo ver "El teléfono ingresado es inválido."
        Y debo ver "El asunto es obligatorio."
        Y debo ver "La descripción es obligatoria."
        Y debo ver "Campo obligatorio"

    @javascript @loadHelpCenterData
    Escenario: Desde la página principal de la plataforma ingreso a Centro de Ayuda en caracter de visitante y completo correctamente el formulario. Entonces debo ver un mensaje de confirmación.
        Dado estoy en "/auth/signin?_lang=es"
        Y sigo "Centro de Ayuda"
        Y debo estar en "/help-center/"
        Y relleno con "John" a "name"
        Y relleno con "Connor" a "surname"
        Y relleno con "john.connor@gointegro.com" a "email"
        Y relleno con "K682149" a "document"
        Y relleno con "1147582159" a "phone"
        Y selecciono "Consulta" de "reason"
        Y selecciono "Plataforma" de "issueType"
        Y relleno con "Asunto" a "issue"
        Y relleno con "Descripción" a "description"
        Cuando presiono "submit"
        Entonces espero a que aparezca el contenido dinámico "Su mensaje fue enviado exitosamente." en "#message"

    @javascript @loadHelpCenterData
    Escenario: Desde la página principal de la plataforma ingreso a Centro de Ayuda en caracter de usuario y completo erróneamente el formulario. Entonces debo ver los correspondientes mensajes de error.
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "go1234"
        Y presiono "_submit"
        Y sigo "Centro de Ayuda"
        Y debo estar en "/help-center/"
        Y relleno con "abcd" a "phone"
        Y relleno con "" a "issue"
        Y relleno con "" a "description"
        Cuando presiono "submit"
        Entonces debo ver "El teléfono ingresado es inválido."
        Y debo ver "El asunto es obligatorio."
        Y debo ver "La descripción es obligatoria."
        Y debo ver "Campo obligatorio"

    @javascript @loadHelpCenterData
    Escenario: Desde la página principal de la plataforma ingreso a Centro de Ayuda en caracter de usuario y completo correctamente el formulario. Entonces debo ver un mensaje de confirmación.
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "go1234"
        Y presiono "_submit"
        Y sigo "Centro de Ayuda"
        Y debo estar en "/help-center/"
        Y relleno con "1147582159" a "phone"
        Y selecciono "Inconveniente" de "reason"
        Y selecciono "Descuento" de "issueType"
        Y relleno con "Asunto" a "issue"
        Y relleno con "test@gointegro.com" a "email"
        Y relleno con "Descripción" a "description"
        Cuando presiono "submit"
        Entonces espero a que aparezca el contenido dinámico "Su mensaje fue enviado exitosamente." en "#message"
