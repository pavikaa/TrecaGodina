package com.example.orwma_lv5_pavicic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String[] Inspo={"Ne činite nikada ništa što se protivi vašoj savjesti, čak ako to od vas i država traži.","Život je kao vožnja bicikla. Da biste zadržali ravnotežu, morate se nastaviti kretati.","Ne žalim što su drugi pokrali moje ideje. Žalim što nemaju svoje.","Svi smo mi jedno. Ljudi su međusobno povezani nevidljivim silama.","Strast prema računici može otključati nove svjetove.","Kao slijepac nema pojma o bojama, tako ni mi nemamo pojma o načinu na koji svemogući Bog sve shvaća i razumije."};
    Random rand=new Random();
    Button Inspiration,EditDescription;
RadioButton RadioButtonOne,RadioButtonTwo,RadioButtonThree;
ImageView einstein,newton,tesla;
EditText editDescription;
TextView tveinstein,tvnewton,tvtesla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
    }
private void initializeUI(){
        this.Inspiration=(Button) findViewById(R.id.buttonInspiration);
        this.EditDescription=(Button) findViewById(R.id.btnDescription);
        this.einstein=(ImageView) findViewById(R.id.iv_tr1);
        this.newton=(ImageView) findViewById(R.id.iv_tr2);
        this.tesla=(ImageView) findViewById(R.id.iv_tr3);
        this.RadioButtonOne=(RadioButton) findViewById(R.id.rdbtnOne);
        this.RadioButtonTwo=(RadioButton) findViewById(R.id.rdbtnTwo);
        this.RadioButtonThree=(RadioButton) findViewById(R.id.rdbtnThree);
        this.editDescription=(EditText) findViewById(R.id.etDescription);
        this.tveinstein=(TextView) findViewById(R.id.einstein_info);
        this.tvnewton=(TextView) findViewById(R.id.newton_info);
        this.tvtesla=(TextView) findViewById(R.id.tesla_info);
        this.einstein.setOnClickListener(this);
        this.newton.setOnClickListener(this);
        this.tesla.setOnClickListener(this);
        this.Inspiration.setOnClickListener(this);
        this.EditDescription.setOnClickListener(this);
    }
public void RemoveImage(ImageView image)
{
    image.setVisibility(View.INVISIBLE);
}
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_tr1:
                RemoveImage(einstein);
                break;
            case R.id.iv_tr2:
                RemoveImage(newton);
                break;
            case R.id.iv_tr3:
                RemoveImage(tesla);
                break;
            case R.id.buttonInspiration:
                this.displayToast(Inspo[rand.nextInt(Inspo.length)]);
                break;
            case R.id.btnDescription:
                if(RadioButtonOne.isChecked())
                    tveinstein.setText(editDescription.getText());

                    else if (RadioButtonTwo.isChecked()){
                    tvnewton.setText(editDescription.getText());
                    }
                        else if (RadioButtonThree.isChecked()){
                    tvtesla.setText(editDescription.getText());
                    }
                            else
                    this.displayToast("Molim odaberite osobu.");
                break;
            default:
                break;
        }
    }
    private void displayToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}