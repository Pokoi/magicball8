package es.esne.eop.bola8.bola8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.esne.eop.bola8.MainActivity;
import es.esne.eop.bola8.R;
import es.esne.eop.bola8.utils.Bola8;

import static es.esne.eop.bola8.MainActivity.NAME;
import static es.esne.eop.bola8.MainActivity.QUESTION;

/**
 * Esta clase controla la actividad de la activity que
 * muestra por pantalla la respuesta a la pregunta del
 * usuario
 */
public class ShowResponseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_response);

        Intent intent = this.getIntent();

        Button button=(Button)findViewById(R.id.ask_again);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            /**
             * Cuando el usuario haga click en el botón se llamará al
             * método ChangeActivity
             */
            public void onClick(View view){
                finish();
            }
        });

        /**
         * Variable que guarda el nombre del usuario
         */
        String name = intent.getStringExtra(NAME);

        /**
         * Variable que guarda la pregunta del usuario
         */
        String question = intent.getStringExtra(QUESTION);

        /**
         * Variable que guarda la respuesta al usuario
         * Obtenida mediante el método getMagic8BallResponse
         * Este método obtiene una respuesta random dentro de un array
         */
        String answer = Bola8.getMagic8BallResponse();


        /**
         * Obtenemos el elemento texto del archivo xml
         */
        TextView text_elemnt = (TextView) findViewById(R.id.text_to_show);

        /**
         * Y accedemos al texto de dicho elemento.
         * Dicho texto lo convertimos a string (ya que de por sí es una secuencia de char)
         * y lo guardamos como variable
         */
        String mensaje = text_elemnt.getText().toString();

        /**
         * Modificamos el valor de dicho texto en base a nuestras variables nombre, pregunta y respuesta
         */
        mensaje = "Hola, " + name + ".\n\nAnte tu pregunta:\n\n\"" + question + "\", mi respuesta es que " + answer;

        /**
         * Asignamos al texto original el texto modificado para que se muestre por pantalla
         */
        text_elemnt.setText(mensaje);

    }
}
