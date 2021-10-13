package com.kh.sample

import android.app.Application
import com.kh.sample.ktor.network.UserImpl
import com.kh.sample.ktor.ui.MainActivityViewModel
import com.kh.sample.ktor.usecase.GetUseListUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {

    private val viewModelModule = module {
        factory { MainActivityViewModel(get()) }
    }
    private val remoteModule = module {
        single { UserImpl.create() }
    }
    private val useCaseModule = module {
        single { GetUseListUseCase(Dispatchers.IO, get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(viewModelModule,remoteModule,useCaseModule)
        }
    }
}