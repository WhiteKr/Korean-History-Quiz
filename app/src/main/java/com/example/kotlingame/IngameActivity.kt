package com.example.kotlingame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ingame.*

class IngameActivity : AppCompatActivity() {

    var a = 0
    var qNum = 0

    object Quiz {

        val q = arrayOf(
            "고려(高麗)는 918년에\n□□ □□(이)가 건국하였다.", //1
            "왕건은 백성의 세금을 줄이는\n□□ □□ 정책을 시행했다.", //2
            "고려와 □나라는 활발한 교류를 하였다.", //3
            "윤관은 여진족을 정벌하기 위해\n특수부대 □□□(을)를 만들었다.", //4
            "□□(은)는 고려 문화에\n많은 영향을 준 종교이다." //5
        )

        val a = arrayOf(
            "태조왕건", //1
            "민생안정", //2
            "송", //3
            "별무반", //4
            "불교" //5
        )

    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingame)

        questionText.text = Quiz.q[qNum]
        quizIndex.text = (qNum + 1).toString() + "번 문제"

        answerBtn.setOnClickListener {
            when {

                answerText.text.toString().replace("\\s".toRegex(), "") == Quiz.a[qNum] -> {

                    Toast.makeText(this, "정답입니다!", Toast.LENGTH_SHORT).show()
                    if (qNum != Quiz.q.size - 1) qNum++
                    else {

                        Toast.makeText(this, "축하합니다. 모든 문제를 다 풀었습니다!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }

                answerText.text.toString() == "" -> Toast.makeText(this, "정답을 입력해주세요.", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "오답입니다..", Toast.LENGTH_SHORT).show()

            }

            answerText.setText("")
            questionText.text = Quiz.q[qNum]
            quizIndex.text = (qNum + 1).toString() + "번 문제"

        }
    }

    override fun onBackPressed() {

        when (a) {

            0 -> Toast.makeText(this, "진행 도중에는 나갈 수 없습니다.", Toast.LENGTH_SHORT).show()
            10 -> Toast.makeText(this, "아니 그렇게 하기 싫어요?", Toast.LENGTH_SHORT).show()
            15 -> {

                Toast.makeText(this, "그냥 하지 마", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        a++

    }
}