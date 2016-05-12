var schemas = jjv();
<<<<<<< HEAD
=======

// Common
schemas.addSchema('meta-pagination', 
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Meta pagination",
    "properties": {
        "pagination": {
            "type": "object",
            "properties": {
                "total-pages": {
                    "type": "number"
                },
                "total-items": {
                    "type": "number"
                }
            }
        }
    }
});

schemas.addSchema('top-links', 
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Top level links",
    "properties": {
        "first": {
            "type": "string"
        },
        "last": {
            "type": "string"
        },
        "prev": {
            "type": "string"
        },
        "next": {
            "type": "string"
        }
    }
});

// Platforms Schemas
>>>>>>> 2fe492e6958703cf82fd8918f51cc821770e0e06
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
<<<<<<< HEAD
                    "enum": ['es', 'en', 'pt']
=======
                    "enum": ['es', 'pt', 'en']
>>>>>>> 2fe492e6958703cf82fd8918f51cc821770e0e06
                },
                "subdomain": {
                    "type": "string"
                },
                "status": {
<<<<<<< HEAD
                    "type": "string"
=======
                    "type": "string",
                    "enum": ["active", "disabled"]
>>>>>>> 2fe492e6958703cf82fd8918f51cc821770e0e06
                },
                "timezone": {
                    "type": "string"
                },
                "users-range": {
<<<<<<< HEAD
                    "type": "string"
=======
                    "type": "string",
                    "enum": ["0-50", "50-100", "100-300","+300"]
>>>>>>> 2fe492e6958703cf82fd8918f51cc821770e0e06
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
<<<<<<< HEAD
=======

schemas.addSchema('branding',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "A Branding.",
    "properties": {
        "type": {
            "type": "string",
            "enum": ["brandings"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "text-color": {
                    "type": "string",
                    "maxLength": 6
                },
                "bg-color": {
                    "type": "string",
                    "maxLength": 6
                },
                "created-at": {
                    "type": "string"
                },
                "updated-at": {
                    "type": "string"
                }
            },
            "required": ["text-color", "bg-color", "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "logo": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["object"],
                            "properties": {
                                "type": {
                                    "type": "string",
                                    "enum": ["files"]
                                },
                                "id": {
                                    "type": "string"
                                }
                            }
                        }
                    }
                },
                "login-bg": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["object"],
                            "properties": {
                                "type": {
                                    "type": "string",
                                    "enum": ["files"]
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

schemas.addSchema('space',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "A space.",
    "properties": {
        "type": {
            "type": "string",
            "enum" : ["spaces"]
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
                "description": {
                    "type": "string"
                },
                "active": {
                    "type": "boolean"
                },
                "visibility": {
                    "type": "string",
                    "enum": [ "public", "private", "company" ]
                },
                "icon": {
                    "type": "string"
                },
                "social-enabled": {
                    "type": "boolean"
                },
                "users-count": {
                    "type": "number"
                },
                "groups-count": {
                    "type": "number"
                },
                "admins-count": {
                    "type": ["number"]
                },
                "membership-status": {
                    "type": "string",
                    "enum": ["admin", "member"]
                },
                "position": {
                    "type": "number"
                }
            },
            "required": ["name", "visibility", "description", "icon", "active", "visibility", "social-enabled", "users-count",
                        "groups-count", "admins-count", "membership-status", "position", "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "platform": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["platforms"]
                        },
                        "id": {
                            "type": "number"
                        }
                    }
                }
            }
        }
    }
});

// Users schemas
schemas.addSchema('user',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "A user.",
    "properties": {
        "type": {
            "type": "string",
            "enum" : ["users"]
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
                "last-name": {
                    "type": "string"
                },
                "email": {
                    "type": "string"
                },
                "status": {
                    "type": "string"
                },
                "slug": {
                    "type": "string"
                },
                "login-enabled": {
                    "type": "boolean"
                },
                "registered-date": {
                    "type": ["string"]
                },
                "created-at": {
                    "type": "string"
                },
                "updated-at": {
                    "type": "string"
                }
            },
            "required": ["name", "last-name", "email", "status", "slug", "login-enabled", "registered-date",
                        "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "role": {
                    "type": "object"
                },
                "preference": {
                    "type": "object"
                },
                "profile": {
                    "type": "object"
                },
                "access": {
                    "type": "object"
                },
                "job-title": {
                    "type": "object"
                },  
                "group-items": {
                    "type": "object"
                },
                "joined-spaces": {
                    "type": "object"
                }                          
            }
        }
    },
    "required": ["type", "id"]
});

>>>>>>> 2fe492e6958703cf82fd8918f51cc821770e0e06
