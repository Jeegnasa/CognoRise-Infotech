import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView bmiTextView;
    private TextView classificationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        bmiTextView = findViewById(R.id.bmiTextView);
        classificationTextView = findViewById(R.id.classificationTextView);
    }

    public void calculateBMI(View view) {
        double weight = Double.parseDouble(weightEditText.getText().toString());
        double height = Double.parseDouble(heightEditText.getText().toString()) / 100; // Convert cm to meters

        double bmi = weight / (height * height);
        bmiTextView.setText("BMI: " + String.format("%.2f", bmi));

        String classification;
        if (bmi < 18.5) {
            classification = "Underweight";
        } else if (bmi < 25) {
            classification = "Normal weight";
        } else if (bmi < 30) {
            classification = "Overweight";
        } else {
            classification = "Obese";
        }
        classificationTextView.setText("Classification: " + classification);
    }
}
