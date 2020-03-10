package com.test.dtac.base

import com.test.dtac.model.Result

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

abstract class UseCase<in P, R> {

    abstract fun execute(parameters: P): Result<R>
}