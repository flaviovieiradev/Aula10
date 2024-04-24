
/*package com.example.aula10;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
*/
package com.example.aula10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private RadioGroup rdgAlter;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdgAlter = (RadioGroup) findViewById(R.id.rdgAlter);
        btnOK = (Button) findViewById(R.id.button);
        rdgAlter.setOnCheckedChangeListener(this);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String txt = "";
        if (rdgAlter.getCheckedRadioButtonId() == R.id.radioButton5) {
            txt = "Parabéns, alternativa correta!";
        } else {
            txt = "Você não acertou, tente novamente.";
        }
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Quem Descobriu o Brasil.");
        dlg.setMessage(txt);
        dlg.setPositiveButton("OK", null);
        dlg.show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton rdb = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(this, rdb.getText(), Toast.LENGTH_SHORT).show();
    }
}