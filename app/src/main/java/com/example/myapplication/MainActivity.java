package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bd,bh,bdot,bc,bs,b0,br;
    EditText txt;
    String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.one);
        b1.setOnClickListener(this);
        b2=(Button) findViewById(R.id.two);
        b2.setOnClickListener(this);
        b3=(Button) findViewById(R.id.three);
        b3.setOnClickListener(this);
        b4=(Button) findViewById(R.id.four);
        b4.setOnClickListener(this);
        b5=(Button) findViewById(R.id.five);
        b5.setOnClickListener(this);
        b6=(Button) findViewById(R.id.six);
        b6.setOnClickListener(this);
        b7=(Button) findViewById(R.id.seven);
        b7.setOnClickListener(this);
        b8=(Button) findViewById(R.id.eight);
        b8.setOnClickListener(this);
        b9=(Button) findViewById(R.id.nine);
        b9.setOnClickListener(this);
        b0=(Button) findViewById(R.id.zero);
        b0.setOnClickListener(this);
        bh=(Button) findViewById(R.id.hash);
        bh.setOnClickListener(this);
        bdot=(Button) findViewById(R.id.dot);
        bdot.setOnClickListener(this);
        bd=(Button) findViewById(R.id.del);
        bd.setOnClickListener(this);
        bc=(Button) findViewById(R.id.call);
        bc.setOnClickListener(this);
        bs=(Button) findViewById(R.id.save);
        bs.setOnClickListener(this);
        br=(Button) findViewById(R.id.recall);
        br.setOnClickListener(this);
        txt=(EditText) findViewById(R.id.editText);
        txt.setText("");
    }

    public void onClick(View v){
        if(v.equals(b1)) txt.append("1");
        else if(v.equals(b2)) txt.append("2");
        else if(v.equals(b3)) txt.append("3");
        else if(v.equals(b4)) txt.append("4");
        else if(v.equals(b5)) txt.append("5");
        else if(v.equals(b6)) txt.append("6");
        else if(v.equals(b7)) txt.append("7");
        else if(v.equals(b8)) txt.append("8");
        else if(v.equals(b9)) txt.append("9");
        else if(v.equals(bh)) txt.append("#");
        else if(v.equals(b0)) txt.append("0");
        else if(v.equals(bdot)) txt.append("*");
        else if(v.equals(bs)){
            Intent contactIntent=new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,txt.getText().toString());
            startActivity(contactIntent);
        }
        if(v.equals(br)){
            Intent i=new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+x));
            startActivity(i);
        }
        else if(v.equals(bd)){
            String data=txt.getText().toString();
            if(data.length()>0)
                txt.setText(data.substring(0,data.length()-1));
            else
                txt.setText("");
        }
        bc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data=txt.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+data));
                startActivity(intent);
            }
        });

    }
}