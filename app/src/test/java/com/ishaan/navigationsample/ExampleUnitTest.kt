package com.ishaan.navigationsample

import com.ishaan.navigationsample.view.Utility
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testLiveUrl() {
        assertEquals(BuildConfig.KEY_VALUE, 2)
    }
}
