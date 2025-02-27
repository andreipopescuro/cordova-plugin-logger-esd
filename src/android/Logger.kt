package com.esd.logger

import android.util.Log
import org.apache.cordova.CallbackContext
import org.apache.cordova.CordovaPlugin
import org.apache.cordova.PluginResult
import org.json.JSONArray

class Logger : CordovaPlugin() {

    companion object {
        private const val DEFAULT_LOG_LEVEL = "info"
        private const val DEFAULT_TAG = "ESD"
    }
    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {

        when (action) {
            "log" -> {

                try {
                    val logLevel = args.optString(0, DEFAULT_LOG_LEVEL).lowercase()
                    val tag = args.optString(1, DEFAULT_TAG)
                    val message = args.optString(2, "");

                    when (logLevel) {
                        DEFAULT_LOG_LEVEL -> Log.i(tag, message)
                        "warn" -> Log.w(tag, message)
                        "error" -> Log.e(tag, message)
                        else -> Log.d(tag, "Unknown log level: $logLevel. Message: $message")
                    }

                    sendPluginResultSuccess("Success text", callbackContext);

                } catch (e: Exception) {
                    Log.e(DEFAULT_TAG, "Exception in logging: ${e.message}", e)
                    sendPluginResultError("Error text", callbackContext)
                }

                return true
            }
        }
        return false
    }

    private fun sendPluginResultSuccess(message: String, callbackContext: CallbackContext) {
        val result = PluginResult(PluginResult.Status.OK, message)
        callbackContext.sendPluginResult(result)
    }

    private fun sendPluginResultError(message: String, callbackContext: CallbackContext) {
        val result = PluginResult(PluginResult.Status.ERROR, message)
        callbackContext.sendPluginResult(result)
    }
}