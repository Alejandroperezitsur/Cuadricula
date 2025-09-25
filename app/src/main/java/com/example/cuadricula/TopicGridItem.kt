package com.example.cuadricula

import javax.sql.DataSource

// File: TopicGridItem.kt (o como llames a tu archivo de UI principal)
package com.example.cuadricula // O el paquete donde tengas tus Composables de UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.data.DataSource // Importa tu DataSource
import com.example.cuadricula.model.Topic    // Importa tu modelo Topic
import com.example.cuadricula.ui.theme.CuadriculaTheme // Importa tu tema (si lo tienes)

@Composable
fun TopicGridItem(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) { // Usamos Card para darle elevación y bordes redondeados
        Row {
            // Box para la imagen, para poder usar aspectRatio
            Box {
                Image(
                    painter = painterResource(id = topic.imageResId),
                    contentDescription = stringResource(id = topic.nameResId),
                    modifier = Modifier
                        .size(width = 68.dp, height = 68.dp) // Tamaño fijo para la imagen
                        .aspectRatio(1f), // Mantiene la relación de aspecto cuadrada
                    contentScale = ContentScale.Crop // Recorta la imagen para llenar el espacio
                )
            }

            // Columna para el texto y el ícono
            Column(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    ) // Padding según especificaciones
            ) {
                Text(
                    text = stringResource(id = topic.nameResId),
                    style = MaterialTheme.typography.bodyMedium, // Estilo de texto especificado
                    modifier = Modifier.padding(bottom = 8.dp) // Espacio debajo del nombre
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start // Alinea los elementos al inicio
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain), // Asume que tienes este ícono
                        contentDescription = null, // El ícono es decorativo
                        modifier = Modifier
                            .padding(end = 8.dp) // Espacio a la derecha del ícono
                            .size(12.dp) // Tamaño del ícono, ajusta según necesidad
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium // Estilo de texto especificado
                    )
                }
            }
        }
    }
}

// Preview para ver cómo se ve el TopicGridItem
@Preview(showBackground = true)
@Composable
fun TopicGridItemPreview() {
    // Asegúrate de que tu tema esté definido y se llame CuadriculaTheme
    // o el nombre que le hayas puesto.
    CuadriculaTheme { // Envuelve con tu tema para aplicar estilos
        TopicGridItem(
            topic = DataSource.topics[0], // Usa el primer tema del DataSource para el preview
            modifier = Modifier.padding(8.dp) // Padding alrededor del item en el preview
        )
    }
}
