package com.example.infinity.quiz02;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox checkBox1, checkBox2, checkBox3;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int marks = calculate();
                String status = "Fail";
                if(marks >= 3){
                    status = "Pass";
                }

                Intent i = new Intent(MainActivity.this, Result.class);
                i.putExtra("score", marks);
                i.putExtra("status", " "+ status);
                startActivity(i);
            }
        });

    }

    public int calculate(){
        int result = 0;
        // caculate and return result

        /* Question 1 */
        radioGroup = findViewById(R.id.bird);
        try{
            radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
            String bird = (String) radioButton.getText();
            if(bird.equals("Peacock")){
                result = result + 1;
            }
        }
        catch (NullPointerException e){
            System.out.println(e);
        }

        /* Question 2 */
         radioGroup = findViewById(R.id.animal);
         try{
             radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
             String animal = radioButton.getText().toString();
             if(animal.equals("Tigeress")){
                 result = result + 1;
             }
         }
         catch (NullPointerException e){
             System.out.println(e);
         }

        /* Question 3 */
        radioGroup = findViewById(R.id.song);
        try{
            radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
            String song = radioButton.getText().toString();
            if(song.equals("Vande Matram")){
                result = result + 1;
            }
        }
        catch (NullPointerException e){
            System.out.println(e);
        }

        /* Question 4 */
        radioGroup = findViewById(R.id.flower);
        try{
            radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
            String flower = radioButton.getText().toString();
            if(flower.equals("Lotus")){
                result = result + 1;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        /* Question 5 */
        checkBox1 =  findViewById(R.id.arjit);
        checkBox2 = findViewById(R.id.armaan);
        checkBox3 = findViewById(R.id.dhinchakpuja);
        if(checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked()){
            result = result + 1;
        }

        return result;
    }

    public void reset(View v){
        RadioGroup rg1, rg2, rg3, rg4;
        CheckBox chBox1, chBox2, chBox3;

        rg1 = findViewById(R.id.bird);
        rg2 = findViewById(R.id.animal);
        rg3 = findViewById(R.id.song);
        rg4 = findViewById(R.id.flower);

        chBox1 = findViewById(R.id.arjit);
        chBox2 = findViewById(R.id.armaan);
        chBox3 = findViewById(R.id.dhinchakpuja);

        /* clearCheck() is a method for radioGroup. It clears/unChecks the selected radio button*/
        rg1.clearCheck();
        rg2.clearCheck();
        rg3.clearCheck();
        rg4.clearCheck();

        if (chBox1.isChecked()) {
            chBox1.setChecked(false);
        }
        if (chBox2.isChecked()) {
            chBox2.setChecked(false);
        }
        if (chBox3.isChecked()) {
            chBox3.setChecked(false);
        }
    }

}
