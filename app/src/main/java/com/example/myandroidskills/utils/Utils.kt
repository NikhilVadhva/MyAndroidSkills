package com.example.myandroidskills.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager


object Utils {

    /**
     * Create a dummy log file to show how it's possible to prefill files in the Contact form
     */
    fun generateSampleLogFileUri(context: Context): List<String>? {
        val uris: MutableList<String> = ArrayList()
       /* try {
            val logAFile: File = File(context.filesDir + File.separator + "log_a.txt")
            logAFile.createNewFile()
            val fileOutputStream = FileOutputStream(logAFile)
            val outputStreamWriter = OutputStreamWriter(fileOutputStream)
            outputStreamWriter.append("This is a sample log called log_a.txt")
            outputStreamWriter.close()
            fileOutputStream.close()
            uris.add(Uri.fromFile(logAFile).toString())
        } catch (exception: IOException) {
            Timber.e(exception)
        }*/
        return uris
    }

    /**
     * @return the Version name of the app
     */
    fun getAppVersion(context: Context): String? {
        return try {
            val pInfo: PackageInfo =
                context.getPackageManager().getPackageInfo(context.getPackageName(), 0)
            pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            throw RuntimeException(e)
        }
    }
}