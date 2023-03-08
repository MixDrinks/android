package org.mixdrinks.mixdrinks

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.mixdrinks.mixdrinks.app.RetrofitClient
import org.mixdrinks.mixdrinks.features.data.CocktailProvider
import org.mixdrinks.mixdrinks.features.detail.ui.DetailScreenViewModel

class App : Application() {
  override fun onCreate() {
    super.onCreate()

    val appModule = module {
      single<CocktailProvider> { RetrofitClient.retrofit.create(CocktailProvider::class.java) }
      viewModel { (id: Int) -> DetailScreenViewModel(cocktailId = id, get()) }
    }

    startKoin {
      androidLogger()
      androidContext(applicationContext)
      modules(appModule)
    }
  }
}

