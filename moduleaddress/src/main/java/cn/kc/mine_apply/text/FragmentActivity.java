package cn.kc.mine_apply.text;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cn.kc.mine_apply.R;
import cn.kc.moduleutils.util.PermissionUtils;
import cn.kc.zxing.common.Constant;

public class FragmentActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ScanFragment scanFragment = new ScanFragment();
    // 单个相机权限
    private final String PERMISSION_CAMERA = Manifest.permission.CAMERA;
    // 打开相机请求Code
    private final int REQUEST_CODE_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        requestPermission();
        initView();

    }

    // 普通申请一个权限
    private void requestPermission() {
        PermissionUtils.checkAndRequestPermission(this, PERMISSION_CAMERA, REQUEST_CODE_CAMERA,
                new PermissionUtils.PermissionRequestSuccessCallBack() {
                    @Override
                    public void onHasPermission() {
                        // 权限已被授予
                        //toCamera();
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_CAMERA:
                if (PermissionUtils.isPermissionRequestSuccess(grantResults)) {
                    // 权限申请成功
                } else {
                    Toast.makeText(FragmentActivity.this, "打开相机失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("在Fragment中使用扫一扫");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, scanFragment).commit();


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1111) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                Log.i("扫描结果为:", content);

                scanFragment.onActivityResult(requestCode, resultCode, data);

            }
        }

    }
}
