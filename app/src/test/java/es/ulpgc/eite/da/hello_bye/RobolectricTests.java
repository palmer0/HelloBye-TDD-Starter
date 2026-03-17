package es.ulpgc.eite.da.hello_bye;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import es.ulpgc.eite.da.hello_bye.app.AppMediator;
import es.ulpgc.eite.da.hello_bye.bye.ByeActivity;
import es.ulpgc.eite.da.hello_bye.hello.HelloActivity;


@RunWith(RobolectricTestRunner.class)
@Config(sdk = 33)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("ALL")
public class RobolectricTests {

    private ActivityController<HelloActivity> helloController;
    private HelloActivity helloActivity;

    private ActivityController<ByeActivity> byeController;
    private ByeActivity byeActivity;

    private Intent byeIntent;

    @Before
    public void setUp() {
        AppMediator.resetInstance();

        helloController = Robolectric.buildActivity(HelloActivity.class)
                .create()
                .start()
                .resume()
                .visible();

        helloActivity = helloController.get();
        byeController = null;
        byeActivity = null;
    }

    @Test
    public void test01MostrarHelloEnHello() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonSayHello();
        girarPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
    }

    @Test
    public void test02IrAByeSinMostrar() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonGoBye();
        girarPantallaBye();
        iniciarPantallaBye();
        ocultarMensajeEnPantallaByeMostrandoTexto(byeActivity.getString(R.string.empty_text));
        pulsarBotonBack();
    }

    @Test
    public void test03IrAByeMostrandoHello() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonSayHello();
        girarPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
        pulsarBotonGoBye();
        girarPantallaBye();
        iniciarPantallaBye();
        mostrarMensajeHelloWorldEnPantallaBye(byeActivity.getString(R.string.hello_message));
        pulsarBotonBack();
    }

    @Test
    public void test04VolverAHelloSinMostrarDesdeByeSinMostrar() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        ocultarMensajeEnPantallaByeMostrandoTexto(byeActivity.getString(R.string.empty_text));
        pulsarBotonGoHello();
        girarPantallaHello();
        finalizarPantallaBye();
        resumirPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
    }

    @Test
    public void test05RetornarAHelloSinMostrarDesdeByeSinMostrar() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        ocultarMensajeEnPantallaByeMostrandoTexto(byeActivity.getString(R.string.empty_text));
        pulsarBotonBack();
        girarPantallaHello();
        finalizarPantallaBye();
        resumirPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
    }

    @Test
    public void test06IrAByeSinMostrarYMostrarBye() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        ocultarMensajeEnPantallaByeMostrandoTexto(byeActivity.getString(R.string.empty_text));
        pulsarBotonSayBye();
        girarPantallaBye();
        mostrarMensajeByeWorldEnPantallaBye(byeActivity.getString(R.string.bye_message));
        pulsarBotonBack();
    }

    @Test
    public void test07IrAByeMostrandoHelloYMostrarBye() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonSayHello();
        girarPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        girarPantallaBye();
        mostrarMensajeHelloWorldEnPantallaBye(byeActivity.getString(R.string.hello_message));
        pulsarBotonSayBye();
        girarPantallaBye();
        mostrarMensajeByeWorldEnPantallaBye(byeActivity.getString(R.string.bye_message));
        pulsarBotonBack();
    }

    @Test
    public void test08VolverAHelloMostrandoByeDesdeByeSinMostrar() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        ocultarMensajeEnPantallaByeMostrandoTexto(byeActivity.getString(R.string.empty_text));
        pulsarBotonSayBye();
        girarPantallaBye();
        mostrarMensajeByeWorldEnPantallaBye(byeActivity.getString(R.string.bye_message));
        pulsarBotonGoHello();
        girarPantallaHello();
        finalizarPantallaBye();
        resumirPantallaHello();
        mostrarMensajeByeWorldEnPantallaHello(helloActivity.getString(R.string.bye_message));
    }

    @Test
    public void test09VolverAHelloDesdeByeSinMostrar() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        ocultarMensajeEnPantallaByeMostrandoTexto(byeActivity.getString(R.string.empty_text));
        pulsarBotonSayBye();
        girarPantallaBye();
        mostrarMensajeByeWorldEnPantallaBye(byeActivity.getString(R.string.bye_message));
        pulsarBotonBack();
        girarPantallaHello();
        finalizarPantallaBye();
        resumirPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
    }

    @Test
    public void test10RetornarAHelloDesdeByeMostrandoHello() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonSayHello();
        girarPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        girarPantallaBye();
        mostrarMensajeHelloWorldEnPantallaBye(byeActivity.getString(R.string.hello_message));
        pulsarBotonSayBye();
        girarPantallaBye();
        mostrarMensajeByeWorldEnPantallaBye(byeActivity.getString(R.string.bye_message));
        pulsarBotonBack();
        finalizarPantallaBye();
        resumirPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
    }

    @Test
    public void test11VolverAHelloMostrandoByeDesdeByeMostrandoHello() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonSayHello();
        girarPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        girarPantallaBye();
        mostrarMensajeHelloWorldEnPantallaBye(byeActivity.getString(R.string.hello_message));
        pulsarBotonSayBye();
        girarPantallaBye();
        mostrarMensajeByeWorldEnPantallaBye(byeActivity.getString(R.string.bye_message));
        pulsarBotonGoHello();
        girarPantallaHello();
        finalizarPantallaBye();
        resumirPantallaHello();
        mostrarMensajeByeWorldEnPantallaHello(helloActivity.getString(R.string.bye_message));
    }

    @Test
    public void test12VolverAHelloMostrandoByeDesdeByeSinMostrarYMostrarHello() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        ocultarMensajeEnPantallaByeMostrandoTexto(byeActivity.getString(R.string.empty_text));
        pulsarBotonSayBye();
        girarPantallaBye();
        mostrarMensajeByeWorldEnPantallaBye(byeActivity.getString(R.string.bye_message));
        pulsarBotonGoHello();
        finalizarPantallaBye();
        resumirPantallaHello();
        mostrarMensajeByeWorldEnPantallaHello(helloActivity.getString(R.string.bye_message));
        pulsarBotonSayHello();
        girarPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
    }

    @Test
    public void test13VolverAHelloMostrandoByeDesdeByeMostrandoHelloYMostrarHello() {
        iniciarPantallaHello();
        ocultarMensajeEnPantallaHelloMostrandoTexto(helloActivity.getString(R.string.empty_text));
        pulsarBotonSayHello();
        girarPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
        pulsarBotonGoBye();
        iniciarPantallaBye();
        girarPantallaBye();
        mostrarMensajeHelloWorldEnPantallaBye(byeActivity.getString(R.string.hello_message));
        pulsarBotonSayBye();
        girarPantallaBye();
        mostrarMensajeByeWorldEnPantallaBye(byeActivity.getString(R.string.bye_message));
        pulsarBotonGoHello();
        finalizarPantallaBye();
        resumirPantallaHello();
        mostrarMensajeByeWorldEnPantallaHello(helloActivity.getString(R.string.bye_message));
        pulsarBotonSayHello();
        girarPantallaHello();
        mostrarMensajeHelloWorldEnPantallaHello(helloActivity.getString(R.string.hello_message));
    }

    private void iniciarPantallaHello() {
        assertNotNull(helloActivity);
    }

    private void ocultarMensajeEnPantallaHelloMostrandoTexto(String text) {
        TextView textView = helloActivity.findViewById(R.id.helloMessage);
        assertNotNull(textView);
        assertEquals(text, textView.getText().toString());
    }

    private void pulsarBotonSayHello() {
        Button button = helloActivity.findViewById(R.id.sayHelloButton);
        assertNotNull(button);
        button.performClick();
    }

    private void pulsarBotonGoBye() {
        Button button = helloActivity.findViewById(R.id.goByeButton);
        assertNotNull(button);
        button.performClick();

        byeIntent = shadowOf(helloActivity).getNextStartedActivity();
        assertNotNull(byeIntent);

        helloController.pause().stop();

        byeController = Robolectric.buildActivity(ByeActivity.class, byeIntent)
                .create()
                .start()
                .resume()
                .visible();

        byeActivity = byeController.get();
    }


    private void iniciarPantallaBye() {
        assertNotNull(byeActivity);
    }

    private void ocultarMensajeEnPantallaByeMostrandoTexto(String text) {
        TextView textView = byeActivity.findViewById(R.id.byeMessage);
        assertNotNull(textView);
        assertEquals(text, textView.getText().toString());
    }

    private void pulsarBotonBack() {
        byeActivity.onBackPressed();

        if (byeController != null) {
            byeController.pause().stop().destroy();
            byeController = null;
            byeActivity = null;
        }

        helloController.restart().start().resume().visible();
        helloActivity = helloController.get();
    }

    private void mostrarMensajeHelloWorldEnPantallaHello(String text) {
        TextView textView = helloActivity.findViewById(R.id.helloMessage);
        assertNotNull(textView);
        assertEquals(text, textView.getText().toString());
    }

    private void mostrarMensajeHelloWorldEnPantallaBye(String text) {
        TextView textView = byeActivity.findViewById(R.id.byeMessage);
        assertNotNull(textView);
        assertEquals(text, textView.getText().toString());
    }

    private void pulsarBotonGoHello() {
        Button button = byeActivity.findViewById(R.id.goHelloButton);
        assertNotNull(button);
        button.performClick();

        if (byeController != null) {
            byeController.pause().stop().destroy();
            byeController = null;
            byeActivity = null;
        }

        helloController.restart().start().resume().visible();
        helloActivity = helloController.get();
    }

    private void finalizarPantallaBye() {
        // Intencionadamente vacío, como en Espresso.
    }

    private void resumirPantallaHello() {
        helloController.restart().start().resume().visible();
        helloActivity = helloController.get();
    }

    private void pulsarBotonSayBye() {
        Button button = byeActivity.findViewById(R.id.sayByeButton);
        assertNotNull(button);
        button.performClick();
    }

    private void mostrarMensajeByeWorldEnPantallaBye(String text) {
        TextView textView = byeActivity.findViewById(R.id.byeMessage);
        assertNotNull(textView);
        assertEquals(text, textView.getText().toString());
    }

    private void mostrarMensajeByeWorldEnPantallaHello(String text) {
        TextView textView = helloActivity.findViewById(R.id.helloMessage);
        assertNotNull(textView);
        assertEquals(text, textView.getText().toString());
    }

    private void girarPantallaHello() {
        Bundle bundle = new Bundle();

        helloController.pause().saveInstanceState(bundle).stop().destroy();

        helloController = Robolectric.buildActivity(HelloActivity.class)
                .create(bundle)
                .start()
                .restoreInstanceState(bundle)
                .resume()
                .visible();

        helloActivity = helloController.get();
    }

    private void girarPantallaBye() {
        Bundle bundle = new Bundle();

        byeController.pause().saveInstanceState(bundle).stop().destroy();

        byeController = Robolectric.buildActivity(ByeActivity.class, byeIntent)
                .create(bundle)
                .start()
                .restoreInstanceState(bundle)
                .resume()
                .visible();

        byeActivity = byeController.get();
    }


}