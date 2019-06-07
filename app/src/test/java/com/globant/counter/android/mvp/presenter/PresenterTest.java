package com.globant.counter.android.mvp.presenter;

import com.globant.counter.android.mvp.model.CalculatorModel;
import com.globant.counter.android.mvp.view.CountView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PresenterTest {

    private CountPresenter presenter;
    @Mock CalculatorModel model;
    @Mock CountView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new CountPresenter(model, view);
    }

    @Test
    public void addNumber() {

    }

}