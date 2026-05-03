package com.example.letssopt.presentation.purchase


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R
import com.example.letssopt.database.PurchaseDatabase
import com.example.letssopt.presentation.purchase.PurchaseItem
import com.example.letssopt.presentation.purchase.PurchaseViewModel

@Composable
fun PurchaseScreen(
) {
    val context = LocalContext.current
    val viewModel: PurchaseViewModel = viewModel {
        val dao = PurchaseDatabase.getDatabase(context).PurchaseDAO()
        PurchaseViewModel(dao)
    }

    val savedItems by viewModel.savedItems.collectAsState()
    val savedTitles = savedItems.map { it.title }.toSet()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = "개별 구매",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.pretendard_bold))
        )

        Spacer(modifier = Modifier.height(45.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(viewModel.dummyItems) { item ->
                PurchaseItemCard(
                    item = item,
                    isSaved = item.title in savedTitles,
                    onSaveClick = { viewModel.saveItem(item) }
                )
            }
        }
    }
}

@Composable
fun PurchaseItemCard(
    item: PurchaseItem,
    isSaved: Boolean,
    onSaveClick: () -> Unit
) {
    Box() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = item.title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.pretendard_regular))
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_purchase_ticket),
            contentDescription = "개별 구매",
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 6.dp, end = 6.dp)
                .size(28.dp)
                .clickable(enabled = !isSaved) { onSaveClick() }
        )
    }
}