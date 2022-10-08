package com.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivityLog"
    var isLoggedIn = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java))
        }
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onStart(){
        Log.d(TAG, "onStart")
        super.onStart()
        //UseCase -5 (Setting Permissions)
//        setPermission()

        //UseCase -6 (Checking Login Status)
//        checkLoginStatus()

        //UseCase -7 (Weather App)
        checkLatestTemp()

        //Note: This is because either initial or resume the app,
        // this onStart() function will be invoked,
        // so any function that need to trigger every activity lunch we need call the function at here
    }

    override fun onResume(){
        Log.d(TAG, "onResume")
        super.onResume()
        //UseCase -7 (Pause Video Like Youtube)
        //Once the app is focus, then the video will automatically resume/play again
        //resume
    }

    override fun onPause(){
        Log.d(TAG, "onPause")
        super.onPause()
        //UseCase -7 (Pause Video Like Youtube)
        //When the app is lost focus, then the video will automatically pause
        // pause
    }

    override fun onStop(){
        Log.d(TAG, "onStop")
        super.onStop()
        isLoggedIn = false
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    //UseCase -5 (Setting Permissions)
//    fun setPermission(){
//        Log.d(TAG, "setPermission called")
//    }

    //UseCase -6 (Checking Login Status)
//    fun checkLoginStatus(){
//        if(isLoggedIn){
//            Log.d(TAG, "LoggedIn")
//        }else{
//            Log.d(TAG, "Log Out")
//        }
//    }

    //UseCase -7 (Weather App)
    fun checkLatestTemp(){
        Log.d(TAG, "checkLatestTemp")
    }
}

// UseCase -1 (Transition b/w activities)
// Result:
//2022-10-08 17:17:04.800 20575-20575 MainActivityLog         com.activitylifecycle                D  onCreate
//2022-10-08 17:17:05.261 20575-20575 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:17:05.264 20575-20575 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:17:17.708 20575-20575 MainActivityLog         com.activitylifecycle                D  onPause
//2022-10-08 17:17:17.768 20575-20575 SecondActivityLog       com.activitylifecycle                D  onStart
//2022-10-08 17:17:17.771 20575-20575 SecondActivityLog       com.activitylifecycle                D  onResume
//2022-10-08 17:17:18.332 20575-20575 MainActivityLog         com.activitylifecycle                D  onStop
//2022-10-08 17:17:25.188 20575-20575 SecondActivityLog       com.activitylifecycle                D  onPause
//2022-10-08 17:17:25.199 20575-20575 MainActivityLog         com.activitylifecycle                D  onRestart
//2022-10-08 17:17:25.203 20575-20575 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:17:25.205 20575-20575 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:17:25.813 20575-20575 SecondActivityLog       com.activitylifecycle                D  onStop
//2022-10-08 17:17:25.817 20575-20575 SecondActivityLog       com.activitylifecycle                D  onDestroy

// UseCase -2 (Screen Lock)
// Result:
//2022-10-08 17:23:44.223 20754-20754 MainActivityLog         com.activitylifecycle                D  onCreate
//2022-10-08 17:23:44.444 20754-20754 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:23:44.449 20754-20754 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:23:47.220 20754-20754 MainActivityLog         com.activitylifecycle                D  onPause
//2022-10-08 17:23:47.230 20754-20754 MainActivityLog         com.activitylifecycle                D  onStop
//2022-10-08 17:23:49.927 20754-20754 MainActivityLog         com.activitylifecycle                D  onRestart
//2022-10-08 17:23:49.933 20754-20754 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:23:49.937 20754-20754 MainActivityLog         com.activitylifecycle                D  onResume

//UseCase -3 (Pressing Home Button)
//Result:
//2022-10-08 17:25:44.357 20964-20964 MainActivityLog         com.activitylifecycle                D  onCreate
//2022-10-08 17:25:44.654 20964-20964 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:25:44.657 20964-20964 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:25:46.923 20964-20964 MainActivityLog         com.activitylifecycle                D  onPause
//2022-10-08 17:25:47.912 20964-20964 MainActivityLog         com.activitylifecycle                D  onStop
//2022-10-08 17:25:51.040 20964-20964 MainActivityLog         com.activitylifecycle                D  onRestart
//2022-10-08 17:25:51.040 20964-20964 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:25:51.041 20964-20964 MainActivityLog         com.activitylifecycle                D  onResume

