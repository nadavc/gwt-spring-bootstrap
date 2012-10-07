package com.mycompany.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * JUnit test that doesn't use Spring at all. Injections are done using mocks only
 * with @InjectMocks.
 */
public class GreetingServiceImplTest {

    @InjectMocks
    private GreetingServiceImpl greetingService;

    @Mock
    private RandomWordService randomWordService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGreetServer() throws Exception {
        when(randomWordService.readRandomWordFor("hello")).thenReturn("hola");

        String result = greetingService.greetServer("George");

        // This is fest-assert fluent assertions
        assertThat(result).isEqualTo("hola, George!");

        // Mockito can be used to make sure that methods were only called once
        verify(randomWordService, times(1)).readRandomWordFor(anyString());
    }

}
