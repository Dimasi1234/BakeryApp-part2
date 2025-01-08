package com.example.bakeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private ImageView frame1Image, frame2Image, frame3Image, frame4Image, frame5Image, frame6Image;
    private TextView frame1Text, frame2Text, frame3Text, frame4Text, frame5Text, frame6Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        frame1Image = findViewById(R.id.product_image_1);
        frame2Image = findViewById(R.id.product_image_2);
        frame3Image = findViewById(R.id.product_image_3);
        frame4Image = findViewById(R.id.product_image_4);
        frame5Image = findViewById(R.id.product_image_5);

        frame1Text = findViewById(R.id.product_name_1);
        frame2Text = findViewById(R.id.product_name_2);
        frame3Text = findViewById(R.id.product_name_3);
        frame4Text = findViewById(R.id.product_name_4);
        frame5Text = findViewById(R.id.product_name_5);

        setupFrame(frame1Image, frame1Text, "Cookies", R.drawable.cookies, "Delicious chocolate chip cookies.", 5);
        setupFrame(frame2Image, frame2Text, "Donuts", R.drawable.donat, "Soft and tasty donuts.", 7);
        setupFrame(frame3Image, frame3Text, "Tart", R.drawable.tart, "Sweet and fruity tart.", 8);
        setupFrame(frame4Image, frame4Text, "Bread", R.drawable.roti, "Freshly baked bread.", 3);
        setupFrame(frame5Image, frame5Text, "Cupcake", R.drawable.cupcake, "Colorful and sweet cupcakes.", 6);
        setupFrame(frame6Image, frame6Text, "More", R.drawable.placeholder_image, "More products coming soon!", 0);
    }

    private void setupFrame(ImageView imageView, TextView textView, String productName, int productImageRes, String productDescription, int productPrice) {
        imageView.setImageResource(productImageRes);
        textView.setText(productName);

        imageView.setOnClickListener(v -> openProductDetail(productName, productImageRes, productDescription, productPrice));
        textView.setOnClickListener(v -> openProductDetail(productName, productImageRes, productDescription, productPrice));
    }

    private void openProductDetail(String name, int imageRes, String description, int price) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtra("product_name", name);
        intent.putExtra("product_image", imageRes);
        intent.putExtra("product_description", description);
        intent.putExtra("product_price", price);
        startActivity(intent);
    }
}
