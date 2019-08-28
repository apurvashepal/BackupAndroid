package com.example.applicationtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.applicationtask.Model.Product;
import com.example.applicationtask.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView randomText,mBookName;
    Button madd;
    TextView mcounter;
    double randomNumber;
    Product product;
    MyViewModel mViewModel;
    List<Product> productList;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomText= findViewById(R.id.text_random);
        mBookName=findViewById(R.id.product_info);
        madd=findViewById(R.id.add);
        madd.setOnClickListener(this);
        mcounter=findViewById(R.id.mycounter);
        randomNumber=  Math.random();
        product = new Product();
        product.setName("Power of your subconscious mind");
        int i = 200;
        product.setPrice(i);

            mViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
            randomText.setText(Double.toString(randomNumber));
            mBookName.setText(product.getName());
            mcounter.setText(Integer.toString(mViewModel.count));




    }

  /* private void displayList() {
        for(int count=0; count<productList.size();count++){
            Product display= productList.get(count);
        }
    }*/

  /*  private List<Product> getProductList() {
       Product product;

        product = new Product();

        product.setName("Power of your subconscious mind");
        int i = 200;
        product.setPrice(i);
        productList.add(product);

        product = new Product();

        product.setName("Everyone has a story");
        product.setPrice(150);
        productList.add(product);

      return productList;
    }*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("saveValue",randomNumber);
        outState.putParcelable("Product",product);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        randomNumber= savedInstanceState.getDouble("saveValue");
        generateRandom(randomNumber);
        Product savedProduct = savedInstanceState.getParcelable("Product");
        mBookName.setText(savedProduct.getName());

    }

    /**
     * Function To generate Random Number
     * param: void
     * return : void
     */
    private void generateRandom(Double randomNumber) {
        String text="Your Text is:"+ randomNumber;
        randomText.setText(text);

    }

    @Override
    public void onClick(View view) {
        mViewModel.count=  mViewModel.count+1;
        mcounter.setText(Integer.toString(mViewModel.count));
    }
}
