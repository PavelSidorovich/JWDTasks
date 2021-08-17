package com.epam.jwd.quadrangle.model;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@ExtendWith(MockitoExtension.class)
public class FigurePublisherTest {

    @Mock
    Point figure;

    @Mock
    FigureSubscriber subscriber;

    @InjectMocks
    private FigurePublisher publisher = new FigurePublisher(PointFactory.getInstance().of(1, 1));

    private AutoCloseable closeable;

    @BeforeMethod
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void setFigure_shouldSetFigure_always() {
        publisher = new FigurePublisher(figure);

        publisher.subscribe(subscriber);

        publisher.setFigure(figure);
    }

    @Test
    public void getFigureContext_shouldReturnFigureContext_ifNotNull() {
        publisher = new FigurePublisher(figure);

        assertNotNull(publisher.getFigureContext());
    }

    @Test
    public void cancel_shouldCancelSubscriptions_always() {
        publisher = new FigurePublisher(figure);

        publisher.cancel();
    }

    @Test
    public void subscribe_shouldSubscribeSubscriber_whenSubscriberIsValid() {
        publisher = new FigurePublisher(figure);

        publisher.subscribe(subscriber);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void subscribe_shouldThrowException_whenSubscriberIsInvalid() {
        publisher = new FigurePublisher(figure);

        publisher.subscribe(null);
    }
}