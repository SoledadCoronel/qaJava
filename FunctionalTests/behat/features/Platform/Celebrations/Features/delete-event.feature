#language: es
Característica: Editar Celebraciones

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Espacio Público" en "#workspaces"
        Y sigo "Celebraciones Corporativas"
        Entonces espero a que aparezca el contenido dinámico "Celebración de prueba 11" en ".main-container"

    @javascript @loadCelebrationsData
    Escenario: Eliminar Evento
        Dado hago click en "#event-options"
        Y sigo "delete-event"
        Y espero a que aparezca el contenido dinámico "Eliminar Celebración" en "body"
        Entonces presiono "Confirmar"

    @javascript @loadCelebrationsData
    Escenario: Eliminar Evento
        Dado hago click en "#event-options"
        Y sigo "delete-event"
        Y espero a que aparezca el contenido dinámico "Eliminar Celebración" en "body"
        Y presiono "Cancelar"
        Entonces debo ver "Celebración de prueba 1"
