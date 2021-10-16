package com.example.template

import android.app.Application
import com.example.template.injection.AppContainer

class TemplateApplication: Application() {

    val appContainer = AppContainer()

}