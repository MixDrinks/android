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
import org.mixdrinks.mixdrinks.features.data.filter.FilterProvider
import org.mixdrinks.mixdrinks.features.detail.ui.DetailScreenViewModel
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
      viewModel { (id: Int) -> DetailScreenViewModel(cocktailId = id, get()) }
      viewModel { StartScreenViewModel(get()) }

      single<FilterProvider> { RetrofitClient.retrofit.create(FilterProvider::class.java) }
      viewModel { FilterScreenViewModel(get()) }

      single <Fetcher> { Fetcher(get(), get()) }

    }

    startKoin {
      androidLogger()
      androidContext(applicationContext)
      modules(appModule)
    }
  }
}

