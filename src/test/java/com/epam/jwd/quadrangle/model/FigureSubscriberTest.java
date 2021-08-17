package com.epam.jwd.quadrangle.model;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.Flow.Subscription;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

@ExtendWith(MockitoExtension.class)
public class FigureSubscriberTest {

    @Mock
    private Subscription subscription;

    @Mock
    private FigureContext figureContext;

    @Mock
    private Logger logger;

    @InjectMocks
    private FigureSubscriber subscriber;

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
    public void onSubscribe() {
        assertNotNull(subscription);

        subscriber = new FigureSubscriber();
        subscriber.onSubscribe(subscription);

        verify(subscription).request(1);
    }

    @Test
    public void onNext() {
        subscriber = new FigureSubscriber();

        assertTrue(subscriber.toString().contains("null"));

        subscriber.onNext(figureContext);

        assertFalse(subscriber.toString().contains("null"));
    }

    @Test
    public void onError() {
        subscriber = new FigureSubscriber();
        subscriber.onError(new NullPointerException());
    }

    @Test
    public void onComplete() {
        subscriber = new FigureSubscriber();
        subscriber.onComplete();
    }
}