//UseCase -4 (Killing App)
//Result:
//2022-10-08 17:26:41.819 21045-21045 MainActivityLog         com.activitylifecycle                D  onCreate
//2022-10-08 17:26:42.181 21045-21045 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:26:42.189 21045-21045 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:26:49.441 21045-21045 MainActivityLog         com.activitylifecycle                D  onPause
//2022-10-08 17:26:49.929 21045-21045 MainActivityLog         com.activitylifecycle                D  onStop
//2022-10-08 17:26:50.838 21045-21045 MainActivityLog         com.activitylifecycle                D  onDestroy

//UseCase -5 (Setting Permissions)
//Result:
//2022-10-08 17:29:34.969 21127-21127 MainActivityLog         com.activitylifecycle                D  onCreate
//2022-10-08 17:29:35.836 21127-21127 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:29:35.837 21127-21127 MainActivityLog         com.activitylifecycle                D  setPermission called
//2022-10-08 17:29:35.840 21127-21127 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:30:02.176 21127-21127 MainActivityLog         com.activitylifecycle                D  onPause
//2022-10-08 17:30:03.276 21127-21127 MainActivityLog         com.activitylifecycle                D  onStop
//2022-10-08 17:30:05.030 21127-21127 MainActivityLog         com.activitylifecycle                D  onRestart
//2022-10-08 17:30:05.032 21127-21127 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:30:05.033 21127-21127 MainActivityLog         com.activitylifecycle                D  setPermission called
//2022-10-08 17:30:05.033 21127-21127 MainActivityLog         com.activitylifecycle                D  onResume

//UseCase -6 (Checking Login Status)
//Result: (For LoggedIn)
//2022-10-08 17:35:26.216 21272-21272 MainActivityLog         com.activitylifecycle                D  onCreate
//2022-10-08 17:35:27.162 21272-21272 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:35:27.164 21272-21272 MainActivityLog         com.activitylifecycle                D  LoggedIn
//2022-10-08 17:35:27.168 21272-21272 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:35:30.543 21272-21272 MainActivityLog         com.activitylifecycle                D  onPause
//2022-10-08 17:35:31.526 21272-21272 MainActivityLog         com.activitylifecycle                D  onStop
//2022-10-08 17:35:33.054 21272-21272 MainActivityLog         com.activitylifecycle                D  onRestart
//2022-10-08 17:35:33.058 21272-21272 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:35:33.058 21272-21272 MainActivityLog         com.activitylifecycle                D  LoggedIn
//2022-10-08 17:35:33.058 21272-21272 MainActivityLog         com.activitylifecycle                D  onResume

//Result: (For Log out)
//2022-10-08 17:36:55.800 21349-21349 MainActivityLog         com.activitylifecycle                D  onCreate
//2022-10-08 17:36:56.217 21349-21349 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:36:56.217 21349-21349 MainActivityLog         com.activitylifecycle                D  LoggedIn
//2022-10-08 17:36:56.219 21349-21349 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:36:59.676 21349-21349 MainActivityLog         com.activitylifecycle                D  onPause
//2022-10-08 17:37:00.739 21349-21349 MainActivityLog         com.activitylifecycle                D  onStop
//2022-10-08 17:37:02.032 21349-21349 MainActivityLog         com.activitylifecycle                D  onRestart
//2022-10-08 17:37:02.033 21349-21349 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:37:02.033 21349-21349 MainActivityLog         com.activitylifecycle                D  Log Out
//2022-10-08 17:37:02.035 21349-21349 MainActivityLog         com.activitylifecycle                D  onResume

//UseCase -7 (Pause Video Like Youtube)
//Result:
//onPause(){
//    do something let the video pause automatically, after minimized the activity
//}

//onResume(){
//    do something let the video play automatically, after maximized or focus the activity again
//}

//UseCase -7 (Weather App)
//Result:
//2022-10-08 17:45:49.293 21583-21583 MainActivityLog         com.activitylifecycle                D  onCreate
//2022-10-08 17:45:49.560 21583-21583 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:45:49.561 21583-21583 MainActivityLog         com.activitylifecycle                D  checkLatestTemp
//2022-10-08 17:45:49.565 21583-21583 MainActivityLog         com.activitylifecycle                D  onResume
//2022-10-08 17:45:53.018 21583-21583 MainActivityLog         com.activitylifecycle                D  onPause
//2022-10-08 17:45:53.963 21583-21583 MainActivityLog         com.activitylifecycle                D  onStop
//2022-10-08 17:45:55.382 21583-21583 MainActivityLog         com.activitylifecycle                D  onRestart
//2022-10-08 17:45:55.384 21583-21583 MainActivityLog         com.activitylifecycle                D  onStart
//2022-10-08 17:45:55.385 21583-21583 MainActivityLog         com.activitylifecycle                D  checkLatestTemp
//2022-10-08 17:45:55.386 21583-21583 MainActivityLog         com.activitylifecycle                D  onResume
