package com.globant.counter.android.mvp.view;

import android.app.Activity;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.util.bus.observers.CountButtonUpBusObserver;
import com.globant.counter.android.util.bus.observers.ResetButtonObserver;
import com.globant.counter.android.util.bus.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountViewBackup extends ActivityView {

    @BindView(R.id.editText_calculator_input) TextView countLabel;

    public CountViewBackup(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setCount(String count) {
        countLabel.setText(count);
    }

    @OnClick(R.id.button_add)
    public void countButtonPressed() {
        RxBus.post(new CountButtonUpBusObserver.CountButtonUp());
    }

    @OnClick(R.id.button_equal)
    public void resetButtonPressed() {
        RxBus.post(new ResetButtonObserver.ResetButtonPressed());
    }

}
