package com.example.booksera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class CSLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_s_links);
        CardView csl1=findViewById(R.id.csl1);
        CardView csl2=findViewById(R.id.csl2);
        CardView csl3=findViewById(R.id.csl3);
        CardView csl4=findViewById(R.id.csl4);
        CardView csl5=findViewById(R.id.csl5);
        CardView csl6=findViewById(R.id.csl6);
        CardView csl7=findViewById(R.id.csl7);
        CardView csl8=findViewById(R.id.csl8);
        CardView csl9=findViewById(R.id.csl9);
        CardView csl10=findViewById(R.id.csl10);
        CardView csl11=findViewById(R.id.csl11);

        csl1.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/threats-to-information-security/"));

        csl2.setOnClickListener(v -> gotoUrl("https://codespaze.com/types-of-attack-in-computer-security/#:~:text=Types%20of%20Attack%3A%201%20MALWARE%3A%20Malware%20is%20used,INFECTORS%3A%20%205%20STEALTH%20VIRUSES%3A%20%20More%20items"));

        csl3.setOnClickListener(v -> gotoUrl("https://www.howtogeek.com/173478/10-important-computer-security-practices-you-should-follow/#:~:text=%20Basic%20Computer%20Security%3A%20How%20to%20Protect%20Yourself,This%20may%20seem%20obvious%2C%20but%20it...%20More%20"));

        csl4.setOnClickListener(v -> gotoUrl("https://searchsecurity.techtarget.com/definition/access-control#:~:text=%20The%20main%20models%20of%20access%20control%20are,the%20system%20administrator%20defines%20the%20rules...%20More%20"));

        csl5.setOnClickListener(v -> gotoUrl("https://digitalguardian.com/blog/what-operational-security-five-step-process-best-practices-and-more"));

        csl6.setOnClickListener(v -> gotoUrl("https://www.techopedia.com/definition/1778/encryption-algorithm#:~:text=An%20encryption%20algorithm%20is%20a,encrypt%20electronic%20data%20or%20numbers.\""));

        csl7.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/caesar-cipher-in-cryptography/"));

        csl8.setOnClickListener(v -> gotoUrl("https://www.codexpedia.com/cryptography/shift-ciphers/"));

        csl9.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/vigenere-cipher/"));

        csl10.setOnClickListener(v -> gotoUrl("https://www.cisco.com/c/en/us/products/security/what-is-network-security.html"));

        csl11.setOnClickListener(v -> gotoUrl("https://www.geeksforgeeks.org/system-security/"));

    }

    private void gotoUrl(String s) {

        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}