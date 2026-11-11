package com.ui.mobile.feature.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.mobile.R

@Composable
fun ProductCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp, 
                color = MaterialTheme.colorScheme.outline, 
                shape = RoundedCornerShape(18.dp)
            )
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.cola),
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .height(80.dp)
                .aspectRatio(1f)
        )
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Text(
            text = "Diet Coke", 
            fontSize = 16.sp, 
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        
        Text(
            text = "355ml, Price", 
            fontSize = 14.sp, 
            color = Color.Gray
        )
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$1.99", 
                fontSize = 18.sp, 
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add to cart",
                tint = Color.White,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary, 
                        shape = RoundedCornerShape(14.dp)
                    )
                    .padding(10.dp)
            )
        }
    }
}
