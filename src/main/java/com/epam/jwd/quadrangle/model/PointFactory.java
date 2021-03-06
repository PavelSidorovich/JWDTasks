package com.epam.jwd.quadrangle.model;

import java.util.List;

/**
 * The {@code PointFactory} class is a fabric designed to create {@link Point} objects
 *
 * @author Pavel Sidorovich
 * @see FigureFactory
 * @since 1.0
 */
public class PointFactory implements FigureFactory {

    public Point newInstance(double x, double y) {
        return new Point(x, y);
    }

    /**
     * Creates new instance of {@code Point} class
     *
     * @param pointList list of points
     * @return created object of {@code Point} class and {@code null} if the number of coordinates is invalid
     */
    @Override
    public Point newInstance(List<Point> pointList) {
        if (pointList.size() == FigureType.POINT.getNumberOfPoints()) {
            return new Point(pointList.get(0));
        }
        return null;
    }
}

