package com.jordan.avefenixapp.Dto.Anotacion;

import java.time.LocalDate;

public record AnotacionRequestDTO(
    String descripcion,
    LocalDate fecha,
    Long userId
) {

}
