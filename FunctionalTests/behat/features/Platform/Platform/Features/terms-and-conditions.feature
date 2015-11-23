# language: es

@termsAndConditions
Característica: Visualizar los Términos y Condiciones de la plataforma.
    Como visitante o usuario de la plataforma quiero poder visualizar los Términos y Condiciones de la plataforma.

    @javascript @loadTermsAndConditionsData
    Escenario: Desde la página principal de la plataforma hago click en el link de Términos y Condiciones en caracter de visitante. Entonces debo visualizar el modal con la información correspondiente.
        Dado estoy en "/auth/signin?_lang=es"
        Cuando sigo "Términos y Condiciones"
        Y debe aparecer "#termsAndConditionsModal"
        Entonces debo ver "Lorem ipsum..."

    @javascript @loadTermsAndConditionsData
    Escenario: Desde la página principal de la plataforma hago click en el link de Términos y Condiciones en caracter de usuario. Entonces debo visualizar el modal con la información correspondiente.
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "go1234"
        Y presiono "_submit"
        Cuando sigo "Términos y Condiciones"
        Y debe aparecer "#termsAndConditionsModal"
        Entonces debo ver "Lorem ipsum..."
