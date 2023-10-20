package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private EditText ed_name;
    private TextView tv_text , tv_name ,tv_winner ,tv_mmora ,tv_cmora;
    private RadioButton btn_scissor ,btn_stone ,btn_paper;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name=findViewById(R.id.ed_name);
        tv_text=findViewById(R.id.textView);
        tv_name=findViewById(R.id.tv_name);
        tv_winner=findViewById(R.id.tv_winner);
        tv_mmora=findViewById(R.id.tv_mmora);
        tv_cmora=findViewById(R.id.tv_cmora);
        btn_scissor=findViewById(R.id.btnScissor);
        btn_paper=findViewById(R.id.btnPaper);
        btn_stone=findViewById(R.id.btnStone);
        btn_mora=findViewById(R.id.btn_mora);

        btn_mora.setOnClickListener(view -> {
            if(ed_name.length()<1){
                tv_text.setText("請輸入玩家姓名");
            }
            else {
                tv_name.setText(String.format("名字:\n%s",ed_name.getText().toString()));
                if(btn_paper.isChecked()){
                    tv_mmora.setText("我方出拳\n布");
                }
                else if(btn_scissor.isChecked()){
                    tv_mmora.setText("我方出拳\n剪刀");
                }
                else {
                    tv_mmora.setText("我方出拳\n石頭");
                }

                int rand=(int)(Math.random()*3);

                if(rand==0){
                    tv_cmora.setText("電腦出拳\n布");
                }
                else if(rand==1){
                    tv_cmora.setText("電腦出拳\n剪刀");
                }
                else if(rand==2){
                    tv_cmora.setText("電腦出拳\n石頭");
                }

                if((btn_paper.isChecked() && rand==2)||(btn_scissor.isChecked() && rand==0)||(btn_stone.isChecked() && rand==1)){
                    tv_text.setText("你贏了");
                    tv_winner.setText("勝利者\n玩家");
                } else if ((btn_paper.isChecked() && rand==1)||(btn_scissor.isChecked() && rand==2)||(btn_stone.isChecked() && rand==0)) {
                    tv_text.setText("你輸了");
                    tv_winner.setText("勝利者\n電腦");
                } else {
                    tv_text.setText("平局，再來一次");
                    tv_winner.setText("勝利者\n平手");
                }
            }
        });
    }
}