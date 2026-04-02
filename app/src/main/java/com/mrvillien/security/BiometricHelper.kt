package com.mrvillien.security

import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.biometric.BiometricPrompt

class BiometricHelper(private val activity: FragmentActivity) {

    fun auth(success: () -> Unit) {
        val executor = ContextCompat.getMainExecutor(activity)

        val prompt = BiometricPrompt(activity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    success()
                }
            })

        val info = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Unlock App")
            .setNegativeButtonText("Cancel")
            .build()

        prompt.authenticate(info)
    }
}
