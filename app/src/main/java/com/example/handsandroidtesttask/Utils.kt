package com.example.handsandroidtesttask

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KProperty

operator fun <T> MutableStateFlow<T>.getValue(thisRef: Any?, property: KProperty<*>): T {
    return value
}

operator fun <T> MutableStateFlow<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
}