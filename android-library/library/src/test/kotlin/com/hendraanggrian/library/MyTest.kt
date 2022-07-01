package com.hendraanggrian.library

import androidx.appcompat.app.AppCompatActivity
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.internal.DoNotInstrument
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@DoNotInstrument
class MyTest {
    private lateinit var activity: AppCompatActivity

    @Before
    fun setUpActivityAndResources() {
        activity = Robolectric.buildActivity(MyTestActivity::class.java).setup().get()
    }

    @Test
    fun test() {
        assertEquals("yo!", MyClass().toString())
    }
}