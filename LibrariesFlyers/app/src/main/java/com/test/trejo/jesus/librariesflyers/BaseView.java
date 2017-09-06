package com.test.trejo.jesus.librariesflyers;

/**
 * Created by roger on 06/09/17.
 */

import android.support.annotation.NonNull;

public interface BaseView<T> {

    void setPresenter(@NonNull T presenter);

}