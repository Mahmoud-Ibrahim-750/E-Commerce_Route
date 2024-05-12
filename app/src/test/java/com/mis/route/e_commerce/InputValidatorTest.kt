package com.mis.route.e_commerce

import com.mis.route.e_commerce.presentation.utils.InputValidator
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import org.junit.Test

@HiltAndroidTest
class InputValidatorTest {

    @Test
    fun emailValidatorTests() {
        val testList = listOf(
            // # invalid email
            "abc",
            "abc.com",
            // # valid email address
            "abc@mail.com",
            "abc@mail.nz",
            "abc@mail.co.nz",
            "abc123@mail.com",
            "abc.def@music.com",
            // # invalid email prefix
            "abc-@mail.com",
            "abc..def@mail.com",
            ".abc@mail.com",
            "abc#def@mail.com",
            // # valid email prefix
            "abc-d@mail.com",
            "abc.def@mail.com",
            "abc@mail.com",
            "abc_def@mail.com",
            // # invalid domain suffix
            "abc.def@mail.c",
            "abc.def@mail#archive.com",
            "abc.def@mail",
            "abc.def@mail..com",
            // # valid domain suffix
            "abc.def@mail.cc",
            "abc.def@mail-archive.com",
            "abc.def@mail.org",
            "abc.def@mail.com",
            "fully-qualified-domain@example.com"
        )
        val expectedResultsList = listOf(
            // # invalid email
            false,
            false,
            // # valid email address
            true,
            true,
            true,
            true,
            true,
            // # invalid email prefix
            false,
            false,
            false,
            false,
            // # valid email prefix
            true,
            true,
            true,
            true,
            // # invalid domain suffix
            false,
            false,
            false,
            false,
            // # valid domain suffix
            true,
            true,
            true,
            true,
            true
        )

        var i = 0
        while (i <= testList.size) {
            val email = testList[i]
            val expectation = expectedResultsList[i]
            assertEquals(InputValidator.validateEmail(email), expectation)
            i++
        }
    }
}