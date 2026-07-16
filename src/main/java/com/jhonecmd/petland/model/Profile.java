package com.jhonecmd.petland.model;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Profile {
    CLIENT,
    SUPPLIER,
    SERVICE_PROVIDER
}
