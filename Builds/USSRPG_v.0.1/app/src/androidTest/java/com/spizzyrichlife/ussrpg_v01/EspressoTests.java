package com.spizzyrichlife.ussrpg_v01;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ListView;

import com.spizzyrichlife.ussrpg_v01.Activities.CharacterCreationActivity;
import com.spizzyrichlife.ussrpg_v01.Activities.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.startsWith;

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
    public void testCharacterCreationProcess() throws Exception{
        testMainCharCreateButton();
        testCharNameSpace();
        testXPSpace();
        testCharCreateButton();
    }

    // Should switch to character creation activity
    public void testMainCharCreateButton() throws Exception {
        onView(withId(R.id.action_create))
                .perform(click());
        intended(hasComponent(CharacterCreationActivity.class.getName()));
    }


    // Should type test name into character creation name space
    public void testCharNameSpace() throws Exception {
        onView(withId(R.id.nameEditText))
                .perform(clearText())
                .perform(typeText("Test Char Name"))
                .check(withText("Test Char Name"));
    }


    // Should type test XP value into character creation XP space
    public void testXPSpace() throws Exception {
        onView(withId(R.id.xpEditText))
                .perform(clearText())
                .perform(typeText("10"))
                .check(withText("10"));
    }


    // Should click character creation button in character creation activity to send Player Character object to PC table in database
    public void testCharCreateButton() throws Exception {
        onView(withId(R.id.charCreateButton))
                .perform(click());
    }
//Leo's Tests
    private void test1(String test) {
        final int[] counts = new int[1];

        onView(withId(R.id.pcList)).check(matches(new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View view) {
                ListView listView = (ListView) view;
                counts[0] = listView.getCount();
                return true;
            }
            @Override
            public void describeTo(Description description) {
            }
        }));
//TODO: figure out what this does...
//        onView(ViewMatchers.withId(R.id.<Add Button>))
//                .perform(click());
//        onView(ViewMatchers.withId(R.id.game_name))
//                .perform(typeText(test));
//        onView(ViewMatchers.withId(R.id.game_numof_attributes))
//                .perform(typeText("Health, Attack, Power"));
//        onView(ViewMatchers.withId(android.R.id.button1))
//                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.pcList))
                .atPosition(counts[0])
                .onChildView(withId(R.id.pc_lv_character_name))
                .check(matches(withText(startsWith(test))));
    }

}
