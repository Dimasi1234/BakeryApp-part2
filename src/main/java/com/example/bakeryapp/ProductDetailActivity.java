package com.example.bakeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImageDetail;
    private TextView productNameDetail, productPriceDetail, productDescriptionDetail;
    private Button addToCartButton, buyNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productImageDetail = findViewById(R.id.product_image_detail);
        productNameDetail = findViewById(R.id.product_name_detail);
        productPriceDetail = findViewById(R.id.product_price_detail);
        productDescriptionDetail = findViewById(R.id.product_description_detail);
        addToCartButton = findViewById(R.id.add_to_cart_button);
        buyNowButton = findViewById(R.id.buy_now_button);

        Intent intent = getIntent();
        String productName = intent.getStringExtra("product_name");
        String productDescription = intent.getStringExtra("product_description");
        int productPrice = intent.getIntExtra("product_price", 0);
        int productImage = intent.getIntExtra("product_image", R.drawable.placeholder_image);

        productNameDetail.setText(productName);
        productDescriptionDetail.setText(productDescription);
        productPriceDetail.setText("Price: $" + productPrice);
        productImageDetail.setImageResource(productImage);

        addToCartButton.setOnClickListener(v -> {
            Intent cartIntent = new Intent(this, CartActivity.class);
            cartIntent.putExtra("product_name", productName);
            cartIntent.putExtra("product_price", productPrice);
            startActivity(cartIntent);
        });

        buyNowButton.setOnClickListener(v -> {
            Intent checkoutIntent = new Intent(this, CheckoutActivity.class);
            checkoutIntent.putExtra("product_name", productName);
            checkoutIntent.putExtra("product_price", productPrice);
            startActivity(checkoutIntent);
        });
    }
}
