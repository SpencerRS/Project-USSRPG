package com.spizzyrichlife.ussrpg_v01;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * Created by SpizzyRich on 9/7/16.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    //HOWTO Set up a test
//    @Test
//    public void testSomething() throws Exception {
//         onView(withId(R.id.sign_in_button))
//            .perform(click())
//            .check(matches(isDisplayed()));
//    }
    @Test
    public void testCharCreateButton() throws Exception {
        onView(ViewMatchers.withId(R.id.createMainButton))
                .perform(click());
        intended(hasComponent(CharacterCreationActivity.class.getName()));
    }

}
