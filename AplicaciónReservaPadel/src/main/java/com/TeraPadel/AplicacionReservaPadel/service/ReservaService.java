package com.TeraPadel.AplicacionReservaPadel.service;

import com.TeraPadel.AplicacionReservaPadel.dto.*;
import java.util.List;

public interface ReservaService {

    ReservaDto grabar(PeticionCreacionReserva data);

    ReservaDto actualizar(PeticionActualizacionReserva data);

    List<ReservaDto> listar();

    void eliminar(Long id);

}
