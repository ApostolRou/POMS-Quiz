package com.example.qaa;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level2);

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.text_left); //Путь к левому тексту
        final TextView text_right = findViewById(R.id.text_right); //Путь к правому тексту




        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        ImageView previewimg = (ImageView)dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.previewim2);

        TextView textdescription = (TextView)dialog.findViewById(R.id.description);
        textdescription.setText(R.string.leveltwo);

       // LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.drawable.preview_background2);

        TextView btn_close = (TextView)dialog.findViewById(R.id.btnclose);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);finish();

                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });

        Button btncontinue = (Button) dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    dialog.dismiss();

            }
        });

        dialog.show();

        //_______________________________________________________________________________

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);

        //
        TextView textdescriptionend = (TextView)dialogEnd.findViewById(R.id.descriptionend);
        textdescriptionend.setText(R.string.leveltwoend);
        //

        TextView btn_close2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btn_close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);finish();

                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });

        Button btncontinue2 = (Button) dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Level2.this, Level3.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }

                dialogEnd.dismiss();

            }
        });


        //_______________________________________________________________________________

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);finish();

                }catch (Exception e){

                }
            }
        });

        //массив для прогресса
        final int[] progress = {
                R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10,


        };

        //анимация началo
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);
        //анимация конец

        numLeft = random.nextInt(10);
        Glide.with(this).load(array.images2[numLeft]).into(img_left);
        text_left.setText(array.texts2[numLeft]);

        numRight = random.nextInt(10);

        while (numLeft == numRight){
            numRight = random.nextInt(10);
        }

        Glide.with(this).load(array.images2[numRight]).into(img_right);
        text_right.setText(array.texts2[numRight]);

        //нажатие на левую картинку
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //касание картинки
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //коснулся кортинки
                    img_right.setEnabled(false);
                    if (numLeft>numRight){
                        img_left.setImageResource(R.drawable.img_true);
                    }else{
                        img_left.setImageResource(R.drawable.img_false);
                    }

                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    //отпустил касание
                    if (numLeft>numRight){
                        if (count<10){
                            count++;
                        }

                        for (int i=0; i<10; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }else{

                        if (count>0){
                            if (count==1){
                                count=0;
                            }else {count=count-2;}
                        }
                        for (int i=0; i<9; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }
                    if (count==10){

                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);

                        if (level>2){

                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",3);
                            editor.commit();
                        }

                        //выход из уровня
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(10);
                        Glide.with(getApplicationContext()).load(array.images2[numLeft]).into(img_left);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]);

                        numRight = random.nextInt(10);

                        while (numLeft == numRight){
                            numRight = random.nextInt(10);
                        }

                        Glide.with(getApplicationContext()).load(array.images2[numRight]).into(img_right);

                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[numRight]);
                        img_right.setEnabled(true);
                    }
                }

                return true;
            }
        });

        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //касание картинки
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //коснулся кортинки
                    img_left.setEnabled(false);
                    if (numRight>numLeft){
                        img_right.setImageResource(R.drawable.img_true);
                    }else{
                        img_right.setImageResource(R.drawable.img_false);
                    }

                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    //отпустил касание
                    if (numRight>numLeft){
                        if (count<10){
                            count++;
                        }

                        for (int i=0; i<10; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }else{

                        if (count>0){
                            if (count==1){
                                count=0;
                            }else {count=count-2;}
                        }
                        for (int i=0; i<9; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }
                    if (count==10){

                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);

                        if (level>2){

                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",3);
                            editor.commit();
                        }

                        //выход из уровня
                        dialogEnd.show();
                    }else{
                        numRight = random.nextInt(10);
                        Glide.with(getApplicationContext()).load(array.images2[numRight]).into(img_right);

                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[numRight]);

                        numLeft = random.nextInt(10);

                        while (numRight == numLeft){
                            numLeft = random.nextInt(10);
                        }

                        Glide.with(getApplicationContext()).load(array.images2[numLeft]).into(img_left);

                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]);
                        img_left.setEnabled(true);
                    }
                }

                return true;
            }
        });

    }

    @Override
    public void onBackPressed(){

        try {

            Intent intent = new Intent(Level2.this, GameLevels.class);
            startActivity(intent);finish();

        }catch (Exception e){

        }

    }
}
