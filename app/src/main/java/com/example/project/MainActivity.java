package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//   กำหนกตัวแปล รูป ข้อความ
    ImageView imgme,imgbot ;
    TextView tMe,tBOT,tx_strat;
    TextView t_Hammer,t_gun,t_peper,t_lucky;
    int sctMe,sctBOT;   //กำหนกผลคะแนน


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        imgme = (ImageView)findViewById(R.id.imgme); // เชื่อมกับชื่อ id ใน activity main ของแต่ละอัน
        imgbot = (ImageView)findViewById(R.id.imgbot); // เชื่อมกับรูปฝั่งบอท
        tMe = (TextView)findViewById(R.id.tMe); // เชื่อมกับผลคะแนนของเรา
        tBOT = (TextView)findViewById(R.id.tBOT);   // เชื่อมคะแนนของบอท
        t_Hammer = (TextView)findViewById(R.id.t_Hammer);   // เชื่อมปุ่มค้อน
        t_gun = (TextView)findViewById(R.id.t_gun);// เชื่อมปุ่มกรรไกร
        t_peper = (TextView)findViewById(R.id.t_peper); // เชื่อมปุ่มกระดาษ
        t_lucky = (TextView)findViewById(R.id.t_lucky); //เชื่อมปุ่มสุ่ม
    }


    public void clickStrat(View v) { // กำหนดปุ่มเริ่มเกมให้เซ็ทค่า ผลคะแนนเป็น 0 เพื่อเริ่มใหม่
        sctMe = 0;
        sctBOT = 0;
        tMe.setText("Me >");
        tBOT.setText("Bot >");
    }

    public void clickHammer(View v) {
        imgme.setImageResource(R.drawable.kon_ng); // สร้างเมทธอดปุ่มค้อนที่เราเป็นคนเลืก

        Random rd = new Random(); // กำหนกให้บอท สุ่มไปด้วย
        int r = rd.nextInt(3);

        if (r == 0){
            imgbot.setImageResource(R.drawable.gadradpng); // ถ้าบอทเลือกกระดาษบอทจะชนะและนับคะแนน
            sctBOT++;
            tBOT.setText("Bot > "+sctBOT);
        }
        else if (r == 1){
            imgbot.setImageResource(R.drawable.gungai_ng); // ถ้าบอทเลือก กรรไกรเราจะชนะและนับคะแนน
            sctMe++;
            tMe.setText("Me > "+sctMe);
        }
        else if (r == 2){
            imgbot.setImageResource(R.drawable.kon_ng); // ถ้าบอทเลือกค้อนเหมือนกันจะไม่นับคะแนน
        }


    }
    public void clickPeper(View v) { // สร้างเมทธอด กระดาษที่เเราเป็นคนเลือก
        imgme.setImageResource(R.drawable.gadradpng);

        Random rd = new Random();
        int r = rd.nextInt(3);

        if (r == 0){
            imgbot.setImageResource(R.drawable.gadradpng); // ถ้าบอทเลือกกระดาษจะไม่นับคะแนนสุ่มใหม่
        }
        else if (r == 1){
            imgbot.setImageResource(R.drawable.gungai_ng); // ถ้าบอทเลือก กรรไกรบอทจะชนะและนับคะแนน
            sctBOT++;
            tBOT.setText("Bot > "+sctBOT);
        }
        else if (r == 2){
            imgbot.setImageResource(R.drawable.kon_ng); // ถ้าบอทเลือก ค้อนเราได้คะแนน
            sctMe++;
            tMe.setText("Me > "+sctMe);
        }
    }

    public void clickGungai(View v) {
        imgme.setImageResource(R.drawable.gungai_ng);  // ถสร้างเมทธอดกรรไกรเป็นอันที่เราเลือก
        Random rd = new Random();
        int r = rd.nextInt(3);

        if (r == 0){
            imgbot.setImageResource(R.drawable.gadradpng); // ถ้าบอทเลือกกระดาษบอทจะชนะและนับคะแนน
            sctMe++;
            tMe.setText("Me > "+sctMe);
        }
        else if (r == 1){
            imgbot.setImageResource(R.drawable.gungai_ng); // ถ้าบอทเลือกกรรไกรจะไม่ยับคะแนน เสมอ
        }
        else if (r == 2){
            imgbot.setImageResource(R.drawable.kon_ng); // ถ้าบอทเลือกค้อนบอทได้คะแนน
            sctBOT++;
            tBOT.setText("Bot > "+sctBOT);
        }
    }

///////////////
    public void clickRandom(View v) {

        imgme.setImageResource(R.drawable.kon_ng);
        Random rd = new Random();
        int r = rd.nextInt(3);
        if (r == 0) {
            imgbot.setImageResource(R.drawable.gadradpng);
        } else if (r == 1) {
            imgbot.setImageResource(R.drawable.gungai_ng);
        } else if (r == 2) {
            imgbot.setImageResource(R.drawable.kon_ng);
        }

        Random rd2 = new Random();
        int r2 = rd.nextInt(3); // สร้างเมทธอดปุ่มสุ่ม

        if (r2 == 0) {
            imgme.setImageResource(R.drawable.gadradpng); // เราสุ่มได้กระดาษ

            if (r == 0){} // // บอทสุ่มได้กระดาษจะเสมอ
            if (r == 1){
                sctBOT++;
                tBOT.setText("Bot > "+sctBOT); // บอทสุ่มได้กรรไกรจะชนะ
            }
            if (r == 2){
                sctMe++;
                tMe.setText("Me > "+sctMe);// บอทเลือกค้อนเราจะชนะและได้คะแนน
            }

        } else if (r2 == 1) {
            imgme.setImageResource(R.drawable.gungai_ng); // สุ่มได้กรรไกร

            if (r == 0){
                sctMe++;
                tMe.setText("Me > "+sctMe); // บอทสุ่มได้กระดาษเราจะชนะ
            }
            if (r == 1){ }  // ถ้าบอทสุ่มได้กรรไกร
            if (r == 2){
                sctBOT++;
                tBOT.setText("Bot > "+sctBOT); // บอทสุ่มได้ค้อนจะชนะ
            }

        } else if (r2 == 2) {
            imgme.setImageResource(R.drawable.kon_ng); // เราสุ่มได้ค้อน

            if (r == 0){
                sctBOT++;
                tBOT.setText("Bot > "+sctBOT);  // บอทสุ่มได้กระดาษจะชนะ
            }
            if (r == 1){
                sctMe++;
                tMe.setText("Me > "+sctMe); // บอทสุ่มได้กรรไกรเราชนะ
            }
            if (r == 2){} // ถบอทสุ่มได้ค้อน เสมอ

        }
    }

}
