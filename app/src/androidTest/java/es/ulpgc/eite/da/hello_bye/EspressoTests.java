package es.ulpgc.eite.da.hello_bye;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import es.ulpgc.eite.da.hello_bye.hello.HelloActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("ALL")
public class EspressoTests {


  @Rule
  public ActivityTestRule<HelloActivity> testRule =
      new ActivityTestRule(HelloActivity.class, true, false);

  private Activity activity;

  public EspressoTestSteps steps = new EspressoTestSteps();


  @Before
  public void setUp() {

    //AppMediator.resetInstance();

    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();

    } catch (RemoteException e) {
    }

    testRule.launchActivity(new Intent());
    activity = testRule.getActivity();
  }

  @After
  public void tearDown() {

    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();

    } catch (RemoteException e) {
    }

    testRule.finishActivity();
  }


  @Test
  public void test01MostrarHelloEnHello() {

    /*
    Scenario: Mostrar Hello en Hello

    Encontrandonos en pantalla Hello sin mostrar mensaje
    hacer que se muestre mensaje Hello

    */


    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayHello
    steps.pulsarBotonSayHello();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
  }


  @Test
  public void test02IrAByeSinMostrar() {

    /*
    Scenario: Ir a Bye sin mostrar

    Encontrandonos en pantalla Hello sin mostrar mensaje
    pasar a pantalla Bye sin mostrar mensaje

    */


    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And ocultar mensaje en pantalla Bye
    steps.ocultarMensajeEnPantallaByeMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton Back
    steps.pulsarBotonBack();
  }

  @Test
  public void test03IrAByeMostrandoHello() {


    /*
    Scenario: Ir a Bye mostrando Hello

    Encontrandonos en pantalla Hello mostrando mensaje Hello
    pasar a pantalla Bye mostrando mensaje Hello

    */


    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayHello
    steps.pulsarBotonSayHello();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And mostrar mensaje HelloWorld en pantalla Bye
    steps.mostrarMensajeHelloWorldEnPantallaBye(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton Back
    steps.pulsarBotonBack();
  }



  @Test
  public void test04VolverAHelloSinMostrarDesdeByeSinMostrar() {

    /*
    Scenario: Volver a Hello sin mostrar desde Bye sin mostrar

    Encontrandonos en pantalla Hello sin mostrar mensaje
    pasar a pantalla Bye sin mostrar mensaje
    y volver a pantalla Hello sin mostrar mensaje

 
    */


    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And ocultar mensaje en pantalla Bye
    steps.ocultarMensajeEnPantallaByeMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton GoHello
    steps.pulsarBotonGoHello();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then finalizar pantalla Bye
    steps.finalizarPantallaBye();
    // And resumir pantalla Hello
    steps.resumirPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
  }

  @Test
  public void test05RetornarAHelloSinMostrarDesdeByeSinMostrar() {

    /*
    Scenario: Retornar a Hello sin mostrar desde Bye sin mostrar

    Encontrandonos en pantalla Hello sin mostrar mensaje
    pasar a pantalla Bye sin mostrar mensaje
    y retornar a pantalla Hello sin mostrar mensaje

    */


    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And ocultar mensaje en pantalla Bye
    steps.ocultarMensajeEnPantallaByeMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton Back
    steps.pulsarBotonBack();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then finalizar pantalla Bye
    steps.finalizarPantallaBye();
    // And resumir pantalla Hello
    steps.resumirPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
  }

  @Test
  public void test06IrAByeSinMostrarYMostrarBye() {

    /*
    Scenario: Ir a Bye sin mostrar y mostrar Bye

    Encontrandonos en pantalla Hello sin mostrar mensaje
    pasar a pantalla Bye sin mostrar mensaje
    y hacer que muestre mensaje Bye

    */

    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And ocultar mensaje en pantalla Bye
    steps.ocultarMensajeEnPantallaByeMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayBye
    steps.pulsarBotonSayBye();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then mostrar mensaje ByeWorld en pantalla Bye
    steps.mostrarMensajeByeWorldEnPantallaBye(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton Back
    steps.pulsarBotonBack();
  }


  @Test
  public void test07IrAByeMostrandoHelloYMostrarBye() {

    /*
    Scenario: Ir a Bye mostrando Hello y mostrar Bye

    Encontrandonos en pantalla Hello mostrando mensaje Hello
    pasar a pantalla Bye mostrando mensaje Hello
    y hacer que muestre mensaje Bye


    */

    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayHello
    steps.pulsarBotonSayHello();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Bye
    steps.mostrarMensajeHelloWorldEnPantallaBye(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton SayBye
    steps.pulsarBotonSayBye();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then mostrar mensaje ByeWorld en pantalla Bye
    steps.mostrarMensajeByeWorldEnPantallaBye(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton Back
    steps.pulsarBotonBack();
  }




  @Test
  public void test08VolverAHelloMostrandoByeDesdeByeSinMostrar() {

    /*
    Scenario: Volver a Hello mostrando Bye desde Bye sin mostrar

    Encontrandonos en pantalla Hello sin mostrar mensaje
    pasar a pantalla Bye sin mostrar mensaje
    hacer que se muestre mensaje Bye
    y volver a pantalla Hello mostrando mensaje Bye


    */

    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And ocultar mensaje en pantalla Bye
    steps.ocultarMensajeEnPantallaByeMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayBye
    steps.pulsarBotonSayBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje ByeWorld en pantalla Bye
    steps.mostrarMensajeByeWorldEnPantallaBye(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton GoHello
    steps.pulsarBotonGoHello();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then finalizar pantalla Bye
    steps.finalizarPantallaBye();
    // And resumir pantalla Hello
    steps.resumirPantallaHello();
    // And mostrar mensaje ByeWorld en pantalla Hello
    steps.mostrarMensajeByeWorldEnPantallaHello(
        activity.getString(R.string.bye_message)
    );
  }


  @Test
  public void test09VolverAHelloDesdeByeSinMostrar() {

    /*
    Scenario: Volver a Hello desde Bye sin mostrar

    Encontrandonos en pantalla Hello sin mostrar mensaje
    pasar a pantalla Bye sin mostrar mensaje
    hacer que se muestre mensaje Bye
    y retornar a pantalla Hello sin mostrar mensaje


    */



    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And ocultar mensaje en pantalla Bye
    steps.ocultarMensajeEnPantallaByeMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayBye
    steps.pulsarBotonSayBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje ByeWorld en pantalla Bye
    steps.mostrarMensajeByeWorldEnPantallaBye(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton Back
    steps.pulsarBotonBack();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then finalizar pantalla Bye
    steps.finalizarPantallaBye();
    // And resumir pantalla Hello
    steps.resumirPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
  }


  @Test
  public void test10RetornarAHelloDesdeByeMostrandoHello() {

    /*
    Scenario: Retornar a Hello desde Bye mostrando Hello

    Encontrandonos en pantalla Hello mostrando mensaje Hello
    pasar a pantalla Bye mostrando mensaje Hello
    hacer que se muestre mensaje Bye
    y retornar a pantalla Hello mostrando mensaje Hello


    */

    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayHello
    steps.pulsarBotonSayHello();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Bye
    steps.mostrarMensajeHelloWorldEnPantallaBye(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton SayBye
    steps.pulsarBotonSayBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje ByeWorld en pantalla Bye
    steps.mostrarMensajeByeWorldEnPantallaBye(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton Back
    steps.pulsarBotonBack();
    // When girar pantalla
    //steps.girarPantalla(activity);
    // Then finalizar pantalla Bye
    steps.finalizarPantallaBye();
    // And resumir pantalla Hello
    steps.resumirPantallaHello();
    // And mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
  }

  @Test
  public void test11VolverAHelloMostrandoByeDesdeByeMostrandoHello() {

    /*
    Scenario: Volver a Hello mostrando Bye desde Bye mostrando Hello

    Encontrandonos en pantalla Hello mostrando mensaje Hello
    pasar a pantalla Bye mostrando mensaje Hello
    hacer que se muestre mensaje Bye
    y retornar a pantalla Hello mostrando mensaje Bye

    */



    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayHello
    steps.pulsarBotonSayHello();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Bye
    steps.mostrarMensajeHelloWorldEnPantallaBye(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton SayBye
    steps.pulsarBotonSayBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje ByeWorld en pantalla Bye
    steps.mostrarMensajeByeWorldEnPantallaBye(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton GoHello
    steps.pulsarBotonGoHello();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then finalizar pantalla Bye
    steps.finalizarPantallaBye();
    // And resumir pantalla Hello
    steps.resumirPantallaHello();
    // And mostrar mensaje ByeWorld en pantalla Hello
    steps.mostrarMensajeByeWorldEnPantallaHello(
        activity.getString(R.string.bye_message)
    );
  }

  @Test
  public void test12VolverAHelloMostrandoByeDesdeByeSinMostrarYMostrarHello() {

    /*
    Scenario: Volver a Hello mostrando Bye desde Bye sin mostrar y mostrar Hello

    Encontrandonos en pantalla Hello sin mostrar mensaje
    pasar a pantalla Bye sin mostrar mensaje
    hacer que se muestre mensaje Bye
    volver a pantalla Hello mostrando mensaje Bye
    y hacer que muestre mensaje Hello

  
    */

    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And ocultar mensaje en pantalla Bye
    steps.ocultarMensajeEnPantallaByeMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayBye
    steps.pulsarBotonSayBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje ByeWorld en pantalla Bye
    steps.mostrarMensajeByeWorldEnPantallaBye(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton GoHello
    steps.pulsarBotonGoHello();
    // And finalizar pantalla Bye
    steps.finalizarPantallaBye();
    // And resumir pantalla Hello
    steps.resumirPantallaHello();
    // And mostrar mensaje ByeWorld en pantalla Hello
    steps.mostrarMensajeByeWorldEnPantallaHello(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton SayHello
    steps.pulsarBotonSayHello();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
  }


  @Test
  public void test13VolverAHelloMostrandoByeDesdeByeMostrandoHelloYMostrarHello() {

    /*
    Scenario: Volver a Hello mostrando Bye desde Bye mostrando Hello y mostrar Hello

    Encontrandonos en pantalla Hello mostrando mensaje Hello
    pasar a pantalla Bye mostrando mensaje Hello
    hacer que se muestre mensaje Bye
    volver a pantalla Hello mostrando mensaje Bye
    y hacer que muestre mensaje Hello


    */

    // Given iniciar pantalla Hello
    steps.iniciarPantallaHello();
    // And ocultar mensaje en pantalla Hello
    steps.ocultarMensajeEnPantallaHelloMostrandoTexto(
        activity.getString(R.string.empty_text)
    );
    // And pulsar boton SayHello
    steps.pulsarBotonSayHello();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton GoBye
    steps.pulsarBotonGoBye();
    // And iniciar pantalla Bye
    steps.iniciarPantallaBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje HelloWorld en pantalla Bye
    steps.mostrarMensajeHelloWorldEnPantallaBye(
        activity.getString(R.string.hello_message)
    );
    // And pulsar boton SayBye
    steps.pulsarBotonSayBye();
    // And girar pantalla
    steps.girarPantalla(activity);
    // And mostrar mensaje ByeWorld en pantalla Bye
    steps.mostrarMensajeByeWorldEnPantallaBye(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton GoHello
    steps.pulsarBotonGoHello();
    // And finalizar pantalla Bye
    steps.finalizarPantallaBye();
    // And resumir pantalla Hello
    steps.resumirPantallaHello();
    // And mostrar mensaje ByeWorld en pantalla Hello
    steps.mostrarMensajeByeWorldEnPantallaHello(
        activity.getString(R.string.bye_message)
    );
    // And pulsar boton SayHello
    steps.pulsarBotonSayHello();
    // When girar pantalla
    steps.girarPantalla(activity);
    // Then mostrar mensaje HelloWorld en pantalla Hello
    steps.mostrarMensajeHelloWorldEnPantallaHello(
        activity.getString(R.string.hello_message)
    );
  }
  
}
