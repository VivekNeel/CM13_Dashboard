package com.cyanogen.unofficial.dashboard.util;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Shiva on 13-03-2016.
 */
public class RestartUI {

    private static Process root;
    private static DataOutputStream dataOutputStream = null;

    public static void killPackage(String pkgName) {

        root = null;
        try {
            root = Runtime.getRuntime().exec("su");
        } catch (IOException e) {

            Log.d("Failed", "Failed to obtain root access");
        }

        if (root != null) {
            try {
                dataOutputStream = new DataOutputStream(root.getOutputStream());
                dataOutputStream.writeBytes("pkill " + pkgName + "\n");
                dataOutputStream.flush();
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                root.waitFor();

            } catch (IOException e) {

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

     }






}
