package com.example.musicshoponcompose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicshoponcompose.ui.theme.AbrilFatface
import com.example.musicshoponcompose.ui.theme.Montserrat

object Memory {
    const val gb128 = "128"
    const val gb256 = "256"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopBox() {
    var phonesList = listOf("IPhone 12", "Google Pixel 7", "One Plus 10 Pro", "Samsung S21 Pro")
    var nameValue by remember {
        mutableStateOf("")
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var selectedPhone by remember {
        mutableStateOf("IPhone 12")
    }
    val arrowRotation by animateFloatAsState(targetValue = if (isExpanded) 180f else 0f)

    var selectedMemory by remember {
        mutableStateOf(Memory.gb128)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(value = nameValue, onValueChange = {
            nameValue = it
        }, label = {
            Text(
                text = "Введите свое имя",
                fontSize = 12.sp, fontWeight = FontWeight.SemiBold, fontFamily = AbrilFatface
            )
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), placeholder = {
            Text(
                text = "Бот",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = AbrilFatface
            )
        })
        Image(
            painter = painterResource(id = R.drawable.background), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp), contentScale = ContentScale.Crop
        )
        Text(
            text = "Выберите смартфон", fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = {
                    isExpanded = it
                }) {
                TextField(
                    value = selectedPhone,
                    onValueChange = {},
                    textStyle =
                    LocalTextStyle.current.copy(
                        fontWeight = FontWeight.W600, color = MaterialTheme.colorScheme.primary
                    ),
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            modifier = Modifier.rotate(arrowRotation)
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(expanded = isExpanded,
                    onDismissRequest = { isExpanded = false }) {
                    for (phoneOption in phonesList) {
                        DropdownMenuItem(text = {
                            Text(
                                text = phoneOption,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Medium
                            )
                        }, onClick = {
                            isExpanded = false
                            selectedPhone = phoneOption
                        })
                    }
                }
            }
        }
        Image(
            painter = painterResource(
                id = when (selectedPhone) {
                    "IPhone 12" -> R.drawable.iphone
                    "Google Pixel 7" -> R.drawable.pixel
                    "One Plus 10 Pro" -> R.drawable.oneplus
                    "Samsung S21 Pro" -> R.drawable.samsung
                    else -> R.drawable.nokia
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .width(130.dp)
                .height(180.dp),
            contentScale = ContentScale.Fit
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Цена смартфона",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .weight(0.6f)
            )
            Text(
                text = "Память (ГБ)",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(0.4f)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 23.dp)
        ) {
            Text(
                text = when (selectedPhone) {
                    "IPhone 12" -> {
                        if (selectedMemory == Memory.gb128) {
                            "1000$"
                        } else {
                            "1350$"
                        }
                    }

                    "Google Pixel 7" -> {
                        if (selectedMemory == Memory.gb128) {
                            "500$"
                        } else {
                            "750$"
                        }
                    }

                    "One Plus 10 Pro" -> {
                        if (selectedMemory == Memory.gb128) {
                            "700$"
                        } else {
                            "900$"
                        }
                    }

                    else -> {
                        if (selectedMemory == Memory.gb128) {
                            "100$"
                        } else {
                            "200$"
                        }
                    }

                },
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.5f)
            )
            Row(
                modifier = Modifier.weight(0.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                RadioButton(
                    selected = selectedMemory == Memory.gb128,
                    onClick = { selectedMemory = Memory.gb128 },
                    colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                )
                Text(
                    text = Memory.gb128,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                RadioButton(
                    selected = selectedMemory == Memory.gb256,
                    onClick = { selectedMemory = Memory.gb256 },
                    colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                )
                Text(
                    text = Memory.gb256,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp).height(50.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Добавить в корзину", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }

    }
}