package com.example.android.emailjustjava;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.x;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        String message = CreateOrderSummary();


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Ordered For");
        intent.putExtra(Intent.EXTRA_TEXT,CreateOrderSummary() );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    private String CreateOrderSummary() {


        int topping1,topping2;

        //WHIPPED CREAM CHECKED BOX
        CheckBox whippedCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);

        //FOR GETTING THAT CHECKBOX IS CHECKED OR NOT
        boolean check = whippedCheckBox.isChecked();

        //NOT NECESSARY BUT DID FOR MAKING TRUE/FALSE IN UPPER CASE
        String str = String.valueOf(check).toUpperCase();


        //CHOCOLATE CHECKBOX
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean check2 = chocolateCheckBox.isChecked();
        String str2 = String.valueOf(check2).toUpperCase();

        if(check)
        {
            topping1 = 5;
        }
        else
            topping1 = 0;

        if(check2)
        {
            topping2=10;
        }
        else
            topping2=0;


        int price = calculatePrice() + topping1 + topping2;


//CUSTOMER NAME BY USER INPUT
        EditText txt = (EditText) findViewById(R.id.name_id);
        String name = txt.getText().toString();

        String priceMessage = "NAME: " + name;
        priceMessage += "\nQUANTITY: " + quantity + "\nWHIPPED CREAM ADDED? : \t" +
                str + "\nCOST: " + topping1 + "\nCHOCOLATE ADDED? : \t" + str2 + "\n COST: " + topping2 +
                "\n TOTAL: \t" + price + "\nTHANKYOU ";

        return priceMessage;
          }

    int quantity = 1;

    public void increment(View view) {
        if(quantity == 100)
        {   //SHOWS ERROR MESSAGE
            Toast.makeText(this,"YOU CAN NOT HAVE MORE THAN 100 COFFEE",Toast.LENGTH_SHORT).show();
            //NOTHING TO DO NOW
            return;
        }

        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {

        if(quantity == 1)
        {   //TOAST SHOWS ERROR MESSAGE
            Toast.makeText(this,"YOU CAN NOT HAVE LESS THAN 1 COFFEE",Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }




}