# language: es

Característica: Como usuario de la Plataforma debo poder distinguir los distintos niveles de visibilidad entre usuarios.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadStandardUserData
    Escenario: Como usuario de la Plataforma con visibilidad entre usuarios debo poder visualizar el ícono de Colaboradores y acceder a la sección correspondiente por medio del mismo.
        Dado estoy en "/"
        Cuando sigo "Colaboradores"
        Entonces debo estar en "/collaborators"
        Y espero a que aparezca el contenido dinámico "Colaboradores" en ".app-title"

    @javascript @loadPlatformStandardUserVisibilityData
    Escenario: Como usuario de la Plataforma sin visibilidad entre usuarios no debo poder visualizar el ícono de Colaboradores ni acceder a la sección correspondiente.
        Dado estoy en "/"
        Y no debo ver "Colaboradores"
        Cuando voy a "/collaborators"
        Entonces no debo ver "Colaboradores"
