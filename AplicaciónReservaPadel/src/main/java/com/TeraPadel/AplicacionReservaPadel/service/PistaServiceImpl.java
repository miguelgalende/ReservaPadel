package com.TeraPadel.AplicacionReservaPadel.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.TeraPadel.AplicacionReservaPadel.model.Pista;
import com.TeraPadel.AplicacionReservaPadel.repository.PistaMongoRepository;
import org.webjars.NotFoundException;

@Service
public class PistaServiceImpl implements PistaService {
    private final PistaMongoRepository pistaRepo;

    public PistaServiceImpl(PistaMongoRepository pistaRepo) {
        this.pistaRepo = pistaRepo;
    }

    @Override
    public List<Pista> listarPorClub(String idClub) {
        return pistaRepo.findByIdClub(idClub);
    }

    @Override
    public Pista crear(Pista pista) {
        return pistaRepo.save(pista);
    }

    @Override
    public void eliminar(String id) {
        if (!pistaRepo.existsById(id)) {
            throw new NotFoundException("Pista no encontrada");
        }
        pistaRepo.deleteById(id);
    }

    @Override
    public Pista buscarPorId(String id) {
        return pistaRepo.findById(id)
            .orElseThrow(() -> new NotFoundException("Pista no encontrada"));
    }
}

