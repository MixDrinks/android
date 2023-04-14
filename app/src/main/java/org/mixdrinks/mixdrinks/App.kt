package org.mixdrinks.mixdrinks

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.mixdrinks.mixdrinks.app.RetrofitClient
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.features.data.CocktailProvider
import org.mixdrinks.mixdrinks.features.detail.ui.cocktail.DetailScreenCocktailViewModel
import org.mixdrinks.mixdrinks.features.detail.ui.good.DetailScreenGoodViewModel
import org.mixdrinks.mixdrinks.features.detail.ui.tool.DetailScreenToolViewModel
import org.mixdrinks.mixdrinks.features.fetcher.Fetcher
import org.mixdrinks.mixdrinks.features.filter.ui.FilterScreenViewModel
import org.mixdrinks.mixdrinks.features.start.ui.StartScreenViewModel

class App : Application() {
  override fun onCreate() {
    super.onCreate()

    val appModule = module {

      single {
        Room.databaseBuilder(
          androidContext(),
          AppDatabase::class.java,
          "mix-drinks-database"
        ).build()
      }

      single<CocktailProvider> { RetrofitClient.retrofit.create(CocktailProvider::class.java) }
      viewModel { StartScreenViewModel(get()) }
      viewModel { (id: Int) -> DetailScreenCocktailViewModel(cocktailId = id, get()) }
      viewModel { (id: Int) -> DetailScreenGoodViewModel(goodId = id, get())}
      viewModel { (id: Int) -> DetailScreenToolViewModel(toolId = id, get()) }

      viewModel { FilterScreenViewModel(get()) }

      single { Fetcher(get(), get()) }

    }

    startKoin {
      androidLogger()
      androidContext(applicationContext)
      modules(appModule)
    }
  }
}

