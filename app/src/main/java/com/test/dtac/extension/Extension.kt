package com.test.dtac.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)

fun Any.toJsonString(): String = Gson().toJson(this)

fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment) {
    this.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
}

fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment, tag: String) {
    this.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment, tag)
            .commit()
}

fun AppCompatActivity.replaceFragmentWithBackStack(containerId: Int, fragment: Fragment, tag: String) {
    this.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment, tag)
            .addToBackStack(null)
            .commit()
}

fun Fragment.replaceFragment(containerId: Int, fragment: Fragment) {
    this.childFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
}

fun Fragment.replaceFragment(containerId: Int, fragment: Fragment, tag: String) {
    this.childFragmentManager.beginTransaction()
            .replace(containerId, fragment, tag)
            .commit()
}