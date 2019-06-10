package com.globant.counter.android.mvp.presenter

import com.globant.counter.android.mvp.model.CalculatorModel
import com.globant.counter.android.mvp.view.CountView
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CountPresenterTest {

    private lateinit var model: CalculatorModel
    private lateinit var presenter: CountPresenter
    private lateinit var view: CountView

    val TWO_VALUE_STRING = "2"
    val FOUR_VALUE_NUM = 4
    val FOUR_VALUE_STRING = "4"
    val NINETEEN_VALUE_NUM = 19
    val NINETEEN_VALUE_STRING = "19"



    @Before
    fun setup() {
        model = Mockito.mock(CalculatorModel::class.java)
        view = Mockito.mock(CountView::class.java)
        presenter = CountPresenter(model, view)
    }

    @Test
    fun onAddButtonPressedTest() {
        Mockito.`when`(model.count).thenReturn(NINETEEN_VALUE_NUM)
        presenter.onAddButtonPressed(NINETEEN_VALUE_STRING)
        verify(view).clearField()
    }

    @Test
    fun `test 2+2 should give 4 as a result`() {
        Mockito.`when`(model.count).thenReturn(FOUR_VALUE_NUM)
        presenter.onEqualButtonPressed(TWO_VALUE_STRING)
        verify(view).setNumber(FOUR_VALUE_STRING)
    }

    @Test
    fun onClearButtonPressedTest() {
        presenter.onClearButtonPressed()
        verify(view).clearField()
    }
}
