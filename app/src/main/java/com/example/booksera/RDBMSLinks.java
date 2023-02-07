package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class RDBMSLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_d_b_m_s_links);
        CardView rdbmsl1=findViewById(R.id.rdbmsl1);
        CardView rdbmsl2=findViewById(R.id.rdbmsl2);
        CardView rdbmsl3=findViewById(R.id.rdbmsl3);
        CardView rdbmsl4=findViewById(R.id.rdbmsl4);
        CardView rdbmsl5=findViewById(R.id.rdbmsl5);
        CardView rdbmsl6=findViewById(R.id.rdbmsl6);
        CardView rdbmsl7=findViewById(R.id.rdbmsl7);
        CardView rdbmsl8=findViewById(R.id.rdbmsl8);
        CardView rdbmsl9=findViewById(R.id.rdbmsl9);
        CardView rdbmsl10=findViewById(R.id.rdbmsl10);

        rdbmsl1.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/introduction-of-dbms-database-management-system-set-1/"));

        rdbmsl2.setOnClickListener(v -> gotoUrl("https://www.guru99.com/relational-data-model-dbms.html"));

        rdbmsl3.setOnClickListener(v -> gotoUrl("https://www.learnsqlonline.org/"));

        rdbmsl4.setOnClickListener(v -> gotoUrl("https://www.sqlshack.com/sql-join-clause-introduction-and-overview/"));

        rdbmsl5.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/sql/sql-operators.htm"));

        rdbmsl6.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/plsql/plsql_functions.htm"));

        rdbmsl7.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/sql/sql-using-views.htm"));

        rdbmsl8.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/plsql/index.htm"));

        rdbmsl9.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/plsql/plsql_procedures.htm"));

        rdbmsl10.setOnClickListener(v -> gotoUrl("https://www.tutorialspoint.com/plsql/plsql_triggers.htm"));

    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
