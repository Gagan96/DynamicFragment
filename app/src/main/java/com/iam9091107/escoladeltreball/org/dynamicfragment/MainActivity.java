package com.iam9091107.escoladeltreball.org.dynamicfragment;

import android.net.sip.SipAudioCall;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragmentA.OnFragmentAInteractionListener, BlankFragmentB.OnFragmentBInteractionListener {


    private Button btn_fragment_a;
    private Button btn_fragment_b;
    private BlankFragmentA fragmentA;
    private BlankFragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup(){
        btn_fragment_a = (Button) findViewById(R.id.btn_fragment1);
        btn_fragment_b = (Button) findViewById(R.id.btn_fragment2);
        View.OnClickListener listenerA =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupFragmentA();
            }
        };
        View.OnClickListener listenerB =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupFragmentB();
            }
        };
        btn_fragment_a.setOnClickListener(listenerA);
        btn_fragment_b.setOnClickListener(listenerB);
//        fragmentA = BlankFragmentA.newInstance(null,null);
//        fragmentB = BlankFragmentB.newInstance(null,null);
    }

    private void setupFragmentB(){
        getFragmentManager()
                .beginTransaction()
                    .replace(R.id.contenidor, BlankFragmentB.newInstance("En Fragment B", null))
//                            .addToBackStack(null)
                                    .commit();
    }

    private void setupFragmentA() {
        getFragmentManager()
                .beginTransaction()
                    .replace(R.id.contenidor,BlankFragmentA.newInstance("En Fragment A", null))
//                            .addToBackStack(null)
                                .commit();
    }

    @Override
    public void onFragmentAInteraction(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentBInteraction(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
