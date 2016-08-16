var schemas = jjv();

// Custom validations
schemas.addType('date', function (v) {
    var re = /^([\+-]?\d{4}(?!\d{2}\b))((-?)((0[1-9]|1[0-2])(\3([12]\d|0[1-9]|3[01]))?|W([0-4]\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\d|[12]\d{2}|3([0-5]\d|6[1-6])))([T\s]((([01]\d|2[0-3])((:?)[0-5]\d)?|24\:?00)([\.,]\d+(?!:))?)?(\17[0-5]\d([\.,]\d+)?)?([zZ]|([\+-])([01]\d|2[0-3]):?([0-5]\d)?)?)?)?$/;
    
    if (v) {
        return re.test(v);
    }
    
    return true;
});

schemas.addType('email', function(v) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (v) {
        return re.test(v);
    }

    return true;
});

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
schemas.addSchema('platform', 
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Platform",
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
                    "enum": ['es', 'pt', 'en']
                },
                "subdomain": {
                    "type": "string"
                },
                "status": {
                    "type": "string",
                    "enum": ["active", "disabled"]
                },
                "timezone": {
                    "type": "string"
                },
                "users-range": {
                    "type": "string",
                    "enum": ["0-50", "50-100", "100-300","+300"]
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
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

schemas.addSchema('branding',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Branding",
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
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
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
    "description": "Space",
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
    "description": "User",
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
                    "type": "email"
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
                    "type": "date"
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
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

schemas.addSchema('profile',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Profile",
    "properties": {
        "type": {
            "type": "string",
            "enum":["profiles"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "employee-id" : {
                    "type": ["string", null]
                },
                "job-phone" : {
                    "type": ["string", null]
                },
                "job-cellphone" : {
                    "type": ["string", null]
                },
                "personal-phone" : {
                    "type": ["string", null]
                },
                "personal-cellphone" : {
                    "type": ["string", null]
                },
                "linkedin" : {
                   "type": ["string", null]
                },
                "facebook" : {
                   "type": ["string",null]
                },
                "twitter" : {
                    "type": ["string", null]
                },
                "admission-date" : {
                    "type": ["date", null]
                },
                "job-address" : {
                    "type": ["string", null]
                },
                "personal-address" : {
                    "type": ["string", null]
                },
                "document-type" : {
                    "type": ["string", null],
                    "enum" : ["DNI", "CPF", "RUT", null]
                },
                "document" : {
                    "type": "string"
                },
                "gender" : {
                    "type": ["string", null],
                    "enum" : ["male", "female", null]
                },
                "birthdate" : {
                    "type": ["date", null]
                },
                "personal-email" : {
                    "type": ["email", null]
                },
                "marital-status" : {
                    "type": ["string", null],
                    "enum": ["single", "married", "divorced", "widowed", null]
                },
                "job-type" : {
                    "type": ["string", null],
                    "enum": ["full-time", "part-time", "teleworking", null]
                }
            }
        },
        "relationships": {
            "type": "object",
            "properties": {
                "user": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["users"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }
                },
                "supervisor": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["users"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }
                },
                "image": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["files"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }
                }
            }
        }
    },
    "required": ["type", "id"]
});

schemas.addSchema('role',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Role",
    "properties": {
        "type": {
            "type": "string",
            "enum" : ["roles"]
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
                "status": {
                    "type": "string"
                },
                "is-admin": {
                    "type": "boolean"
                },
                "is-default": {
                    "type": "boolean"
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
                }
            },
            required: ["name", "status", "is-admin", "is-default", "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "access": {
                    "type": "object"
                }
            }
        }        
    },
    "required": ["type", "id"]
});

schemas.addSchema('access', 
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Access",
    "properties": {
        "type": {
            "type" : "string",
            "enum" : ["access"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "description": {
                    "type": "string"
                },
                "key": {
                    "type": "string"
                },
                "namespace": {
                    "type": "string"
                }
            },
            required: ["description", "key", "namespace"]
        }
    },
    "required": ["type", "id"]
});

schemas.addSchema('group-item',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Group items",
    "properties": {
        "type": {
            "type" : "string",
            "enum" : ["group-items"]
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
                "position": {
                    "type": ["number", null]
                }
            },
            required: ["name"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "group": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["groups"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }                    
                }
            },
            "required": ["group"]
        }
    },
    "required": ["type", "id"]
});

schemas.addSchema('group',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Groups",
    "properties": {
        "type": {
            "type" : "string",
            "enum" : ["groups"]
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
                "position": {
                    "type": ["number", null]
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
                }
            },
            required: ["name"]
        }
    },
    "required": ["type", "id"]
});

