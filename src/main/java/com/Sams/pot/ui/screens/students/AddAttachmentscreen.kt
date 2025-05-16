package com.Sams.pot.ui.screens.students

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.Sams.pot.R
import com.Sams.pot.data.StudentViewModel
import com.Sams.pot.ui.screens.BottomNav
import com.Sams.pot.ui.screens.TopBar

@Composable
fun AddAttachment(navController: NavController) {
    val imageUri = rememberSaveable() { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                imageUri.value = it
            }
        }
    var name by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var report by remember { mutableStateOf("") }
    val studentViewModel: StudentViewModel = viewModel()
    val context = LocalContext.current
    Scaffold(
        topBar = { TopBar("Write your report") },
        bottomBar = { BottomNav(navController) }
    ) { innerpadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
        ) {
            Image(
                painter = painterResource(R.drawable.img_2),
                contentDescription = "Background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(innerpadding)
                    .size(700.dp)
            )
            Column(
                modifier = Modifier.padding(10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(shape = CircleShape, modifier = Modifier.padding(10.dp).size(200.dp)) {
                    AsyncImage(
                        model = imageUri.value ?: R.drawable.img_1,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(200.dp)
                            .clickable { launcher.launch("image/*") })
                }
                Text(text = "Upload Picture Here")

                OutlinedTextField(
                    value = name,
                    onValueChange = { newName -> name = newName },
                    label = { Text(text = "Enter student name") },
                    placeholder = { Text(text = "PLease enter student name") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = course,
                    onValueChange = { newCourse -> course = newCourse },
                    label = { Text(text = "Enter student course") },
                    placeholder = { Text(text = "PLease enter student course") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = report,
                    onValueChange = { newSummary -> report = newSummary },
                    label = { Text(text = "Enter student report") },
                    placeholder = { Text(text = "PLease enter student report") },
                    modifier = Modifier.fillMaxWidth().height(150.dp), singleLine = false
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(onClick = {
                        imageUri.value?.let {
                            studentViewModel.Reports(
                                it,
                                context,
                                name,
                                course,
                                report,
                                navController
                            )
                        } ?: Toast.makeText(context, "Please pick an image", Toast.LENGTH_LONG)
                            .show()
                    }) {
                        Text(text = "SAVE")
                    }
                }
            }
        }
    }
}

