package com.example.labtwo;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTestUI {


    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test_If_Symbol_Count_Is_The_Same()
    {
        final String input = "Hello";
        final String result = "Symbols: 5";

        onView(withId(R.id.edUserInput)).perform(click());
        onView(withId(R.id.edUserInput)).perform(replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.edUserInput)).perform(click());
        onView(withId(R.id.edUserInput)).perform(typeText(input), closeSoftKeyboard());
        onView(withId(R.id.spSelectOption)).perform(click());
        onView(withText("Symbols")).perform(ViewActions.click());
        onView(withId(R.id.btnCount)).perform(ViewActions.click());
        onView(withId(R.id.tvMain)).check(matches(withText(result)));
    }

    @Test
    public void test_If_Word_Count_Is_The_Same()
    {
        final String givenString = "BE BETTER AT DVITASKIS";
        final String expectedResult = "Words: 4";

        onView(withId(R.id.edUserInput)).perform(click());
        onView(withId(R.id.edUserInput)).perform(replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.edUserInput)).perform(click());
        onView(withId(R.id.edUserInput)).perform(typeText(givenString), closeSoftKeyboard());
        onView(withId(R.id.spSelectOption)).perform(click());
        onView(withText("Words")).perform(click());
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvMain)).check(matches(withText("Words: 4")));
    }


    @Test
    public void mainActivityTestUI() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edUserInput), withText("Enter text here"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.edUserInput), withText("Enter text here"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Text"));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.edUserInput), withText("Text"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText3.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.edUserInput), withText("Text"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText4.perform(pressImeActionButton());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.edUserInput), withText("Text"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("Text for test"));

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.edUserInput), withText("Text for test"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText6.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.edUserInput), withText("Text for test"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText7.perform(pressImeActionButton());

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spSelectOption),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatSpinner.perform(click());

        DataInteraction appCompatCheckedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(0);
        appCompatCheckedTextView.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnCount), withText("Count"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatSpinner2 = onView(
                allOf(withId(R.id.spSelectOption),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatSpinner2.perform(click());

        DataInteraction appCompatCheckedTextView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(1);
        appCompatCheckedTextView2.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btnCount), withText("Count"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.edUserInput), withText("Text for test"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("Text for test")));

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.text1), withText("Symbols"),
                        withParent(allOf(withId(R.id.spSelectOption),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        textView.check(matches(withText("Symbols")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.tvMain), withText("Symbols: 11"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView2.check(matches(withText("Symbols: 11")));

        ViewInteraction spinner = onView(
                allOf(withId(R.id.spSelectOption),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        spinner.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
