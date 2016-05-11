var schemas = jjv();
schemas.addSchema('platform', 
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "A platform.",
    "properties": {
        "type": {
            "type": "string",
            "enum": ["platforms"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "name": {
                    "type": "string"
                },
                "language": {
                    "type": "string",
                    "enum": ['es', 'en', 'pt']
                },
                "subdomain": {
                    "type": "string"
                },
                "status": {
                    "type": "string"
                },
                "timezone": {
                    "type": "string"
                },
                "users-range": {
                    "type": "string"
                },
                "created-at": {
                    "type": "string"
                },
                "updated-at": {
                    "type": "string"
                }
            },
            required: ['name', 'status', 'language', 'subdomain','timezone','users-range','created-at','updated-at']
        },
        "relationships": {
            "type": "object",
            "properties": {
                "branding": {
                    "type": "object"
                }
            },
            "installations": {
                "type": "object",
                "properties": {
                    "data": {
                        "type": "array",
                        "items": {
                            "type": "object",
                            "properties": {
                                "type": {
                                    "type": "string",
                                    "enum": ["installations"]
                                },
                                "id": {
                                    "type": "string"
                                }
                            }
                        }
                    }
                }
            }
        }
    },
    "required": ["type", "id"]
});
