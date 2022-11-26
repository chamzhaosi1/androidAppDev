package com.example.customcontentproviderdemo

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var helper = MyHelper(applicationContext)
//        var db:SQLiteDatabase = helper.readableDatabase
//        var rs:Cursor = db.rawQuery("SELECT * FROM ACTABLE", null)
//        if(rs.moveToFirst()){
//            Toast.makeText(applicationContext, rs.getString(1)+"\n"+rs.getString(2), Toast.LENGTH_LONG).show()
//        }

        var rs = contentResolver.query(AcronymProvider.CONTENT_URI,
            arrayOf(AcronymProvider._ID, AcronymProvider.NAME, AcronymProvider.MEANING),null, null, AcronymProvider.NAME)

        button.setOnClickListener{
            if (rs?.moveToNext()!!){
                editTextTextPersonName.setText(rs.getString(1))
                editTextTextPersonName2.setText(rs.getString(2))
            }
        }

        button2.setOnClickListener{
            if (rs?.moveToPrevious()!!){
                editTextTextPersonName.setText(rs.getString(1))
                editTextTextPersonName2.setText(rs.getString(2))
            }
        }

        button3.setOnClickListener{
            var cv = ContentValues()
            cv.put(AcronymProvider.NAME, editTextTextPersonName.text.toString())
            cv.put(AcronymProvider.MEANING, editTextTextPersonName2.text.toString())

            contentResolver.insert(AcronymProvider.CONTENT_URI, cv)
            rs?.requery()
        }

        button4.setOnClickListener{
            var cv = ContentValues()
            cv.put(AcronymProvider.MEANING, editTextTextPersonName2.text.toString())
            contentResolver.update(AcronymProvider.CONTENT_URI, cv, "NAME = ?", arrayOf(editTextTextPersonName.text.toString()))
            rs?.requery()
        }

        button5.setOnClickListener{
            contentResolver.delete(AcronymProvider.CONTENT_URI, "NAME = ?", arrayOf(editTextTextPersonName.text.toString()))
            rs?.requery()
        }

        button6.setOnClickListener{
            editTextTextPersonName.setText("")
            editTextTextPersonName2.setText("")
            editTextTextPersonName.requestFocus()
        }

    }
}