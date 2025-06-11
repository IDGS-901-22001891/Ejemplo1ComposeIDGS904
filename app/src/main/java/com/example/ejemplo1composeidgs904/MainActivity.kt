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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import com.example.compose.Ejemplo1ComposeIDGS904Theme


// Hacer la lista de 10 personajes de DragonBall usando esta forma


private val personajes: List<CardPersonaje> = listOf(
    CardPersonaje( "lunch_traje_de_sirvienta_en_el_manga", "Chica con personalidad dual que cambia al estornudar"),
    CardPersonaje( "gohan", "Hijo mayor de Goku y Chi-Chi, mestizo saiyano-humano."),
    CardPersonaje( "goku_normal", "Protagonista saiyano, guerrero fuerte y bondadoso"),
    CardPersonaje( "chichi_dbs", "Esposa de Goku y madre de Gohan y Goten, estricta pero cariñosa."),
    CardPersonaje( "broly_dbs_base", "Saiyano legendario con poder destructivo incontrolable"),
    CardPersonaje( "androide_18_artwork", "Exandroide, esposa de Krilin y luchadora poderosa"),
    CardPersonaje( "vegetto", "Fusión de Goku y Vegeta mediante los Potara."),
    CardPersonaje( "vegeta_normal", "Príncipe saiyano, rival de Goku y luego aliado"),
    CardPersonaje( "vegeta_normal", "Padre de Goku, saiyano rebelde que enfrentó a Freeza.")
)
data class CardPersonaje(val title: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ejemplo1ComposeIDGS904Theme {
                Tarjeta(personajes)
            }
        }
    }
}

@Composable
fun Tarjeta(personajes:List<CardPersonaje>){
    LazyColumn {
        items (personajes) { personaje ->
            MyPersonajes(personaje)
        }
    }
}

@Composable
fun MyPersonajes(personaje: CardPersonaje){
    Card (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), // Add fillMaxWidth to make the card take full width
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer) // Use a color from your theme or Color.Blue
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background) // Row background can be different if needed
        ) {
            ImagenHeroe(personaje.title) // Pass the image resource ID
            Personajes(personaje)
        }
    }
}

@Composable
fun Personajes(personaje: CardPersonaje){
    Column {
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge)
        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun Personaje(name: String, color: Color, style: TextStyle){
    Text(text = name)
}

@Composable
fun ImagenHeroe(imageName : String ){
    val context = LocalContext.current
    val ImageResid = remember(imageName){
        context.resources.getIdentifier(imageName.lowercase(), "drawable", context.packageName)
    }
    Image(
        painter = painterResource(id = ImageResid),
        contentDescription = imageName,
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape)
            .size(100.dp)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Preview
@Composable
fun PreviewMessageCard(){
    Tarjeta(personajes)
}

