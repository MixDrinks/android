package org.mixdrinks.mixdrinks

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.mixdrinks.mixdrinks.app.RetrofitClient
import org.mixdrinks.mixdrinks.features.data.cocktail.CocktailProvider
import org.mixdrinks.mixdrinks.features.data.filter.FilterProvider
import org.mixdrinks.mixdrinks.features.detail.ui.DetailScreenViewModel
import org.mixdrinks.mixdrinks.features.filter.ui.FilterScreenViewModel
import org.mixdrinks.mixdrinks.features.start.ui.StartScreenViewModel

class App : Application() {
  override fun onCreate() {
    super.onCreate()

    val appModule = module {
      single<CocktailProvider> { RetrofitClient.retrofit.create(CocktailProvider::class.java) }
      viewModel { (id: Int) -> DetailScreenViewModel(cocktailId = id, get()) }
      viewModel { StartScreenViewModel(get()) }

      single<FilterProvider> { RetrofitClient.retrofit.create(FilterProvider::class.java) }
      viewModel { FilterScreenViewModel(get()) }
    }

    startKoin {
      androidLogger()
      androidContext(applicationContext)
      modules(appModule)
    }
  }
}

