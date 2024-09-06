package com.example.e_bankingapplication.ui.theme.screens.about



import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsScreen(navController: NavController) {
    val mContext = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("About Us") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // App Description
            Text(
                text = "Welcome to our eBanking Management App! We are dedicated to providing you with a seamless and secure banking experience. Our app offers a range of features to manage your financial transactions, handle client information, and more.",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Mission Statement
            Text(
                text = "Our Mission:",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "To revolutionize the banking experience by offering intuitive, secure, and reliable solutions that empower our users to manage their finances with confidence.",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Team Information
            Text(
                text = "Our Team:",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "We are a team of experienced developers, financial experts, and customer support professionals committed to delivering the best user experience. Our team is here to assist you and ensure that your banking needs are met with the highest level of service.",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Contact Information
            Text(
                text = "Contact Us:",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "For any inquiries or support, please reach out to us at:\n\nEmail: support@ebankingapp.com\nPhone: +1-800-123-4567\nAddress: 123 Bank Street, Finance City, FC 12345",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            //SMS
            Button(onClick = {
                val smsIntent=Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0713038425".toUri()
                smsIntent.putExtra("sms_body","Hello Musa,how was your day?")
                mContext.startActivity(smsIntent)

            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.Green),
                shape = RoundedCornerShape(10.dp)

            )

            {
                Text(text = "SMS?")
            }
            //sms

            Spacer(modifier = Modifier.height(10.dp))

            //Call
            Button(onClick = { val callIntent=Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0713038425".toUri()
                mContext.startActivity(callIntent) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.Green),
                shape = RoundedCornerShape(10.dp)

            )

            {
                Text(text = "CALL")
            }

            //call

            Spacer(modifier = Modifier.height(10.dp))

            //Email
            Button(onClick =    { val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("karaya123ali@gmail.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                mContext.startActivity(shareIntent) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.Green),
                shape = RoundedCornerShape(10.dp)

            )

            {
                Text(text = "EMAIL")
            }
            //Email

            Spacer(modifier = Modifier.height(10.dp))


            Button(onClick = {
                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share")) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.Green),
                shape = RoundedCornerShape(10.dp)

            )

            {
                Text(text = "SHARE")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutUsScreenPreview() {
    AboutUsScreen(rememberNavController())
}
