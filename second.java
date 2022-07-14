//1=====================
package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnone, btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnzero;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Button btnClear, btnEqual, btnDot;
    EditText txtResult;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnone=(Button) findViewById(R.id.btn_1);
        btnone.setOnClickListener(this);

        btntwo=(Button) findViewById(R.id.btn_2);
        btntwo.setOnClickListener(this);

        btnthree=(Button) findViewById(R.id.btn_3);
        btnthree.setOnClickListener(this);

        btnfour=(Button) findViewById(R.id.btn_4);
        btnfour.setOnClickListener(this);

        btnfive=(Button) findViewById(R.id.btn_5);
        btnfive.setOnClickListener(this);

        btnsix=(Button) findViewById(R.id.btn_6);
        btnsix.setOnClickListener(this);

        btnseven=(Button) findViewById(R.id.btn_7);
        btnseven.setOnClickListener(this);

        btneight=(Button) findViewById(R.id.btn_8);
        btneight.setOnClickListener(this);

        btnnine=(Button) findViewById(R.id.btn_9);
        btnnine.setOnClickListener(this);

        btnzero=(Button) findViewById(R.id.btn_0);
        btnzero.setOnClickListener(this);

        btnAdd=(Button) findViewById(R.id.btn_plus);
        btnAdd.setOnClickListener(this);

        btnSub=(Button) findViewById(R.id.btn_minus);
        btnSub.setOnClickListener(this);

        btnMul=(Button) findViewById(R.id.btn_mul);
        btnMul.setOnClickListener(this);

        btnDiv=(Button) findViewById(R.id.btn_div);
        btnDiv.setOnClickListener(this);

        btnDot=(Button) findViewById(R.id.btn_dot);
        btnDot.setOnClickListener(this);

        btnClear=(Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);

        btnEqual=(Button) findViewById(R.id.btn_equals);
        btnEqual.setOnClickListener(this);

        txtResult=(EditText) findViewById(R.id.Edit_Txt);
        txtResult.setText("");

    }

    @Override
    public void onClick(View v) {
           if(v.equals(btnone))
               txtResult.append("1");
           if(v.equals(btntwo))
               txtResult.append("2");
           if(v.equals(btnthree))
                txtResult.append("3");
        if(v.equals(btnfour))
            txtResult.append("4");
        if(v.equals(btnfive))
            txtResult.append("5");
        if(v.equals(btnsix))
            txtResult.append("6");
        if(v.equals(btnseven))
            txtResult.append("7");
        if(v.equals(btneight))
            txtResult.append("8");
        if(v.equals(btnnine))
            txtResult.append("9");
        if(v.equals(btnzero))
            txtResult.append("0");
        if(v.equals(btnDot))
            txtResult.append(".");
        if(v.equals(btnAdd))
            txtResult.append("+");
        if(v.equals(btnSub))
            txtResult.append("-");
        if(v.equals(btnMul))
            txtResult.append("*");
        if(v.equals(btnDiv))
            txtResult.append("/");
        if(v.equals(btnClear))
            txtResult.setText("");
        if(v.equals(btnEqual))
        {
            try {
                 String data = txtResult.getText().toString();
                 if(data.contains("/")){
                     divide(data);
                 } else if(data.contains("*")){
                     multiplication(data);
                 } else if(data.contains("+")){
                     addition(data);
                 } else if(data.contains("-")){
                     subtraction(data);
                 }
            } catch(Exception e){
                displayInvalidMessage("Invalid Input");
            }
        }

    }

    private void displayInvalidMessage(String mes) {
        Toast.makeText(getBaseContext(),mes,Toast.LENGTH_LONG).show();

    }

    private void subtraction(String data) {
           String[] operands=data.split("-");
           if(operands.length==2){
               double operand1=Double.parseDouble(operands[0]);
               double operand2=Double.parseDouble(operands[1]);
               double result=operand1-operand2;
               txtResult.setText(String.valueOf(result));
           } else{
               displayInvalidMessage("Invalid Input");
           }
    }

    private void addition(String data) {
        String[] operands=data.split(Pattern.quote("+"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1+operand2;
            txtResult.setText(String.valueOf(result));
        } else{
            displayInvalidMessage("Invalid Input");
        }
    }

    private void multiplication(String data) {
        String[] operands=data.split(Pattern.quote("*"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1*operand2;
            txtResult.setText(String.valueOf(result));
        } else{
            displayInvalidMessage("Invalid Input");
        }
    }

    private void divide(String data) {
        String[] operands=data.split("/");
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1/operand2;
            txtResult.setText(String.valueOf(result));
        } else{
            displayInvalidMessage("Invalid Input");
        }
    }
}

