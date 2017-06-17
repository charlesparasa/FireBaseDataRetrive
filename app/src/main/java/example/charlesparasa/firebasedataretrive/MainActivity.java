package example.charlesparasa.firebasedataretrive;

import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import example.charlesparasa.model.Products;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mRef;
    private Button getProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getProducts = (Button)findViewById(R.id.get_product);
        getProducts.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {


        FirebaseDatabase.getInstance().getReference().child("products")
                .addListenerForSingleValueEvent(new ValueEventListener(){
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                       /* for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {

                            //Products products = productSnapshot.getChildren("Product_ID").getValue(Products.class);
                            Products products = productSnapshot.getValue(Products.class);

                            String productID = products.getproductID("");





                        }
*/


                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            //child is each element in the finished list
                            Map<String, Object> message = (Map<String, Object>) child.getValue();
                            Products product = new Products((String) message.get("Product_ID"),
                                    (String) message.get("Name"),
                                    (String) message.get("Image"));
                            System.out.println("name" + product.getProductName());


                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

    }
}
