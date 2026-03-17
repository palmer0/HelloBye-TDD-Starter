package es.ulpgc.eite.da.hello_bye;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.RemoteException;

import androidx.test.uiautomator.UiDevice;

/**
* Created by Luis on octubre, 2023
*/

class EspressoTestSteps {


  public void iniciarPantallaHello() {

  }
  
  
  public void ocultarMensajeEnPantallaHelloMostrandoTexto(String text) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.helloMessage)).check(matches(isDisplayed()));
    onView(withId(R.id.helloMessage)).check(matches(withText(text)));
  }

  public void pulsarBotonSayHello() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.sayHelloButton)).check(matches(isDisplayed()));
    onView(withId(R.id.sayHelloButton)).perform(click());
  }

  public void girarPantalla(Activity activity) {

    int orientation = activity.getRequestedOrientation();

    if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
      orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

    } else {
      orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    }

    activity.setRequestedOrientation(orientation);

    try {
      UiDevice device = UiDevice.getInstance(getInstrumentation());

      if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
        device.setOrientationNatural();

      } else {
        device.setOrientationLeft();
      }

    } catch (RemoteException e) {
    }

    /*
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }
    */
  }

  public void mostrarMensajeHelloWorldEnPantallaHello(String text) {

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.helloMessage)).check(matches(isDisplayed()));
    onView(withId(R.id.helloMessage)).check(matches(withText(text)));
  }

  public void pulsarBotonGoBye() {
    onView(withId(R.id.goByeButton)).check(matches(isDisplayed()));
    onView(withId(R.id.goByeButton)).perform(click());
  }

  public void iniciarPantallaBye() {

  }

  public void ocultarMensajeEnPantallaByeMostrandoTexto(String text) {
    onView(withId(R.id.byeMessage)).check(matches(isDisplayed()));
    onView(withId(R.id.byeMessage)).check(matches(withText(text)));
  }

  public void pulsarBotonBack() {
    pressBack();

    /*try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }*/
  }

  public void mostrarMensajeHelloWorldEnPantallaBye(String text) {

    onView(withId(R.id.byeMessage)).check(matches(isDisplayed()));
    onView(withId(R.id.byeMessage)).check(matches(withText(text)));
  }

  public void pulsarBotonGoHello() {
    onView(withId(R.id.goHelloButton)).check(matches(isDisplayed()));
    onView(withId(R.id.goHelloButton)).perform(click());
  }

  public void finalizarPantallaBye() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }
  }

  public void resumirPantallaHello() {

  }

  public void pulsarBotonSayBye() {
    onView(withId(R.id.sayByeButton)).check(matches(isDisplayed()));
    onView(withId(R.id.sayByeButton)).perform(click());
  }

  public void mostrarMensajeByeWorldEnPantallaBye(String text) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.byeMessage)).check(matches(isDisplayed()));
    onView(withId(R.id.byeMessage)).check(matches(withText(text)));
  }

  public void mostrarMensajeByeWorldEnPantallaHello(String text) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.helloMessage)).check(matches(isDisplayed()));
    onView(withId(R.id.helloMessage)).check(matches(withText(text)));
  }
}
