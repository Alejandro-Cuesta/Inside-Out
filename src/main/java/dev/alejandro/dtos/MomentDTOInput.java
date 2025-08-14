package dev.alejandro.dtos;

import java.time.LocalDate;

public record  MomentDTOInput(String title, String description, String emotion, LocalDate momentDate) {}

