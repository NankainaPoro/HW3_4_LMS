package vakulenko.hw3_4_lms;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Метод для перехода на вторую активность
    public void goToSecondActivity(View view) {
        // Получаем доступ к полям ввода для стоимости комплектующих
        EditText engineEditText = findViewById(R.id.engine_price);
        EditText transmissionEditText = findViewById(R.id.transmission_price);
        EditText bodyEditText = findViewById(R.id.body_price);

        // Получаем текст из полей ввода и удаляем лишние пробелы
        String enginePriceString = engineEditText.getText().toString().trim();
        String transmissionPriceString = transmissionEditText.getText().toString().trim();
        String bodyPriceString = bodyEditText.getText().toString().trim();

        // Проверяем, все ли поля ввода заполнены
        if (TextUtils.isEmpty(enginePriceString) || TextUtils.isEmpty(transmissionPriceString) || TextUtils.isEmpty(bodyPriceString)) {
            // Если не все заполнены, выводим сообщение об ошибке
            Toast.makeText(this, "Пожалуйста, введите все стоимости", Toast.LENGTH_SHORT).show();
            return; // Прерываем выполнение метода
        }

        // Преобразуем текст введенный пользователем в числа
        double enginePrice = Double.parseDouble(enginePriceString);
        double transmissionPrice = Double.parseDouble(transmissionPriceString);
        double bodyPrice = Double.parseDouble(bodyPriceString);

        // Вычисляем общую стоимость комплектующих
        double totalPrice = enginePrice + transmissionPrice + bodyPrice;

        // Создаем интент для перехода на вторую активность
        Intent intent = new Intent(this, SecondActivity.class);
        // Передаем общую стоимость второй активности
        intent.putExtra("total_price", totalPrice);
        // Запускаем вторую активность
        startActivity(intent);
    }
}
