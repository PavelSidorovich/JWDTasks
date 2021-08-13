package com.epam.jwd.quadrangle.repository.search;

import com.epam.jwd.quadrangle.action.FigureActions;
import com.epam.jwd.quadrangle.action.FigureActions2D;
import com.epam.jwd.quadrangle.model.Figure;

public class FindByFigureSquareRange implements SearchSpecification<Figure> {

    private final double fromSquareValue;
    private final double toSquareValue;

    public FindByFigureSquareRange(double fromSquareValue, double toSquareValue) {
        this.fromSquareValue = fromSquareValue;
        this.toSquareValue = toSquareValue;
    }

    @Override
    public boolean exists(Figure figure) {
        FigureActions figureActions = new FigureActions2D(figure);
        double square = figureActions.square();
        return square >= fromSquareValue
               && square <= toSquareValue;
    }

    @Override
    public String toString() {
        return "FindByFigureSquareRange{" +
               "fromSquareValue=" + fromSquareValue +
               ", toSquareValue=" + toSquareValue +
               '}';
    }
}