package com.example.stockmanager.ui.pages.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.stockmanager.ui.theme.AquaBlue
import com.example.stockmanager.ui.theme.DeepBlue
import com.example.stockmanager.ui.theme.OrangeYellow3
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {
    Column(modifier = Modifier
        .fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            Card(modifier = Modifier
                .weight(1f)) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Icon(imageVector = Icons.Default.PieChart, contentDescription = "")
                    Text(text = "3,027", style = MaterialTheme.typography.titleLarge)
                    Text(text = "Products In", style = MaterialTheme.typography.bodySmall)
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Card(modifier = Modifier
                .weight(1f)) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Icon(imageVector = Icons.Default.PieChart, contentDescription = "")
                    Text(text = "3,027", style = MaterialTheme.typography.titleLarge)
                    Text(text = "Products Out", style = MaterialTheme.typography.bodySmall)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(text = "Revenue", style = MaterialTheme.typography.bodyMedium)
            Text(text = "MK 20,550.00", style = MaterialTheme.typography.titleLarge)
        }

        Spacer(modifier = Modifier.height(16.dp))

        val list = listOf(
            listOf(DataPoint(1f, 100f), DataPoint(5f, 5000f), DataPoint(10f, 15000f), DataPoint(15f, 20000f))
        )
        SampleLineGraph(lines = list)
    }
}

@Composable
fun SampleLineGraph(lines: List<List<DataPoint>>) {
    LineGraph(
        plot = LinePlot(
            listOf(
                LinePlot.Line(
                    lines[0],
                    LinePlot.Connection(color = OrangeYellow3, strokeWidth = 0.5.dp),
                    LinePlot.Intersection(color = AquaBlue, radius = 3.dp),
                    LinePlot.Highlight(color = DeepBlue),
                    LinePlot.AreaUnderLine(AquaBlue, 0.3f)
                )
            ),
//            grid = LinePlot.Grid(LightRed, steps = 4),
//        yAxis = LinePlot.YAxis(content = { min, offset, _ ->
//            for (it in 0 until 6) {
//                val value = it * offset + min
//
//                Text(
//                    text = "M",
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis,
////                    style = androidx.compose.material.MaterialTheme.typography.caption,
////                    color = androidx.compose.material.MaterialTheme.colors.onSurface
//                )
//            }
//        }),
            xAxis = LinePlot.XAxis(content = { min, offset, max ->
                for (it in 0 until 7) {
                    val value = it * offset + min
                    androidx.compose.material.Text(
                        text = "M",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = androidx.compose.material.MaterialTheme.typography.caption,
                        color = androidx.compose.material.MaterialTheme.colors.onSurface
                    )
                    if (value > max) {
                        break
                    }
                }
            })
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp).background(color = MaterialTheme.colorScheme.surface),
        onSelection = { xLine, points ->
            // Do whatever you want here
        }
    )
}