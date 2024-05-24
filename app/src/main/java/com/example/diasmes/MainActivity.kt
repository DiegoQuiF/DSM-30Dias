package com.example.diasmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diasmes.data.Datos
import com.example.diasmes.model.Dia
import com.example.diasmes.ui.theme.DiasMesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiasMesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun Titulo(modifier: Modifier = Modifier) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(.08F)
            .background(Color(0xFFa7c957)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "30 Días de Bienestar",
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.displayMedium,
            fontSize = 25.sp
        )
    }
}

@Composable
fun Tarjeta(dia: Dia, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .background(Color.White)
            .border(width = 1.dp, color = Color.Black)
            .fillMaxWidth(.92F)
    ) {
        Column (
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = dia.nroDia,
                modifier = Modifier.padding(bottom = 10.dp),
                style = MaterialTheme.typography.displayMedium,
                color = Color.Black
            )
            Text(
                text = stringResource(id = dia.mensajeStringId),
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.labelSmall,
                color = Color.Black

            )
            Image(
                painter = painterResource(id = dia.imageResourceId),
                contentDescription = null,
                modifier = Modifier.height(220.dp).align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = dia.descStringId),
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black
            )
        }
    }
}

@Composable
fun ListaDias(dias: List<Dia>, modifier: Modifier = Modifier) {
    LazyColumn (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(dias) { dia ->
            Tarjeta(
                dia = dia
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(12.dp))
        }
    }
}

@Composable
fun App() {
    Column (
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Titulo()
        ListaDias(
            dias = Datos().cargarDatos(),
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiasMesTheme {
        App()
    }
}