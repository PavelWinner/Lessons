/*
 *
 *  *
 *  *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *  *
 *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  * you may not use this file except in compliance with the License.
 *  *  * You may obtain a copy of the License at
 *  *  *
 *  *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *  *
 *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  * See the License for the specific language governing permissions and
 *  *  * limitations under the License.
 *  *
 *
 */

package ua.com.todd.daggersample.ui.main;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.todd.daggersample.AppModule;
import ua.com.todd.daggersample.interactors.FindItemsInteractor;

@Module(
        injects = MainActivity.class,
        addsTo = AppModule.class
)
public class MainModule {

    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides @Singleton public MainView provideView() {
        return view;
    }

    @Provides @Singleton
    public MainPresenter providePresenter(MainView mainView, FindItemsInteractor findItemsInteractor) {
        return new MainPresenterImpl(mainView, findItemsInteractor);
    }
}
