package mx.edu.itson.potros.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val C : EditText = findViewById(R.id.etC)
        val F : EditText = findViewById(R.id.etF)
        val bC : Button = findViewById(R.id.btnGC)
        val bF : Button = findViewById(R.id.btnGF)
        var gradosC : Double
        var gradosF : Double

        bC.setOnClickListener() {
            try{
                gradosF = F.text.toString().toDouble()
                gradosC = FtoC(gradosF)
                val formattedNumber="%.2f".format(gradosC)
                C.setText(formattedNumber)
            }catch(e:java.lang.Exception){
                F.setText("Debe ingresar valores reales")
                print(e)
            }
        }

        bF.setOnClickListener() {
            try{
                gradosC = C.text.toString().toDouble()
                gradosF = CtoF(gradosC)
                val formattedNumber="%.2f".format(gradosF)
                F.setText(formattedNumber)
            }catch(e:java.lang.Exception){
                F.setText("Debe ingresar valores reales")
                print(e)
            }
        }
    }

    fun FtoC (grados: Double) : Double {
        var centigrados : Double = grados-32
        centigrados=centigrados/1.8
        return centigrados
    }

    fun CtoF (grados: Double) : Double {
        var farenheit : Double = grados * 1.8 + 32
        return farenheit
    }
}