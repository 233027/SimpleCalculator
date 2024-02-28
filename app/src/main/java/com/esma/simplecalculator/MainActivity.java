package com.esma.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number1Text;
    EditText number2Text;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1Text= findViewById(R.id.number1Text);
        number2Text= findViewById(R.id.number2Text);
        resultText = findViewById(R.id.textResult);
    }

    public void sum(View view){

        //Kullanıcın hesap makinesine string değer girmesini engellemek için de
        //tasarım kısımdan textin Input Type özelliğini number olarak ayarlamazı
        //yeterli.

        //Kullanıcı bize boş değer girmesin diğer kontrol etmemiz gerekiyor
        //bunu if else ile yapabiliriz. Boş olup olmadığını kontol etmek için aklımıza
        // == "" yapmak gelebilir ama text içine yazılan değerlerin boş olup
        // olmadığını böyle kontrol edemeyiz. Bunun için kullandığımız fonksiyon
        // matches() kullanırız.
        // matches(buraya ne girmesini istemediğimizi yazarız biz boşluk
        // istemediğimiz için "" bunu koyduk)
        if(number1Text.getText().toString().matches("") || number2Text.getText().toString().matches("")){
            resultText.setText("Enter Number");
        }
        else{
            //Kullanıcının yazdığı şeyi nasıl alırız?
            //girdiğimiz değer text biçiminde olduğu için onu rrakama çevirmeliyiz
            //text içindeki değeri "number1Text.getText().toString()" bu kot ile alıp
            //parsInt ettiğimiziz zaman hedefimize ulaşmız oluruz.


            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            int result = number1+number2;

            //set text bizden string bir değer isyiyor biz o yüzden int dğer olan result u
            //resultText.setText(result); böyle yazarsak çalıştırdığımız zaman program çöker
            //resultText.setText("Result:" + result); retuldu yazmadan önce "" için de
            // bir metin yazarsak resylu bizim için otomatik string e çeviriyor

            resultText.setText("Result:" + result);
        }



    }

    public void deduct(View view){

        if(number1Text.getText().toString().matches("") || number2Text.getText().toString().matches("")){
            resultText.setText("Enter Number");
        }
        else{
            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            int result = number1-number2;

            resultText.setText("Result:" + result);
        }

    }

    public void multiply(View view){
        if(number1Text.getText().toString().matches("") || number2Text.getText().toString().matches("")){
            resultText.setText("Enter Number");
        }
        else{
            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            int result = number1*number2;

            resultText.setText("Result:" + result);
        }
    }

    public void divide(View view){
        if(number1Text.getText().toString().matches("") || number2Text.getText().toString().matches("")){
            resultText.setText("Enter Number");
        }
        else if(number2Text.getText().toString().matches("0")){
            resultText.setText("Number 2 cannot be 0");
        }
        else{
            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            int result = number1/number2;

            resultText.setText("Result:" + result);
        }
    }
}