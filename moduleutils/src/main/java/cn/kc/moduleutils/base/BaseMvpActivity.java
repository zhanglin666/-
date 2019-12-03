package cn.kc.moduleutils.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import cn.kc.moduleutils.base.BaseActivity;
import cn.kc.moduleutils.view.WeiboDialogUtils;
import org.jetbrains.annotations.Nullable;

/**
 * 作者： Abel .
 * 日期：2019/9/25
 * 说明：
 */
public abstract class BaseMvpActivity<P extends BaseContract.Presenter> extends BaseActivity
        implements BaseContract.View {
    private ProgressDialog mProgressDialog;
    protected P mPresenter;
    private Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            getLifecycle().addObserver(mPresenter);
        }
    }

    @Override
    public void showProgressDialog() {
        mDialog = WeiboDialogUtils.createLoadingDialog(this, "加载中...");

//        if (mProgressDialog == null) {
//            mProgressDialog = new ProgressDialog(this);
//            mProgressDialog.setMessage("网络加载中...");
//        }
//        if (!mProgressDialog.isShowing()) {
//            mProgressDialog.show();
//        }
    }

    @Override
    public void dismissProgressDialog() {
        WeiboDialogUtils.closeDialog(mDialog);
//        if (mProgressDialog != null && mProgressDialog.isShowing()) {
//            mProgressDialog.dismiss();
//        }
    }

    protected abstract P createPresenter();
}
