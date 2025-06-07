package com.example.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplo1composeidgs904.ui.theme.Ejemplo1ComposeIDGS904Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //
        setContent {
            Ejemplo1ComposeIDGS904Theme {
                //
                Trjeta()

                //

            }
        }
    }
}


// Funcion para la imagen
@Composable
fun ImagenWoman() {
    Image(
        painterResource(id = R.drawable.lunch_traje_de_sirvienta_en_el_manga),
        contentDescription = "Imagen de la personaje",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}


// Descripcion del perosnaje junto con su nombre
@Composable
fun Personaje() {
    Column {
        Text("Nombre: Launch")
        Text("Descripción: OwO. Personaje que sufre cambios de personalidad al estornudar. Es uno de los personajes principales del manga Dragon Ball y su anime homónimo")
    }
}


// Creamos como una intefaz
data class Personaje(val  nombre: String, val descripcion: String){

}


// Creamos una funcion de tipo "@Composable" para poder utilizarla
@Composable
fun Trjeta() {
    Row (
        modifier = Modifier.padding(8.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        ImagenWoman()
        Personaje()
    }
}



// Para trabajar con mi componente a tiempo real usamos el decorador ""
@Preview
@Composable
fun PreviewMessageCard(nombre: String = "Goku") {
    Trjeta()
}
