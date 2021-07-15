package com.example.m20210712_mubasharkhan_nycschools.di.subcomponent;

import com.example.m20210712_mubasharkhan_nycschools.di.scope.MainActivityScope;
import com.example.m20210712_mubasharkhan_nycschools.ui.activities.MainActivity;
import com.example.m20210712_mubasharkhan_nycschools.ui.fragments.DetailFragment;
import com.example.m20210712_mubasharkhan_nycschools.ui.fragments.MainFragment;

import javax.inject.Singleton;

import dagger.Subcomponent;

@MainActivityScope
@Subcomponent
public interface MainActivitySubComponent {
    @Subcomponent.Factory
    interface Factory {
        MainActivitySubComponent create();
    }

    // MainActivity, MainFragment
    // request injection from MainActivitySubComponent. The graph needs to satisfy
    // all the dependencies of the fields those classes are injecting
    void inject(MainActivity mainActivity);
    void inject(MainFragment mainFragment);
    void inject(DetailFragment detailFragment);
}
