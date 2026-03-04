package com.jordan.avefenixapp.Dto.Anotacion;

import java.time.LocalDate;

public record AnotacionResponseDTO(
    Long idAnotacion,
    String descirpcion,
    LocalDate fecha,
    Long userId
) {

}
