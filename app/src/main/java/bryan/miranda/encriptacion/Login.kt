package bryan.miranda.encriptacion

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import modelo.ClaseConexion
import java.security.MessageDigest

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtCorreo = findViewById<TextView>(R.id.txtCorreo)
        val txtContrasenia = findViewById<TextView>(R.id.txtContrasenia)
        val btnIngresar = findViewById<TextView>(R.id.btnIngresar)
        val btnRegistrarme = findViewById<TextView>(R.id.btnRegistrarme)

        fun hashSHA256(input: String): String {
            val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
            return bytes.joinToString("") { "%02x".format(it) }
        }

        btnIngresar.setOnClickListener {
            //preparo el intent para cambiar a la pantalla de bienvenida
            val pantallaPrincipal = Intent(this, Inicio::class.java)
            //Dentro de una corrutina hago un select en la base de datos
            GlobalScope.launch(Dispatchers.IO) {
                //1-Creo un objeto de la clase conexion
                val objConexion = ClaseConexion().cadenaConexion()

                //Encripto la contraseña usando la función de arriba
                val contraseniaEncriptada = hashSHA256(txtContrasenia.text.toString())


                //2- Creo una variable que contenga un PrepareStatement
                //MUCHA ATENCION! hace un select where el correo y la contraseña sean iguales a
                //los que el usuario escribe
                //Si el select encuentra un resultado es por que el usuario y contraseña si están
                //en la base de datos, si se equivoca al escribir algo, no encontrará nada el select
                val comprobarUsuario = objConexion?.prepareStatement("SELECT * FROM TB_USUARIO_EMPRESA WHERE Correo = ? AND Contraseña = ?")!!
                comprobarUsuario.setString(1, txtCorreo.text.toString())
                comprobarUsuario.setString(2, contraseniaEncriptada)
                val resultado = comprobarUsuario.executeQuery()
                //Si encuentra un resultado
                if (resultado.next()) {
                    startActivity(pantallaPrincipal)
                } else {
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Login, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                        println("contraseña $contraseniaEncriptada")
                    }

                }
            }
        }

        //Ir a la pantalla de registrarse
        btnRegistrarme.setOnClickListener {
            val pantallaRegistrarse = Intent(this, Registrarse::class.java)
            startActivity(pantallaRegistrarse)
        }

    }
}