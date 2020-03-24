package com.codesaid.lib_core.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.codesaid.lib_core.app.CodeSaid;
import com.codesaid.lib_core.net.callback.IError;
import com.codesaid.lib_core.net.callback.IFailure;
import com.codesaid.lib_core.net.callback.IRequest;
import com.codesaid.lib_core.net.callback.ISuccess;
import com.codesaid.lib_core.utils.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * Created By codesaid
 * On :2020-03-24 21:01
 * Package Name: com.codesaid.lib_core.net.download
 * desc:
 */

public class SaveFileTask extends AsyncTask<Object, Void, File> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;

    public SaveFileTask(IRequest request, ISuccess success, IError error, IFailure failure) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
    }

    @Override
    protected File doInBackground(Object... objects) {

        String downloadDir = (String) objects[0];
        String extension = (String) objects[1];

        final ResponseBody body = (ResponseBody) objects[2];
        final String name = (String) objects[3];
        // 获取输入流
        final InputStream inputStream = body.byteStream();
        // 判断 download dir  是否为空
        if (downloadDir == null || downloadDir.equals("")) {
            // 如果为空，直接指定
            downloadDir = "down_loads";
        }
        if (extension == null || extension.equals("")) {
            extension = "";
        }

        // 判断 是否有完整的 文件名
        if (name == null) {
            return FileUtil.writeToDisk(inputStream, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(inputStream, downloadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        autoInstallApk(file);
    }

    /**
     * 自动安装文件
     *
     * @param file file
     */
    private void autoInstallApk(File file) {
        // 判断该文件是否 是 apk 的后缀
        if (FileUtil.getExtension(file.getPath()).equals("apk")) {
            final Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            CodeSaid.getApplication().startActivity(intent);
        }
    }

}
