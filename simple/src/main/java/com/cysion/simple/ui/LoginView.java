package com.cysion.simple.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cysion.simple.R;

/**
 * Created by cysion on 2018\6\26 0026.
 */

public class LoginView extends LinearLayout {

    public interface ViewListener {
        void toLogin(String user, String pwd);

        void forgetPwd();
    }

    private Context mContext;
    private View mRootView;
    private EditText mEtUser;
    private EditText mEtPwd;
    private Button mBtnLogin;
    private TextView mTxtForget;
    private ViewListener mViewListener;

    public void setViewListener(ViewListener aViewListener) {
        mViewListener = aViewListener;
    }

    public LoginView(Context context) {
        super(context);
        init(context);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context aContext) {
        mContext = aContext;
        setPadding(30,30,30,30);
        mRootView = inflate(mContext, R.layout.ui_login, this);
        mEtUser = (EditText) mRootView.findViewById(R.id.et_account);
        mEtPwd = (EditText) mRootView.findViewById(R.id.et_pwd);
        mBtnLogin = (Button) mRootView.findViewById(R.id.btn_login);
        mTxtForget = (TextView) mRootView.findViewById(R.id.tv_forget_pwd);
        initEvent();

    }

    private void initEvent() {
        mBtnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEtUser.getText().toString())) {
                    Toast.makeText(mContext, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mEtPwd.getText().toString())) {
                    Toast.makeText(mContext, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mViewListener.toLogin(mEtUser.getText().toString(), mEtPwd.getText().toString());
            }
        });
        mTxtForget.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewListener.forgetPwd();
            }
        });
    }


    public EditText getEtUser() {
        return mEtUser;
    }

    public EditText getEtPwd() {
        return mEtPwd;
    }

    public Button getBtnLogin() {
        return mBtnLogin;
    }

    public TextView getTxtForget() {
        return mTxtForget;
    }
}
