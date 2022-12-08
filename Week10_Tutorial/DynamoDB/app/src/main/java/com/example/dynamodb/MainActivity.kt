package com.example.dynamodb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
//import androidx.compose.ui.platform.setContent
import com.example.dynamodb.ui.theme.AmplifydatastorecrudTheme
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.generated.model.HotModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureAmplify()
        setContent {
            AmplifydatastorecrudTheme {
                CRUDButtons()
            }
        }
    }

    @Composable
    fun CRUDButtons() {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val padding = Modifier.padding(vertical = 8.dp)

                // CREATE
                Button(
                    onClick = { create() },
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    modifier = padding
                ) {
                    Text("Create")
                }

                // READ ALL
                Button(
                    onClick = { readAll() },
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    modifier = padding
                ) {
                    Text("Read ALL")
                }

                // READ BY ID
                Button(
                    onClick = {
                        CoroutineScope(IO).launch {
                            readById()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Cyan),
                    modifier = padding
                ) {
                    Text("Read BY IDs")
                }

                // UPDATE
                Button(
                    onClick = {
                        CoroutineScope(IO).launch {
                            update()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Yellow),
                    modifier = padding
                ) {
                    Text("Update")
                }

                // DELETE
                Button(
                    onClick = { delete() },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    modifier = padding
                ) {
                    Text("Delete")
                }
            }
        }
    }

    private fun configureAmplify() {
        try {
            Amplify.addPlugin(AWSApiPlugin()) // UNCOMMENT this line once backend is deployed
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.configure(applicationContext)
            Log.i("Amplify", "Initialized Amplify")
        } catch (e: AmplifyException) {
            Log.e("Amplify", "Could not initialize Amplify", e)
        }
    }

    private val objectId = "1ffc7034-4d04-48f0-9136-a694e0431ba6"

    private fun create() {
        val item: HotModel = HotModel.builder()
            .name("Sexy Coder XOXO")
            .build()
        Amplify.DataStore.save(
            item,
            { success -> Log.i("Amplify", "Saved item: " + success.item().name) },
            { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
        )
    }

    private fun readAll() {
        Amplify.DataStore.query(
            HotModel::class.java,
            { items ->
                while (items.hasNext()) {
                    val item = items.next()
                    Log.i("Amplify", "Queried item: " + item.id + item.name)
                }
            },
            { failure -> Log.e("Amplify", "Could not query DataStore", failure) }
        )
    }

    private suspend fun readById(): HotModel = suspendCoroutine { cont ->
        Amplify.DataStore.query(
            HotModel::class.java,
            Where.id(objectId),
            { items ->
                if (items.hasNext()) {
                    val item = items.next()
                    Log.i("Amplify", "Queried item by id: " + item.id)
                    cont.resume(item)
                }
            },
            { failure -> Log.e("Tutorial", "Could not query DataStore", failure) }
        )
    }

    private suspend fun update() {
        val hotModel = withContext(CoroutineScope(IO).coroutineContext) {
            readById()
        }

        val updatedHotModel = hotModel.copyOfBuilder()
            .name(hotModel.name + " [UPDATED]")
            .build()

        Amplify.DataStore.save(
            updatedHotModel,
            { success -> Log.i("Amplify", "updated item to: " + success.item().name) },
            { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
        )
    }

    private fun delete() {
        val hotModel = HotModel.justId(objectId)

        Amplify.DataStore.delete(
            hotModel,
            { Log.i("Amplify", "Deleted object with id: $objectId")},
            { Log.e("Amplify", "Couldn't delete") }
        )
    }
}