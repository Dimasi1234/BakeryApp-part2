package com.example.bakeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    private LinearLayout checkoutItemsContainer;
    private TextView checkoutTotalPrice;
    private Button btnProceedToPayment;
    private int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkoutItemsContainer = findViewById(R.id.checkout_items_container);
        checkoutTotalPrice = findViewById(R.id.checkout_total_price);
        btnProceedToPayment = findViewById(R.id.btn_checkout_payment);

        // Get items passed from CartActivity
        List<CartItem> cartItems = CartActivity.getCartItems(); // Assuming you maintain a static list in CartActivity

        if (cartItems != null && !cartItems.isEmpty()) {
            for (CartItem item : cartItems) {
                addItemToCheckout(item.getProductName(), item.getProductPrice(), item.getQuantity());
                totalPrice += item.getProductPrice() * item.getQuantity();
            }
        }

        checkoutTotalPrice.setText("Rp " + totalPrice);

        btnProceedToPayment.setOnClickListener(v -> {
            // Navigate to Payment Activity
            Intent intent = new Intent(CheckoutActivity.this, PaymentActivity.class);
            startActivity(intent);
        });
    }

    private void addItemToCheckout(String productName, int productPrice, int quantity) {
        View itemView = getLayoutInflater().inflate(R.layout.checkout_item, null);

        TextView itemName = itemView.findViewById(R.id.checkout_item_name);
        TextView itemPrice = itemView.findViewById(R.id.checkout_item_price);
        TextView itemQuantity = itemView.findViewById(R.id.checkout_item_quantity);

        itemName.setText(productName);
        itemPrice.setText("Rp " + productPrice);
        itemQuantity.setText("Qty: " + quantity);

        checkoutItemsContainer.addView(itemView);
    }
}
