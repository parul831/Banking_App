package com.example.bankbasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.bankbasic2.data.myDbHandler;
import com.example.bankbasic2.model.Accounts;
import com.example.bankbasic2.model.Transactions;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.viewusers);
       

       myDbHandler db=new myDbHandler(MainActivity.this);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {
            //Adding accounts
            Accounts anushka = new Accounts();
            anushka.setName("Anushka Mathur");
            anushka.setEmail("anushkamathur908@gmail.com");
            anushka.setPhone("8982037485");
            anushka.setBalance(9000);
            db.addAccount(anushka);


            Accounts brijesh = new Accounts();
            brijesh.setName("Brijesh Singh");
            brijesh.setEmail("brijesh1234@gmail.com");
            brijesh.setPhone("7890346570");
            brijesh.setBalance(900);
            db.addAccount(brijesh);

            Accounts rajni = new Accounts();
            rajni.setName("Rajni Sharma");
            rajni.setEmail("rajnisharma987@gmail.com");
            rajni.setPhone("9008760914");
            rajni.setBalance(102930);
            db.addAccount(rajni);

            Accounts karan = new Accounts();
            karan.setName("Karan Patel");
            karan.setEmail("patelkaran123@gmail.com");
            karan.setPhone("97788340123");
            karan.setBalance(5000);
            db.addAccount(karan);

            Accounts rishabh = new Accounts();
            rishabh.setName("Rishabh Shaw");
            rishabh.setEmail("rishabh.shaw@gmail.com");
            rishabh.setPhone("7668812345");
            rishabh.setBalance(100020);
            db.addAccount(rishabh);

            Accounts yashaswi = new Accounts();
            yashaswi.setName("Yashaswi Khanna");
            yashaswi.setEmail("yashaswikhanna12@gmail.com");
            yashaswi.setPhone("7224471629");
            yashaswi.setBalance(19000);
            db.addAccount(yashaswi);

            Accounts shruti = new Accounts();
            shruti.setName("Shruti");
            shruti.setEmail("shruti136@gmail.com");
            shruti.setPhone("9123456780");
            shruti.setBalance(1200);
            db.addAccount(shruti);

            Accounts jyoti = new Accounts();
            jyoti.setName("Jyoti Mehra");
            jyoti.setEmail("jyoti.mehra197@gmail.com");
            jyoti.setPhone("9772251014");
            jyoti.setBalance(120);
            db.addAccount(jyoti);


            Accounts pallavi = new Accounts();
            pallavi.setName("Pallavi Chakraborty");
            pallavi.setEmail("pallavi12chakraborty@gmail.com");
            pallavi.setPhone("9891265497");
            pallavi.setBalance(121300);
            db.addAccount(pallavi);

            Accounts vikrant = new Accounts();
            vikrant.setName("Vikrant Kumar");
            vikrant.setEmail("vikrant.kumar192@gmail.com");
            vikrant.setPhone("9192001928");
            vikrant.setBalance(71000);
            db.addAccount(vikrant);


       Log.d("sid","Inserted all");
       SharedPreferences.Editor editor = prefs.edit();
          editor.putBoolean("firstTime", true);
           editor.commit();
        }



        //Get all accounts
        List<Accounts> allAccounts=db.getAllAccounts();
        for(Accounts accounts:allAccounts)
        {
            Log.d("sid","Account: "+accounts.getId1()+"\n"+
                    "Name: "+accounts.getName() +"\n"+
                    "Email: "+accounts.getEmail()+"\n"+
                    "PhoneNO: "+accounts.getPhone()+"\n"+
                    "Balance: "+accounts.getBalance());
        }


        //Get all transactions
        List<Transactions> allTransactions=db.getAllTransactions();
        for(Transactions transactions:allTransactions)
        {
            Log.d("sid","Sender's Account: "+transactions.getS_acc()+"\n"+
                    "Sender's Name: "+transactions.getS_name() +"\n"+
                    "Receiver's Account: "+transactions.getR_acc()+"\n"+
                    "Receiver's Name: "+transactions.getR_name() +"\n"+
                    "Transaction amount: "+transactions.getT_amt()+"\n");
        }
        Log.d("count","Number of rows in Accounts:"+db.getAccountCount());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountList();
            }
        });

    }
    public void openAccountList()
    {
        Intent intent=new Intent(this,AccountList.class);
        startActivity(intent);
    }

}