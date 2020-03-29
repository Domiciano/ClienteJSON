package appmoviles.com.clientejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ComunicacionTCP.OnMessageListener{

    private EditText nombreET, emailET, usernameET;
    private Button enviarUsuarioBtn, enviarListaBtn;
    private ComunicacionTCP comunicacionTCP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreET = findViewById(R.id.nombreET);
        emailET = findViewById(R.id.emailET);
        usernameET = findViewById(R.id.usernameET);
        enviarUsuarioBtn = findViewById(R.id.enviarUsuarioBtn);
        enviarListaBtn = findViewById(R.id.enviarListaBtn);

        comunicacionTCP = ComunicacionTCP.getInstance();
        comunicacionTCP.setObserver(this);
        comunicacionTCP.solicitarConexion("10.0.2.2");


        enviarUsuarioBtn.setOnClickListener(
                (v)->{
                    //alt+enter
                    String nombre = nombreET.getText().toString();
                    String email = emailET.getText().toString();
                    String username = usernameET.getText().toString();

                    Usuario usuario = new Usuario(
                            nombre,
                            email,
                            username
                    );

                    Gson gson = new Gson();
                    String json = gson.toJson(usuario);

                    comunicacionTCP.mandarMensaje(json);

                }
        );

        enviarListaBtn.setOnClickListener(
                (view)->{
                    ArrayList<Usuario> usuarios = new ArrayList<>();
                    usuarios.add( new Usuario("Alfa","alfa@alfa.com","Alfa") );
                    usuarios.add (new Usuario("Beta","beta@alfa.com","Beta") );
                    usuarios.add ( new Usuario("Gamma","gamma@alfa.com","Gamma") );
                    usuarios.add( new Usuario("Delta","delta@alfa.com","Delta") );

                    Gson gson = new Gson();
                    String json = gson.toJson(usuarios);
                    comunicacionTCP.mandarMensaje(json);

                }
        );

    }

    @Override
    public void onMessage(String mensaje) {

    }
}
