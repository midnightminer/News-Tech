package id.midnightminer.newstech.util

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

object CommonUtils {
    fun isInternetWorking(): Boolean {
        var success = false
        try {
            val url = URL(Constant.BASE_URL)
            val connection =
                url.openConnection() as HttpURLConnection
            connection.connectTimeout = 10000
            connection.connect()
            success = connection.responseCode == 200
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return success
    }
}