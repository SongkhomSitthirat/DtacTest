package com.test.di

import com.test.dtac.ui.MainViewModel
import com.test.dtac.network.ApiService
import com.test.dtac.network.ServiceEndpointInterface
import com.test.dtac.repostiory.RemoteRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

val appModule = module {
    single { ApiService() }
    single {
        val apiService: ApiService = get()
        RemoteRepositoryImpl(apiService.getEndpointInterface(ServiceEndpointInterface::class.java))
    }
}

val useCaseModule = module {
}

val viewModelModule = module {
    viewModel { MainViewModel() }
}