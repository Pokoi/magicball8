package es.esne.eop.bola8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.esne.eop.bola8.bola8.ShowResponseActivity;
import es.esne.eop.bola8.utils.Bola8;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;


public class MainActivity extends Activity {

    /**
     * Constantes que nos servirán para pasar los parámetros
     * NAME: nombre del usuario
     * QUESTION: pregunta escrita por el usuario
     * a la siguiente activity por medio de los intents.
     */
   public static final String NAME = "name";
   public static final String QUESTION = "question";


    /**
     * Obtenemos el canonical name para el debug
     */
    private static final String TAG = MainActivity.class.getCanonicalName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Hemos ejecutado la Main Activity");
        /**
         * Accedemos al botón que va a cambiar la activity
         * Y le añadimos un listener para el OnClick
         */
        Button button=(Button)findViewById(R.id.generate_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            /**
             * Cuando el usuario haga click en el botón se llamará al
             * método ChangeActivity
             */
            public void onClick(View view){
                ChangeActivity();
            }
        });
    }


    /**
     * Método que comprueba si el texto escrito por el usuario
     * es una pregunta
     */
    boolean CheckQuestion( String question_to_check){

        /**
         * Para comprobar que sea una pregunta comprobamos si tiene cualquiera de los
         * signos de interrogación.
         */

        return (question_to_check.contains("?") || question_to_check.contains("¿"));
    }

    /**
     * Método llamado al pulsar el botón
     */
    void ChangeActivity(){

        /**
         * Obtenemos los elemento texto del archivo xml escritos por el usuario
         */
        EditText text_name = (EditText) findViewById(R.id.typed_name);
        EditText text_question = (EditText) findViewById(R.id.typed_question);

        /**
         * Y accedemos al texto de dichos elementos.
         * Dicho texto lo convertimos a string (ya que de por sí es una secuencia de char)
         * y lo guardamos como variable
         */
        String user_name = text_name.getText().toString();
        String user_question = text_question.getText().toString();

        /**
         * Comprobamos si la pregunta introducida por el usuario.
         *
         * Si es una pregunta, cambiamos de activity pasándole los parámetros name y question
         * Si no es una pregunta, lanzamos un toast diciéndole al usuario que modifique la pregunta
         */

        if(CheckQuestion(user_question)){

            /**
             * Creamos el intent con la siguiente activity
             */
            Intent intent = new Intent (this, ShowResponseActivity.class);

            /**
             * Le pasamos los parámetros del nombre del usuario y la pregunta del usuario
             */
            intent.putExtra(QUESTION, user_question);
            intent.putExtra(NAME, user_name);

            /**
             * Comenzamos la activity
             */
            startActivity(intent);

        }
        else{
            Toast.makeText(getBaseContext(), R.string.toast_text_not_a_question, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        /**
         * Obtenemos los elemento texto del archivo xml escritos por el usuario
         */
        EditText text_name = (EditText) findViewById(R.id.typed_name);
        EditText text_question = (EditText) findViewById(R.id.typed_question);

        text_name.setText("");
        text_question.setText("");

    }
}
