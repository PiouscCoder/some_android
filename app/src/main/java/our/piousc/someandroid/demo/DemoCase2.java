package our.piousc.someandroid.demo;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import our.piousc.someandroid.base.case_.CaseItemBean;
import our.piousc.someandroid.base.case_.ICaseProvider;
import our.piousc.someandroid.base.case_.OnCaseClickListener;

/**
 * Created by qianbingbing on 2021/9/29
 * Description：
 */
public class DemoCase2 implements ICaseProvider {

    private Context context;

    public DemoCase2(Context context){

        this.context = context;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public String getName() {
        return "DemoCase2";
    }

    @NonNull
    @Override
    public OnCaseClickListener getClickListener() {
        return new OnCaseClickListener() {
            @Override
            public void onCaseClick(int position, @Nullable CaseItemBean item) {
                Toast.makeText(context, getName(), Toast.LENGTH_SHORT).show();
            }
        };
    }
}
