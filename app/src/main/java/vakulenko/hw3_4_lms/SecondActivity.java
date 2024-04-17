package vakulenko.hw3_4_lms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        double totalPrice = getIntent().getDoubleExtra("total_price", 0.0);
        TextView totalPriceTextView = findViewById(R.id.total_price_text);
        totalPriceTextView.setText(String.format("Итоговая стоимость комплекта: %.2f руб.", totalPrice));
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
