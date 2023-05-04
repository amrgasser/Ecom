package org.example.Store.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Store.Models.Variation;
import org.example.Store.Repositories.VariationRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class VariationServiceImpl implements VariationService{
    private final VariationRepository variationRepository;

    @Override
    public Collection<Variation> index() {
        return null;
    }

    @Override
    public Variation find() {
        return null;
    }

    @Override
    public Variation store() {
        return null;
    }
}
