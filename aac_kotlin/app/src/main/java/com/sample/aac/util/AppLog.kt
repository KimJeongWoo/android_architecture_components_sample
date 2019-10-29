package com.sample.aac.util

import android.util.Log
import com.sample.aac.BuildConfig


/**
 * Logger (for logcat)
 */
object AppLog {

    private var DEBUG = BuildConfig.DEBUG

    /**
     * logcat TAG
     */
    private const val TAG = BuildConfig.APPLICATION_ID

    fun i(tag: String, msg: String) {
        if (DEBUG) Log.i(tag, msg)
    }

    fun i(message: String) {
        if (DEBUG) i(TAG, buildLogMsg(message))
    }

    private fun d(tag: String, msg: String) {
        if (DEBUG) Log.d(tag, msg)
    }

    fun d(message: String) {
        if (DEBUG) d(TAG, buildLogMsg(message))
    }

    fun e(tag: String, msg: String) {
        if (DEBUG) Log.e(tag, msg)
    }

    fun e(message: String) {
        if (DEBUG) e(TAG, buildLogMsg(message))
    }

    fun w(tag: String, msg: String) {
        if (DEBUG) Log.w(tag, msg)
    }

    fun w(message: String) {
        if (DEBUG) w(TAG, buildLogMsg(message))
    }

    private fun buildLogMsg(message: String): String {
        val stackTraceElement = Thread.currentThread().stackTrace[4]
        val fileName = stackTraceElement.fileName.replace(".java", "")
        val methodName = stackTraceElement.methodName
        val lineNumber = stackTraceElement.lineNumber
        return ("[$fileName] $methodName()[$lineNumber] >> $message")
    }
}