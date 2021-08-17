package com.epam.jwd.quadrangle.repository.sort;

import com.epam.jwd.quadrangle.model.Figure;
import com.epam.jwd.quadrangle.model.FigureType;
import com.epam.jwd.quadrangle.model.PointFactory;
import com.epam.jwd.quadrangle.reader.FigureReader;
import com.epam.jwd.quadrangle.repository.FigureRepository;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import static org.testng.Assert.*;

public class SortFiguresByIdTest {

    private final SortFiguresById comparator = new SortFiguresById();
    private FigureRepository figureRepository = null;

    @BeforeClass
    public void setUp() throws FileNotFoundException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("quadrangles.txt");
        File file = new File(url.getPath());
        Scanner fileScanner = new Scanner(file);
        FigureReader figureReader = new FigureReader(FigureType.QUADRANGLE);
        List<Figure> quadrangles = figureReader.scanFigures(fileScanner);
        PointFactory pointFactory = PointFactory.getInstance();
        figureRepository = new FigureRepository(quadrangles);
        figureRepository.create(pointFactory.of(0, 0));
        figureRepository.create(pointFactory.of(1, 2));
        figureRepository.create(pointFactory.of(2, 30));
    }

    @Test
    public void compare_shouldReturnPositiveNumber_ifIdOfTheFirstFigureIsLessThanSecondOne() {
        List<Figure> sorted = figureRepository.sortByComparator(comparator);

        assertTrue(sorted.get(0).getId() < sorted.get(1).getId());
        assertTrue(sorted.get(1).getId() < sorted.get(2).getId());
        assertTrue(sorted.get(2).getId() < sorted.get(3).getId());
    }

    @Test
    public void reversed_shouldReturnNegativeNumber_ifIdOfTheFirstFigureIsLessThanSecondOne() {
        List<Figure> sorted = figureRepository.sortByComparator(comparator.reversed());

        assertTrue(sorted.get(0).getId() > sorted.get(1).getId());
        assertTrue(sorted.get(1).getId() > sorted.get(2).getId());
        assertTrue(sorted.get(2).getId() > sorted.get(3).getId());
    }
}