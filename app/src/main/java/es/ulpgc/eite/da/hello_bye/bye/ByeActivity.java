package es.ulpgc.eite.da.hello_bye.bye;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.da.hello_bye.R;
import es.ulpgc.eite.da.hello_bye.hello.HelloContract;
import es.ulpgc.eite.da.hello_bye.hello.HelloScreen;
import es.ulpgc.eite.da.hello_bye.hello.HelloViewModel;


public class ByeActivity
    extends AppCompatActivity implements HelloContract.View {

    public static String TAG = "HelloBye.HelloActivity";


    HelloContract.Presenter presenter;

    Button sayHelloButton, goByeButton;
    TextView helloMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        setTitle(R.string.hello_screen_title);

        initScreen();

        // do the setup
        HelloScreen.configure(this);

        // do some work
        if (savedInstanceState == null) {
            presenter.onCreateCalled();

        } else {
            presenter.onRecreateCalled();
        }

    }

    private void initScreen() {

        sayHelloButton = findViewById(R.id.sayHelloButton);
        goByeButton = findViewById(R.id.goByeButton);
        helloMessage = findViewById(R.id.helloMessage);

        sayHelloButton.setText(getSayHelloButtonLabel());
        goByeButton.setText(getGoByeButtonLabel());

        sayHelloButton.setOnClickListener(v -> presenter.sayHelloButtonClicked());
        goByeButton.setOnClickListener(v -> presenter.goByeButtonClicked());
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.onResumeCalled();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // do some work
        presenter.onPauseCalled();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // do some work
        presenter.onDestroyCalled();
    }

    @Override
    public void navigateToByeScreen() {

    }

    @Override
    public void displayHelloData(HelloViewModel viewModel) {
        Log.e(TAG, "displayHelloData");

        // deal with the data
        helloMessage.setText(viewModel.helloMessage);
    }


    private String getGoByeButtonLabel() {
        return getResources().getString(R.string.go_bye_button_label);
    }

    private String getSayHelloButtonLabel() {
        return getResources().getString(R.string.say_hello_button_label);
    }

    @Override
    public void injectPresenter(HelloContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
