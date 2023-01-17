package mz.co.bilheteira.utils

import android.content.Context
import mz.co.bilheteira.pixabayimagesearch.R
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.handleThrowable(context: Context): String {
    Timber.e(this)
    return when (this) {
        is SocketTimeoutException -> context.getString(R.string.connectivity_error)
        is UnknownHostException -> context.getString(R.string.connection_error)
        is ConnectException -> context.getString(R.string.connectivity_error)
        else -> this.message.toString()
    }
}