//4=======================================
package com.example.prg4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    boolean running;
    int[] ia=new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn_wall);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!running){
            new Timer().schedule(new MyTimer(),0,3000);
            running=true;
        }

    }

    private class MyTimer extends TimerTask {

        @Override
        public void run() {
            try {
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(5)]));
            }catch(IOException e){}

        }
    }
}
//5============================
package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonStart, buttonStop;
    TextView counterValue;
    public int counter=0;
    public boolean running=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStart=(Button)findViewById(R.id.btn_start);
        buttonStart.setOnClickListener(this);
        buttonStop=(Button)findViewById(R.id.btn_stop);
        buttonStop.setOnClickListener(this);
        counterValue=(TextView)findViewById(R.id.txt_value);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(buttonStart)){
            counterStart();
        } else if(v.equals(buttonStop)) {
            counterStop();
        }

    }

    private void counterStop() {
        this.running=false;
        //buttonStart.setEnabled(true);
        //buttonStop.setEnabled(false);
    }

    private void counterStart() {
        counter=0;
        running=true;
        System.out.println("Start ->"+Thread.currentThread().getName());
        new MyCounter().start();
        //buttonStart.setEnabled(false);
        //buttonStop.setEnabled(true);

    }

    Handler handler = new Handler(Looper.getMainLooper())
    {
        public void handleMessage(Message mes){
            counterValue.setText(String.valueOf(mes.what));
        }
    };


    class MyCounter extends Thread{
        public void run()
        {
            System.out.println("MyCounter ->"+Thread.currentThread().getName());
            while(running){
                counter++;
                handler.sendEmptyMessage(counter);
                try{
                    Thread.sleep(1000);
                } catch(Exception e){}

            }
        }
    }
}
//6=====================
//main-----------
package com.computerlabspace.parsexmlandjson_program6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button parseXMLBtn, parseJSONBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseXMLBtn = (Button) findViewById(R.id.main_parse_xml_btn_id);
        parseJSONBtn = (Button) findViewById(R.id.main_parse_json_id);
        parseXMLBtn.setOnClickListener(this);
        parseJSONBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(parseXMLBtn)) {
            // Intent will act like a broadcaster
            Intent intent = new Intent(this,ViewDataActivity.class);
            intent.putExtra("dataType", "xml");
            startActivity(intent);
        } else if(view.equals(parseJSONBtn)) {
            Intent intent = new Intent(this,ViewDataActivity.class);
            intent.putExtra("dataType", "json");
            startActivity(intent);
        }
    }
}
//viewDataActivity----
package com.computerlabspace.parsexmlandjson_program6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ViewDataActivity extends AppCompatActivity {

    TextView xmlContentTextView, jsonContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        xmlContentTextView = (TextView) findViewById(R.id.view_xml_content_id);
        jsonContentTextView = (TextView) findViewById(R.id.view_json_content_id);
        Intent intent = getIntent();
        String dataType = intent.getStringExtra("dataType");
        if(dataType.equals("xml")) {
            xmlContentTextView.setText("Test xml parsed content");
            parseXML();
        } else if(dataType.equals("json")) {
            jsonContentTextView.setText("Test json parsed content");
            parseJSON();
        }
    }

    public void parseXML() {
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("weather.xml");
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(inputStream);
            doc.normalize();
            NodeList nodeList = doc.getElementsByTagName("weather");
            for(int i=0; i<nodeList.getLength();i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    xmlContentTextView.setText("City_Name: "+element.getElementsByTagName("city_name").item(0).getTextContent() + "\n");
                    xmlContentTextView.append("Latitude: "+element.getElementsByTagName("latitude").item(0).getTextContent() + "\n");
                    xmlContentTextView.append("Longitude: "+element.getElementsByTagName("longitude").item(0).getTextContent() + "\n");
                    xmlContentTextView.append("Temperature: "+element.getElementsByTagName("temperature").item(0).getTextContent() + "\n");
                    xmlContentTextView.append("Humidity: "+element.getElementsByTagName("humidity").item(0).getTextContent());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void parseJSON() {
        try (InputStream inputStream = getAssets().open("weather.json")) {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            String jsonString = new String(data);
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject weather = jsonObject.getJSONObject("weather");
            jsonContentTextView.setText("City_Name: "+weather.getString("city_name") + "\n");
            jsonContentTextView.append("Latitude: "+weather.getString("latitude") + "\n");
            jsonContentTextView.append("Longitude: "+weather.getString("longitude") + "\n");
            jsonContentTextView.append("Temperature: "+weather.getString("temperature") + "\n");
            jsonContentTextView.append("Humidity: "+weather.getString("humidity") + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
//7==========================
package com.example.program7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity<AppCompatActivity> extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    Button btnSpeak;
    EditText txtSpeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSpeak=(EditText)findViewById(R.id.edt_txt);
        btnSpeak=(Button)findViewById(R.id.btn_speech);
        btnSpeak.setOnClickListener(this);
        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);

    }

    @Override
    public void onClick(View v) {
        String text=txtSpeak.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    public void onInit(int status) {
        if(status!=TextToSpeech.ERROR){
            Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_LONG).show();
        }
    }
}
//8============================
package com.example.program7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity<AppCompatActivity> extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    Button btnSpeak;
    EditText txtSpeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSpeak=(EditText)findViewById(R.id.edt_txt);
        btnSpeak=(Button)findViewById(R.id.btn_speech);
        btnSpeak.setOnClickListener(this);
        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);

    }

    @Override
    public void onClick(View v) {
        String text=txtSpeak.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    public void onInit(int status) {
        if(status!=TextToSpeech.ERROR){
            Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_LONG).show();
        }
    }
}
