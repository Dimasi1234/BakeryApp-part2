package com.example.bakeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    private TextView totalPriceTextView;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Inisialisasi elemen
        totalPriceTextView = findViewById(R.id.cart_total_price);
        checkoutButton = findViewById(R.id.checkout_button);

        // Set Total Harga (contoh)
        double totalPrice = 25.00;
        totalPriceTextView.setText("Total: $" + totalPrice);

        // Aksi tombol checkout
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