schemas.addSchema('job-title',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Job Title",
    "properties": {
        "type": {
            "type" : "string",
            "enum" : ["job-titles"]
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
                "position": {
                    "type": ["number", null]
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
                }                
            },
            required: ["name", "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "tier": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["tiers"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }                    
                }
            },
            required: ["tier"]
        }        
    },
    "required": ["type", "id"]
});

schemas.addSchema('tier',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Tier",
    "properties": {
        "type": {
            "type" : "string",
            "enum" : ["tiers"]
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
                "position": {
                    "type": ["number", null]
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
                }                
            },
            required: ["name", "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "job-titles": {
                    "type": "object"                   
                }
            },
            required: ["job-titles"]
        }        
    },
    "required": ["type", "id"]
});

schemas.addSchema('user-preference',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "User Preference",
    "properties": {
        "type": {
            "type": "string",
            "enum":["user-preferences"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "timezone": {
                    "type": "string"
                },
                "language": {
                    "type": "string",
                    "enum": ["en", "es", "pt"]
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
                }                
            },
            required: ["timezone", "language", "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "user": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["users"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }
                }
            },
            "required": ["user"]
        }        
    },
    required: ["type", "id"]
});

schemas.addSchema('invitation',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Invitation",
    "properties": {
        "type": {
            "type": "string",
            "enum" : ["invitations"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "status": {
                    "type": "string",
                    "enum" : ["pending", "complete"]
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
                }                
            },
            required: ["status", "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "user": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["users"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }
                }
            },
            "required": ["user"]
        }
    },
    required: ["type", "id"]
});

schemas.addSchema('registration-domain',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Registration Domain",
    "properties": {
        "type": {
            "type": "string",
            "enum" : ["registration-domains"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "domain": {
                    "type": "string"
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
                }                
            },
            required: ["domain", "created-at", "updated-at"]
        }
    },
    required: ["type", "id"]
});

schemas.addSchema('registration',
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Registration",
    "properties": {
        "type": {
            "type": "string",
            "enum" : ["registrations"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "status": {
                    "type": "string",
                    "enum" : ["pending", "processing", "complete"]
                },
                "first-name": {
                    "type": "string"
                },
                "last-name": {
                    "type": "string"
                },
                "email": {
                    "type": "email"
                },
                "created-at": {
                    "type": "date"
                },
                "updated-at": {
                    "type": "date"
                }                
            },
            required: ["status", "first-name", "last-name", "email", "created-at", "updated-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "user": {
                    "type": "object"
                }
            },
            required: ["user"]
        }
    },
    "required": ["type", "id"]
});

// Files schemas
schemas.addSchema('file',
{
  "$schema": "http://json-schema.org/schema",
  "type": "object",
  "description": "A file",
  "properties": {
    "type": {
      "type" : "string",
      "enum" : ["files"]
    },
    "id": {
      "type": "string",
      "maxLength": 40
    },
    "attributes": {
      "type": "object",
      "properties": {
        "name": {
          "type": "string"
        },
        "mime": {
          "type": "string"
        },
        "url": {
          "type": "string"
        },
        "prefix": {
          "type": "string",
          "enum": ["profile", "social", "branding", "application", "article"]
        },
        "size": {
          "type": "string"
        },
        "created-at": {
          "type": "date"
        }
      },
     "required": ["name", "mime", "url", "prefix", "size", "created-at"]
    }
  },
  "required": ["type", "id"]
});

// Social schemas

schemas.addSchema('feed-item', 
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Feed item",
    "properties": {
        "type": {
            "type": "string",
            "enum": ["feed-items"]    
        },
        "id": {
            "type": "string"
        },
        "relationships": {
            "type": "object",
            "properties": {
                "item": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["object"],
                            "properties": {
                                "type": {
                                    "type": "string",
                                    "enum": ["posts", "shares"]
                                },
                                "id": {
                                    "type": "string"
                                }
                            }
                        }
                    },
                    "required": ["data"]
                }
            }
        }
    },
    required: ["type", "id"]
});

