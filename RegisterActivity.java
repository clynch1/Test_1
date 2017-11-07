package whisc.test_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText USER_NAME, USER_PASS, CON_PASS;
    String user_name, user_pass, con_pass;
    Button REG;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        USER_NAME = (EditText) findViewById(R.id.user_name);
        USER_PASS = (EditText) findViewById(R.id.user_pass);
        CON_PASS = (EditText) findViewById(R.id.user_con_pass);
        REG = (Button) findViewById(R.id.register);
        REG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name = USER_NAME.getText().toString();
                user_pass = USER_PASS.getText().toString();
                con_pass = CON_PASS.getText().toString();

                if(!(user_pass.equals(con_pass))){
                    Toast.makeText(getBaseContext(), "Passwords Do Not Match", Toast.LENGTH_LONG).show();
                    USER_NAME.setText("");
                    USER_PASS.setText("");
                    CON_PASS.setText("");
                }
                else{
                    DatabaseOperations DB = new DatabaseOperations(ctx);
                    DB.putInformation(DB, user_name, user_pass);
                    Toast.makeText(getBaseContext(), "Registration Success", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}
