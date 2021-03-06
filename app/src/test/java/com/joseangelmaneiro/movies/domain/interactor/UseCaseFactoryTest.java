package com.joseangelmaneiro.movies.domain.interactor;

import com.joseangelmaneiro.movies.domain.MoviesRepository;
import com.joseangelmaneiro.movies.domain.executor.JobScheduler;
import com.joseangelmaneiro.movies.domain.executor.UIScheduler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;


public class UseCaseFactoryTest {

    @Mock
    MoviesRepository repository;
    @Mock
    UIScheduler uiScheduler;
    @Mock
    JobScheduler jobScheduler;

    UseCaseFactory sut;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        sut = new UseCaseFactory(repository, uiScheduler, jobScheduler);
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    public void getMovie_CreatesCorrectInstance(){
        UseCase useCase = sut.getMovie();

        assertTrue(useCase instanceof GetMovie);
    }

    @Test
    public void getMovies_CreatesCorrectInstance(){
        UseCase useCase = sut.getMovies();

        assertTrue(useCase instanceof GetMovies);
    }

}