schemas.addSchema('post', 
{
    "$schema": "http://json-schema.org/schema",
    "type": "object",
    "description": "Post",
    "properties": {
        "type": {
            "type": "string",
            "enum": ["posts"]
        },
        "id": {
            "type": "string"
        },
        "attributes": {
            "type": "object",
            "properties": {
                "content": {
                    "type": ["string", null]
                },
                "length": {
                    "type": ["number", null]
                },
                "count-likes": {
                    "type": "number"
                },
                "count-comments": {
                    "type": "number"
                },
                "created-at": {
                    "type": "date"
                },
                "last-activity": {
                    "type": ["date", null]
                }

            },
            required: ["count-likes", "count-comments", "created-at"]
        },
        "relationships": {
            "type": "object",
            "properties": {
                "target": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["object"],
                            "properties": {
                                "type": {
                                    "type": "string",
                                    "enum": ["spaces", "users"]
                                },
                                "id": {
                                    "type": "string"
                                }
                            }
                        }
                    }
                },
                "mentions": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": "array",
                            "items": {
                                "type": "object",
                                "properties": {
                                    "type": {
                                        "type": "string",
                                        "enum": ["users"]
                                    },
                                    "id": {
                                        "type": "string"
                                    }
                                }
                            }
                        }
                    }
                },
                "author": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["object"],
                            "properties": {
                                "type": {
                                    "type": "string",
                                    "enum": ["users"]
                                },
                                "id": {
                                    "type": "string"
                                }
                            }
                        }
                    },
                    "required": ["data"]
                },
                "attachments": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": "array",
                            "items": {
                                "type": "object",
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
                },
                "image": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["files"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }
                },
                "hyperlink": {
                    "type": "object",
                    "properties": {
                        "type": {
                            "type": "string",
                            "enum" : ["hyperlinks"]
                        },
                        "id": {
                            "type": "string"
                        }
                    }
                }
            },
            required: ["author"]
        }
    },
    required: ["type", "id"]
});

schemas.addSchema('like',
{
  "$schema": "http://json-schema.org/schema",
  "type": "object",
  "description": "likes",
  "properties": {
    "type": {
      "type" : "string",
      "enum" : ["likes"]
    },
    "id": {
      "type": "string"
    },
    "attributes": {
      "type": "object",
      "properties": {
        "created-at": {
            "type": "date"
        }
      },
      required: ["created-at"]
    },
    "relationships": {
      "type": "object",
      "properties": {
        "subject": {
          "type": "object",
          "properties": {
            "data": {
              "type": ["object"],
              "properties": {
                "type": {
                  "type": "string",
                  "enum": ["posts", "shares", "comments"]
                },
                "id": {
                  "type": "string"
                }
              }
            }
          },
          "required": ["data"]
        },
        "author": {
          "type": "object",
          "properties": {
            "data": {
              "type": ["object"],
              "properties": {
                "type": {
                  "type": "string",
                  "enum": ["users"]
                },
                "id": {
                  "type": "string"
                }
              }
            }
          },
          "required": ["data"]
        }
      }
    }
  },
  required: ["type", "id"]
});

schemas.addSchema('hyperlink',
{
  "$schema": "http://json-schema.org/schema",
  "type": "object",
  "description": "Hyperlink",
  "properties": {
    "type": {
      "type" : "string",
      "enum" : ["hyperlinks"]
    },
    "id": {
      "type": "string"
    },
    "attributes": {
      "type": "object",
      "properties": {
        "host": {
          "type": "string"
        },
        "path": {
          "type": "string"
        },
        "title": {
          "type": "string"
        },
        "external": {
          "type": "boolean"
        },
        "favicon": {
            "type": ["string", null]
        },
        "created-at": {
            "type": "date"
        }
      }
    },
    "relationships": {
      "type": "object",
      "properties": {
        "image": {
          "type": "object",
          "properties": {
            "data": {
              "type": ["object", null],
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
  }
});

schemas.addSchema('comment',
{
  "$schema": "http://json-schema.org/schema",
  "type": "object",
  "description": "Comment",
  "properties": {
    "type": {
      "type" : "string",
      "enum" : ["comments"]
    },
    "id": {
      "type": "string"
    },
    "attributes": {
      "type": "object",
      "properties": {
        "comment": {
          "type": "string"
        },
        "count-likes": {
          "type": "number"
        },
        "count-replies": {
          "type": "string"
        },
        "created-at": {
          "type": "date"
        },
        "last-activity": {
            "type": ["date", null]
        }
      }
    },
    "relationships": {
            "type": "object",
            "properties": {
                "subject": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["object"],
                            "properties": {
                                "type": {
                                    "type": "string",
                                    "enum": ["posts", "shares"]
                                },
                                "id": {
                                    "type": "string"
                                }
                            }
                        }
                    }
                },
                "mentions": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": "array",
                            "items": {
                                "type": "object",
                                "properties": {
                                    "type": {
                                        "type": "string",
                                        "enum": ["users"]
                                    },
                                    "id": {
                                        "type": "string"
                                    }
                                }
                            }
                        }
                    }
                },
                "author": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["object"],
                            "properties": {
                                "type": {
                                    "type": "string",
                                    "enum": ["users"]
                                },
                                "id": {
                                    "type": "string"
                                }
                            }
                        }
                    },
                    "required": ["data"]
                },
                "reply-to": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["object", null]
                        }
                    }
                },
                "featured-likes": {
                    "type": "object",
                    "properties": {
                        "data": {
                            "type": ["array"]
                        }
                    }
                }
            },
            required: ["author", "subject"]
        }
  }
});
