package org.example.Store.Services;

import org.example.Store.Models.Variation;

import java.util.Collection;

public interface VariationService {
    public Collection<Variation> index();
    public Variation find();
    public Variation store();
}
