package com.epam.jwd.figures.model.point;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.FigureTypes;

import java.util.Objects;

/**
 * This class is immutable
 */
public class Point implements Figure {
    public static final FigureTypes FIGURE_TYPE = FigureTypes.POINT;

    private final double x;
    private final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int getNumberOfPoints() {
        return FIGURE_TYPE.getNumberOfPoints();
    }

    @Override
    public String toString() {
        return "Point{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
