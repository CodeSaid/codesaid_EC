package com.codesaid.lib_core.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.codesaid.lib_core.R;
import com.codesaid.lib_core.delegates.CodeSaidDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created By codesaid
 * On :2020-03-16 21:14
 * Package Name: com.codesaid.lib_core.activitys
 * desc: Activity 容器
 */
public abstract class ProxyActivity extends SupportActivity {

    public abstract CodeSaidDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init(savedInstanceState);
    }

    private void init(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);

        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
