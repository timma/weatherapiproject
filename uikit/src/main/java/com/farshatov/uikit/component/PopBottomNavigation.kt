package com.farshatov.uikit

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.farshatov.common.navigation.NavigationItem
import com.farshatov.uikit.resources.UiColors

@Composable
fun PopBottomNavigation(navController: NavController, items: List<NavigationItem>) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(bottom = 6.dp, start = 6.dp, end = 6.dp)
    ) {
        Divider(thickness = 1.dp, color = UiColors.BLACK.value.copy(0.4f))
        BottomNavigation(
            backgroundColor = UiColors.WHITE.value,
            contentColor = UiColors.BLACK.value
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val context = LocalContext.current

            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            tint = UiColors.UNSPECIFIED.value,
                            contentDescription = context.getString(item.title),
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.title),
                            fontSize = 6.sp
                        )
                    },
                    selected = currentRoute == item.route,
                    alwaysShowLabel = true,
                    onClick = {
                        navController.navigate(item.route)
                    },
                    selectedContentColor = UiColors.BLACK.value,
                    unselectedContentColor = UiColors.BLACK.value.copy(0.4f)
                )
            }
        }
    }
}
