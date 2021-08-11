package com.epam.jwd.quadrangle.exception;

import com.epam.jwd.quadrangle.model.Point;

import java.util.List;

public class PointException extends IllegalArgumentException {
    private static final String ILLEGAL_ARGUMENT_MSG = "%s cannot be build from coordinates: %s";

    private final List<String> coordinates;

    public PointException(String s, List<String> coordinates) {
        super(s);
        this.coordinates = coordinates;
    }

    @Override
    public String getMessage() {
        return String.format(super.getMessage() + ILLEGAL_ARGUMENT_MSG, Point.class.getSimpleName(), coordinates);
    }
}