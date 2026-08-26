package com.sapliogluyazilim.cepkrtasiyem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> yayinevleri = new ArrayList<String>();
    ArrayList<String> kirtasiyeler = new ArrayList<String>();

    Connection con;
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
        kirtasiyeler.add("0");


        con=SQLConnection();


        try {
            int i=1;
            while(i<3) {
                if(con!=null){
                    String Q="SELECT * FROM `Kirtasiyeler` WHERE '"+i+"'";

                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(Q);
                    while(rs.next()){
                        kirtasiyeler.add(rs.getString(i));
                    }
                    i++;
                }
            }
        }catch (Exception e){Log.e("hata2 ",e.getMessage());}


        try {
            int i=1;
            while(i<3) {
                if(con!=null){
                    String Q="SELECT * FROM `Kirtasiyeler` WHERE '"+i+"'";

                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(Q);
                    while(rs.next()){
                        kirtasiyeler.add(rs.getString(i));
                    }
                    i++;
                }
            }
        }catch (Exception e){Log.e("hata2 ",e.getMessage());}
        try {
            int i=1;
            while(i<3) {
                if(con!=null){
                    String Q="SELECT * FROM `Kirtasiyeler` WHERE '"+i+"'";

                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(Q);
                    while(rs.next()){
                            kirtasiyeler.add(rs.getString(i));
                    }
                    i++;
                }
            }
        }catch (Exception e){Log.e("hata2 ",e.getMessage());}
        Button btnget=(Button)findViewById(R.id.button);
        EditText edittexta=(EditText) findViewById(R.id.editTextNumber);



        btnget.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){

                con=SQLConnection();

                try {
                    if(con!=null){
                        String Q="SELECT* FROM AnaTablo WHERE id='2'";

                        Statement st=con.createStatement();
                        ResultSet rs=st.executeQuery(Q);
                        while(rs.next()){
                            edittexta.setText(rs.getString(3));

                        }
                    }
                }catch (Exception e){
                    Log.e("hata ",e.getMessage());
                }

            }
        });


    }

    @SuppressLint("NewApi")
    public Connection SQLConnection(){

        // Database endpoint and credentials are supplied outside version control.
        StrictMode.ThreadPolicy tp= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        String ConURL=null;

        try {
            if (ConnectionConfig.CONNECTION_URL.trim().isEmpty()) {
                Log.w("database", "No database connection URL has been configured.");
                return null;
            }
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            ConURL = ConnectionConfig.CONNECTION_URL;
            Log.w("deniyo", "con");
            con= DriverManager.getConnection(ConURL);
            Log.w("hata yok", "hata yok");
        }
        catch (Exception e){
            Log.e("1.hata",e.getMessage());
        }
        return con;
    }
}
